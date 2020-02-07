package com.carvuonganh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carvuonganh.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

}
