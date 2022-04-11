package com.app.memo.info.model;

import java.util.Date;

import lombok.Data;

@Data
public class Project {
	public String projectName;
	public String author;
	public Date createdDate;
}
