package com.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backoffice.model.ExtratResult;
import com.backoffice.service.IExtratResultService;

@Controller
@RequestMapping("extraResult")
public class ExtratResultController {
	
	@Autowired
	IExtratResultService iExtratResultService;

	@RequestMapping("findbyid")
	public String findbyid(Model model) {
		// 查数据
		ExtratResult extratResult = iExtratResultService.findByid(1);
		System.out.println("extratResult:" + extratResult);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		String str = sdf.format((Date)extratResult.getBirth());
//		System.out.println("birth:"+str);
		// 存数据
		model.addAttribute("extratResult", extratResult);
		return "index";
	}
	
	@RequestMapping("list")
	public String list() {
		List<ExtratResult> extratResults = iExtratResultService.findAllResult();
		for (ExtratResult extratResult : extratResults) {
			System.out.println(extratResult);
		}
		return null;
	}
	
	@RequestMapping("save")
	public String save(ExtratResult extratResult) {
		iExtratResultService.saveOrUpdate(extratResult);
		return null;
	}
	
	@RequestMapping("update")
	public String update(ExtratResult extratResult) {
		iExtratResultService.saveOrUpdate(extratResult);
		return null;
	}
	
	@RequestMapping("delete")
	public String delete(int id) {
		iExtratResultService.deleteByid(id);
		return null;
	}
}
