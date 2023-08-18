package com.irs.admin.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "IES_PLANS")
public class PlanDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Integer planId;
    @Column(name = "plan_name")
    private String planName;
    @Column(name = "plan_category")
    private String planCategory;
    @Column(name = "plan_start_date")
    private LocalDate planStartDate;
    @Column(name = "plan_end_date")
    private LocalDate planEndDate;
    @Column(name = "active_switch")
    private String activeSwitch;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "update_date")
    private LocalDate UpdateDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String UpdateBy;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserDetails user;
}
