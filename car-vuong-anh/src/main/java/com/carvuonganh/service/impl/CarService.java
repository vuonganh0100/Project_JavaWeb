package com.carvuonganh.service.impl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvuonganh.converter.CarConverter;
import com.carvuonganh.dto.CarDTO;
import com.carvuonganh.entity.CarEntity;
import com.carvuonganh.entity.CategoryEntity;
import com.carvuonganh.repository.CarRepository;
import com.carvuonganh.repository.CategoryRepository;
import com.carvuonganh.service.ICarService;
import com.carvuonganh.utils.SecurityUtils;

@Service
public class CarService implements ICarService {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CategoryRepository cateRepository;
	
	@Autowired
	private CarConverter carconveter;

	@Override
	public List<CarDTO> fildAll(Pageable pageable) {
		List<CarDTO> models= new ArrayList<>();
		List<CarEntity> entitys= carRepository.findAll(pageable).getContent();
		for(CarEntity entity: entitys) {
			CarDTO cardto= carconveter.toDTO(entity);
			models.add(cardto);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) carRepository.count();
	}

	@Override
	public CarDTO fildOne(Long id) {
		CarDTO model= new CarDTO();
		CarEntity carentity =carRepository.findOne(id);
		model= carconveter.toDTO(carentity);
		
		return model;
	}

	@Override
	@Transactional
	public CarDTO save(CarDTO dto) {
		
		CategoryEntity category =cateRepository.findOneByCode(dto.getCategoryCode());
		CarEntity carEntity=new CarEntity();
		if(dto.getId() != null) {
			
		}else {
			carEntity = carconveter.toEntity(dto);
			carEntity.setCategory(category);
		
		}
		
		return carconveter.toDTO(carRepository.save(carEntity));
	}
	
	

}
