package com.carvuonganh.converter;

import org.springframework.stereotype.Component;

import com.carvuonganh.dto.CarDTO;
import com.carvuonganh.entity.CarEntity;
@Component
public class CarConverter {
	public CarDTO toDTO(CarEntity entity) {
		CarDTO dto =new CarDTO();
		dto.setName(entity.getName());
		dto.setId(entity.getId());
		dto.setCategoryId(entity.getCategory().getId());;
		dto.setContent(entity.getContent());
		dto.setThumbnail(entity.getThumbnail());
		dto.setShortDescription(entity.getShortDescription());
		dto.setCategoryCode(entity.getCategory().getCode());	
		return dto;
	}

	public CarEntity toEntity(CarDTO dto) {
		CarEntity result=new CarEntity();
		result.setContent(dto.getContent());
		result.setName(dto.getName());
		result.setThumbnail(dto.getThumbnail());
		result.setShortDescription(dto.getShortDescription());
		
		return result;
	}
}
