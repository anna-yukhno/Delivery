/**
 * ServiceClass
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.impl;

import java.util.List;
import org.apache.log4j.Logger;
import delivery.api.DELIVERY;
import delivery.api.Office;
import delivery.api.Parcel;
import delivery.api.Service;


public class ServiceClass implements Service {

	private static Logger logger = Logger.getLogger(ServiceClass.class);

	/*
	 * singleton
	 */
	private static ServiceClass instance;

	List<Office> offices;

	protected ServiceClass() {
	}

	public static ServiceClass getInstance() {
		if (instance == null) {
			instance = new ServiceClass();
		}
		return instance;
	}

	@Override
	public void getDelMethods() {
		for (DELIVERY del : DELIVERY.values()) {
			logger.info(del);
		}
	}

	@Override
	public Double getDeliveryPrice(int tarif, Parcel parc, int from, int to) {
		double deliveryPrice;
		long distance = getDistance(from, to);
		deliveryPrice = (double) (distance * tarif) + parc.getPrice();
		
		logger.debug("distance is " + distance + ", chosen tarif is " + tarif 
				+ " UAH/km, parcel's cost "
				+ parc.getPrice() + "; result = " + deliveryPrice);
		
		return deliveryPrice;
	}

	@Override
	public Long getDistance(int fromOffice, int toOffice) {
		Long distance = 0L;		
		Long dist_val = 50L;

		logger.debug("Total offices quantity = " + offices.size());

		if (fromOffice < toOffice) {
			for (int i = fromOffice; i < toOffice; i++) {
				distance += dist_val;
			}
		} else if (fromOffice > toOffice) {
			for (int i = fromOffice; i > toOffice; i--) {
				distance += dist_val;
			}
		}
		logger.debug("from " + offices.get(fromOffice).getName() +
				" to " + offices.get(toOffice).getName() + " = " + distance + " km");
		
		return distance;
	}

	@Override
	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}

	@Override
	public String selectOffices(int fromOffice, int toOffice) {
		String from = "", to = "";
		if (((fromOffice < 0) || (fromOffice > offices.size())) 
				|| ((toOffice > offices.size()) || (toOffice < 0))) {

			logger.error("Office with this number doesn't exist");
		} else {
			from = offices.get(fromOffice).getName();
			to = offices.get(toOffice).getName();
		}
		return "from " + from + " to " + to;
	}

	@Override
	public void getDeliveryMethod(int delChoice) {
		switch (delChoice) {
		case 1:
			logger.debug("By car" + " - " + (DELIVERY.BY_CAR.grnKm) + " UAH/km");
			break;
		case 2:
			logger.debug("By postman" + " - " + (DELIVERY.BY_POSTMAN.grnKm) + " UAH/km");
			break;
		default:
			logger.debug("Invalid method");
		}
	}

}
