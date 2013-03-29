package com.convenetech.notification.event.api.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class IpAddress {
	
	@JsonIgnore
	private String private0_v4;
	private String public0_v6;
	private String public1_v4;
	private String  access_ip0_v4;
	private String  access_ip1_v6;
	@JsonProperty(value="default")
	private String defaultValue;

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	

}
