package entity;

public class BoxModel {
	
	private String btime ;
	private String etime ;
	private String deviceNo ;//保温箱编号
	private float  min;     
	private float  max;
	private int interval;  //数据间隔
	private String oper;  //需要执行的操作：增加 删除  修正
	
	public BoxModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoxModel(String btime, String etime, String deviceNo, float min,
			float max, int interval, String oper) {
		super();
		this.btime = btime;
		this.etime = etime;
		this.deviceNo = deviceNo;
		this.min = min;
		this.max = max;
		this.interval = interval;
		this.oper = oper;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	

}
