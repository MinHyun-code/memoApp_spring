package com.app.memo.info;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.memo.info.model.Project;
import com.app.memo.info.model.Sawon;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InfoController {

	private InfoService infoService;
	
	@Autowired
	public InfoController(InfoService infoService) {
		this.infoService = infoService;
	}
	
	@GetMapping("/info")
	public Object projectInfo() {
		log.info("/info start");
		Project project = infoService.getProjectInfo();
		return project;
	}
	
	@GetMapping("/info2")
	public String customJson() {
		JsonObject jo = new JsonObject();
		
		jo.addProperty("projectName", "preword");
		jo.addProperty("author", "hello-bryan");
		jo.addProperty("createdDate", new Date().toString());
		
		JsonArray ja = new JsonArray();
		for(int i=0; i<5; i++) {
			JsonObject jObj = new JsonObject();
			jObj.addProperty("prop"+i, i);
			ja.add(jObj);
		}
		
		jo.add("follower", ja);
		
		return jo.toString();
	}
	
	@GetMapping("/cityList")
	public Object cityList() {
		log.debug("/cityList start");
		List<Sawon> cityList = infoService.getCityList();
		return cityList;
	}
}
