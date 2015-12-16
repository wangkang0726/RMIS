package com.kunlunrisk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kunlunrisk.model.Model;


public interface ModelRepository extends JpaRepository<Model, Integer> {

}
