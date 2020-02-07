package com.carvuonganh.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carvuonganh.dto.CarDTO;
import com.carvuonganh.service.ICarService;

@RestController(value = "carAPIOfAdmin")
public class CarAPI {
	
	@Autowired
	private ICarService carService;
	
	@PostMapping("/api/car")
	public CarDTO createCar(@RequestBody CarDTO carDTO) {
		return carService.save(carDTO);
	}

}
