package com.convenetech.notification.event.drools.service;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.drools.runtime.pipeline.Pipeline;

public class NodeMetricMessageListener implements MessageListener {

	private Pipeline pipeline;

	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			ObjectMessage msg = (ObjectMessage) message;
			pipeline.insert(msg, null);
		} else {
			throw new IllegalArgumentException(
					"Message must be of type TextMessage");
		}
	}

	public Pipeline getPipeline() {
		return pipeline;
	}

	public void setPipeline(Pipeline pipeline) {
		this.pipeline = pipeline;
	}
}
