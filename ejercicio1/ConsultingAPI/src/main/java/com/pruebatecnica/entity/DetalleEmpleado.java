package com.pruebatecnica.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "DetalleEmpleado")
public class DetalleEmpleado {

	@Id
	@Column(name = "employeeIdDetalle", length = 125)
	private Integer employeeId;

	@Column(name = "worker", length = 125)
	private String worker;

	@Column(name = "legalName", length = 125)
	private String legalName;

	@Column(name = "preferredName", length = 125)
	private String preferredName;

	@Column(name = "homeCnum", length = 125)
	private String homeCnum;

	@Column(name = "hostCnum", length = 125)
	private String hostCnum;

	@Column(name = "dnkCpr", length = 125)
	private String dnkCpr;

	@Column(name = "norDn", length = 125)
	private String norDn;

	@Column(name = "norFn", length = 125)
	private String norFn;

	@Column(name = "finId", length = 125)
	private String finId;

	@Column(name = "finKela", length = 125)
	private String finKela;

	@Column(name = "swePn", length = 125)
	private String swePn;

	@Column(name = "brnNkp", length = 125)
	private String brnNkp;

	@Column(name = "korRrn", length = 125)
	private String korRrn;

	@Column(name = "mysId", length = 125)
	private String mysId;

	@Column(name = "sgpNric", length = 125)
	private String sgpNric;

	@Column(name = "sgpFin", length = 125)
	private String sgpFin;

	@Column(name = "vnmCmnd", length = 125)
	private String vnmCmnd;

	@Column(name = "idCardNumber", length = 125)
	private String idCardNumber;

	@Column(name = "socialSecurityTajNumber", length = 125)
	private String socialSecurityTajNumber;

	@Column(name = "hungaryTaxIdNumber", length = 125)
	private String hungaryTaxIdNumber;

	@Column(name = "polDo", length = 125)
	private String polDo;

	@Column(name = "polPesel", length = 125)
	private String polPesel;

	@Column(name = "svnJmbg", length = 125)
	private String svnJmbg;

	@Column(name = "srbJmbg", length = 125)
	private String srbJmbg;

	@Column(name = "croatiaTaxNumberOib", length = 125)
	private String croatiaTaxNumberOib;

	@Column(name = "turTckn", length = 125)
	private String turTckn;

	@Column(name = "slovenianTaxNumber", length = 125)
	private String slovenianTaxNumber;

	@Column(name = "bulgarianIdCard", length = 125)
	private String bulgarianIdCard;

	@Column(name = "croatiaMunicipalityCode", length = 125)
	private String croatiaMunicipalityCode;

	@Column(name = "romaniaPersonalNumericCode", length = 125)
	private String romaniaPersonalNumericCode;

	@Column(name = "personalNumericCodeUniformCivilNumberEgn", length = 125)
	private String personalNumericCodeUniformCivilNumberEgn;

	@Column(name = "czechRepublicBirthNumber", length = 125)
	private String czechRepublicBirthNumber;

	@Column(name = "ausTfn", length = 125)
	private String ausTfn;

	@Column(name = "nzlIrd", length = 125)
	private String nzlIrd;

	@Column(name = "thaId", length = 125)
	private String thaId;

	@Column(name = "thaSsn", length = 125)
	private String thaSsn;

	@Column(name = "thaTaxId", length = 125)
	private String thaTaxId;

	@Column(name = "idnBpjskh", length = 125)
	private String idnBpjskh;

	@Column(name = "idnBpjskk", length = 125)
	private String idnBpjskk;

	@Column(name = "idnKtp", length = 125)
	private String idnKtp;

	@Column(name = "idnNjs", length = 125)
	private String idnNjs;

	@Column(name = "idnNp", length = 125)
	private String idnNp;

	@Column(name = "assignmentType", length = 125)
	private String assignmentType;

	@Column(name = "title", length = 125)
	private String title;

	@Column(name = "firstName", length = 125)
	private String firstName;

	@Column(name = "middleName", length = 125)
	private String middleName;

	@Column(name = "initialsNl", length = 125)
	private String initialsNl;

	@Column(name = "lastName", length = 125)
	private String lastName;

	@Column(name = "suffix", length = 125)
	private String suffix;

	@Column(name = "fullName", length = 125)
	private String fullName;

	@Column(name = "fullNameLocalScript", length = 125)
	private String fullNameLocalScript;

	@Column(name = "highestDegree", length = 125)
	private String highestDegree;

	@Column(name = "highestFieldOfStudy", length = 125)
	private String highestFieldOfStudy;

	@Column(name = "emailPrimaryWork", length = 125)
	private String emailPrimaryWork;

	@Column(name = "workShift", length = 125)
	private String workShift;

	@Column(name = "scheduledWeeklyHours", length = 125)
	private Integer scheduledWeeklyHours;

	@Column(name = "companyId", length = 125)
	private String companyId;

	@Column(name = "companyName", length = 125)
	private String companyName;

	@Column(name = "employeeType", length = 125)
	private String employeeType;

	@Column(name = "timeType", length = 125)
	private String timeType;

	@Column(name = "jobFamilyGroup", length = 125)
	private String jobFamilyGroup;

