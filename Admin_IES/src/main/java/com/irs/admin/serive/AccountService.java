package com.irs.admin.serive;

import java.util.List;

import com.irs.admin.bindings.UnlockAccountForm;
import com.irs.admin.bindings.UserAccountForm;

public interface AccountService {
	
	public boolean createUserAccount(UserAccountForm accountForm);
	
	public List<UserAccountForm> fetchUserAccounts();
	
	public UserAccountForm getUserAccountById(Integer userId);
	
	public String changeAccountStatus(Integer userId, String status);
	
    public String unlockUserAccount(UnlockAccountForm unlockAccountForm);
}
