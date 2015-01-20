<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <div>
      <table>
        <tr> 
          <td><a href="boxOper.jsp">批量处理保温箱数据</a></td>
        </tr>
        <tr> 
          <td></br><a href="addBoxHisData.jsp">添加保温箱历史数据</a></td>
        </tr>
        <tr> 
          <td></br><a href="delBoxHisData.jsp">删除保温箱历史数据</a></td>
        </tr>
        <tr>
          <td></br><a href="modifyBoxHisData.jsp">修正保温箱历史数据</a></td>
        </tr>
        <tr>
          <td></br><a href="addOneBoxHisData.jsp">添加单条保温箱历史数据</a></td>
        </tr>
        <tr>
          <td></br><a href="modifyOneBoxHisData.jsp">修改单条保温箱历史数据</a></td>
        </tr>
        <tr>
          <td></br><a href="boxhisdata.jsp">查询保温箱历史数据</a></td>
        </tr>
      </table>
      <br/>
      <input type="button" value="返回" onclick="javascript:history.back(-1)">
    </div>
  </body>
</html>
