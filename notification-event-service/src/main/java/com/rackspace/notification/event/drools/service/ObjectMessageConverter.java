package com.convenetech.notification.event.drools.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.convenetech.notification.event.api.common.NodeMetrics;

public class ObjectMessageConverter implements MessageConverter {

	@Override
	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {
		NodeMetrics metric = (NodeMetrics) object;
		ObjectMessage message = session.createObjectMessage(metric);
		return message;
	}

	@Override
	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {

		ObjectMessage omessage = (ObjectMessage) message;
		NodeMetrics metric = (NodeMetrics) omessage.getObject();
		return metric;
	}

}
