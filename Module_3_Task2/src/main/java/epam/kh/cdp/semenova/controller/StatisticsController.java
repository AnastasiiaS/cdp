package epam.kh.cdp.semenova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import epam.kh.cdp.semenova.bean.YearsStatisticsByCities;
import epam.kh.cdp.semenova.service.GrouppedService;
import epam.kh.cdp.semenova.service.Service;

@Controller
@RequestMapping("/")
public class StatisticsController {

	@Autowired
	private GrouppedService service;

	@RequestMapping(value = "/stat", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		YearsStatisticsByCities yearsStatisticsByCities = service
				.getYearsStatisticsByCities();
		Gson gson = new Gson();
		String answ = gson.toJson(yearsStatisticsByCities);
		model.addAttribute("message", answ);

		return "statistics";
	}

	@ResponseBody
	@RequestMapping(value = "/stat/getData", method = RequestMethod.GET)
	public String getData() {

		YearsStatisticsByCities yearsStatisticsByCities = service
				.getYearsStatisticsByCities();
		Gson gson = new Gson();
		String answ = gson.toJson(yearsStatisticsByCities);
		return answ;
	}

}
