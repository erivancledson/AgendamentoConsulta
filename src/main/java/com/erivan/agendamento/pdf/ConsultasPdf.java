package com.erivan.agendamento.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.erivan.agendamento.model.Consulta;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ConsultasPdf {
	
	public static ByteArrayInputStream consultasReport(Iterable<Consulta> consultas) {
		
		Document document = new Document();
		
		
	      
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		
	
		
		try {
			
			
			

			PdfPTable table = new PdfPTable(5);//tamanho da tabela 3 colunas
			table.setWidthPercentage(90);
			table.setWidths(new int[] {  5, 5, 5, 5, 5}); //tamanho das colunas

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			
			
				//campos estaticos
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Médico", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Especialidade", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Horario", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Data", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			
			hcell = new PdfPCell(new Phrase("Valor Consulta", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
	
	

			for (Consulta consulta : consultas) {

				PdfPCell cell;

				

				cell = new PdfPCell(new Phrase(consulta.getNome_medico()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(consulta.getEspecialidade()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);
				
				
				cell = new PdfPCell(new Phrase(consulta.getHorario()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				
				cell = new PdfPCell(new Phrase(consulta.getData().toString()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
				
				cell = new PdfPCell(new Phrase(consulta.getValor_consulta().toString()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table.addCell(cell);
		
			}

			PdfWriter.getInstance(document, out);
			document.open();
			
			document.add(table);

			document.close();

		} catch (DocumentException ex) {

			Logger.getLogger(ConsultasPdf.class.getName()).log(Level.SEVERE, null, ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
		
	}

}
