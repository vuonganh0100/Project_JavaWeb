package com.carvuonganh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carvuonganh.converter.CategoryConverter;
import com.carvuonganh.dto.CategoryDTO;
import com.carvuonganh.entity.CategoryEntity;
import com.carvuonganh.repository.CategoryRepository;
import com.carvuonganh.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public Map<String, String> fildAll() {
		Map<String,String> result= new HashMap<>();
		List<CategoryEntity> entitys = categoryRepository.findAll();
		for(CategoryEntity entity : entitys ) {
			result.put(entity.getCode(), entity.getName());
		}
		return result;
	}
	

}
