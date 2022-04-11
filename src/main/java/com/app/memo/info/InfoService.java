package com.app.memo.info;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.memo.info.model.Project;
import com.app.memo.info.model.Sawon;
import com.app.memo.info.repository.CityRepository;

@Service
public class InfoService {
	
	private final CityRepository cityRepository;
	
	// spring 4.2 이상은 @Autowired 생략 가능
	public InfoService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	public Project getProjectInfo() {
		
		Project project = new Project();
		project.projectName = "preword";
		project.author = "hello-bryan";
		project.createdDate = new Date();
		
		return project;
	}
	
	public List<Sawon> getCityList() {
		return this.cityRepository.findList();
	}
}