	@Column(name = "supervisoryOrganization", length = 125)
	private String supervisoryOrganization;

	@Column(name = "isManager", length = 125)
	private String isManager;

	@Column(name = "acquisitionCompany", length = 125)
	private String acquisitionCompany;

	@Column(name = "isBluebookerNz", length = 125)
	private String isBluebookerNz;

	@Column(name = "isBbsAu", length = 125)
	private String isBbsAu;

	@Column(name = "internationalAssignmentRecord", length = 125)
	private String internationalAssignmentRecord;

	@Column(name = "lineOfBusiness", length = 125)
	private String lineOfBusiness;

	@Column(name = "jobProfile", length = 125)
	private String jobProfile;

	@Column(name = "businessTitle", length = 125)
	private String businessTitle;

	@Column(name = "jobTitle", length = 125)
	private String jobTitle;

	@Column(name = "compensationGrade", length = 125)
	private String compensationGrade;

	@Column(name = "compensationGradeProfile", length = 125)
	private String compensationGradeProfile;

	@Column(name = "jobFamily", length = 125)
	private String jobFamily;

	@Column(name = "contractType", length = 125)
	private String contractType;

	@Column(name = "cbaGroup", length = 125)
	private String cbaGroup;

	@Column(name = "cba", length = 125)
	private String cba;

	@Column(name = "koreaCallingTitle", length = 125)
	private String koreaCallingTitle;

	@Column(name = "status", length = 125)
	private String status;

	@Column(name = "hireDate", length = 125)
	private LocalDate hireDate;

	@Column(name = "hireCategory", length = 125)
	private String hireCategory;

	@Column(name = "hireReason", length = 125)
	private String hireReason;

	@Column(name = "terminationDate", length = 125)
	private LocalDate terminationDate;

	@Column(name = "lastDayOfWork", length = 125)
	private LocalDate lastDayOfWork;

	@Column(name = "continuousServiceDate", length = 125)
	private LocalDate continuousServiceDate;

	@Column(name = "seniorityDate", length = 125)
	private LocalDate seniorityDate;

	@Column(name = "contractEndDate", length = 125)
	private LocalDate contractEndDate;

	@Column(name = "endEmploymentDate", length = 125)
	private LocalDate endEmploymentDate;

	@Column(name = "expectedAssignmentEndDate", length = 125)
	private LocalDate expectedAssignmentEndDate;

	@Column(name = "licenseChangeIndicator", length = 125)
	private String licenseChangeIndicator;

	@Column(name = "locationCompanyIndicator", length = 125)
	private String locationCompanyIndicator;

	@Column(name = "costCenterId", length = 125)
	private String costCenterId;

	@Column(name = "costCenterName", length = 125)
	private String costCenterName;

	@Column(name = "workplaceIndicator", length = 125)
	private String workplaceIndicator;

	@Column(name = "locationId", length = 125)
	private String locationId;

	@Column(name = "locationName", length = 125)
	private String locationName;

	@Column(name = "buildingName", length = 125)
	private String buildingName;

	@Column(name = "buildingId", length = 125)
	private String buildingId;

	@Column(name = "floorInBuilding", length = 125)
	private String floorInBuilding;

	@Column(name = "officeCube", length = 125)
	private String officeCube;

	@Column(name = "country", length = 125)
	private String country;

	@Column(name = "state", length = 125)
	private String state;

	@Column(name = "city", length = 125)
	private String city;

	@Column(name = "addressLine1", length = 125)
	private String addressLine1;

	@Column(name = "addressLine2", length = 125)
	private String addressLine2;

	@Column(name = "addressLine3", length = 125)
	private String addressLine3;

	@Column(name = "postalCode", length = 125)
	private String postalCode;

	@Column(name = "phonePrimaryWork", length = 125)
	private String phonePrimaryWork;

	@Column(name = "alternateWorkAddress", length = 125)
	private String alternateWorkAddress;

	@Column(name = "currentPbcRating", length = 125)
	private String currentPbcRating;

	@Column(name = "age", length = 125)
	private Integer age;

	@Column(name = "dateOfBirth", length = 125)
	private LocalDate dateOfBirth;

	@Column(name = "countryOfBirth", length = 125)
	private String countryOfBirth;

	@Column(name = "cityOfBirth", length = 125)
	private String cityOfBirth;

	@Column(name = "fte", length = 125)
	private double fte;

	@Column(name = "managerEmployeeId", length = 125)
	private Integer managerEmployeeId;

	@Column(name = "managerCnum", length = 125)
	private String managerCnum;

	@Column(name = "managerFullName", length = 125)
	private String managerFullName;

	@Column(name = "managerEmailAddress", length = 125)
	private String managerEmailAddress;

	@Column(name = "matrixManagerEmployeeId", length = 125)
	private Integer matrixManagerEmployeeId;

	@Column(name = "matrixManagerCnum", length = 125)
	private String matrixManagerCnum;

	@Column(name = "matrixManagerFullName", length = 125)
	private String matrixManagerFullName;

	@Column(name = "matrixManagerEmailAddress", length = 125)
	private String matrixManagerEmailAddress;

	@OneToOne
	@JoinColumn(name = "employee_id")
	private Empleado empleado;
}
