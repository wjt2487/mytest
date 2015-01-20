package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoxService;
import service.impl.BoxServiceImple;


public class BoxAddOneDataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoxService  boxService=new BoxServiceImple();
	/**
	 * Constructor of the object.
	 */
	public BoxAddOneDataServlet() {
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
//		PrintWriter pw=response.getWriter();
		String taskId =request.getParameter("taskId").trim();
		String tagId =request.getParameter("tagId").trim();
		String btime =request.getParameter("btime").trim();
		double tvalue=Double.parseDouble(request.getParameter("tvalue").trim());
		String precision="0.0";//精度
		if(taskId == null || tagId==null ||btime==null  ){
			response.sendRedirect("fail.html");
			return;
		}
		
		String histablename="tblTemperature";
		
		try {
			boolean b = boxService.insertOneHis(histablename, taskId, tagId, btime,  tvalue, precision);
			if(b){
				
				response.sendRedirect("success.html");
			}else {
				response.sendRedirect("fail.html");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("fail.html");
		} 
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
