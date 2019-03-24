package com.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backoffice.model.Expert;
import com.backoffice.service.IExpertService;

@Controller
@RequestMapping("expert")
public class ExpertController {
	
	@Autowired
	IExpertService iExpertService;

//	@RequestMapping("findbyid")
//	public String findbyid(Model model) {
//		// 查数据
//		Expert expert = iExpertService.findByid(1);
//		System.out.println("expert:" + expert);
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
////		String str = sdf.format((Date)expert.getBirth());
////		System.out.println("birth:"+str);
//		// 存数据
//		model.addAttribute("expert", expert);
//		return "index";
//	}
	
	@RequestMapping("findbyid")
//	@RequestMapping(value="findbyid", method = RequestMethod.POST)
//	@GetMapping(value= {"findbyid"})
	@ResponseBody
	public String findbyid() {
		// 查数据
		Expert expert = iExpertService.findByid(1);
		System.out.println("expert:" + expert);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		String str = sdf.format((Date)expert.getBirth());
//		System.out.println("birth:"+str);
		// 存数据
		String jsonString = "{\"msg\":\"hello world\"}";
		return jsonString;
	}
	
	@RequestMapping("list")
	public String list() {
		List<Expert> experts = iExpertService.findAllExpert();
		for (Expert expert : experts) {
			System.out.println(expert);
		}
		return null;
	}
	
	@RequestMapping("save")
	public String save(Expert expert) {
		iExpertService.saveOrUpdate(expert);
		return null;
	}
	
	@RequestMapping("update")
	public String update(Expert expert) {
		iExpertService.saveOrUpdate(expert);
		return null;
	}
	
	@RequestMapping("delete")
	public String delete(int id) {
		iExpertService.deleteByid(id);
		return null;
	}
}