package com.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backoffice.model.SubjectGroup;
import com.backoffice.service.ISubjectGroupService;

@Controller
@RequestMapping("subjectGroup")
public class SubjectGroupController {
	@Autowired
	ISubjectGroupService iSubjectGroupService;

	@RequestMapping("findbyid")
	public String findbyid(Model model) {
		// 查数据
		SubjectGroup subjectGroup = iSubjectGroupService.findByid(1);
		System.out.println("subjectGroup:" + subjectGroup);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		String str = sdf.format((Date)subjectGroup.getBirth());
//		System.out.println("birth:"+str);
		// 存数据
		model.addAttribute("subjectGroup:", subjectGroup);
		return "index";
	}
	
	@RequestMapping("list")
	public String list() {
		List<SubjectGroup> subjectGroups = iSubjectGroupService.findAllGroup();
		for (SubjectGroup subjectGroup : subjectGroups) {
			System.out.println(subjectGroup);
		}
		return null;
	}
	
	@RequestMapping("save")
	public String save(SubjectGroup subjectGroups) {
		iSubjectGroupService.saveOrUpdate(subjectGroups);
		return null;
	}
	
	@RequestMapping("update")
	public String update(SubjectGroup subjectGroups) {
		iSubjectGroupService.saveOrUpdate(subjectGroups);
		return null;
	}
	
	public String delete(int id) {
		iSubjectGroupService.deleteByid(id);
		return null;
	}
}
