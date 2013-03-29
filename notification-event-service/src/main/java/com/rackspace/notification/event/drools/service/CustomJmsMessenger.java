package com.convenetech.notification.event.drools.service;

import javax.jms.Message;

import org.drools.runtime.pipeline.Pipeline;
import org.drools.runtime.pipeline.ResultHandlerFactory;
import org.drools.runtime.pipeline.Service;
import org.drools.runtime.pipeline.impl.BaseService;
import org.springframework.jms.core.JmsTemplate;

public class CustomJmsMessenger extends BaseService implements Service {

	private JmsTemplate jmsTemplate;

	private ResultHandlerFactory resultHandlerFactory;

	private Pipeline pipeline;

	private Thread thread;

	private JmsMessengerRunner jmsFeederRunner;

	public CustomJmsMessenger(JmsTemplate jmsTemplate, Pipeline pipeline,
			ResultHandlerFactory resultHandlerFactory) {
		super();
		this.pipeline = pipeline;
		this.resultHandlerFactory = resultHandlerFactory;
		this.jmsTemplate = jmsTemplate;
	}

	public void start() {
		this.jmsFeederRunner = new JmsMessengerRunner(this.jmsTemplate,
				this.pipeline, this.resultHandlerFactory);
		this.jmsFeederRunner.setRun(true);
		this.thread = new Thread(this.jmsFeederRunner);
		this.thread.start();
	}

	public void stop() {
		this.jmsFeederRunner.setRun(false);
	}

	public static class JmsMessengerRunner implements Runnable {
		private Pipeline pipeline;
		private ResultHandlerFactory resultHandlerFactory;
		private volatile boolean run;
		private JmsTemplate jmsTemplate;

		public JmsMessengerRunner(JmsTemplate jmsTemplate, Pipeline pipeline,
				ResultHandlerFactory resultHandlerFactory) {
			super();
			this.jmsTemplate = jmsTemplate;
			this.pipeline = pipeline;
			this.resultHandlerFactory = resultHandlerFactory;
		}

		public void run() {
			while (this.run) {
				Message msg = null;
				msg = this.jmsTemplate.receive();
				if (msg != null) {
					if (this.resultHandlerFactory != null) {
						pipeline.insert(msg,
								this.resultHandlerFactory.newResultHandler());
					} else {
						pipeline.insert(msg, null);
					}
				}
			}
		}

		public void setRun(boolean run) {
			this.run = run;
		}

	}

}
