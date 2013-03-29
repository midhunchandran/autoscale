package com.convenetech.notification.event.service;

import org.codehaus.jackson.map.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper {

	public CustomObjectMapper() {

		this.configure(
				org.codehaus.jackson.map.SerializationConfig.Feature.WRAP_ROOT_VALUE,
				true);
		this.configure(
				org.codehaus.jackson.map.DeserializationConfig.Feature.UNWRAP_ROOT_VALUE,
				true);

	}

}
