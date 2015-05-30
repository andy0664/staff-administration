package at.fh.swenga.jpa.export;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.model.TimeRecord;
import at.fh.swenga.jpa.support.Constant;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class TimeRecordPdfExport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HashedMap<Employee, List<TimeRecord>> timeRecords = (HashedMap<Employee, List<TimeRecord>>) model
				.get(Constant.KEY_TIME_RECORD_LIST);
		MapIterator<Employee, List<TimeRecord>> iter = timeRecords
				.mapIterator();
		while (iter.hasNext()) {
			Employee employee = iter.next();
			document.add(new Paragraph("Employee: " + employee.getFirstName()
					+ " " + employee.getLastName()));
				document.add(generateTable(iter.getValue()));
		}
	}

	private PdfPTable generateTable(List<TimeRecord> records) throws DocumentException {
		String[] headers = { "Date from", "Date to", "Time from", "Time to",
				"Reason" };

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 1.75f,1.75f,1.75f,1.75f,3.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.black);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.gray);
		cell.setPadding(3);

		for (int i = 0; i < headers.length; i++) {
			cell.setPhrase(new Phrase(headers[i], font));
			table.addCell(cell);
		}
		
		for(TimeRecord record:records){
			table.addCell(Constant.parseDateToString(record.getStartDate()));
			table.addCell(Constant.parseDateToString(record.getEndDate()));
			table.addCell(Constant.parseTimeToString(record.getStartTime()));
			table.addCell(Constant.parseTimeToString(record.getEndTime()));
			table.addCell(record.getTyp());
		}
		
		return table;
	}

}
