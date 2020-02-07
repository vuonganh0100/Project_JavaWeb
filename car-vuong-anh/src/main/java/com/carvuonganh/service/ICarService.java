package com.carvuonganh.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.carvuonganh.dto.CarDTO;


public interface ICarService {
	List<CarDTO> fildAll(Pageable pageable);
	int getTotalItem();
	CarDTO fildOne(Long id);
	CarDTO save(CarDTO dto);

}
