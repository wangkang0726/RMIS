package com.kunlunrisk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kunlunrisk.model.ProjectItem;

public interface ProjectItemRepository extends JpaRepository<ProjectItem, Integer> {

}
