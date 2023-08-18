package com.irs.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irs.admin.entities.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails,Integer> {
}
