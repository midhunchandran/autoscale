package com.convenetech.notification.event.api.common;


public class Check {
	private String id;
	private String label;
	private String type;
	private CheckDetails details;
	private String[] monitoring_zones_poll;
	private int timeout;
	private int period;
	private String target_alias;
	private String target_hostname;
	private String target_resolver;
	private boolean disabled;
	private String metadata;
	private long created_at;
	private long updated_at;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public CheckDetails getDetails() {
		return details;
	}
	public void setDetails(CheckDetails details) {
		this.details = details;
	}
	public String[] getMonitoring_zones_poll() {
		return monitoring_zones_poll;
	}
	public void setMonitoring_zones_poll(String[] monitoring_zones_poll) {
		this.monitoring_zones_poll = monitoring_zones_poll;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getTarget_alias() {
		return target_alias;
	}
	public void setTarget_alias(String target_alias) {
		this.target_alias = target_alias;
	}
	public String getTarget_hostname() {
		return target_hostname;
	}
	public void setTarget_hostname(String target_hostname) {
		this.target_hostname = target_hostname;
	}
	public String getTarget_resolver() {
		return target_resolver;
	}
	public void setTarget_resolver(String target_resolver) {
		this.target_resolver = target_resolver;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	public long getCreated_at() {
		return created_at;
	}
	public void setCreated_at(long created_at) {
		this.created_at = created_at;
	}
	public long getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(long updated_at) {
		this.updated_at = updated_at;
	}
}
