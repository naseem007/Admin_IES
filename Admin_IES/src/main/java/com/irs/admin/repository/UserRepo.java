package com.irs.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irs.admin.entities.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails,Integer> {
	
	@Query("update userDetails set account accStatus=:status where userId=:userId")
	public Integer updateAccountStatus(Integer userId, String status);
	
	public UserDetails findByEmail(String email);
	
	public UserDetails findByEmailAndPwd(String email, String pwd);
}
