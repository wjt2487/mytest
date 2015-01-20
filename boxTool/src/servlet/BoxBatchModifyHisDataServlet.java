package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoxService;
import service.impl.BoxServiceImple;
public class BoxBatchModifyHisDataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoxService  boxService=new BoxServiceImple();
	/**
	 * Constructor of the object.
	 */
	public BoxBatchModifyHisDataServlet() {
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
		String tagId =request.getParameter("tagId").trim();
		String btime =request.getParameter("btime").trim();
		String etime =request.getParameter("etime").trim();
		float min=Float.parseFloat(request.getParameter("min").trim());
		float max=Float.parseFloat(request.getParameter("max").trim());
		
		String precision="0.0";//精度
		if(tagId==null ||btime==null ||etime==null ){
			response.sendRedirect("fail.html");
			return;
		}
		
		String histablename="tblTemperature";
		
			boolean b=false;
			boolean bdel = false;
			boolean bbin = false;
			//1、先删除
			bdel=boxService.deleteHis(histablename, tagId, btime, etime);
			//2、再添加
			bbin=boxService.insertHis3(histablename, "1404171750AA0732", tagId,btime,etime,5,min,max, precision);
			b = bdel&&bbin;
			if(b){
				System.out.println("修正"+btime+"到"+etime+"数据成功");
				response.sendRedirect("success.html");
			}else {
				System.out.println("修正"+btime+"到"+etime+"数据失败");
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
