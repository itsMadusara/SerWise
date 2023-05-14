package com.CS01.SerWise.Services.Payment;

import com.CS01.SerWise.Controllers.*;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DoubleBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class getInvoice extends HttpServlet {
    public static int genenatePDF(String jobID,String savePath, ArrayList<String[]> jobTableResults,
                                   ArrayList<String[]> jobServiceResults, ArrayList<String[]> jobItemResults,
                                   ArrayList<String[]> vehicleDetails, ArrayList<String[]> clientDetails) throws FileNotFoundException, MalformedURLException {
        int totalPrice =0;

        PdfWriter pdfWriter = new PdfWriter(savePath);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);

        float [] pointColumnWidths = {150f*2, 150f};
        Table table = new Table(pointColumnWidths);
        table.setWidthPercent(100f);
        table.setMarginBottom(5f);

        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");

        LocalTime time = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        String imgPath = "http://localhost:8081/SerWise_war/Assets/SerWise.png";
        ImageData imageData = ImageDataFactory.create(imgPath);
        Image img = new Image(imageData);
        img.setWidth(75f);
        img.setHeight(75f);

        Cell cell1 = new Cell();
        cell1.add(img);
        cell1.setBorder(Border.NO_BORDER);
        cell1.setVerticalAlignment(VerticalAlignment.MIDDLE);
        table.addCell(cell1);

        Cell cell2 = new Cell();
        cell2.add("Date : "+ date.format(dateFormatter) + "\n" + "Time : " + time.format(timeFormatter) + "\nBranch : Kollupitiya");
        cell2.setBorder(Border.NO_BORDER);
        cell2.setTextAlignment(TextAlignment.LEFT);
        cell2.setVerticalAlignment(VerticalAlignment.MIDDLE);
        table.addCell(cell2);

        document.add(table);

        float [] coloms = {10000f};
        Table divider = new Table(coloms);
        divider.setWidthPercent(100f);
        Border border = new DoubleBorder(Color.BLACK,0.5f);
        divider.setBorder(border);
        divider.setMarginBottom(10f);
        document.add(divider);

        Paragraph invoiceTitle = new Paragraph("INVOICE : Job ID "+jobID);
        invoiceTitle.setTextAlignment(TextAlignment.CENTER);
        invoiceTitle.setMarginBottom(10f);
        invoiceTitle.setUnderline();
        invoiceTitle.setBold();
        document.add(invoiceTitle);

        float [] vehicleDetailscols = {100f,100f};
        Table vehicleDetailsTable = new Table(vehicleDetailscols);
        vehicleDetailsTable.setWidthPercent(100f);
        vehicleDetailsTable.setMarginBottom(10f);

        Cell vehicleNum = new Cell();
        vehicleNum.setTextAlignment(TextAlignment.LEFT);
        vehicleNum.setBorder(Border.NO_BORDER);
        vehicleNum.add("Vehicle No : "+vehicleDetails.get(0)[4]).setUnderline();
        vehicleDetailsTable.addCell(vehicleNum);

        Cell vehicleOwner = new Cell();
        vehicleOwner.setTextAlignment(TextAlignment.RIGHT);
        vehicleOwner.setBorder(Border.NO_BORDER);
        vehicleOwner.add("Owner : "+clientDetails.get(0)[1]+" "+clientDetails.get(0)[2]).setUnderline();
        vehicleDetailsTable.addCell(vehicleOwner);

        document.add(vehicleDetailsTable);

        float [] itemsTableCols = {200f,80f,80f,80f,100f};
        Table itemTable = new Table(itemsTableCols);
        itemTable.setWidthPercent(100f);
        itemTable.setMarginBottom(10f);

        Cell itemNameTitle = new Cell();
        itemNameTitle.add("Item/Service Name");
        itemNameTitle.setBold();
        itemNameTitle.setTextAlignment(TextAlignment.CENTER);
        itemTable.addCell(itemNameTitle);

        Cell batchNoTitle = new Cell();
        batchNoTitle.add("Batch No.");
        batchNoTitle.setBold();
        batchNoTitle.setTextAlignment(TextAlignment.CENTER);
        itemTable.addCell(batchNoTitle);

        Cell quantityTitle = new Cell();
        quantityTitle.add("Quantity");
        quantityTitle.setBold();
        quantityTitle.setTextAlignment(TextAlignment.CENTER);
        itemTable.addCell(quantityTitle);

        Cell unitPriceTitle = new Cell();
        unitPriceTitle.add("Unit Price (Rs.)");
        unitPriceTitle.setBold();
        unitPriceTitle.setTextAlignment(TextAlignment.CENTER);
        itemTable.addCell(unitPriceTitle);

        Cell priceTitle = new Cell();
        priceTitle.add("Price (Rs.)");
        priceTitle.setBold();
        priceTitle.setTextAlignment(TextAlignment.CENTER);
        itemTable.addCell(priceTitle);

        for (String[] i:jobServiceResults){
            ArrayList<String[]> serviceTableResults = new ArrayList<>();

            try {
                serviceTableResults = serviceTable.select("*","Service_Id="+i[1]);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Cell serviceName = new Cell();
            serviceName.add(serviceTableResults.get(0)[1]);
            itemTable.addCell(serviceName);

            Cell dashCell = new Cell();
            dashCell.add("--");
            itemTable.addCell(dashCell);

            Cell dashCell1 = new Cell();
            dashCell1.add("--");
            itemTable.addCell(dashCell1);

            Cell dashCell2 = new Cell();
            dashCell2.add("--");
            itemTable.addCell(dashCell2);

            Cell servicePrice = new Cell();
            servicePrice.setTextAlignment(TextAlignment.RIGHT);
            servicePrice.add(serviceTableResults.get(0)[2]);
            itemTable.addCell(servicePrice);

            totalPrice = totalPrice + Integer.parseInt(serviceTableResults.get(0)[2]);
        }

        for (String[] i:jobItemResults){
            ArrayList<String[]> inventoryItemTableResults = new ArrayList<>();

            try {
                inventoryItemTableResults = inventoryItemTable.select("*","Inventory_Item_Id="+i[1]);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Cell itemName = new Cell();
            itemName.add(inventoryItemTableResults.get(0)[1]);
            itemTable.addCell(itemName);

            Cell itemBatch = new Cell();
            itemBatch.add(i[2]);
            itemTable.addCell(itemBatch);

            Cell itemQuantity = new Cell();
            itemQuantity.add(i[3]);
            itemTable.addCell(itemQuantity);

            Cell itemUnitPrice = new Cell();
            itemUnitPrice.add(inventoryItemTableResults.get(0)[3]);
            itemTable.addCell(itemUnitPrice);

            Cell itemFullPrice = new Cell();
            itemFullPrice.setTextAlignment(TextAlignment.RIGHT);
            int totalItemPrice = Integer.parseInt(inventoryItemTableResults.get(0)[3]) * Integer.parseInt(i[3]);
            itemFullPrice.add(String.valueOf(totalItemPrice));
            itemTable.addCell(itemFullPrice);

            totalPrice = totalPrice + totalItemPrice;
        }

//        for (int i = 0; i < 5; i++) {
//            Cell itemName = new Cell();
//            itemName.add("Dummy Name");
//            itemTable.addCell(itemName);
//
//            Cell unitPrice = new Cell();
//            unitPrice.add("100.00");
//            itemTable.addCell(unitPrice);
//
//            Cell quantity = new Cell();
//            quantity.add("99");
//            itemTable.addCell(quantity);
//
//            Cell price = new Cell();
//            price.setTextAlignment(TextAlignment.RIGHT);
//            price.add("10000.00");
//            itemTable.addCell(price);
//        }

        Cell totalTitle = new Cell();
        totalTitle.add("Total");
        totalTitle.setBold();
        itemTable.addCell(totalTitle);
        itemTable.addCell(totalTitle);
        itemTable.addCell(totalTitle);
        itemTable.addCell(totalTitle);

        Cell total = new Cell();
        total.setTextAlignment(TextAlignment.RIGHT);
        total.add(String.valueOf(totalPrice));
        total.setBorderBottom(new DoubleBorder(2f));
        itemTable.addCell(total);

        document.add(itemTable);

        document.add(divider);

        document.add(new Paragraph("Thank you for choosing us...").setTextAlignment(TextAlignment.CENTER));

        document.close();

        return totalPrice;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobID = req.getParameter("jobId");
        String afterWhere = "Job_ID=%s";
        afterWhere = String.format(afterWhere, jobID);
        ArrayList<String[]> jobTableResults = new ArrayList<>();
        ArrayList<String[]> jobServiceResults = new ArrayList<>();
        ArrayList<String[]> jobItemResults = new ArrayList<>();
        ArrayList<String[]> vehicleDetails = new ArrayList<>();
        ArrayList<String[]> clientDetails = new ArrayList<>();
        try {

            jobTableResults = jobTable.select("*",afterWhere);
            jobServiceResults = jobServiceTable.select("*",afterWhere);
            jobItemResults = jobInventoryItemTable.select("*",afterWhere);
            vehicleDetails = vehicleTable.select("*","Vehicle_Id="+jobTableResults.get(0)[7]);
            clientDetails = registeredClientTable.select("*","Registered_Client_Id="+vehicleDetails.get(0)[3]);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ServletContext context = getServletContext();
        String contextPath = context.getRealPath("/");
        String filePath = contextPath + "/Invoices/"+jobID+".pdf";

        String duplicateSaveLocation = "D:\\SerWise\\src\\main\\webapp\\Invoices\\"+jobID+".pdf";

        int totalPrice = genenatePDF(jobID, filePath, jobTableResults, jobServiceResults, jobItemResults, vehicleDetails, clientDetails);
        int totalPriceDuplicate = genenatePDF(jobID, duplicateSaveLocation, jobTableResults, jobServiceResults, jobItemResults, vehicleDetails, clientDetails);
////        String path = "http://localhost:8081/SerWise_war/Invoices/invoice.pdf";
//        PdfWriter pdfWriter = new PdfWriter(filePath);
//        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//        pdfDocument.setDefaultPageSize(PageSize.A4);
//        Document document = new Document(pdfDocument);
//
//        float [] pointColumnWidths = {150f*2, 150f};
//        Table table = new Table(pointColumnWidths);
//        table.setWidthPercent(100f);
//        table.setMarginBottom(5f);
//
//        LocalDate date = LocalDate.now();
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");
//
//        LocalTime time = LocalTime.now();
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
//
//        String imgPath = "http://localhost:8081/SerWise_war/Assets/SerWise.png";
//        ImageData imageData = ImageDataFactory.create(imgPath);
//        Image img = new Image(imageData);
//        img.setWidth(75f);
//        img.setHeight(75f);
//
//        Cell cell1 = new Cell();
//        cell1.add(img);
//        cell1.setBorder(Border.NO_BORDER);
//        cell1.setVerticalAlignment(VerticalAlignment.MIDDLE);
//        table.addCell(cell1);
//
//        Cell cell2 = new Cell();
//        cell2.add("Date : "+ date.format(dateFormatter) + "\n" + "Time : " + time.format(timeFormatter) + "\nBranch : Kollupitiya");
//        cell2.setBorder(Border.NO_BORDER);
//        cell2.setTextAlignment(TextAlignment.LEFT);
//        cell2.setVerticalAlignment(VerticalAlignment.MIDDLE);
//        table.addCell(cell2);
//
//        document.add(table);
//
//        float [] coloms = {10000f};
//        Table divider = new Table(coloms);
//        divider.setWidthPercent(100f);
//        Border border = new DoubleBorder(Color.BLACK,0.5f);
//        divider.setBorder(border);
//        divider.setMarginBottom(10f);
//        document.add(divider);
//
//        Paragraph invoiceTitle = new Paragraph("INVOICE : Job ID "+jobID);
//        invoiceTitle.setTextAlignment(TextAlignment.CENTER);
//        invoiceTitle.setMarginBottom(10f);
//        invoiceTitle.setUnderline();
//        invoiceTitle.setBold();
//        document.add(invoiceTitle);
//
//        float [] vehicleDetailscols = {100f,100f};
//        Table vehicleDetailsTable = new Table(vehicleDetailscols);
//        vehicleDetailsTable.setWidthPercent(100f);
//        vehicleDetailsTable.setMarginBottom(10f);
//
//        Cell vehicleNum = new Cell();
//        vehicleNum.setTextAlignment(TextAlignment.LEFT);
//        vehicleNum.setBorder(Border.NO_BORDER);
//        vehicleNum.add("Vehicle No : "+vehicleDetails.get(0)[4]).setUnderline();
//        vehicleDetailsTable.addCell(vehicleNum);
//
//        Cell vehicleOwner = new Cell();
//        vehicleOwner.setTextAlignment(TextAlignment.RIGHT);
//        vehicleOwner.setBorder(Border.NO_BORDER);
//        vehicleOwner.add("Owner : "+clientDetails.get(0)[1]+" "+clientDetails.get(0)[2]).setUnderline();
//        vehicleDetailsTable.addCell(vehicleOwner);
//
//        document.add(vehicleDetailsTable);
//
//        float [] itemsTableCols = {200f,80f,80f,80f,100f};
//        Table itemTable = new Table(itemsTableCols);
//        itemTable.setWidthPercent(100f);
//        itemTable.setMarginBottom(10f);
//
//        Cell itemNameTitle = new Cell();
//        itemNameTitle.add("Item/Service Name");
//        itemNameTitle.setBold();
//        itemNameTitle.setTextAlignment(TextAlignment.CENTER);
//        itemTable.addCell(itemNameTitle);
//
//        Cell batchNoTitle = new Cell();
//        batchNoTitle.add("Batch No.");
//        batchNoTitle.setBold();
//        batchNoTitle.setTextAlignment(TextAlignment.CENTER);
//        itemTable.addCell(batchNoTitle);
//
//        Cell quantityTitle = new Cell();
//        quantityTitle.add("Quantity");
//        quantityTitle.setBold();
//        quantityTitle.setTextAlignment(TextAlignment.CENTER);
//        itemTable.addCell(quantityTitle);
//
//        Cell unitPriceTitle = new Cell();
//        unitPriceTitle.add("Unit Price (Rs.)");
//        unitPriceTitle.setBold();
//        unitPriceTitle.setTextAlignment(TextAlignment.CENTER);
//        itemTable.addCell(unitPriceTitle);
//
//        Cell priceTitle = new Cell();
//        priceTitle.add("Price (Rs.)");
//        priceTitle.setBold();
//        priceTitle.setTextAlignment(TextAlignment.CENTER);
//        itemTable.addCell(priceTitle);
//
//        for (String[] i:jobServiceResults){
//            ArrayList<String[]> serviceTableResults = new ArrayList<>();
//
//            try {
//                serviceTableResults = serviceTable.select("*","Service_Id="+i[1]);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            Cell serviceName = new Cell();
//            serviceName.add(serviceTableResults.get(0)[1]);
//            itemTable.addCell(serviceName);
//
//            Cell dashCell = new Cell();
//            dashCell.add("--");
//            itemTable.addCell(dashCell);
//
//            Cell dashCell1 = new Cell();
//            dashCell1.add("--");
//            itemTable.addCell(dashCell1);
//
//            Cell dashCell2 = new Cell();
//            dashCell2.add("--");
//            itemTable.addCell(dashCell2);
//
//            Cell servicePrice = new Cell();
//            servicePrice.setTextAlignment(TextAlignment.RIGHT);
//            servicePrice.add(serviceTableResults.get(0)[2]);
//            itemTable.addCell(servicePrice);
//
//            totalPrice = totalPrice + Integer.parseInt(serviceTableResults.get(0)[2]);
//        }
//
//        for (String[] i:jobItemResults){
//            ArrayList<String[]> inventoryItemTableResults = new ArrayList<>();
//
//            try {
//                inventoryItemTableResults = inventoryItemTable.select("*","Inventory_Item_Id="+i[1]);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            Cell itemName = new Cell();
//            itemName.add(inventoryItemTableResults.get(0)[1]);
//            itemTable.addCell(itemName);
//
//            Cell itemBatch = new Cell();
//            itemBatch.add(i[2]);
//            itemTable.addCell(itemBatch);
//
//            Cell itemQuantity = new Cell();
//            itemQuantity.add(i[3]);
//            itemTable.addCell(itemQuantity);
//
//            Cell itemUnitPrice = new Cell();
//            itemUnitPrice.add(inventoryItemTableResults.get(0)[3]);
//            itemTable.addCell(itemUnitPrice);
//
//            Cell itemFullPrice = new Cell();
//            itemFullPrice.setTextAlignment(TextAlignment.RIGHT);
//            int totalItemPrice = Integer.parseInt(inventoryItemTableResults.get(0)[3]) * Integer.parseInt(i[3]);
//            itemFullPrice.add(String.valueOf(totalItemPrice));
//            itemTable.addCell(itemFullPrice);
//
//            totalPrice = totalPrice + totalItemPrice;
//        }
//
////        for (int i = 0; i < 5; i++) {
////            Cell itemName = new Cell();
////            itemName.add("Dummy Name");
////            itemTable.addCell(itemName);
////
////            Cell unitPrice = new Cell();
////            unitPrice.add("100.00");
////            itemTable.addCell(unitPrice);
////
////            Cell quantity = new Cell();
////            quantity.add("99");
////            itemTable.addCell(quantity);
////
////            Cell price = new Cell();
////            price.setTextAlignment(TextAlignment.RIGHT);
////            price.add("10000.00");
////            itemTable.addCell(price);
////        }
//
//        Cell totalTitle = new Cell();
//        totalTitle.add("Total");
//        totalTitle.setBold();
//        itemTable.addCell(totalTitle);
//        itemTable.addCell(totalTitle);
//        itemTable.addCell(totalTitle);
//        itemTable.addCell(totalTitle);
//
//        Cell total = new Cell();
//        total.setTextAlignment(TextAlignment.RIGHT);
//        total.add(String.valueOf(totalPrice));
//        total.setBorderBottom(new DoubleBorder(2f));
//        itemTable.addCell(total);
//
//        document.add(itemTable);
//
//        document.add(divider);
//
//        document.add(new Paragraph("Thank you for choosing us...").setTextAlignment(TextAlignment.CENTER));
//
//        document.close();

        try {
            jobTable.update("Total="+totalPrice+",Status='Billed'",afterWhere);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Invoice</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<script>");
        out.println("window.location='http://localhost:8081/SerWise_war/doneJobList';");
        out.println("window.open('http://localhost:8081/SerWise_war/Invoices/"+jobID+".pdf');");
        out.println("");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
