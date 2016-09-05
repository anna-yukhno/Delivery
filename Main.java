/**
 * Main
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.impl;

import java.util.ArrayList;
import java.util.List;
import delivery.api.Office;
import delivery.api.Service;


public class Main {

	public static void main(String[] args) {
		
		List<Office> offices = new ArrayList <>();
		offices.add(new OfficeClass("Kharkiv"));
		offices.add(new OfficeClass("Kiev"));
		offices.add(new OfficeClass("Odessa"));
		offices.add(new OfficeClass("Poltava"));
		offices.add(new OfficeClass("Dnepr"));
		offices.add(new OfficeClass("Lviv"));
		offices.add(new OfficeClass("Ternopol"));
		offices.add(new OfficeClass("Herson"));
		
		Service service = ServiceClass.getInstance();
		service.setOffices(offices);
		
		UserClass user = new UserClass(service);
		user.enterData();
	}
}
