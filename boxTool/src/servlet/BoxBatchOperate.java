package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoxService;
import service.impl.BoxServiceImple;
import util.ExceltoObject;
import entity.BoxModel;

public class BoxBatchOperate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoxService  boxService=new BoxServiceImple();

	/**
	 * Constructor of the object.
	 */
	public BoxBatchOperate() {
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
		String filePath = request.getParameter("filePath").trim();
		
		ExceltoObject exceltoObject = new ExceltoObject();
		String precision="0.0";//精度
		if(filePath == null  ){
			response.sendRedirect("fail.html");
			return;
		}
		String histablename="tblTemperature";
		try {
			
			List<BoxModel> boxList = new ArrayList<BoxModel>();
			
			boxList = exceltoObject.getBoxModeList(filePath);
			
			boolean b=false;
				 
				for(BoxModel bo :boxList){	
					if(bo.getOper().equals("删除")){
						b=boxService.deleteHis(histablename, bo.getDeviceNo(), bo.getBtime(), bo.getEtime());
						if(b){
							System.out.println("删除"+bo.getBtime()+"到"+bo.getEtime()+"数据成功");
						}else {
							System.out.println("删除"+bo.getBtime()+"到"+bo.getEtime()+"数据失败");
						}
					}else{//如果是添加或修正
						boolean bdel = false;
						boolean bbin = false;
						//1、先删除
						bdel=boxService.deleteHis(histablename, bo.getDeviceNo(), bo.getBtime(), bo.getEtime());
						//2、再添加
						bbin=boxService.insertHis3(histablename, "1404171750AA0732", bo.getDeviceNo(), bo.getBtime(), bo.getEtime(), bo.getInterval(), bo.getMin(), bo.getMax(), precision);
						b = bdel&&bbin;
						if(b){
							System.out.println("添加/修正"+bo.getBtime()+"到"+bo.getEtime()+"数据成功");
						}else {
							System.out.println("添加/修正"+bo.getBtime()+"到"+bo.getEtime()+"数据失败");
						}
						
					}
					
				}
				
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
