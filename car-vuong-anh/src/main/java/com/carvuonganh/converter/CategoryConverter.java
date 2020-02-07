package com.carvuonganh.converter;

import org.springframework.stereotype.Component;

import com.carvuonganh.dto.CategoryDTO;
import com.carvuonganh.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO model= new CategoryDTO();
		model.setCode(entity.getCode());
		model.setId(entity.getId());
		model.setName(entity.getName());
		return model;
	}

}
