package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildModel;
import com.example.demo.repository.ChildRepo;

@Service
public class ChildService {
	@Autowired
	ChildRepo cr;
	
	public List<ChildModel> savedetails(List<ChildModel> c)
	{
		return (List<ChildModel>)cr.saveAll(c);
	}
	
	public List<ChildModel> sortinfo(String s)
	{
		return cr.findAll(Sort.by(Sort.Direction.DESC,s));
	}
	
	public List<ChildModel> getPage(int pageno,int psize)
	{
		Page<ChildModel> p =cr.findAll(PageRequest.of(pageno,psize));
		return p.getContent();
	}
	public List<ChildModel> getPageSort(int pageno,int psize,String s)
	{
		Page<ChildModel> p =cr.findAll(PageRequest.of(pageno,psize,Sort.by(s)));
		return p.getContent();
	}
}
