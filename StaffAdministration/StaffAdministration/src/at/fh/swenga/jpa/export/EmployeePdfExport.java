package at.fh.swenga.jpa.export;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import at.fh.swenga.jpa.model.Employee;
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

public class EmployeePdfExport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Employee> employees = (List<Employee>) model
				.get(Constant.KEY_EMPLOYEE_LIST);
		document.add(new Paragraph("Employee Data"));

		for (Employee employee : employees) {
			document.add(generateTable(employee));
		}
	}

	private PdfPTable generateTable(Employee employee) throws DocumentException {
		String[] headers = { "First Name:", "Last Name:", "SSN:", "Birthday:",
				"Country:", "City:", "Street", "ZIP", "Phone", "E-Mail" };
		String[] values = { employee.getFirstName(), employee.getLastName(),
				employee.getSsn() + "",
				Constant.parseDateToString(employee.getDayOfBirth()),
				employee.getAddress().getCountry(),
				employee.getAddress().getCity(),
				employee.getAddress().getStreet(),
				employee.getAddress().getZip() + "", employee.getPhone(),
				employee.getMail() };

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 3.0f, 7.0f });
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
			table.addCell(values[i]);

		}
		return table;
	}
}
