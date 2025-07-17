package PDF;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.*;

public class PdfGenerator {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Admin\\Documents\\Docs\\PdfGenerator.pdf";
        PdfWriter writer = new PdfWriter(path); //specifying the file path for your PDF.

        PdfDocument pdf = new PdfDocument(writer);

        Document doc = new Document(pdf);
        doc.close();
        System.out.println("PDF created at : " + path);
    }
}
