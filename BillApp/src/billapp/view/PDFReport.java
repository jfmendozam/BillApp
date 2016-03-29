package billapp.view;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jf
 */
public class PDFReport {
    private String pdfFilename;
    private String author;
    private String appName;
    private String title;
    private String companyName;
    private String[] fields;
    private String[] dbFields;
    private ResultSet resultSet;
    
    /**
     * Default constructor
     */
    PDFReport() {    
    }

    /**
     * Constructor with parameters
     * @param pdfFilename PDF Filename 
     * @param author Author of the PDF file
     * @param appName Application name
     * @param title Application title
     * @param companyName Company name
     * @param fields Fields names
     * @param dbFields Database fields names
     * @param resultSet Result set 
     */
    public PDFReport(String pdfFilename, String author, String appName, String title, String companyName, String[] fields, String[] dbFields, ResultSet resultSet) {
        this.pdfFilename = pdfFilename;
        this.author = author;
        this.appName = appName;
        this.title = title;
        this.companyName = companyName;
        this.fields = fields;
        this.dbFields = dbFields;
        this.resultSet = resultSet;
    }

    /**
     * Get PDF Filename
     * @return PDF Filename
     */
    public String getPdfFilename() {
        return this.pdfFilename;
    }

    /**
     * Set PDF Filename
     * @param pdfFilename 
     */
    public void setPdfFilename(String pdfFilename) {
        this.pdfFilename = pdfFilename;
    }

    /**
     * Get Author
     * @return Author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Set Author
     * @param author Author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get Application name
     * @return Application name
     */
    public String getAppName() {
        return this.appName;
    }

    /**
     * Set Application name
     * @param appName Application name
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * Get Title
     * @return Title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set Title
     * @param title Title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get Company name
     * @return Company name
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * Set Company name
     * @param companyName Company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Get fields names
     * @return Fields names
     */
    public String[] getFields() {
        return this.fields;
    }

    /**
     * Set fields names
     * @param fields Fields names
     */
    public void setFields(String[] fields) {
        this.fields = fields;
    }

    /**
     * Get Result set
     * @return Result set
     */
    public ResultSet getResultSet() {
        return this.resultSet;
    }

    /**
     * Set Result set
     * @param resultSet 
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * Get Database fields names
     * @return Database fields names
     */
    public String[] getDbFields() {
        return dbFields;
    }

    /**
     * Set Database fields names
     * @param dbFields Database fields names
     */
    public void setDbFields(String[] dbFields) {
        this.dbFields = dbFields;
    }

    /**
     * Generate a PDF report
     */
    public void generatePDF() {
        Font bfBold12 = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.WHITE); 
        Font bf12 = new Font(Font.FontFamily.HELVETICA, 8);        
        int columns = this.getFields().length;
        Paragraph header;

        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(this.getPdfFilename()));

            doc.addAuthor(this.getAuthor());
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator(this.getAppName());
            doc.addTitle(this.getTitle());
            doc.setPageSize(PageSize.LETTER);

            doc.open();

            header = new Paragraph(this.getCompanyName(), 
                    FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD));
            header.setAlignment(Element.ALIGN_RIGHT);
            doc.add(header);
            header = new Paragraph(this.getTitle(), 
                    FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD));
            header.setAlignment(Element.ALIGN_CENTER);
            doc.add(header);
            header = new Paragraph(new Date().toString(),
                    FontFactory.getFont(FontFactory.COURIER, 8, Font.NORMAL));
            header.setAlignment(Element.ALIGN_RIGHT);
            doc.add(header);
            header=new Paragraph(" ");
            doc.add(header);

            PdfPTable table = new PdfPTable(columns);
            table.setWidthPercentage(95f);

            for (String field : this.getFields()) {
                this.insertPDFCell(table, field, Element.ALIGN_CENTER, 1, bfBold12, BaseColor.BLACK);
            }
            table.setHeaderRows(1);

            if (this.getResultSet() != null) {
                this.getResultSet().beforeFirst();
                while (this.getResultSet().next()) {
                    for (String dbField : this.getDbFields()) {
                        String value = (this.getResultSet().getString(dbField) == null) 
                                ? "" : this.getResultSet().getString(dbField);
                        this.insertPDFCell(table, value, Element.ALIGN_RIGHT, 1, bf12, BaseColor.WHITE);
                    }
                }
            }

            doc.add(table);
            doc.close();
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PDFReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Create a new cell with the specified text and font
     * @param table PDF Table
     * @param text Text to create
     * @param align Cell alignment
     * @param colspan Cell column span in case you want to merge two or more cells
     * @param font Cell font
     */
    public void insertPDFCell(PdfPTable table, String text, int align, int colspan, Font font, BaseColor Background){
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        if (Background != BaseColor.WHITE) {
            cell.setBackgroundColor(Background);
        }
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        table.addCell(cell);
    }    
}
