package com.convenetech.notification.node.service.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.convenetech.notification.node.service.impl.NodeManagerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:monitoringDaoContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class NodeManagerServiceImplTest {

	@Autowired
	private NodeManagerServiceImpl daoImpl;

	@Test
	public void testGetNodeCount() {
		daoImpl.ensureNodeCount(2);
		assertEquals(2, daoImpl.getNodeCount());
		daoImpl.ensureNodeCount(3);
		assertEquals(3, daoImpl.getNodeCount());

	}

	@Test
	public void testGetNodeStatus() {

		daoImpl.ensureNodeStatus("NEW");
		assertEquals("NEW", daoImpl.getNodeStatus());
		daoImpl.ensureNodeStatus("PROGRESS");
		assertEquals("PROGRESS", daoImpl.getNodeStatus());
	}

	@Test
	public void testGetNodeDateTime() {
		Date date = daoImpl.getNodeUpdateTime();
		assertNotNull(date);
		System.out.println(date);

	}

	@Test
	public void testRulesLogic() {

		System.out.println(Minutes.minutesBetween(new DateTime(),
				new DateTime(daoImpl.getNodeUpdateTime())).isGreaterThan(
				Minutes.minutes(5)));
		System.out.println(new DateTime(daoImpl.getNodeUpdateTime()));
		System.out.println(new DateTime());

		if (Minutes.minutesBetween(new DateTime(),
				new DateTime(daoImpl.getNodeUpdateTime())).isGreaterThan(
				Minutes.minutes(5))
				&& (!daoImpl.getNodeStatus().equalsIgnoreCase("PROGRESS"))) {
			System.out.println("asdfsad fsdaf ");

		}

		DateTime datetime1 = new DateTime(daoImpl.getNodeUpdateTime());

		DateTime datetime2 = datetime1.minus(300000);
		
		System.out.println(Minutes.minutesBetween(datetime2,
				datetime1).getMinutes());
		
		System.out.println(Minutes.minutesBetween(datetime2,
				datetime1).isGreaterThan(Minutes.minutes(4)));

	}
}
