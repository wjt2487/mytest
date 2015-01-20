package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import entity.TblTemperature;

public interface BoxHisDataDao {

	/**
	 * 根据设备编号查询保温箱数据
	 * @param etime 
	 * @param btime 
	 */
	List<TblTemperature> queryBoxHisData(String tagId, String btime, String etime);
	/**
	 * 删除一段时间内的历史数据
	 * @param histablename  表名
	 * @param tagId 设备编号
	 * @param btime 开始时间
	 * @param etime 结束时间
	 * @return
	 */
	public boolean deleteHis(String histablename, String tagId, String btime,String etime);
	/**
 	 * 
 	 * 插入的历史数据按照一次函数增长
 	 * @throws SQLException 
 	 * @throws ParseException 
 	 * 
 	 */
 	boolean insertHis3(String histablename,String taskId,String tagId,String  begintime,String  endtime,int interval,float min,float max,String precision);
 	/**
	 * 插入单条保温箱历史数据
	 * @param histablename
	 * @param taskId
	 * @param tagId
	 * @param btime
	 * @param tvalue
	 * @param precision
	 * @return
	 */
	 boolean insertOneHis(String histablename, String taskId,
			String tagId, String btime, double tvalue, String precision);
	/**
	 * 修正一段时间内的保温箱的历史数据
	 * @param histablename
	 * @param btime
	 * @param etime
	 * @param min
	 * @param max
	 * @return
	 */
	boolean modifyHis(String histablename,String tagId, String btime, String etime,
			int min,int max,int lowLimit,int highLimit);
	
	/**
	 * 修改单条历史数据
	 * @param histablename
	 * @param tagId
	 * @param testtime
	 * @param TemperatureValue
	 * @return
	 */
	boolean updateOneData(	String histablename,String tagId,String testtime,
			double TemperatureValue );
	/**
	 * 得到小于0的数据集合 升序排列
	 * @param tagId
	 * @param btimeString
	 * @param etimString
	 * @param min
	 * @param max
	 * @return
	 */
	List<TblTemperature> getAlarmDataListByAsc(String histablename,String tagId,String btimeString,
			String etimString,int min , int max);
}
