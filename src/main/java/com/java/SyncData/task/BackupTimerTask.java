package com.java.SyncData.task;

import java.sql.SQLException;
import java.util.Date;
import java.util.TimerTask;

import com.java.SyncData.Back.BackupData;
public class BackupTimerTask extends TimerTask {

	int RunTime=1000;
	@Override
	public void run() {		
		RunTime++;

		Date d= new Date();
		System.out.println("Hours:"+d.getHours()+"/RunTime:"+RunTime);
		if ((RunTime>60*2) && (d.getHours()==4))
		{

			System.out.println("BackupTimerTask");
			RunTime=0;
			
			BackupData b= new BackupData();
			try {
				b.BackupTable("abd_bookingdatetime", "abd_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("abdp_bookingdatetime_pay", "abdp_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("abp_base_parameter", "abp_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("amb_member", "amb_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("amc_member_card", "amc_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("amca_member_card_apply", "amca_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("amch_member_card_history", "amch_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("amcra_member_card_recharge_amount", "amcra_id");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				b.BackupTable("amp_medical_project", "amp_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("amps_medical_project_schedule", "amps_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("and_notifyurl_data", "and_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				b.BackupTable("atn_time_number", "atn_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			RunTime=0;
			
		}
		// TODO Auto-generated method stub
		


	}

}
