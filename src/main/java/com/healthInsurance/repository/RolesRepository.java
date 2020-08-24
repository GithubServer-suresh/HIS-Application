package com.healthInsurance.repository;

import org.springframework.data.repository.CrudRepository;

import com.healthInsurance.entity.RolesEntity;

public interface RolesRepository extends CrudRepository<RolesEntity,Integer> {
}
