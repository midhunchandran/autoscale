package com.convenetech.notification.event.service;

import java.util.Date;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.convenetech.notification.event.api.common.Metric;
import com.convenetech.notification.event.api.common.NodeMetrics;
import com.convenetech.notification.event.api.common.Notification;
import com.convenetech.notification.event.service.dao.MonitoringDao;

@Controller
public class NotificationEventWS {

	@Autowired
	private MonitoringDao daoImpl;

	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping(value = "/notification", method = RequestMethod.POST)
	public @ResponseBody
	void addNodeMetrics(@RequestBody Notification notification) {
		List<Metric> metrics = notification.getDetails().getMetrics()
				.getMetric();
		String label = notification.getEntity().getLabel();
		for (final Metric nodeMetric : metrics) {

			final NodeMetrics metric = new NodeMetrics();
			metric.setDateTime(new Date());
			metric.setLabel(label);
			metric.setMetricName(nodeMetric.getMetricName());
			metric.setMetricValue(nodeMetric.getData());
			daoImpl.addNodeMetrics(metric);
			jmsTemplate.send(new MessageCreator() {

				@Override
				public Message createMessage(Session session)
						throws JMSException {
					ObjectMessage message = session.createObjectMessage(metric);
					return message;
				}

			});
		}

	}
}
