package epam.kh.cdp.semenova.bean;

import java.util.Map;

public class EmployeesStatisticsByCities {
	
	private Map<City, EmployeesOnQuarters>  statisticsByCities;

	public Map<City, EmployeesOnQuarters> getStatisticsByCities() {
		return statisticsByCities;
	}

	public void setStatisticsByCities(
			Map<City, EmployeesOnQuarters> statisticsByCities) {
		this.statisticsByCities = statisticsByCities;
	}

	@Override
	public String toString() {
		return "EmployeesStatisticsByCities [statisticsByCities="
				+ statisticsByCities + "]";
	}

	
}
