package util;

import java.util.Random;

public class ProduceRandom {

	/**
	 * 产生min~max之间的随机数
	 * @param min   产生随机数的最小值
	 * @param max   产生随机数的最大值
	 * @param precision  产生随机数的精度
	 * @return
	 */
	public static double getRandom(int min,int max,String precision) {
		Random random=new Random();
		double d =random.nextDouble()*(max-min-1)*10;
		int i = (int) d+min;
		double f =i/10.0+min;
		
		return f;
	}
}
