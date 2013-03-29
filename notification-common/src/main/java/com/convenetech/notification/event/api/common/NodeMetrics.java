package com.convenetech.notification.event.api.common;

import java.io.Serializable;
import java.util.Date;

public class NodeMetrics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8180878123627237674L;
	private String label;
	private String metricName;
	private String metricValue;
	private Date dateTime;

	public NodeMetrics() {
		super();
	}

	public NodeMetrics(String label, String metricName, String metricValue,
			Date dateTime) {
		super();
		this.setLabel(label);
		this.metricName = metricName;
		this.metricValue = metricValue;
		this.dateTime = dateTime;
	}

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public String getMetricValue() {
		return metricValue;
	}

	public void setMetricValue(String metricValue) {
		this.metricValue = metricValue;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
