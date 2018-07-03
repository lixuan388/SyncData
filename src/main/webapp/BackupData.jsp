<%@page import="com.java.SyncData.Back.BackupData"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
BackupData b= new BackupData();
b.BackupTable("abd_bookingdatetime", "abd_id");
b.BackupTable("abdp_bookingdatetime_pay", "abdp_id");
b.BackupTable("abp_base_parameter", "abp_id");
b.BackupTable("amb_member", "amb_id");
b.BackupTable("amc_member_card", "amc_id");
b.BackupTable("amca_member_card_apply", "amca_id");
b.BackupTable("amch_member_card_history", "amch_id");
b.BackupTable("amcra_member_card_recharge_amount", "amcra_id");
b.BackupTable("amp_medical_project", "amp_id");
b.BackupTable("amps_medical_project_schedule", "amps_id");
b.BackupTable("and_notifyurl_data", "and_id");
b.BackupTable("atn_time_number", "atn_id");

















%>
<html>
<head>      
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">    
    
<title>BackupData</title>

</head>
<body>


</body>
</html>