package epam.kh.cdp.semenova.bean;

import java.util.Map;

public class CitiesStatisticsByYears {

	private Map<Integer, EmployeesStatisticsByCities> citiesStatistics;

	public Map<Integer, EmployeesStatisticsByCities> getCitiesStatistics() {
		return citiesStatistics;
	}

	public void setCitiesStatistics(
			Map<Integer, EmployeesStatisticsByCities> citiesStatistics) {
		this.citiesStatistics = citiesStatistics;
	}

	@Override
	public String toString() {
		return "CitiesStatisticsByYears [citiesStatistics=" + citiesStatistics
				+ "]";
	}
	
	
}
