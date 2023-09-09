package com.irs.admin.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "ELIG_DTLS")
public class EligEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer edgTraceId;
	private String planStaus;
	private Double benifitAmt;

}
