package epam.kh.cdp.semenova.bean;

import java.util.List;

public class EmployeesOnQuarters {

	private List<Integer> employeesQuantity;

	public List<Integer> getEmployeesQuantity() {
		return employeesQuantity;
	}

	public void setEmployeesQuantity(List<Integer> employeesQuantity) {
		this.employeesQuantity = employeesQuantity;
	}

	@Override
	public String toString() {
		return "EmployeesOnQuarter [employeesQuantity=" + employeesQuantity
				+ "]";
	}
	
	
}
