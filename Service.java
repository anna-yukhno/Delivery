/**
 * interface Service
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.api;

import java.util.List;

public interface Service {

	/*
	 * Shows all of delivery methods
	 */
	void getDelMethods();

	/*
	 * @param tarif - delivery method
	 * 
	 * @param parc - the parcel
	 * 
	 * @param from
	 * 
	 * @param to
	 * 
	 * @return - full price of delivery
	 */
	Double getDeliveryPrice(int tarif, Parcel parc, int from, int to);

	/*
	 * @param fromOffice
	 * 
	 * @param toOffice
	 * 
	 * @return - distance between fromOffice & toOffice TESTED:)
	 */
	Long getDistance(int fromOffice, int toOffice);

	void setOffices(List<Office> offices);

	/*
	 * @param from
	 * 
	 * @param toOffice
	 * 
	 * @return - route of the parcel TESTED:)
	 */
	String selectOffices(int from, int to);

	/*
	 * @param delChoice gets the rate of chosen delivery method
	 */
	void getDeliveryMethod(int delChoice);

}
