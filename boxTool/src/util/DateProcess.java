package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateProcess {
	/**
	 *在给定的日期上增加几分钟
	 *@param interva  增加的分钟数
	 * @throws ParseException 
	 */
	private static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static String DateAddMinute(String  time,int interval) throws ParseException{
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date date =null;
       date=sdf.parse(time);
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE,interval);
		date=calendar.getTime();
		return sdf.format(date);
	}
	/**
	 * 一个时间段内  按照固定间隔可以分为多少段
	 * @param btime
	 * @param etime
	 * @param interval
	 * @return
	 */
	public static long getTimeInterval(String btime,String etime,int interval) {
		long time1,time2, intervals=0;
		
		try {
			time1=sdf.parse(btime).getTime();
			time2=sdf.parse(etime).getTime();
			if(time2!=time1){
				//间隔数
				 intervals = (time2 - time1)/(interval*1000*60);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获得时间段数失败！！");
		}
		return intervals;
	}
	
}
