package com.backoffice.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backoffice.model.Subject;
import com.backoffice.service.ISubjectService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import com.fasterxml.jackson.core.JsonProcessingException;  
import com.fasterxml.jackson.databind.JsonNode;  
import com.fasterxml.jackson.databind.ObjectMapper; 


@Controller
@RequestMapping("subject")
public class SubjectController {
	@Autowired
	ISubjectService iSubjectService;

//	@RequestMapping("findbyid")
//	public String findbyid(Model model) {
//		// ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
//		Subject Subject = iSubjectService.findByid(1);
//		System.out.println("Subject:" + Subject);
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
////		String str = sdf.format((Date)Subject.getBirth());
////		System.out.println("birth:"+str);
//		// ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
//		model.addAttribute("Subject", Subject);
//		return "index";
//	}
	
	@RequestMapping("findbyid")
	@ResponseBody
	public String findbyid() {
		

		Subject subject = iSubjectService.findByid(1);
		System.out.println("Subject:" + subject);
		String sjson = "{\"id\":\""+ subject.getId()+"\","+              
				"\"remarks\":\""+subject.getRemarks()+"\","+ 
				"\"subjectName\":\""+subject.getSubjectName()+
				"\"}";
		System.out.println("sjson"+sjson);

		return sjson;
	}
	
	
	
//	@RequestMapping("list")
//	public String list() {
//		List<Subject> Subjects = iSubjectService.findAllSubject();
//		for (Subject Subject : Subjects) {
//			System.out.println(Subject);
//		}
//		return null;
//	}
	
	@RequestMapping("list")
	@ResponseBody
	public List list(@RequestBody Subject subStr) {
		System.out.println(subStr);
		
//		JsonParser parse =new JsonParser(); 
//		
//		JsonObject params=(JsonObject) parse.parse(subStr);
//		System.out.println("jsonid="+params.get("id").getAsString());
//		
//		Subject sys = JSONObject.parseObject(subStr,Subject.class);
//		System.out.println("json="+sys);
		List<Subject> subjects = iSubjectService.findAllSubject();
		
		for (Subject subject : subjects) {
			System.out.println(subject);
			String sjson = "{\"id\":\""+ subject.getId()+"\","+              
					"\"remarks\":\""+subject.getRemarks()+"\","+ 
					"\"subjectName\":\""+subject.getSubjectName()+
					"\"}";
			
		}

		
		return subjects;
	}
	
	@RequestMapping("save")
	public String save(Subject Subject) {
		iSubjectService.saveOrUpdate(Subject);
		return null;
	}
	
	@RequestMapping("update")
	public String update(Subject Subject) {
		iSubjectService.saveOrUpdate(Subject);
		return null;
	}
	
	public String delete(int id) {
		iSubjectService.deleteByid(id);
		return null;
	}
}
