package at.fh.swenga.jpa.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateTimeEditor extends PropertyEditorSupport {

	private static final List<String> formats = new ArrayList<String>();

	static {
		formats.add("dd.MM.yyyy");
		formats.add("HH:mm");
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text==null || text.equals("")){
			return;
		}
		SimpleDateFormat sdf;
		for (String format : formats) {
			try {
				sdf = new SimpleDateFormat(format);
				setValue(sdf.parse(text));
			} catch (Exception ex) {
				System.out.println("wrong format - try next: "+format);
			}
		}
		
	}

	@Override
	public String getAsText() {
		Date date = (Date) getValue();
		if (date == null) {
			return null;
		}

		SimpleDateFormat sdf;
		for (String format : formats) {
			try {
				sdf = new SimpleDateFormat(format);
				return sdf.format(date);
			} catch (Exception ex) {
				System.out.println("wrong format - try next: "+format);
			}
		}
		return null;
	}

}
