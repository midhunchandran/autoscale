package com.convenetech.notification.event.api.common;


public class Metric {
	
	private String metricName;
	
	private String type;
	
	private String data;

	public Metric() {
		super();
	}

	public Metric(String metricName, String type, String data) {
		super();
		this.metricName = metricName;
		this.type = type;
		this.data = data;
	}

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
