package com.java.SyncData.Back;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.java.sql.SQLConnect;
import com.java.sql.table.MySQLTable;
import com.java.sql.table.MySQLUpdate;

public class GetTableCount {

	public int Count1=0;
	public int Count2=0;
	public void Count(String TableName) throws SQLException
	{
		MySQLTable MasterTable=new MySQLTable(SQLConnect.Sql_MasterServer,"select  count(0) as c  from "+TableName);
		MySQLTable BackTable=new MySQLTable(SQLConnect.Sql_BackServer,"select  count(0) as c  from "+TableName);
		
		try {
			MasterTable.Open();
			BackTable.Open();
			
			MasterTable.next();
			BackTable.next();
			Count1=MasterTable.getInt("c");
			Count2=BackTable.getInt("c");			
		} 
		finally {
			MasterTable.Close();
			BackTable.Close();	
		}		
	}
}
