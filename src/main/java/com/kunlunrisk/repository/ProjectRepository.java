package com.kunlunrisk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kunlunrisk.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
