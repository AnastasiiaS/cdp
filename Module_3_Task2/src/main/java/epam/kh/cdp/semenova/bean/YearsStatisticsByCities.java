package epam.kh.cdp.semenova.bean;

import java.util.Map;

public class YearsStatisticsByCities {

	private Map<City, EmployeesStatisticsByYears> data;

	public Map<City, EmployeesStatisticsByYears> getEmpl() {
		return data;
	}

	public void setEmpl(Map<City, EmployeesStatisticsByYears> empl) {
		this.data = empl;
	}

	@Override
	public String toString() {
		return "YearsStatisticsByCities [empl=" + data + "]";
	}
	
	
	
}
