package com.convenetech.notification.event.service.dao;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.convenetech.notification.event.api.common.NodeMetrics;

@Component
public class MonitoringDao {

	@Resource
	private DataSource mysqldataSource;

	private JdbcTemplate jdbcTemplate;

	private static org.apache.log4j.Logger log = Logger
			.getLogger(MonitoringDao.class);

	@PostConstruct
	public void init() {
		jdbcTemplate = new JdbcTemplate(mysqldataSource);

	}

	public void addNodeMetrics(NodeMetrics metric) {
		String statement = "INSERT INTO node_metrics(metrics_name, metrics_value, label, time_stamp) VALUES (?,?,?,?)";
		try {
			log.debug("Attempting to add node metrics to database" + metric);
			jdbcTemplate.update(statement, metric.getMetricName(),
					metric.getMetricValue(), metric.getLabel(),
					getDateFormat().format(metric.getDateTime()));
		} catch (DataAccessException e) {
			log.error("problem adding node metrics to database"
					+ e.getMessage());
			throw e;
		}
	}

	private SimpleDateFormat getDateFormat() {

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		TimeZone gmt = TimeZone.getTimeZone("GMT");
		if (!dateFormat.getTimeZone().getID().equals(gmt.getID()))
			dateFormat.setTimeZone(gmt);

		return dateFormat;
	}
}
