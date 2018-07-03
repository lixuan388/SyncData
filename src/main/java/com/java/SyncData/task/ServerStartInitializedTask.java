package com.java.SyncData.task;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.java.version;


public class ServerStartInitializedTask implements ServletContextListener {
	
	
	private Timer timer=null;

    public void contextDestroyed(ServletContextEvent event)    
    {    

    	System.out.println("ServerStartTask.contextDestroyed");
		timer.cancel();
		event.getServletContext().log("定时器ServerRunServlet销毁");

    }    
    public void contextInitialized(ServletContextEvent event)    
    {    


    	System.out.println("SyncData ServerStartTask.contextInitialized");  	
    	timer=new Timer(true);
		//添加日志，可在tomcat日志中查看到 
		System.out.println("开启定时器ServerRunServlet");
		//调用定时任务，0表示任务无延迟，5*1000表示每隔5秒执行任务，触发间隔以毫秒计算。
	    //1分钟后启动，每10秒一次
//		System.out.println("1分钟后启动，每60秒一次"); 
//		timer.schedule(new SendServerMessageTimerTask(),1000*60,1000*60*5);
		timer.schedule(new BackupTimerTask(),1000*60,1000*60*1);
		System.out.println("定时器ServerRunServlet已开启");
    	

    }
}
