package com.carvuonganh.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.carvuonganh.dto.CategoryDTO;
import com.carvuonganh.service.ICategoryService;

public class MenuHandleInterceptor implements HandlerInterceptor{

	@Autowired
	private ICategoryService categoryServive;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<CategoryDTO> catemenu= new ArrayList<>();
		Map<String, String> map =categoryServive.fildAll();
		for(Map.Entry<String, String> entry: map.entrySet()) {
			CategoryDTO cateody= new CategoryDTO();
			cateody.setCode(entry.getKey());
			cateody.setName(entry.getValue());
			catemenu.add(cateody);
		}
		
		request.setAttribute("catemenu", catemenu);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
