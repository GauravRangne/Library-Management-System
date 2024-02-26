package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boot.dao.BookRepo;
import com.boot.entity.Book;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController {

	@Autowired
	BookRepo bk; 
	
	@RequestMapping("/")
	public String entry() {
		return "home.html";		
	}
	
	@RequestMapping("/addbk")
	public String m1() {
		return "addbk.html";		
	}
	
	@RequestMapping("/addbook")
	public String m2(HttpServletRequest request) {
	
		int bookId = Integer.parseInt(request.getParameter("bId"));		
		String bookNm =  request.getParameter("bNm");		
		int bookPrice = Integer.parseInt(request.getParameter("bPrc"));		
		String bookInfo = request.getParameter("bInfo");		
		String relDate = request.getParameter("rDate");
		
		bk.save(new Book(bookId, bookNm, bookPrice, bookInfo, relDate));
		
		return "/";		
	}
	
	@RequestMapping("/displaybk")
	public ModelAndView m3() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("displaybk.jsp");
		
		List<Book> lstbook = bk.findAll();
		
		mv.addObject("variable",lstbook);	// for tom handle language barrier in java (lstbookt) and Jsp (variable)
		// note : for variable use Only camalCase
		return mv;
	}
	
	@RequestMapping("/removebk")
	public String m4() {
		return "removebk.html";		
	}
	
	@RequestMapping("/removebook")
	public String m5(HttpServletRequest request) {
		
		int bookId = Integer.parseInt(request.getParameter("bId"));
		
		bk.deleteById(bookId);
		
		return "/";		
	}
	
	@RequestMapping("/updatebk")
	public String m7() {
		return "updatebk.html";
	}
	
	@RequestMapping("/updatebook")
	public String m8(HttpServletRequest request) {
	
		int bookId = Integer.parseInt(request.getParameter("bId"));
		String bookNm =  request.getParameter("bNm");		
		int bookPrice = Integer.parseInt(request.getParameter("bPrc"));		
		String bookInfo = request.getParameter("bInfo");		
		String relDate = request.getParameter("rDate");
		
		bk.updateInfo(bookId, bookNm, bookPrice, bookInfo,relDate);
		return "/";
	}	
}
