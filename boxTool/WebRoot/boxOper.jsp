<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>批量处理数据</title>
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
  <form action="boxOper" method="post" >
    <div>
      <table>
        <tr> 
          <td>
                 文件路径：
          </td>
          <td>
              <input type="text" name="filePath" value="">
          </td>
        </tr>
      </table>
      <br/>
      <input type="submit" value="确认"/>
      <input type="button" value="返回" onclick="javascript:history.back(-1)">
    </div>
  </form>
  </body>
</html>
