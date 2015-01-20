package entity;

import java.util.Date;

/**
 * TblTemperature entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TblTemperature implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date dtRecordEnter;
	private String taskId;
	private String tagId;
	private Date testTime;
	private double temperatureValue;
	private float humidityValue;
	private float valueLongitude;
	private float valueLatitude;
	private Integer clmDataType;
	private Integer clmGroupId;
	private String remark;
	private String vehicleId;
	private short ideviceStatus;
	private short ipower;
	private String clmUserName;

	// Constructors

	/** default constructor */
	public TblTemperature() {
	}

	/** minimal constructor */
	public TblTemperature(short ideviceStatus) {
		this.ideviceStatus = ideviceStatus;
	}

	/** full constructor */
	public TblTemperature(Date dtRecordEnter, String taskId, String tagId,
			Date testTime, double temperatureValue, float humidityValue,
			float valueLongitude, float valueLatitude, Integer clmDataType,
			Integer clmGroupId, String remark, String vehicleId,
			short ideviceStatus, short ipower, String clmUserName) {
		this.dtRecordEnter = dtRecordEnter;
		this.taskId = taskId;
		this.tagId = tagId;
		this.testTime = testTime;
		this.temperatureValue = temperatureValue;
		this.humidityValue = humidityValue;
		this.valueLongitude = valueLongitude;
		this.valueLatitude = valueLatitude;
		this.clmDataType = clmDataType;
		this.clmGroupId = clmGroupId;
		this.remark = remark;
		this.vehicleId = vehicleId;
		this.ideviceStatus = ideviceStatus;
		this.ipower = ipower;
		this.clmUserName = clmUserName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDtRecordEnter() {
		return this.dtRecordEnter;
	}

	public void setDtRecordEnter(Date dtRecordEnter) {
		this.dtRecordEnter = dtRecordEnter;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTagId() {
		return this.tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public Date getTestTime() {
		return this.testTime;
	}

	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}

	public double getTemperatureValue() {
		return this.temperatureValue;
	}

	public void setTemperatureValue(double temperatureValue) {
		this.temperatureValue = temperatureValue;
	}

	public float getHumidityValue() {
		return this.humidityValue;
	}

	public void setHumidityValue(float humidityValue) {
		this.humidityValue = humidityValue;
	}

	public float getValueLongitude() {
		return this.valueLongitude;
	}

	public void setValueLongitude(float valueLongitude) {
		this.valueLongitude = valueLongitude;
	}

	public float getValueLatitude() {
		return this.valueLatitude;
	}

	public void setValueLatitude(float valueLatitude) {
		this.valueLatitude = valueLatitude;
	}

	public Integer getClmDataType() {
		return this.clmDataType;
	}

	public void setClmDataType(Integer clmDataType) {
		this.clmDataType = clmDataType;
	}

	public Integer getClmGroupId() {
		return this.clmGroupId;
	}

	public void setClmGroupId(Integer clmGroupId) {
		this.clmGroupId = clmGroupId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public short getIdeviceStatus() {
		return this.ideviceStatus;
	}

	public void setIdeviceStatus(short ideviceStatus) {
		this.ideviceStatus = ideviceStatus;
	}

	public short getIpower() {
		return this.ipower;
	}

	public void setIpower(short ipower) {
		this.ipower = ipower;
	}

	public String getClmUserName() {
		return this.clmUserName;
	}

	public void setClmUserName(String clmUserName) {
		this.clmUserName = clmUserName;
	}

}