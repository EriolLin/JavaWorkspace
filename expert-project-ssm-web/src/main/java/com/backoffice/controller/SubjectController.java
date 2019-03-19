package com.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backoffice.model.Subject;
import com.backoffice.service.ISubjectService;

@Controller
@RequestMapping("subject")
public class SubjectController {
	@Autowired
	ISubjectService iSubjectService;

	@RequestMapping("findbyid")
	public String findbyid(Model model) {
		// 查数据
		Subject Subject = iSubjectService.findByid(1);
		System.out.println("Subject:" + Subject);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		String str = sdf.format((Date)Subject.getBirth());
//		System.out.println("birth:"+str);
		// 存数据
		model.addAttribute("Subject", Subject);
		return "index";
	}
	
	@RequestMapping("list")
	public String list() {
		List<Subject> Subjects = iSubjectService.findAllSubject();
		for (Subject Subject : Subjects) {
			System.out.println(Subject);
		}
		return null;
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
