package com.carvuonganh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carvuonganh.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);

}
