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
	<script type="text/javascript" src="js/jquery-latest.js"></script>
	<script type="text/javascript">
	  $(document).ready(function() {
       //each遍历文本框
       $(".dinput").each(function() {
        //保存当前文本框的值
        var vdefault = this.value;
        $(this).focus(function() {
            //获得焦点时，如果值为默认值，则设置为空
            if (this.value == vdefault) {
                this.value = "";
            }
        });
        $(this).blur(function() {
            //失去焦点时，如果值为空，则设置为默认值
            if (this.value == "") {
                this.value = vdefault;
            }
         });
       });
      });
	</script>
  </head>
  
  <body>
    <form  action="bmd" method="post">
      <table >
        <tr>
          <td>标签编号:</td>
          <td><input type="text" value="" name="tagId"/></td>
        </tr>
        <tr>
          <td>开始时间:</td>
          <td><input type="text" value="" name="btime"/></td>
        </tr>
        <tr>
          <td>结束时间:</td>
          <td><input type="text" value="" name="etime"/></td>
        </tr>
        <tr>
          <td>温度值范围:</td>
          <td><input type="text" value="2" name="min" class="dinput" style="width:30px; "/> ~ <input type="text" value="8" name="max" class="dinput" style="width:30px; "/>℃（*选填）</td>
        </tr>
        <tr>
          <td>仓储类型:</td>
          <td><input type="text" value="2" name="lowLimit" class="dinput" style="width:30px; "/> ~ <input type="text" value="8" name="highLimit" class="dinput" style="width:30px; "/>℃（*选填）</td>
        </tr>
      </table>
		</BR>
		<input type="submit" value="确认修正"/>
		<input type="reset" value="重 设"/>
		<input type="button" value="返回" onclick="javascript:history.back(-1)">
	</form>
  </body>
</html>
