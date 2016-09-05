/**
 * ServiceTest
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import delivery.api.Office;
import delivery.api.Parcel;
import delivery.api.Service;
import delivery.impl.OfficeClass;
import delivery.impl.ParcelClass;
import delivery.impl.ServiceClass;


public class ServiceTest {
	private static Logger logger = Logger.getLogger(ServiceTest.class);

	/*
	 * Я знаю, что у меня в каждом методе есть блок, который просится наверх, но
	 * тогда область видимости объектов будет ограничена и недоступна тестам.
	 * Подскажи, пож, как грамотно это сделать.
	 */

	@BeforeClass
	public static void prepareGlobal() {
		logger.debug("Prepare global variables");
	}

	@Before
	public void prepareBeforeEachRun() {
		logger.debug("Before test method invocation");
	}

	@Test
	public void testSelectOffices() {
		logger.debug("Test selectOffices");

		List<Office> testOffices = new ArrayList<>();
		testOffices.add(new OfficeClass("Acity"));
		testOffices.add(new OfficeClass("Bcity"));
		testOffices.add(new OfficeClass("Ccity"));

		Service service = ServiceClass.getInstance();
		service.setOffices(testOffices);

		String result = "from Acity to Bcity";
		Assert.assertEquals("ATTENTION ", result, service.selectOffices(0, 1));
	}

	@Test
	public void testGetDistance() {
		logger.debug("Test getDistance");

		List<Office> testOffices = new ArrayList<>();
		testOffices.add(new OfficeClass("Acity"));
		testOffices.add(new OfficeClass("Bcity"));
		testOffices.add(new OfficeClass("Ccity"));

		Service service = ServiceClass.getInstance();
		service.setOffices(testOffices);

		Long result = 100l;
		Assert.assertEquals("ATTENTION ", result, service.getDistance(0, 2));
	}

	@Test
	public void testGetDeliveryPrice() {
		logger.debug("Test getDeliveryPrice");

		List<Office> testOffices = new ArrayList<>();
		testOffices.add(new OfficeClass("Acity"));
		testOffices.add(new OfficeClass("Bcity"));
		testOffices.add(new OfficeClass("Ccity"));

		Service service = ServiceClass.getInstance();
		service.setOffices(testOffices);
		Parcel parcel = new ParcelClass(10, 10, 10, 10);

		Double result = 165.0;
		Assert.assertEquals("ATTENTION ", result, service.getDeliveryPrice(1, parcel, 0, 2));
	}

	@After
	public void afterEachRun() {
		logger.debug("After test method invocation");
	}

	@AfterClass
	public static void afterGlobal() {
		logger.debug("After all methods");

	}

}
