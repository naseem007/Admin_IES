package com.irs.admin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irs.admin.bindings.UserAccountForm;
import com.irs.admin.serive.AccountService;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/user")
	public ResponseEntity<String> createAccount(@RequestBody UserAccountForm userAccountForm){
		
		boolean staus = accountService.createUserAccount(userAccountForm);
		
		if(staus) {
			return new ResponseEntity<>("Account Created",HttpStatus.CREATED);//201
		}else {
			return new ResponseEntity<String>("Account Creation Faild",HttpStatus.INTERNAL_SERVER_ERROR);//500
		}	
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserAccountForm>> getUsers(){
		List<UserAccountForm> accountForm = accountService.fetchUserAccounts();
		return new ResponseEntity<List<UserAccountForm>>(accountForm, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserAccountForm> getUserAccountById(@PathVariable Integer userId){
		
	UserAccountForm accountForm =	accountService.getUserAccountById(userId);
		return new ResponseEntity<UserAccountForm>(accountForm, HttpStatus.OK);
		
	}
	
	@PutMapping("/user/{userId}/status")
	public ResponseEntity<List<UserAccountForm>> updateUserStatus(@PathVariable Integer userId, @PathVariable String status){
		accountService.changeAccountStatus(userId, status);
		List<UserAccountForm> userAccount = accountService.fetchUserAccounts();
		return new ResponseEntity<List<UserAccountForm>>(userAccount, HttpStatus.OK);
		
	}
	}
