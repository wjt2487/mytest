package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 判断两个时间是否相等
 * @author Administrator
 * Dec 4, 2014
 * 5:21:27 PM
 */
public class CompareTime {
	private static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 判断两个时间是否相等
	 * @param time1 
	 * @param time2
	 * @return
	 * @throws ParseException 
	 */
	public static int compareTime(String time1, String time2) throws ParseException {
		// TODO Auto-generated method stub
       long btime,etime;
       btime=sdf.parse(time1).getTime();
       etime=sdf.parse(time2).getTime();
       int r=-2;
       if(btime>etime){
       	r=1;
       }
       if(btime<etime){
       	r=-1;
       }
       if(btime==etime){
       	r=0;
       }
		return r;
	}
}
