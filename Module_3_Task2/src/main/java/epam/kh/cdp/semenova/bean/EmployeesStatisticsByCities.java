package epam.kh.cdp.semenova.bean;

import java.util.Map;

public class EmployeesStatisticsByCities {
	
	private Map<City, EmployeesOnQuarters>  statosticsByCities;

	public Map<City, EmployeesOnQuarters> getStatosticsByCities() {
		return statosticsByCities;
	}

	public void setStatosticsByCities(
			Map<City, EmployeesOnQuarters> statosticsByCities) {
		this.statosticsByCities = statosticsByCities;
	}

	@Override
	public String toString() {
		return "EmployeesStatosticsByCities [statosticsByCities="
				+ statosticsByCities + "]";
	}

	
}
