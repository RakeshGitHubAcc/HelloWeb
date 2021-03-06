package com.myschool.form.model;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		LoginForm loginForm = (LoginForm) model.get("command");
		Paragraph header = new Paragraph(new Chunk(
				"Generate Pdf USing Spring Mvc", FontFactory.getFont(
						FontFactory.HELVETICA, 30)));
		Paragraph by = new Paragraph(new Chunk("Author "
				+ "Rakesh" + " " + "Bishwal",
				FontFactory.getFont(FontFactory.HELVETICA, 20)));
		document.add(header);
		document.add(by);
	}

}
