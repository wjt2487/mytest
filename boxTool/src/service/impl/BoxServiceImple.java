package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BoxHisDataDao;
import dao.imple.BoxHisDataDaoImple;

import entity.TblTemperature;
import service.BoxService;
import util.CheckData;

public class BoxServiceImple implements BoxService {

	private BoxHisDataDao  boxHisDataDao=new BoxHisDataDaoImple();
	public boolean deleteHis(String histablename, String tagId, String btime,
			String etime) {
		// TODO Auto-generated method stub
		return boxHisDataDao.deleteHis(histablename, tagId, btime, etime);
	}

	public boolean insertHis3(String histablename, String taskId, String tagId,
			String begintime, String endtime, int interval, float min,
			float max, String precision) {
		// TODO Auto-generated method stub
		return boxHisDataDao.insertHis3(histablename, taskId, tagId, begintime, endtime, interval, min, max, precision);
	}

	public boolean insertOneHis(String histablename, String taskId,
			String tagId, String btime, double tvalue, String precision) {
		// TODO Auto-generated method stub
		return boxHisDataDao.insertOneHis(histablename, taskId, tagId, btime, tvalue, precision);
	}

	public boolean modifyHis(String histablename, String tagId, String btime,
			String etime, int min, int max, int lowLimit, int highLimit) {
		// TODO Auto-generated method stub
		return boxHisDataDao.modifyHis(histablename, tagId, btime, etime, min, max, lowLimit, highLimit);
	}

	public List<TblTemperature> queryBoxHisData(String tagId, String btime,
			String etime) {
		// TODO Auto-generated method stub
		return boxHisDataDao.queryBoxHisData(tagId, btime, etime);
	}

	public boolean updateOneData(String histablename, String tagId,
			String testtime, double TemperatureValue) {
		// TODO Auto-generated method stub
		return boxHisDataDao.updateOneData(histablename, tagId, testtime, TemperatureValue);
	}

	public String[] getNotDealPeriod(String histablename, String tagId,
			String btime, String etime, int histo, int continueTime, int min,
			int max) {
		// TODO Auto-generated method stub
		List<TblTemperature> list = new ArrayList<TblTemperature>();
		
		list = boxHisDataDao.getAlarmDataListByAsc(histablename, tagId, btime, etime, min, max);
		String[] s=CheckData.getNotDealPeriod(list, histo, continueTime);
		return s;
	}


}
