/**
 * DBStorage
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.impl;

import java.sql.SQLException;
import delivery.api.Parcel;
import delivery.api.ParcelStorage;


public class DBStorage extends DBclass implements ParcelStorage {

	@Override
	public void saveParcel(ParcelClass parcel) throws SQLException {
	}

	/*
	 * overloading method
	 */
	public void saveParcel(int sendOfficeID, String sendOfficeName, String senderName, int recOfficeID,
			String recOfficeName, String recName, int parcID, int cost, int paid)
					throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);

			fillTableSend(sendOfficeID, senderName, senderName, parcID, cost, paid);
			fillTableRec(recOfficeID, recOfficeName, recName, parcID, cost, paid);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Parcel getParcelById(int id) throws SQLException {
		String condition = " where parcID = " + id;
		
		try {
			Class.forName(JDBC_DRIVER);

			selectAllSend(condition);
			selectAllRec(condition);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
