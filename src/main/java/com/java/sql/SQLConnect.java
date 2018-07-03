package com.java.sql;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import com.java.version;

public class SQLConnect {
	

	static PoolProperties p = null;

	static DataSource MasterDS=null;
	static DataSource BackDS=null;
	

	public static final int Sql_MasterServer=1;
	public static final int Sql_BackServer=2;
	
	
	
	
    static void InitConnectPoolSQL(int ServerType)
    {
        p = new PoolProperties();
        switch (ServerType) {
		case Sql_MasterServer:
	  		  p.setDriverClassName("com.mysql.jdbc.Driver");
			  p.setUrl("jdbc:mysql://172.18.232.153:53306/txdb");
			  p.setUsername("root");
			  p.setPassword("root@17ecity.cc");
			break;
		case Sql_BackServer:

			  
	  		  p.setDriverClassName("com.mysql.jdbc.Driver");
			  p.setUrl("jdbc:mysql://127.0.0.1/txdb");
			  p.setUsername("root");
			  p.setPassword("root");
			break;
		}

        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(false);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
    
        switch (ServerType) {
		case Sql_MasterServer:
			MasterDS = new DataSource();
			MasterDS.setPoolProperties(p);
			break;
		case Sql_BackServer:

			BackDS = new DataSource();
			BackDS.setPoolProperties(p);
			break;
		}		
        

            
    }       
            
	static public Connection GetConnect(int ServerType)
	{
        switch (ServerType) {
		case Sql_MasterServer:
			if (MasterDS==null)
			{
//				InitConnectPool();
				InitConnectPoolSQL(ServerType);
			}
			try {
				return MasterDS.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case Sql_BackServer:
			if (BackDS==null)
			{
//				InitConnectPool();
				InitConnectPoolSQL(ServerType);
			}
			try {
				return BackDS.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}		

		return null;
	}
		    
	
	static {
//		InitConnectPool();
	}
		    

}
