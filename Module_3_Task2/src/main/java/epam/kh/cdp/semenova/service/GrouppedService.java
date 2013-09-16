package epam.kh.cdp.semenova.service;


import org.springframework.beans.factory.annotation.Autowired;

import epam.kh.cdp.semenova.bean.CitiesStatisticsByYears;
import epam.kh.cdp.semenova.bean.YearsStatisticsByCities;
import epam.kh.cdp.semenova.dao.Dao;
import epam.kh.cdp.semenova.util.DataConverter;

@org.springframework.stereotype.Service
public class GrouppedService implements Service {

	@Autowired
	private Dao dao;

	public CitiesStatisticsByYears getCitiesStatisticsByYears() {

		return dao.getCitiesStatisticsByYears();
	}

	public YearsStatisticsByCities getYearsStatisticsByCities() {

		CitiesStatisticsByYears statisticsByYears = dao
				.getCitiesStatisticsByYears();

		return DataConverter.convert(statisticsByYears);
	}


}
