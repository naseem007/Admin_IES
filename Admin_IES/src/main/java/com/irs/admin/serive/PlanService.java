package com.irs.admin.serive;

import java.util.List;

import com.irs.admin.bindings.PlanForm;

public interface PlanService {
	
	public boolean createPlan(PlanForm planForm);
	
	public List<PlanForm> fetchPlan();
	
	public PlanForm getPlanNameById(Integer planId);
	
	public String changePlanStatus(Integer planId, String planStatus);

}
