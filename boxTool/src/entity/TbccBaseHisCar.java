package entity;

import java.util.Date;

/**
 * 
 * @author Administrator
 *
 */
public class TbccBaseHisCar implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id ;
	private Long parentId ;
	
	private Date updateTime ;
	private Double ai1;
	private Double ai2;
	private Double ai3;
	private Double ai4;
	private Integer latitude_dir;
	private Double latitude;
	private Integer longitude_dir ;
	private Double longitude;
	private Integer alarmStatus;
	private Integer unloadStatus;

	private Integer histAlarmStorageType ;

	private Integer gpsStorageType ;

	private Integer histDataStorageType;

	private Integer unloadStorageType;

	private Integer histAlarmData;
	
	public TbccBaseHisCar(){super();}
	public TbccBaseHisCar(Long id ,Long parentId , Date updateTime , Double ai1, Double ai2, Double ai3,
			Double ai4, Integer latitude_dir, Double latitude, Integer longitude_dir ,Double longitude,
			Integer alarmStatus, Integer unloadStatus, Integer histAlarmStorageType, Integer gpsStorageType 
			,Integer histDataStorageType, Integer unloadStorageType, Integer histAlarmData){
		super();
		this.id = id;
		this.parentId = parentId;
		this.updateTime = updateTime;
		this.ai1 = ai1;
		this.ai2 = ai2;
		this.ai3 = ai3;
		this.ai4 = ai4;
		this.latitude_dir = latitude_dir;
		this.latitude  =latitude;
		this.longitude_dir = longitude_dir;
		this.longitude = longitude;
		this.alarmStatus = alarmStatus;
		this.unloadStatus = unloadStatus;
		this.histAlarmStorageType = histAlarmStorageType;
		this.gpsStorageType = gpsStorageType;
		this.histDataStorageType = histDataStorageType;
		this.unloadStorageType = unloadStorageType;
		this.histAlarmData = histAlarmData;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Double getAi1() {
		return ai1;
	}
	public void setAi1(Double ai1) {
		this.ai1 = ai1;
	}
	public Double getAi2() {
		return ai2;
	}
	public void setAi2(Double ai2) {
		this.ai2 = ai2;
	}
	public Double getAi3() {
		return ai3;
	}
	public void setAi3(Double ai3) {
		this.ai3 = ai3;
	}
	public Double getAi4() {
		return ai4;
	}
	public void setAi4(Double ai4) {
		this.ai4 = ai4;
	}
	public Integer getLatitude_dir() {
		return latitude_dir;
	}
	public void setLatitude_dir(Integer latitude_dir) {
		this.latitude_dir = latitude_dir;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Integer getLongitude_dir() {
		return longitude_dir;
	}
	public void setLongitude_dir(Integer longitude_dir) {
		this.longitude_dir = longitude_dir;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getAlarmStatus() {
		return alarmStatus;
	}
	public void setAlarmStatus(Integer alarmStatus) {
		this.alarmStatus = alarmStatus;
	}
	public Integer getUnloadStatus() {
		return unloadStatus;
	}
	public void setUnloadStatus(Integer unloadStatus) {
		this.unloadStatus = unloadStatus;
	}
	public Integer getHistAlarmStorageType() {
		return histAlarmStorageType;
	}
	public void setHistAlarmStorageType(Integer histAlarmStorageType) {
		this.histAlarmStorageType = histAlarmStorageType;
	}
	public Integer getGpsStorageType() {
		return gpsStorageType;
	}
	public void setGpsStorageType(Integer gpsStorageType) {
		this.gpsStorageType = gpsStorageType;
	}
	public Integer getHistDataStorageType() {
		return histDataStorageType;
	}
	public void setHistDataStorageType(Integer histDataStorageType) {
		this.histDataStorageType = histDataStorageType;
	}
	public Integer getUnloadStorageType() {
		return unloadStorageType;
	}
	public void setUnloadStorageType(Integer unloadStorageType) {
		this.unloadStorageType = unloadStorageType;
	}
	public Integer getHistAlarmData() {
		return histAlarmData;
	}
	public void setHistAlarmData(Integer histAlarmData) {
		this.histAlarmData = histAlarmData;
	}
	
}
