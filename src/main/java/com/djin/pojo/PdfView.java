package com.djin.pojo;

import com.djin.service.OrderService;
import com.djin.service.TicketService;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Map;

public class PdfView extends AbstractPdfView {

   private Order order;
   private Ticket ticket;

    public PdfView(Order order, Ticket ticket) {
        this.order = order;
        this.ticket = ticket;
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {



        Paragraph p = new Paragraph("Ticket Information", FontFactory.getFont(FontFactory.TIMES_ROMAN,40, Font.BOLD,new Color(14, 14, 14)));
        p.setAlignment(1);//set alignment as center
        document.add(p);
        Table table = new Table(2);

        Chunk name = new Chunk("Ticket Name: "+ticket.getTicketName(), FontFactory.getFont(FontFactory.TIMES_ROMAN,20));
        Chunk amount = new Chunk("Amount: "+order.getItemAmount(), FontFactory.getFont(FontFactory.TIMES_ROMAN,20));
        Chunk date = new Chunk("Selected Date: "+order.getSelectedDate(), FontFactory.getFont(FontFactory.TIMES_ROMAN,20));
        Chunk time = new Chunk("Selected Time: "+order.getSelectedTime(), FontFactory.getFont(FontFactory.TIMES_ROMAN,20));
        Cell cellname = new Cell(name);
        Cell cellamount = new Cell(amount);
        Cell celldate = new Cell(date);
        Cell celltime = new Cell(time);
        table.addCell(cellname);
        table.addCell(cellamount);
        table.addCell(celldate);
        table.addCell(celltime);

        Image image = Image.getInstance("D:\\NEU\\Spring 2021\\Tomcat\\webapps\\myApps\\FinalProject\\src\\main\\webapp\\images\\QRcode.png");
        Cell cellimage = new Cell(image);
        cellimage.setRowspan(4);
        table.addCell(cellimage);

        table.setPadding(5);
        table.setAlignment(Element.ALIGN_LEFT);
        table.setBorderWidth(0);
        cellimage.setBorderWidth(0);
        cellname.setBorderWidth(0);
        cellamount.setBorderWidth(0);
        celldate.setBorderWidth(0);
        celltime.setBorderWidth(0);
        table.setWidth(100);
        document.add(table);
    }
}
