package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import entity.BoxModel;

public class ExceltoObject {
    private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public List<BoxModel> getBoxModeList( String filePath) {
		
		List<BoxModel> boxList = new ArrayList<BoxModel>();
		try {
			InputStream in =new FileInputStream(filePath);
			//从输入流创建Workbook
			jxl.Workbook workbook = Workbook.getWorkbook(in);
			
			//获取第一张Sheet表
			//我们既可能通过Sheet的名称来访问它，也可以通过下标来访问它。如果通过下标来访问的话，
			//要注意的一点是下标从0开始，就像数组一样。
			
			Sheet sheet = workbook.getSheet(0);
			
			//得到总行数
			int rows = sheet.getRows();
			
			//一旦得到了Sheet，我们就可以通过它来访问Excel Cell(术语：单元格)
			
			Cell cell1=null;
			
			int bRow=0;//用于标记Excel中是需要执行操作的时间的第一条位置
			for(int row = 0;row<rows;row++){
				cell1=sheet.getCell(0,row);
				if((cell1.getContents()).equals("开始时间")){
					 bRow = row+1;
				}
				
				cell1=null;
			}
			//System.out.println(bRow);
			for(int i =bRow;i<rows;i++){
				if(sheet.getCell(0,i).getContents()!=null && sheet.getCell(0,i).getContents()!=""){
					BoxModel boxModel = new BoxModel();
					boxModel.setBtime(formateTime(sheet.getCell(0,i)));
					//System.out.println(formateTime(sheet.getCell(0,i)));
					boxModel.setEtime(formateTime(sheet.getCell(1,i)));
					//System.out.println(dateformat.format(date));
					boxModel.setDeviceNo(sheet.getCell(2,i).getContents());
					//System.out.println(sheet.getCell(2,i).getContents());
					boxModel.setInterval(5);
					
					if(!sheet.getCell(3,i).getContents().equals("")){//判断温度值范围是否为空
						String[] str=((sheet.getCell(3,i).getContents()).split("-"));
						float min =Float.parseFloat(str[0]);
						//System.out.println(min);
						float max =Float.parseFloat(str[1]);
						//System.out.println(max);
						boxModel.setMin(min);
						boxModel.setMax(max);
					}
					boxModel.setOper(sheet.getCell(4,i).getContents());
					//System.out.println(sheet.getCell(4,i).getContents());
					boxList.add(boxModel);
				}
			}
			
			workbook.close();
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boxList;
	}
	public String  formateTime(Cell cell) {
		
		CellType celltype = cell.getType();
		String returString=cell.getContents().replace("/", "-");
		if(celltype==CellType.DATE){
			Date  myDate = null;
			DateCell dateCell = (DateCell) cell;
			myDate = dateCell .getDate();
			long time = myDate.getTime()-8*60*60*1000;
			
			myDate.setTime(time);
			returString = dateformat.format(myDate);
		}
		
		
		return returString;
		
	}
}
