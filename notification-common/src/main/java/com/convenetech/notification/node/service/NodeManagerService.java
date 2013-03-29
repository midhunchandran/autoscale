package com.convenetech.notification.node.service;

import java.util.Date;

public interface NodeManagerService {
	
	
	public int getNodeCount();
	
	public void ensureNodeCount(int count);
	
	public String getNodeStatus();
	
	public void ensureNodeStatus(String status);
	
	public Date getNodeUpdateTime();

}
