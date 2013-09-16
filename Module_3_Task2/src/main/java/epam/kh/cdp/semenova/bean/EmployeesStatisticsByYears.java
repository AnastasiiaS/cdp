package epam.kh.cdp.semenova.bean;

import java.util.Map;

public class EmployeesStatisticsByYears {
	
	private Map<Integer, EmployeesOnQuarters> emplStat;

	public Map<Integer, EmployeesOnQuarters> getEmplStat() {
		return emplStat;
	}

	public void setEmplStat(Map<Integer, EmployeesOnQuarters> emplStat) {
		this.emplStat = emplStat;
	}

	@Override
	public String toString() {
		return "EmployeesStatisticsByYears [emplStat=" + emplStat + "]";
	}
	
	

}
