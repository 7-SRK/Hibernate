package PDF;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

import java.io.IOException;

public class PdfModify {
    public static void main(String[] args) throws IOException {
        String src = "C:\\Users\\Admin\\Documents\\Docs\\PdfGenerator.pdf";
        String dest = "C:\\Users\\Admin\\Documents\\Docs\\PdfData.pdf";

        PdfDocument pdf = new PdfDocument(new PdfReader(src), new PdfWriter(dest));
        Document doc = new Document(pdf);

        doc.add(new Paragraph("Hello World"));

        Image img = new Image(ImageDataFactory.create("Downloads\\Design_Patterns.jpeg"));
        img.scaleToFit(1182,300);
        doc.add(img);

//        Table table = new Table(UnitValue.createPercentArray(3)).useAllAvailableWidth();
//        table.addCell("Sid");
//        table.addCell("Sname");
//        table.addCell("Smark");
//        table.addCell("1");
//        table.addCell("A");
//        table.addCell("50");
//        table.addCell("2");
//        table.addCell("B");
//        table.addCell("60");
//        table.addCell("3");
//        table.addCell("C");
//        table.addCell("70");
//        table.addCell("4");
//        table.addCell("D");
//        table.addCell("80");
//        doc.add(table);

        doc.close();

        System.out.println("Pdf Modified and Saved at : " + dest);
    }
}
