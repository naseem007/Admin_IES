package com.irs.admin.serive.serviceimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.irs.admin.bindings.PlanForm;
import com.irs.admin.entities.PlanDetails;
import com.irs.admin.repository.PlanRepo;
import com.irs.admin.serive.PlanService;

public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlanRepo planRepo;

	@Override
	public boolean createPlan(PlanForm planForm) {
		PlanDetails planEntity = new PlanDetails();
		
		BeanUtils.copyProperties(planForm, planEntity);
		
		
		return false;
	}

	@Override
	public List<PlanForm> fetchPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanForm getPlanNameById(Integer planId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePlanStatus(Integer planId, String planStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
