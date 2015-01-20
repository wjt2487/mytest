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
    <form  action="qboxhis" method="post">
      <table>
          <tr>
            <td>任务编号:</td>
            <td><input type="text" value="1404171750AA0732" name="taskId" class="dinput"/>(*选填)</td>
          </tr>
          <tr>
            <td>标签编号:</td>
            <td><input type="text" value="" name="tagId"/></td>
          </tr>
          <tr>
            <td>起始时间：</td>
            <td><input type="text" value="" name="btime" ></td>
          </tr>
          <tr>
            <td> 结束时间：</td>
            <td><input type="text" value="" name="etime" ></td>
          </tr>
          <tr>
            <td><input type="submit" value="查询" ></td>
            <td><input type="button" value="返回" onclick="javascript:history.back(-1)"></td>
          </tr>
        </table>
    </form>
    <div>
      <table>
        <tr> 
          <td></td>
        </tr>
      </table>
    </div>
  </body>
</html>
