package com.convenetech.notification.event.drools.service;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.drools.ClassObjectFilter;
import org.drools.runtime.ObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

import com.convenetech.notification.event.api.common.NodeMetrics;

public class RuleEngineService {

	private StatefulKnowledgeSession rsession;

	private static org.apache.log4j.Logger log = Logger
			.getLogger(RuleEngineService.class);
	

	public RuleEngineService() {
		super();
	}

	public void timedFireAllRules() {

		ObjectFilter filter = new ClassObjectFilter(NodeMetrics.class);
		Collection<FactHandle> handles = rsession.getFactHandles(filter);
		//handlers getting reference so have to do to deep copy
		Collection<FactHandle> copiedHandles = new ArrayList<FactHandle>();
		copiedHandles.addAll(handles);
		log.debug("calling fire all rules now");
		//rsession.startProcess("firstFlow");
		rsession.fireAllRules();
		for (FactHandle handle : copiedHandles) {
			rsession.retract(handle);
		}
	}

	public StatefulKnowledgeSession getRsession() {
		return rsession;
	}

	public void setRsession(StatefulKnowledgeSession rsession) {
		this.rsession = rsession;
	}

}
