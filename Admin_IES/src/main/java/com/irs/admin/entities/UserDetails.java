package com.irs.admin.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "IES_USERS")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "birth_date")
    private String dob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String userPassword;

    private String SSN;
    @Column(name = "active_switch")
    private String activeSwitch;
    @Column(name = "acc_status")
    private String accStatus;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "update_date")
    private LocalDate UpdateDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String UpdateBy;

    private String roleId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PlanDetails> plan;
}
