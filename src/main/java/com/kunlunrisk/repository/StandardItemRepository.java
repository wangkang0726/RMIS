package com.kunlunrisk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kunlunrisk.model.StandardItem;

public interface StandardItemRepository extends JpaRepository<StandardItem, Integer> {

}
