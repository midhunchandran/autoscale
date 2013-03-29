package com.convenetech.notification.node.service.impl;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.convenetech.notification.event.service.dao.MonitoringDao;
import com.convenetech.notification.node.service.NodeManagerService;

@Component(value = "nodeManagerServiceImpl")
public class NodeManagerServiceImpl implements NodeManagerService {

	@Resource
	private DataSource mysqldataSource;

	private JdbcTemplate jdbcTemplate;

	private static org.apache.log4j.Logger log = Logger
			.getLogger(MonitoringDao.class);

	@PostConstruct
	public void init() {
		jdbcTemplate = new JdbcTemplate(mysqldataSource);

	}

	@Override
	public int getNodeCount() {
		try {
			return jdbcTemplate
					.queryForInt("SELECT count FROM monitoring.node_counter where id = 1");
		} catch (DataAccessException e) {
			log.error("problem retrieving node count from database"
					+ e.getMessage());
			throw e;
		}
	}

	@Override
	public void ensureNodeCount(int count) {
		String query = "UPDATE node_counter SET count="+ count + " WHERE id = 1";
		try {
			jdbcTemplate.update(query);
		} catch (DataAccessException e) {
			log.error("problem adding node count to database" + e.getMessage());
			throw e;
		}
	}

	public String getNodeStatus() {

		String query = "SELECT status FROM monitoring.autoscale_actions WHERE id = 1";
		try {
			return jdbcTemplate.queryForObject(query, String.class);
		} catch (DataAccessException e) {
			log.error("problem retrieving node staus from database"
					+ e.getMessage());
			throw e;
		}
	}
	
	public Date getNodeUpdateTime() {

		String query = "SELECT time_stamp FROM monitoring.autoscale_actions WHERE id = 1";
		try {
			return jdbcTemplate.queryForObject(query, Date.class);
		} catch (DataAccessException e) {
			log.error("problem retrieving node staus from database"
					+ e.getMessage());
			throw e;
		}
	}

	public void ensureNodeStatus(String status) {

		String query = "UPDATE autoscale_actions SET status='"+status +"' WHERE id = 1";
		try {
			jdbcTemplate.update(query);
		} catch (DataAccessException e) {
			log.error("problem adding node status to database"
					+ e.getMessage());
			throw e;
		}
	}

}
