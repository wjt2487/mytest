package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoxService;
import service.impl.BoxServiceImple;
import entity.TblTemperature;


public class BoxQueryHisDataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoxService  boxService=new BoxServiceImple();
	/**
	 * Constructor of the object.
	 */
	public BoxQueryHisDataServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String tagId =request.getParameter("tagId").trim();
		String btime =request.getParameter("btime").trim();
		String etime =request.getParameter("etime").trim();
		
		if(tagId==null ||btime==null ||etime==null ){
			response.sendRedirect("fail.html");
			return;
		}
		
		List<TblTemperature> tList = new ArrayList<TblTemperature>();
		
		tList = boxService.queryBoxHisData(tagId,btime,etime);
		
	    
	    /*request.setAttribute("tList", tList);
		request.getRequestDispatcher("/boxhisdata.jsp").forward(request, response);*/
	    out
		.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
out.println("<HTML>");
out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
out.println("  <BODY>");
out.println("<input type='button' value='返回' onclick='javascript:history.back(-1)'>" +
		"<table border='1'>");
out.println("<tr>");
  out.println("<td>设备编号</td>");
  out.println("<td>温度值</td>");
  out.println("<td>记录时间</td>");
out.println("</tr>");
for(TblTemperature t:tList){
	out.println("<tr>");
      out.println("<td>"+t.getTagId()+"</td>");
      out.println("<td>"+t.getTemperatureValue()+"</td>");
      out.println("<td>"+t.getTestTime()+"</td>");
    out.println("</tr>");
}
out.println("</table>");
out.println("  </BODY>");
out.println("</HTML>");
out.flush();
out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
