package com.convenetech.notification.event.api.common;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.convenetech.notification.event.util.MetricsDeSerializer;

@JsonDeserialize(using = MetricsDeSerializer.class)
public class Metrics {


	private List<Metric> metric;
	
	public Metrics() {
		super();
	}

	public Metrics(List<Metric> metric) {
		super();
		this.metric = metric;
	}

	public List<Metric> getMetric() {
		return metric;
	}

	public void setMetric(List<Metric> metric) {
		this.metric = metric;
	}

}
