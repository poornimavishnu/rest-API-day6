package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.ChildModel;
import com.example.demo.service.ChildService;



public class ChildControl {
	@Autowired
	ChildService cs;
	
	@PostMapping("addn")
	public List<ChildModel> addDet(@RequestBody List<ChildModel> c)
	{
		return cs.savedetails(c);
	}
	@org.springframework.web.bind.annotation.GetMapping("sort{name}")
	public List<ChildModel> showsortinfo(@PathVariable String name)
	{
		return cs.sortinfo(name);
	}
	@GetMapping("paging/{pageno}/{psize}/{name}")
	public List<ChildModel> showpagesortinfo(@PathVariable int pageno,@PathVariable int psize,@PathVariable String name)
	{
		return cs.getPageSort(pageno,psize,name);
	}
	@GetMapping("paging/{pageno}/{psize}")
	public List<ChildModel> showpageinfo(@PathVariable int pageno,@PathVariable int psize)
	
	{
		return cs.getPage(pageno,psize);
	}
}
