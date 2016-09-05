/**
 * interface ParcelStorage
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.api;

import java.sql.SQLException;
import delivery.impl.ParcelClass;

public interface ParcelStorage {

	/*
	 * insert data in the local storage or in the database
	 * 
	 * @param parcel
	 */
	void saveParcel(ParcelClass parcel) throws SQLException;

	/*
	 * find a parcel in the storage by unique id
	 * 
	 * @param id
	 * 
	 * @return a found parcel
	 */
	Parcel getParcelById(int id) throws SQLException;

}
