package com.convenetech.notification.event.api.common;

public class Observations {
	private String monitoring_zone_id;
	private String state;
	private String status;
	private long timestamp;
	
	public String getMonitoring_zone_id() {
		return monitoring_zone_id;
	}
	public void setMonitoring_zone_id(String monitoring_zone_id) {
		this.monitoring_zone_id = monitoring_zone_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
