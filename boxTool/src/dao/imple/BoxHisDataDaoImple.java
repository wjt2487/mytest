package dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.CompareTime;
import util.DateProcess;
import util.ProduceRandom;
import util.dbtool.DBUtil;
import dao.BoxHisDataDao;
import entity.TblTemperature;

public class BoxHisDataDaoImple implements BoxHisDataDao {

	private SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public List<TblTemperature> queryBoxHisData(String tagId, String btime, String etime) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection conn= DBUtil.getCon();
		ResultSet rs =null ;
		List<TblTemperature> tList = new ArrayList<TblTemperature>();
		
		try {
			String sql ="select * from tblTemperature where tagid=? and TestTime between '"+btime+"' and '"+etime+"'  order  by TestTime desc" ;
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, tagId);
			rs=ps.executeQuery();
			while(rs.next()){
				TblTemperature tblTemperature=new TblTemperature();
				tblTemperature.setTagId(tagId);
				tblTemperature.setTemperatureValue(rs.getDouble("temperatureValue"));
				tblTemperature.setTestTime(rs.getTimestamp("testTime"));
				tList.add(tblTemperature);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tList;
	}
	
    /**
	 * 直线增长
	 * 插入（2~8℃）的历史数据
	 * @throws SQLException 
	 * @throws ParseException 
	 * 
	 */
	public boolean insertHis3(String histablename,String taskId,String tagId,String  begintime,String  endtime,int interval,float min,float max,String precision)  {
		// TODO Auto-generated method stub
		
		PreparedStatement ps =null;
		Connection connection =DBUtil.getCon();
		List<TblTemperature> temperatureList =new ArrayList<TblTemperature>();
        boolean flag=true;
        try {
    		
        	connection.setAutoCommit(false);
        	//插入历史数据
        	String sql="insert into tblTemperature(DtRecordEnter,TaskID,TagID,TestTime,TemperatureValue,HumidityValue,ValueLongitude,ValueLatitude,clmDataType,clmGroupID,VehicleID,iDeviceStatus,iPower) " +
        			           "values('2014-6-1 11:10:38','"+taskId+"',"+tagId+",?,?,0,0,0,4,NULL,NULL,1,0)";
        	
        	
			ps=connection.prepareStatement(sql);
		
			int i = CompareTime.compareTime(begintime,endtime);
			//1、获得时间间隔数
			long tInterval=DateProcess.getTimeInterval(begintime, endtime, interval);
			//2、得到斜率
			float slope =1;
			if(tInterval != 0){
				slope = Float.parseFloat((max-min)+"")/tInterval;
			}
			//3/x值
			int x = 0;
			while(i==-1||i==0){
		
				TblTemperature temperature =new TblTemperature();
			    double tValue= x*slope+min;//一次函数算出温度值
			    String ttValue = String.format("%.1f", tValue);//保留小数点后一位有效数字
			    System.out.println(ttValue);
				temperature.setTemperatureValue(Double.parseDouble(ttValue));
				temperature.setTestTime(sdf.parse(begintime));
				temperatureList.add(temperature);
			
				begintime=DateProcess.DateAddMinute(begintime,interval);
			
				i= CompareTime.compareTime(begintime,endtime);
			    x++;
			}
		
			int count=0;
		
			for(TblTemperature h:temperatureList ){
			
				ps.setTimestamp(1, new Timestamp(h.getTestTime().getTime()));
			
				ps.setDouble(2,h.getTemperatureValue());
				
				ps.addBatch();
			
				if(++count %100==0){//每100条数据  执行一次批量插入
					ps.executeBatch();
				}
			}
		
			ps.executeBatch();
			connection.commit();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
			System.out.println("--手动添加冷藏箱历史数据失败！"+e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				flag=false;
				System.out.println("--手动添加冷藏箱历史数据事务回滚！！");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
		}finally{
			DBUtil.closeCon(connection);
			DBUtil.closeStatement(ps);
		}
		return flag;
	}
	
	
	/**
	 * 修正车载的历史数据
	 * @param histablename
	 * @param btime
	 * @param etime
	 * @param min
	 * @param max
	 * @return
	 */
	public boolean modifyHis(String histablename,String tagId, String btime, String etime,
			int min,int max,int lowLimit,int highLimit) {
		PreparedStatement ps =null;
		ResultSet rs =null;
		Connection connection =DBUtil.getCon();
		List<Date> tList =new ArrayList<Date>();

       boolean flag=true;
       try {
   		String sqls="select TestTime from   "+histablename+" where  TagID="+tagId +" and (TemperatureValue<="+lowLimit+"   or TemperatureValue>="+highLimit+") and TestTime between '"+btime+"' and '"+etime+"'" ;
   		ps=connection.prepareStatement(sqls);
   		rs=ps.executeQuery();
   		while (rs.next()) {
   			tList.add(rs.getTimestamp(1));
   		}
   		for(int i=0;i<tList.size();i++){
   			//修正报警的历史数据
   			String precision="0.0";
   			double TemperatureValue=ProduceRandom.getRandom(min,max,precision);
   			this.updateOneData(histablename, tagId, tList.get(i).toString(), TemperatureValue);
   		}
			
       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
			System.out.println("--手动-修正-保温箱历史数据失败！"+e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				flag=false;
				System.out.println("--手动-修正-保温箱历史数据事务回滚！！");
			}
		} finally{
			DBUtil.closeCon(connection);
			DBUtil.closeStatement(ps);
		}
		return flag;
	}
	/**
	 * 修改单条历史数据
	 * @param histablename
	 * @param tagId
	 * @param testtime
	 * @param TemperatureValue
	 * @return
	 */
	public boolean updateOneData(	String histablename,String tagId,String testtime,
			double TemperatureValue ){
		PreparedStatement ps =null;
		Connection connection =DBUtil.getCon();
		
		try {
			connection.setAutoCommit(false);
			String sql2="update  "+histablename+" set TemperatureValue="+TemperatureValue+"  where TagID="+tagId+" and TestTime='"+testtime+"'";
			ps=connection.prepareStatement(sql2);
			ps.executeUpdate();
			connection.commit();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("手动修正保温箱历史数据失败！");
			return false;
		}
		
	}
	/**
	 * 
	 * @param histablename
	 * @param taskId
	 * @param tagId
	 * @param btime
	 * @param tvalue
	 * @param precision
	 * @return
	 */
	public boolean insertOneHis(String histablename, String taskId,
			String tagId, String btime, double tvalue, String precision) {
		// TODO Auto-generated method stub
		PreparedStatement ps =null;
		Connection connection =DBUtil.getCon();
       boolean flag=true;
       try {
       	String sql1="delete  from tblTemperature where TagID="+tagId+" and testtime = '"+btime+"' ";
       	ps=connection.prepareStatement(sql1);
   		ps.executeUpdate();
       	connection.setAutoCommit(false);
       	//插入历史数据
       	String sql="insert into tblTemperature(DtRecordEnter,TaskID,TagID,TestTime,TemperatureValue,HumidityValue,ValueLongitude,ValueLatitude,clmDataType,clmGroupID,VehicleID,iDeviceStatus,iPower) " +
       			           "values('2014-6-1 11:10:38','"+taskId+"',"+tagId+",?,?,0,0,0,4,NULL,NULL,1,0)";
       	
			ps=connection.prepareStatement(sql);
				ps.setTimestamp(1, new Timestamp(sdf.parse(btime).getTime()));
				ps.setDouble(2,tvalue);
			ps.executeUpdate();
			connection.commit();
       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
			System.out.println("--手动添加单条冷藏箱历史数据失败！"+e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				flag=false;
				System.out.println("--手动添加单条冷藏箱历史数据事务回滚！！");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
		}finally{
			DBUtil.closeCon(connection);
			DBUtil.closeStatement(ps);
		}
		return flag;
	}
	/**
	 * 删除一段时间内的数据
	 * @param histablename
	 * @param tagId
	 * @param btime
	 * @param etime
	 * @return
	 */
	public boolean deleteHis(String histablename, String tagId, String btime,
			String etime) {
		// TODO Auto-generated method stub
		PreparedStatement ps =null;
		Connection connection =DBUtil.getCon();
       boolean flag=true;
       
       	try {
       		String sql1="delete  from tblTemperature where TagID="+tagId+" and TestTime between '"+btime+"' and '"+etime+"'";
				ps=connection.prepareStatement(sql1);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag=false;
			}
   		
		return flag;
	}

	public List<TblTemperature> getAlarmDataListByAsc(String histablename,String tagId,
			String btimeString, String etimString, int min, int max) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection connection = DBUtil.getCon();
		List<TblTemperature> list = new ArrayList<TblTemperature>();
		ResultSet rs = null;
		String sql ="select testTime from tblTemperature where tagid=? and testtime between ? and ? and TemperatureValue<-2 order by testtime asc " ;
		try {
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, tagId);
			ps.setString(2, btimeString);
			ps.setString(3, etimString);
			
			rs=ps.executeQuery();
			while (rs.next()) {
				TblTemperature tblTemperature=new TblTemperature();
				tblTemperature.setTestTime(rs.getTimestamp("testTime"));
				list.add(tblTemperature);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
