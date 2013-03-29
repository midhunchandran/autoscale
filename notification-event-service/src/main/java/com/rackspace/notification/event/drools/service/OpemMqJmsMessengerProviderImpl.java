package com.convenetech.notification.event.drools.service;

import java.util.Properties;

import org.drools.runtime.pipeline.Action;
import org.drools.runtime.pipeline.JmsMessengerProvider;
import org.drools.runtime.pipeline.Pipeline;
import org.drools.runtime.pipeline.ResultHandlerFactory;
import org.drools.runtime.pipeline.Service;
import org.drools.runtime.pipeline.impl.JmsUnwrapMessageObject;
import org.springframework.jms.core.JmsTemplate;

/**
 * This class is an workaround for not to use default JmsMessengerProvider which uses
 * default JNDI connection factory retrieved using Initial context. This class
 * fixes through using JmsTemplate configured with broker in any way.
 * 
 * @author aart0328
 * 
 */
public class OpemMqJmsMessengerProviderImpl implements JmsMessengerProvider {

	private JmsTemplate jmsTemplate;

	public OpemMqJmsMessengerProviderImpl() {
		super();
	}

	public OpemMqJmsMessengerProviderImpl(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	/**
	 * Workaround to fix the issue of custom JmsMessenger in retrieving Jndi
	 * object.
	 */
	@Override
	public Service newJmsMessenger(Pipeline pipeline, Properties properties,
			String destinationName, ResultHandlerFactory resultHandlerFactory) {

		return new CustomJmsMessenger(jmsTemplate, pipeline,
				resultHandlerFactory);
	}

	@Override
	public Action newJmsUnwrapMessageObject() {
		return new JmsUnwrapMessageObject();
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

}
