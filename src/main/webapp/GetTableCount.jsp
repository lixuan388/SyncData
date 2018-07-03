<%@page import="com.java.SyncData.Back.GetTableCount"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>      
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">    
    
<title>BackupData</title>

</head>
<body>

<%
GetTableCount b= new GetTableCount();
int Count1=0;
int Count2=0;
String color="";

String [] tableList ={"abd_bookingdatetime","abdp_bookingdatetime_pay","abp_base_parameter","amb_member","amc_member_card","amca_member_card_apply","amch_member_card_history","amcra_member_card_recharge_amount","amp_medical_project","amps_medical_project_schedule","and_notifyurl_data","atn_time_number"};

for (int i=0;i<tableList.length;i++)
{
	b.Count(tableList[i]);
	if (b.Count1==b.Count2)
	{
		color="blue";
	}
	else
	{
		color="red";
	}
	%>
	<div ><span style="display: block;text-align: center;"><%=tableList[i] %></span><span style="display: block;text-align: center;color: <%=color %>"><%=b.Count1%>/<%=b.Count2%></span></div>
	<%
}




















%>



</body>
</html>