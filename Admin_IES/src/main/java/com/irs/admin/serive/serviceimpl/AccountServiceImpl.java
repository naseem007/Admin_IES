package com.irs.admin.serive.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.irs.admin.bindings.UnlockAccountForm;
import com.irs.admin.bindings.UserAccountForm;
import com.irs.admin.entities.UserDetails;
import com.irs.admin.repository.UserRepo;
import com.irs.admin.serive.AccountService;
import com.irs.admin.utils.EmailUtils;

public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean createUserAccount(UserAccountForm accountForm) {
		UserDetails entity = new UserDetails();
		BeanUtils.copyProperties(accountForm, entity);
		//set the random pwd
		entity.setUserPassword(generatePwd());
		//set the account status
		entity.setAccStatus("LOCKED");
		entity.setActiveSwitch("Y");
		userRepo.save(entity);
		
		//send Email to the user
		String suject = "User Registation";
		String body = readEmailBody("REG_EMAIL_BODY.txt", entity);
		
		return emailUtils.sendEmail(suject, body, accountForm.getEmail());
	}

	@Override
	public List<UserAccountForm> fetchUserAccounts() {
		List<UserDetails> entity = userRepo.findAll();
		List<UserAccountForm> form = new ArrayList<UserAccountForm>();
		
		for(UserDetails userEntity : entity) {
			UserAccountForm userForm = new UserAccountForm();
			BeanUtils.copyProperties(userEntity, userForm);
			form.add(userForm);
		}
		return form;
	}

	@Override
	public UserAccountForm getUserAccountById(Integer userId) {
		Optional<UserDetails> optional = userRepo.findById(userId);
		if (optional.isPresent()) {
			UserDetails userDetails = optional.get();
			UserAccountForm user = new UserAccountForm();
			BeanUtils.copyProperties(userDetails, user);
			return user;
		}
		return null;
	}

	@Override
	public String changeAccountStatus(Integer userId, String status) {
		int cnt = userRepo.updateAccountStatus(userId, status);
		if (cnt > 0) {
			return "status changed";
		}
		return "Failed to change";
	}

	@Override
	public String unlockUserAccount(UnlockAccountForm unlockAccountForm) {
		UserDetails entity = userRepo.findByEmail(unlockAccountForm.getEmail());
		
		entity.setUserPassword(unlockAccountForm.getNewPwd());
		entity.setAccStatus("unlocked");
		return "Account Unlock";
	}
	private String generatePwd() {
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		// combine all strings
		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

		// create random string builder
		StringBuilder sb = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 6;

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphaNumeric.length());

			// get character specified by index
			// from the string
			char randomChar = alphaNumeric.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}

}
