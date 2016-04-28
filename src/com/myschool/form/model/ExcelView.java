package com.myschool.form.model;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		LoginForm loginForm= (LoginForm) model.get("loginForm");
		resp.setContentType("application/vnd.ms-excel");
		resp.setHeader("Content-disposition", "attachment; filename=Report.xls");
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Login User Report");
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("UserId");
		header.createCell(1).setCellValue("UserName");
		int rowNum = 1;
		//create the row data
		HSSFRow row = sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(loginForm.getUserId());
		row.createCell(1).setCellValue(loginForm.getUserName());
	}
}
