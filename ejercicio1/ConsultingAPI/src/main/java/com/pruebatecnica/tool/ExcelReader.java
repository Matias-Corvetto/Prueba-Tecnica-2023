package com.pruebatecnica.tool;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

public class ExcelReader {

	public void obtenerInformacionColumnas() {

		// Funcion auxiliar para conocer la estructura de la tabla de excel

		String jdbcUrl = "jdbc:mysql://localhost:3306/pruebatecnica";
		String user = "pruebatecnica";
		String password = "pruebatecnica";
		String sql = "SELECT * FROM detalle_empleado";

		try (Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();

			System.out.println(numberOfColumns);
			System.out.println("-----");

			for (int i = 1; i <= numberOfColumns; i++) {
				String columnName = metaData.getColumnName(i);
				String columnTypeName = metaData.getColumnTypeName(i);

				System.out.println("Índice: " + i);
				System.out.println("Nombre de la columna: " + columnName);
				System.out.println("Tipo de columna: " + columnTypeName);
				System.out.println("-----");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertarDatos() {
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/pruebatecnica";
			String user = "pruebatecnica";
			String password = "pruebatecnica";

			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

			// Tabla empleados

			String countQuery = "SELECT COUNT(*) FROM Empleado";
			Statement countStatement = connection.createStatement();
			ResultSet resultSet = countStatement.executeQuery(countQuery);

			if (resultSet.next() && resultSet.getInt(1) == 0) {
				String insertQuery1 = "INSERT INTO Empleado (Worker, employee_Id, Home_TalentID, Home_Employee_Type, Active_Status, "
						+
						"Separation_Date, Last_Day_Of_Work, Current_Compensation_Grade, " +
						"Effective_Dateof_Current_Compensation_Grade, Previous_Compensation_Grade,  " +
						"Effective_Dateof_Previous_Compensation_Grade, Compensation_Grade_Profile,  " +
						"Job_Profile, Job_Family, FTE, Compa_Ratio, Length_Of_Service, Business_Process, " +
						"Effective_Date, Business_Process_Reason, Annual_Reference_Salary, Monthly_Reference_Salary, " +
						"Actual_Salary, Number_Of_Salary_Months, Currency, Pay_Rate_Type, YTDCommissions, Incentive_Plan, Incentive_Role) "
						+
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement preparedStatement1 = connection.prepareStatement(insertQuery1);
				String fileName1 = "src/main/resources/static/data/Employee_Compensation_Details_-_Manager_version.xlsx";
				lectorExcel(preparedStatement1, fileName1, false);
				preparedStatement1.close();
			}

			resultSet.close();
			countStatement.close();

			// Tabla detalle empleados

			countQuery = "SELECT COUNT(*) FROM Detalle_Empleado";
			countStatement = connection.createStatement();
			resultSet = countStatement.executeQuery(countQuery);

			if (resultSet.next() && resultSet.getInt(1) == 0) {
				String insertQuery2 = "INSERT INTO Detalle_Empleado (worker, employee_id_detalle, legal_name, preferred_name, home_cnum, "
						+
						"host_cnum, dnk_cpr, nor_dn, nor_fn, fin_id, fin_kela, swe_pn, brn_nkp, kor_rrn, mys_id, sgp_nric, sgp_fin, vnm_cmnd, "
						+
						"id_card_number, social_security_taj_number, hungary_tax_id_number, pol_do, pol_pesel, svn_jmbg, srb_jmbg, "
						+
						"croatia_tax_number_oib, tur_tckn, slovenian_tax_number, bulgarian_id_card, croatia_municipality_code, "
						+
						"romania_personal_numeric_code, personal_numeric_code_uniform_civil_number_egn, czech_republic_birth_number, aus_tfn, "
						+
						"nzl_ird, tha_id, tha_ssn, tha_tax_id, idn_bpjskh, idn_bpjskk, idn_ktp, idn_njs, idn_np, assignment_type, "
						+
						"title, first_name, middle_name, initials_nl, last_name, suffix, full_name, full_name_local_script, "
						+
						"highest_degree, highest_field_of_study, email_primary_work, work_shift, scheduled_weekly_hours, company_id, "
						+
						"company_name, employee_type, time_type, job_family_group, supervisory_organization, is_manager, " +
						"acquisition_company, is_bluebooker_nz, is_bbs_au, international_assignment_record, line_of_business, "
						+
						"job_profile, business_title, job_title, compensation_grade, compensation_grade_profile, job_family, "
						+
						"contract_type, cba_group, cba, korea_calling_title, status, hire_date, hire_category, hire_reason, "
						+
						"termination_date, last_day_of_work, continuous_service_date, seniority_date, contract_end_date, end_employment_date, "
						+
						"expected_assignment_end_date, license_change_indicator, location_company_indicator, cost_center_id, "
						+
						"cost_center_name, workplace_indicator, location_id, location_name, building_name, building_id, " +
						"floor_in_building, office_cube, country, state, city, address_line1, address_line2, address_line3, "
						+
						"postal_code, phone_primary_work, alternate_work_address, current_pbc_rating, age, date_of_birth, " +
						"country_of_birth, city_of_birth, fte, manager_employee_id, manager_cnum, manager_full_name, manager_email_address, "
						+
						"matrix_manager_employee_id, matrix_manager_cnum, matrix_manager_full_name, matrix_manager_email_address, employee_id) "
						+
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement preparedStatement2 = connection.prepareStatement(insertQuery2);
				String fileName2 = "src/main/resources/static/data/Employee_Max_Detail_Report.xlsx";
				lectorExcel(preparedStatement2, fileName2, true);
				preparedStatement2.close();
			}

			resultSet.close();
			countStatement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void lectorExcel(PreparedStatement preparedStatement, String fileName, boolean tieneFK) throws SQLException {
		try {

			FileInputStream excelFile = new FileInputStream(new File(fileName));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			int currentRowNumber = 0;

			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				currentRowNumber++;
				String numId = "";

				if (currentRowNumber >= 3) {
					Iterator<Cell> cellIterator = currentRow.iterator();

					int columnIndex = 0;
					while (cellIterator.hasNext()) {
						Cell currentCell = cellIterator.next();
						columnIndex = currentCell.getColumnIndex() + 1;

						if (currentCell.getCellType() == CellType.STRING) {		
							// Es string
							preparedStatement.setString(columnIndex, currentCell.getStringCellValue());
							if (tieneFK && columnIndex == 2) {
									numId = currentCell.getStringCellValue();
								}

						} else if (currentCell.getCellType() == CellType.NUMERIC) {
							if (DateUtil.isCellDateFormatted(currentCell)) {

								// Es una fecha
								Date date = currentCell.getDateCellValue();
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
								preparedStatement.setDate(columnIndex,
										java.sql.Date.valueOf(LocalDate.parse(dateFormat.format(date))));

							} else if (isPercentageFormat(currentCell)) {

								// Es porcentaje
								double numericValue = currentCell.getNumericCellValue() * 100;
								preparedStatement.setDouble(columnIndex,
										Double.parseDouble(String.valueOf(numericValue).replace(',', '.')));

							} else if (isIntValue(String.valueOf(currentCell.getNumericCellValue()))) {

								// es un entero
								preparedStatement.setInt(columnIndex,
										Integer.parseInt(String.valueOf(currentCell.getNumericCellValue())));

							} else {

								// Es un decimal
								preparedStatement.setDouble(columnIndex,
										Double.parseDouble(String.valueOf(currentCell.getNumericCellValue()).replace(',', '.')));

							}
						} else if (currentCell.getCellType() == CellType.FORMULA) {

							// Es resultado de formula
							preparedStatement.setString(columnIndex, currentCell.getStringCellValue());

						} else if (currentCell.getCellType() == CellType.BLANK) {

							// Es null
							preparedStatement.setNull(columnIndex, java.sql.Types.NULL);
						}
					}
					if (columnIndex >= 2) {
						if (tieneFK) {
							preparedStatement.setString(125, numId);
						}
						preparedStatement.executeUpdate();
					}
				}
			}

			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isPercentageFormat(Cell cell) {
		String formatString = cell.getCellStyle().getDataFormatString();
		return formatString.contains("%") || formatString.contains("0.00%");
	}

	private static boolean isIntValue(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
