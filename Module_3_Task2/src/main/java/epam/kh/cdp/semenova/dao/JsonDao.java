package epam.kh.cdp.semenova.dao;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import epam.kh.cdp.semenova.bean.CitiesStatisticsByYears;
import epam.kh.cdp.semenova.util.EpamJsonDeserialazer;

@Repository
public class JsonDao implements Dao {

	@Value(value="${json.filePath}")
	private String pathToJson;

	public CitiesStatisticsByYears getCitiesStatisticsByYears() {
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(pathToJson);
		GsonBuilder gsonBuilder = new GsonBuilder();

		gsonBuilder.registerTypeAdapter(CitiesStatisticsByYears.class,
				new EpamJsonDeserialazer());
		Gson gson = gsonBuilder.create();
		JsonParser parser = new JsonParser();
		JsonReader reader;
		reader = new JsonReader(new InputStreamReader(resourceAsStream));

		JsonElement jsonWithStatistics = parser.parse(reader);
		CitiesStatisticsByYears statistcisData = gson.fromJson(
				jsonWithStatistics, CitiesStatisticsByYears.class);
		return statistcisData;
	}

}
