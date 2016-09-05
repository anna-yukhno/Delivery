/**
 * ParcelClass
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.impl;

import org.apache.log4j.Logger;
import delivery.api.Parcel;


public class ParcelClass implements Parcel {

	private static Logger logger = Logger.getLogger(ParcelClass.class);

	protected Double height, width, depth, weight;
	public Double volume, price;
	public int ID;

	public ParcelClass(double height, double width, double depth, double weight) {

		this.depth = depth;
		this.height = height;
		this.width = width;
		this.weight = weight;
		this.volume = (depth * height * width);
		this.ID = hashCode();
	}

	@Override
	public Double getPrice() {
		price = (volume / 4000) * 250;
		if (price < 65) {
			price = 65.0;
		}
		logger.debug("parcel volume is " + volume + "; parcel price is " + price);
		return price;
	}

}
