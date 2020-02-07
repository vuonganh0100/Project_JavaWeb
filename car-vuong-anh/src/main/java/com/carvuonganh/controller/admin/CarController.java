package com.carvuonganh.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carvuonganh.dto.CarDTO;
import com.carvuonganh.dto.CategoryDTO;
import com.carvuonganh.service.ICarService;
import com.carvuonganh.service.ICategoryService;
import com.carvuonganh.utils.MessageUtil;



@Controller(value = "carControllerOfAdmin")
public class CarController {
	@Autowired
	private ICarService carsevice;
	
	@Autowired
	private ICategoryService categoryservice;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/quan-tri/car/danh-sach", method = RequestMethod.GET)
	public ModelAndView showlist(@RequestParam("page") int page,
			                     @RequestParam("limit") int limit, HttpServletRequest request ) {
		CarDTO model =new CarDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav=new ModelAndView("/admin/car/list");
		Pageable pageable =new PageRequest(page-1, limit);
		model.setListResult(carsevice.fildAll(pageable));
		model.setTotalItem(carsevice.getTotalItem());
		model.setTotalPage((int)Math.ceil((double)model.getTotalItem()/model.getLimit()));
	
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/car/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editCar(@RequestParam(value ="id", required = false ) Long id, HttpServletRequest request) {
		
		CarDTO model =new CarDTO();
		List<CategoryDTO> category=new ArrayList<>();
		if(id !=null) {
			model = carsevice.fildOne(id);
		}
		ModelAndView mav=new ModelAndView("/admin/car/edit");
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories", categoryservice.fildAll());
		mav.addObject("model",model);
		return mav;
		
	}
}
