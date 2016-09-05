/**
 * UserClass
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.impl;

import java.util.Scanner;
import org.apache.log4j.Logger;
import delivery.api.Service;
import delivery.api.User;


public class UserClass implements User {
	private static Logger logger = Logger.getLogger(UserClass.class);

	Double height, width, depth, weight;
	int fromOfficeNumb, toOfficeNumb, delChoice;
	String nameSend, nameRec;
	Service serv;
	
	public UserClass(Service serv) {
		this.serv = serv;
	}

	@Override
	public void enterData() {

		Scanner scan = new Scanner(System.in);
		logger.info("Enter height: ");
		height = scan.nextDouble();
		logger.info("Enter width: ");
		width = scan.nextDouble();
		logger.info("Enter depth: ");
		depth = scan.nextDouble();
		logger.info("Enter weight: ");
		weight = scan.nextDouble();

		logger.info("Enter ¹ of sender office: ");
		fromOfficeNumb = scan.nextInt();
		logger.info("Enter ¹ of receiver office: ");
		toOfficeNumb = scan.nextInt();

		logger.info("Select delivery method:\n1. By car\n2. By courier\nEnter: ");
		delChoice = scan.nextInt();

		logger.info("Sender name: ");
		nameSend = scan.next();
		logger.info("Receiver name: ");
		nameRec = scan.next();

		ParcelClass parcel = new ParcelClass(height, width, depth, weight);

		logger.debug("Parcel #" + parcel.ID + ": " + parcel.weight + " kg, " 
				+ parcel.volume + " cm3, " + serv.selectOffices(fromOfficeNumb, toOfficeNumb)
				+ " ( " + nameSend + " - " + nameRec + " ), " 
				+ serv.getDeliveryPrice(delChoice, parcel, fromOfficeNumb, toOfficeNumb) + " UAH.");
	}

}
