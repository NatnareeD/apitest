package com.example.apitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apitest.entity.ApiEntity;


@Repository
public interface ApiJpaRepository extends JpaRepository<ApiEntity, Long>{
    
}