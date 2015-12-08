package com.kunlunrisk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kunlunrisk.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
