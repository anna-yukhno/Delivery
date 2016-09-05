/**
 * LocalStorage
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.impl;

import java.util.HashMap;
import delivery.api.Parcel;
import delivery.api.ParcelStorage;


public class LocalStorage implements ParcelStorage{

	HashMap<Integer, Parcel> parcMap;

	
	@Override
	public void saveParcel(ParcelClass parcel) {
		parcMap.put(parcel.ID, parcel);		
	}
	
	@Override
	public Parcel getParcelById(int id) {
		return parcMap.get(id);
	}

}
