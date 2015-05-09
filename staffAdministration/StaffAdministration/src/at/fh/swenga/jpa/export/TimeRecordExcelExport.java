package at.fh.swenga.jpa.export;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class TimeRecordExcelExport extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HSSFSheet sheet = workbook.createSheet("Test Report");
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Firstname");
		header.createCell(1).setCellValue("Lastname");
		//header.createCell(3).setCellValue("Lastname");
		
	}
}
