package com.irs.admin.serive;

import com.irs.admin.bindings.DashboardCard;
import com.irs.admin.bindings.LoginForm;

public interface UserService {
	
	public String loginUser(LoginForm loginForm);
	
	public boolean recoverPassword(String email);
	
	public DashboardCard fetchDashboardInfo();

}
