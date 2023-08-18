package com.irs.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irs.admin.entities.PlanDetails;

@Repository
public interface PlanRepo extends JpaRepository<PlanDetails, Integer> {
}
