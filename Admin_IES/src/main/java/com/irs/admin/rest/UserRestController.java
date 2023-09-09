package com.irs.admin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.irs.admin.bindings.DashboardCard;
import com.irs.admin.bindings.LoginForm;
import com.irs.admin.serive.UserService;

public class UserRestController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginForm loginForm) {
		String status = userService.loginUser(loginForm);
		if(status.equals("success")) {
			return "redirect:/ dashbord";
		}else {
			return status;
		}
	}
	
	@GetMapping("/dashboard")
	public ResponseEntity<DashboardCard> buildDashboard(){
	    DashboardCard dashbord = userService.fetchDashboardInfo();
	    
	    return new ResponseEntity<DashboardCard>(dashbord, HttpStatus.OK);
	}

}
