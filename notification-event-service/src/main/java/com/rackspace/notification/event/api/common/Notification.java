package com.convenetech.notification.event.api.common;

import org.codehaus.jackson.annotate.JsonIgnore;



public class Notification {

	
	private String event_id;
	private String log_entry_id;
	private Details details;
	private Entity entity;
	@JsonIgnore
	private Check check;
	@JsonIgnore
	private Alarm alarm;
	private String tenant_id;

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getLog_entry_id() {
		return log_entry_id;
	}

	public void setLog_entry_id(String log_entry_id) {
		this.log_entry_id = log_entry_id;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public Alarm getAlarm() {
		return alarm;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}

	public String getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}

}
