package epam.kh.cdp.semenova.util;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import epam.kh.cdp.semenova.bean.CitiesStatisticsByYears;
import epam.kh.cdp.semenova.bean.City;
import epam.kh.cdp.semenova.bean.EmployeesOnQuarters;
import epam.kh.cdp.semenova.bean.EmployeesStatisticsByCities;
import epam.kh.cdp.semenova.bean.EmployeesStatisticsByYears;
import epam.kh.cdp.semenova.bean.YearsStatisticsByCities;

public class DataConverter {
	public static YearsStatisticsByCities convert(
			CitiesStatisticsByYears statisticsByYears) {

		YearsStatisticsByCities yearsStatisticsByCities = new YearsStatisticsByCities();
		Map<City, EmployeesStatisticsByYears> emplByCities = new TreeMap<City, EmployeesStatisticsByYears>();

		EmployeesStatisticsByYears employeesStatisticsByYears;
		Map<Integer, EmployeesOnQuarters> emplByYear;

		for (Entry<Integer, EmployeesStatisticsByCities> yearEntry : statisticsByYears
				.getCitiesStatistics().entrySet()) {
			for (Entry<City, EmployeesOnQuarters> cityEntry : yearEntry
					.getValue().getStatisticsByCities().entrySet()) {
				City city = cityEntry.getKey();
				if (!emplByCities.containsKey(city)) {
					employeesStatisticsByYears = new EmployeesStatisticsByYears();
					emplByYear = new TreeMap<Integer, EmployeesOnQuarters>();
					emplByYear.put(yearEntry.getKey(), cityEntry.getValue());
					employeesStatisticsByYears.setEmplStat(emplByYear);
					emplByCities.put(city, employeesStatisticsByYears);
				} else {
					employeesStatisticsByYears = emplByCities.get(city);
					emplByYear = employeesStatisticsByYears.getEmplStat();
					emplByYear.put(yearEntry.getKey(), cityEntry.getValue());
				}

			}

		}
		yearsStatisticsByCities.setEmpl(emplByCities);
		return yearsStatisticsByCities;
	}

}
