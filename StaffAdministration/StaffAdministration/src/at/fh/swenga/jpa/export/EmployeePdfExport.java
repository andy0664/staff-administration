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
		
		Employee employee = (Employee) model.get(Constant.KEY_EMPLOYEE);
		document.add(new Paragraph("Employee Data"));
		 
		PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f,7.0f});
        table.setSpacingBefore(10);
 
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.black);
 
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.gray);
        cell.setPadding(3);
 
        cell.setPhrase(new Phrase("First Name:", font));
        table.addCell(cell);
        table.addCell(employee.getFirstName());
        
        
        cell.setPhrase(new Phrase("Last Name:", font));
        table.addCell(cell);
        table.addCell(employee.getLastName());
 
        cell.setPhrase(new Phrase("SSN:", font));
        table.addCell(cell);
        table.addCell(employee.getSsn()+"");
        
        cell.setPhrase(new Phrase("Birthday:", font));
        table.addCell(cell);
        table.addCell(Constant.parseDateToString(employee.getDayOfBirth()));
        
        cell.setPhrase(new Phrase("Country:", font));
        table.addCell(cell);
        table.addCell(employee.getAddress().getCountry());
        
        cell.setPhrase(new Phrase("City:", font));
        table.addCell(cell);
        table.addCell(employee.getAddress().getCity());
 
        cell.setPhrase(new Phrase("Street:", font));
        table.addCell(cell);
        table.addCell(employee.getAddress().getStreet());
        
        cell.setPhrase(new Phrase("Zip:", font));
        table.addCell(cell);
        table.addCell(employee.getAddress().getZip()+"");
       
        document.add(table);
		
	}

}
