package epam.kh.cdp.semenova.util;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import epam.kh.cdp.semenova.bean.CitiesStatisticsByYears;
import epam.kh.cdp.semenova.bean.City;
import epam.kh.cdp.semenova.bean.EmployeesOnQuarters;
import epam.kh.cdp.semenova.bean.EmployeesStatisticsByCities;

public class EpamJsonDeserialazer implements
		JsonDeserializer<CitiesStatisticsByYears> {
	
	public CitiesStatisticsByYears deserialize(JsonElement json, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		JsonObject root = json.getAsJsonObject();
		JsonElement epam = root.get("EPAM");
		TypeToken<Map<String, Map<String, List<Integer>>>> mapToken = new TypeToken<Map<String, Map<String, List<Integer>>>>() {
		};
		Gson gson = new Gson();
		Map<String, Map<String, List<Integer>>> data = gson.fromJson(epam,
				mapToken.getType());

		CitiesStatisticsByYears citiesStatisticsByYears = new CitiesStatisticsByYears();
		Map<Integer, EmployeesStatisticsByCities> statByYears = new TreeMap<Integer, EmployeesStatisticsByCities>();
		for (Map.Entry<String, Map<String, List<Integer>>> entryData : data
				.entrySet()) {
			Integer year = parseYear(entryData.getKey());
			EmployeesStatisticsByCities employeesStatosticsByCities = new EmployeesStatisticsByCities();

			Map<City, EmployeesOnQuarters> statByCities = new HashMap<City, EmployeesOnQuarters>();
			for (Map.Entry<String, List<Integer>> statByCity : entryData
					.getValue().entrySet()) {
				City city = new City();
				city.setCityName(statByCity.getKey());
				EmployeesOnQuarters employeesOnQuarters = new EmployeesOnQuarters();
				employeesOnQuarters.setEmployeesQuantity(statByCity.getValue());
				statByCities.put(city, employeesOnQuarters);
			}
			employeesStatosticsByCities.setStatisticsByCities(statByCities);
			statByYears.put(year, employeesStatosticsByCities);
		}

		citiesStatisticsByYears.setCitiesStatistics(statByYears);
		return citiesStatisticsByYears;
	}

	private Integer parseYear(String key) {
		return Integer.valueOf(key.split("Year")[1]);
	}

}
