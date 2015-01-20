package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entity.TblTemperature;
/**
 * 解决：如果数据低于0度  持续30分钟的数据 不进行修改
 * @author Administrator
 * Dec 7, 2014
 * 11:26:23 AM
 */
public class CheckData {

	 private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 得到：{数据集合 持续(>、<、=...)参照值(>、<、=...)持续时间}内满足条件的时间段
	 * 
	 * @param datalist 时间按照升序排列的数据集合
	 * @param histo 存储间隔
	 * @param continueTime  持续时间
	 * @return  String[] :string[0]:存起始时间 string[1]:存结束时间
	 */
	public static String[] getNotDealPeriod(List<TblTemperature> datalist,int histo,int continueTime){
        //1、判断数据集合中最后一条超标时间的时间和第一条超标的时间差是否超过了持续时间
		//2、如果超过了持续时间，检查这段时间数据是否连续，即：该时间段按照存储间隔应该存放数据的条数是否<=实际的条数
		//3、如果不连续，就将倒数第二条做为新的结束时间点  。执行1,2,3
		
		Date btimeDate,etimeDate;//第一条超标的时间 （时间类型） 最后一条超标的时间  （时间类型）
		long conTime;//数据集合的实际持续时间
		long theoryCount=0,factCount=0;//理论应该存放数据的条数  、实际存放的条数
		String[] returnStrings = new String[2];//返回值
        btimeDate = datalist.get(0).getTestTime();//第一条超标时间
		etimeDate = datalist.get(datalist.size()-1).getTestTime();//最后一条超标时间
		conTime = (etimeDate.getTime()-btimeDate.getTime())/1000;//秒
		if(conTime<continueTime*60){//如果没有超过持续时间
			
			return null;
		}
//2     
		theoryCount = conTime/(histo*60)+1;
		
		for(int i=0;i<datalist.size();i++){
			if(datalist.get(i).getTestTime().equals(etimeDate)){
				factCount=i+1;
			}
		}
		if(factCount<theoryCount){//如果不连续
			
			datalist.remove(datalist.size()-1);
			
			getNotDealPeriod(datalist, histo, continueTime);//迭代
			
			if(getNotDealPeriod(datalist, histo, continueTime)==null){
				return null;
			}
			
		}
		returnStrings[0]= sdf.format(btimeDate);
		returnStrings[1]= sdf.format(etimeDate);
		return returnStrings;
		
	}
}
