package com.convenetech.notification.event.api.common;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Entity {
	
	private String id;
	private String label;
	@JsonIgnore
	private IpAddress ip_addresses;
	@JsonIgnore
	private String metadata;
	@JsonIgnore
	private String managed;
	@JsonIgnore
	private String uri;
	@JsonIgnore
	private String agent_id;
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
	public IpAddress getIp_addresses() {
		return ip_addresses;
	}
	public void setIp_addresses(IpAddress ip_addresses) {
		this.ip_addresses = ip_addresses;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	public String getManaged() {
		return managed;
	}
	public void setManaged(String managed) {
		this.managed = managed;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
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
