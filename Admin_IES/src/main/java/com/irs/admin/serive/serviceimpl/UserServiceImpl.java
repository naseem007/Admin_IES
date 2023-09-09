package com.irs.admin.serive.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.irs.admin.bindings.DashboardCard;
import com.irs.admin.bindings.LoginForm;
import com.irs.admin.entities.EligEntity;
import com.irs.admin.entities.UserDetails;
import com.irs.admin.repository.EligRepo;
import com.irs.admin.repository.PlanRepo;
import com.irs.admin.repository.UserRepo;
import com.irs.admin.serive.UserService;
import com.irs.admin.utils.EmailUtils;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private EligRepo eligRepo;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String loginUser(LoginForm loginForm) {
	UserDetails entity = userRepo.findByEmailAndPwd(loginForm.getEmail(), loginForm.getPwd());
	
	if (entity == null) {
		return "Invalid Credential";
	}
	if ("Y".equals(entity.getActiveSwitch()) && "UNLOCKED".equals(entity.getAccStatus())) {
		return "success";
		
	} else {
		return "Account Locked/In-Active";

	 }
	}

	@Override
	public boolean recoverPassword(String email) {
	  UserDetails userEntity = userRepo.findByEmail(email);
	  
	  if (null == userEntity) {
		  return false;
		
	}else {
		String subject = "";
		String body = "";
		return emailUtils.sendEmail(subject, body, email);
	}
	}

	@Override
	public DashboardCard fetchDashboardInfo() {
		Long plansCount = planRepo.count();
		List<EligEntity> eligList = eligRepo.findAll();
		
		Long aprovedCont = eligList.stream().filter(ed->ed.getPlanStaus().equals("AP")).count();
	    Long denidCont = eligList.stream().filter(ed->ed.getPlanStaus().equals("DN")).count();
	    
	    Double total = eligList.stream().mapToDouble(ed->ed.getBenifitAmt()).sum();
	    
	    DashboardCard card = new DashboardCard();
	    card.setPlansCnt(plansCount);
	    card.setApprovedCnt(aprovedCont);
	    card.setDeniedCnt(denidCont);
	    card.setBeniftAmtGiven(total);
		return card;
	}

}
