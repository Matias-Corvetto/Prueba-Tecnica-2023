package com.pruebatecnica.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Empleado")
public class Empleado {

	@Column(name = "Worker", length = 125)
	private String worker;

	@Id
	@Column(name = "EmployeeId", length = 125)
	private Integer employeeID;

	@Column(name = "HomeTalentid", length = 125)
	private Integer homeTalentID;

	@Column(name = "HomeEmployeeType", length = 125)
	private String homeEmployeeType;

	@Column(name = "ActiveStatus", length = 125)
	private String activeStatus;

	@Column(name = "SeparationDate", length = 125)
	private LocalDate separationDate;

	@Column(name = "LastDayOfWork", length = 125)
	private LocalDate lastDayOfWork;

	@Column(name = "CurrentCompensationGrade", length = 125)
	private String currentCompensationGrade;

	@Column(name = "EffectiveDateofCurrentCompensationGrade", length = 125)
	private LocalDate effectiveDateofCurrentCompensationGrade;

	@Column(name = "PreviousCompensationGrade", length = 125)
	private String previousCompensationGrade;

	@Column(name = "EffectiveDateofPreviousCompensationGrade", length = 125)
	private LocalDate effectiveDateofPreviousCompensationGrade;

	@Column(name = "CompensationGradeProfile", length = 125)
	private String compensationGradeProfile;

	@Column(name = "JobProfile", length = 125)
	private String jobProfile;

	@Column(name = "JobFamily", length = 125)
	private String jobFamily;

	@Column(name = "FTE", length = 125)
	private Double fte;

	@Column(name = "CompaRatio", length = 125)
	private Double compaRatio;

	@Column(name = "LengthOfService", length = 125)
	private String lengthOfService;

	@Column(name = "BusinessProcess", length = 125)
	private String businessProcess;

	@Column(name = "EffectiveDate", length = 125)
	private LocalDate effectiveDate;

	@Column(name = "BusinessProcessReason", length = 125)
	private String businessProcessReason;

	@Column(name = "AnnualReferenceSalary", length = 125)
	private Integer annualReferenceSalary;

	@Column(name = "MonthlyReferenceSalary", length = 125)
	private Integer monthlyReferenceSalary;

	@Column(name = "ActualSalary", length = 125)
	private Integer actualSalary;

	@Column(name = "NumberOfSalaryMonths", length = 125)
	private Integer numberOfSalaryMonths;

	@Column(name = "Currency", length = 125)
	private String currency;

	@Column(name = "PayRateType", length = 125)
	private String payRateType;

	@Column(name = "YTDCommissions", length = 125)
	private Integer ytdCommissions;

	@Column(name = "IncentivePlan", length = 125)
	private String incentivePlan;

	@Column(name = "IncentiveRole", length = 125)
	private String incentiveRole;
	
	@JsonIgnore
	@OneToOne(mappedBy = "empleado")
	private DetalleEmpleado detalleEmpleado;
}
