package com.stackroute.purchase.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.purchase.model.Category;
import com.stackroute.purchase.repo.CategoryDAO;

@Controller

public class PurchaseController {

	@Autowired
	CategoryDAO categorydao; // use API  via service provide CategoryDAO

	
	@GetMapping("/")
	public String getFirst(ModelMap mp)
	{
		mp.addAttribute("categorieslist",categorydao.findallCategory());
		return "index";
	}
	
	@PostMapping("/save")
	public String addCategory(@ModelAttribute("category") Category catobj,ModelMap modelmap)
	{
		categorydao.addCategory(catobj);
		modelmap.addAttribute("categorieslist",categorydao.findallCategory());
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteCat(@RequestParam("catid") int cid,ModelMap modelmap)
	{
		categorydao.deleteCategory(cid);
		modelmap.addAttribute("categorieslist",categorydao.findallCategory());
		return "index";
		
	}
	
	
	@GetMapping("/findcat")
	public String findCategory(@RequestParam("catid") int cid,ModelMap modelmap )
	{
		Category catobj=categorydao.findByCategoryId(cid);
		modelmap.addAttribute("catobj",catobj);
		modelmap.addAttribute("categorieslist",categorydao.findallCategory());
		return "index";
		
	}
	
	@RequestMapping("/update")
	public String updCategory(@ModelAttribute("catupd") Category cobj)
	{ 
		
		System.out.println("Inside update " + cobj.getCname());
		categorydao.updCategory(cobj);
		return "redirect:/";
	
	}
}
