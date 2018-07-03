package com.java.SyncData.Back;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.java.sql.SQLConnect;
import com.java.sql.table.MySQLTable;
import com.java.sql.table.MySQLUpdate;

public class BackupData {

	public BackupData()
	{
		
	}
	
	public void BackupTable(String TableName,String KeyField) throws SQLException
	{
		System.out.println("------------------backup "+TableName+"------------------");
		MySQLTable MasterTable=new MySQLTable(SQLConnect.Sql_MasterServer,"select  * from "+TableName+" where ifnull(_SyncFlag,0)=0 LIMIT 0, 10");
		MySQLTable BackTable=new MySQLTable(SQLConnect.Sql_BackServer);
		MySQLUpdate updateTable=new MySQLUpdate(SQLConnect.Sql_MasterServer);
		
		try {
			MasterTable.Open();
			ResultSetMetaData rsmd = MasterTable.rs().getMetaData();
			boolean loop=true;
			
			
//			//获取当前表格的列数
			int columns = rsmd.getColumnCount();
//			System.out.println("列数:"+columns);
//
//			//输出当前表格的表头
//			System.out.println("------------------");
//			for(int i=0; i<columns;i++){
//			System.out.println(rsmd.getColumnName(i+1)+"\t");
//			}
//			System.out.println();
//			System.out.println("------------------");		
			while (loop)
			{
				loop=false;
				while (MasterTable.next())
				{
					BackTable.SQL(SQLConnect.Sql_BackServer, "select  * from "+TableName+" where "+KeyField+"='"+MasterTable.getString(KeyField)+"'");
					BackTable.Open();
					if (!BackTable.next())
					{
						BackTable.moveToInsertRow();
						BackTable.updateString(KeyField, MasterTable.getString(KeyField));
	
						System.out.println("Insert "+MasterTable.getString(KeyField));
						
					}
					else
					{
						System.out.println("Update "+MasterTable.getString(KeyField));
					}
					for (int i=0; i<columns;i++ )
					{
						String FieldName=rsmd.getColumnName(i+1);
						if (!FieldName.equals(KeyField))
						{
							BackTable.updateString(FieldName, MasterTable.getString(FieldName));
						}
					}
					BackTable.PostRow();
					System.out.println("PostRow ");
					updateTable.Update("update "+TableName+" set _SyncFlag=1,_SyncDate=now() where "+KeyField+"='"+MasterTable.getString(KeyField)+"'");
					
					loop=true;
				}
				MasterTable.Open();
			}
			
			
		} 
		finally {
			MasterTable.Close();
			BackTable.Close();

			System.out.println("------------------backup "+TableName+" end ----------------");
			
		}
		
		
	}
}
