/**
 * OfficeClass
 * @version 17.0 
 * @author Anna Kovalenko, 2016
 */

package delivery.impl;

import delivery.api.Office;


public class OfficeClass implements Office {

	private String name;

	public OfficeClass(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
