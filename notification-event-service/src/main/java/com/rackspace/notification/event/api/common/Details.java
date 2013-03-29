package com.convenetech.notification.event.api.common;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Details {

	private String target;
	private long timestamp;
	private Metrics metrics;
	private String state;
	private String status;
	private String txn_id;
	private String collector_address_v4;
	private String collector_address_v6;
	@JsonIgnore
	private Observations[] observations;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Metrics getMetrics() {
		return metrics;
	}

	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
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

	public String getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}

	public String getCollector_address_v4() {
		return collector_address_v4;
	}

	public void setCollector_address_v4(String collector_address_v4) {
		this.collector_address_v4 = collector_address_v4;
	}

	public String getCollector_address_v6() {
		return collector_address_v6;
	}

	public void setCollector_address_v6(String collector_address_v6) {
		this.collector_address_v6 = collector_address_v6;
	}

	public Observations[] getObservations() {
		return observations;
	}

	public void setObservations(Observations[] observations) {
		this.observations = observations;
	}

}
