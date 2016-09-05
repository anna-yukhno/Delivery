/**
 * ENUM Delivery
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.api;

public enum DELIVERY {
	BY_CAR(1), BY_POSTMAN(2);
	public int grnKm;

	private DELIVERY(int grnKm) {
		this.grnKm = grnKm;
	}

}
