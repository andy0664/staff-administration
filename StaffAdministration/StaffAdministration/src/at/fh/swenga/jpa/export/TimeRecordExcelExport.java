package at.fh.swenga.jpa.export;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.model.TimeRecord;
import at.fh.swenga.jpa.support.Constant;

public class TimeRecordExcelExport extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HSSFSheet sheet = workbook.createSheet("Test Report");
		HashedMap<Employee, List<TimeRecord>> timeRecords = (HashedMap<Employee, List<TimeRecord>>) model
				.get(Constant.KEY_TIME_RECORD_LIST);
		
		CellStyle titleStyle = workbook.createCellStyle();
		CellStyle nameStyle = workbook.createCellStyle();
		CellStyle headerStyle = workbook.createCellStyle();
		CellStyle recordStyle = workbook.createCellStyle();
		
		titleStyle.setFont(formatFont(workbook,(short)25,true));
		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell cell = titleRow.createCell(0);
		cell.setCellStyle(titleStyle);
		//titleRow.createCell(0).setCellValue("Timerecord Table");
		cell.setCellValue("Timerecord Table");
		
		int rowCount=2;
		MapIterator<Employee, List<TimeRecord>> iter = timeRecords.mapIterator();
		while(iter.hasNext()){
			
			//Name Cell
			nameStyle.setFont(formatFont(workbook,(short)15,true));
			HSSFRow nameRow = sheet.createRow(rowCount++);
			Employee emp = iter.next();
			createStyledCell(nameStyle,nameRow,0,sheet).setCellValue(emp.getFirstName()+" "+emp.getLastName());
			
			//Header Cells
			headerStyle.setFont(formatFont(workbook,(short)12,true));
			HSSFRow header = sheet.createRow(rowCount++);
			createStyledCell(headerStyle,header,0,sheet).setCellValue("Date from");
			createStyledCell(headerStyle,header,1,sheet).setCellValue("Date to");
			createStyledCell(headerStyle,header,2,sheet).setCellValue("Time from");
			createStyledCell(headerStyle,header,3,sheet).setCellValue("Time to");
			createStyledCell(headerStyle,header,4,sheet).setCellValue("Reason");
			
			recordStyle.setFont(formatFont(workbook,(short)10,false));
			
			//Formt Timerecord Cells
			for(TimeRecord record:iter.getValue()){
				HSSFRow recordLine = sheet.createRow(rowCount++);
				createStyledCell(recordStyle,recordLine,0,sheet).setCellValue(Constant.parseDateToString(record.getStartDate()));
				createStyledCell(recordStyle,recordLine,1,sheet).setCellValue(Constant.parseDateToString(record.getEndDate()));
				createStyledCell(recordStyle,recordLine,2,sheet).setCellValue(Constant.parseTimeToString(record.getStartTime()));
				createStyledCell(recordStyle,recordLine,3,sheet).setCellValue(Constant.parseTimeToString(record.getEndTime()));
				createStyledCell(recordStyle,recordLine,4,sheet).setCellValue(record.getTyp());
			}
		}
		// header.createCell(3).setCellValue("Lastname");
		//To autoSize each Column
		for(int i=0;i<5;i++){
			sheet.autoSizeColumn(i);
		}
		

	}
	
	private Font formatFont(HSSFWorkbook workbook, short size, boolean bold){
		Font font = workbook.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		if(bold){
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		}
		font.setFontHeightInPoints(size);
		return font;
	}
	
	private HSSFCell createStyledCell(CellStyle style, HSSFRow row,int count,HSSFSheet sheet){
		HSSFCell cell = row.createCell(count);
		cell.setCellStyle(style);
		return cell;
	}
	
}
