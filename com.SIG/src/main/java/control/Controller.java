package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceHeader;
import model.InvoiceHeaderTableModel;
import model.InvoiceLine;
import model.InvoiceLineTableModel;
import view.InvoiceDialog;
import view.LineDialog;
import view.Zframe;

/**
 *
 * @author Ahmed
 */
public class Controller implements ActionListener, ListSelectionListener{
    private Zframe frame;
    private InvoiceDialog invoiceDialog;
    private LineDialog lineDialog;

    public Controller(Zframe frame) {
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Create New Invoice":
                crtInv();
                break;
            case "Delete Invoice":
                deleteInv();
                break;
            case "Save":
                saveChng();
                break;
            case "Cancel":
                cancelChng();
                break;
            case "Open":
                openFile();
                break;
            case "Save Data":
                saveDate();
                break;
            case "createInvoiceCancel":
                createInvoiceCancel();
                break;
            case "createInvoiceOK":
                createInvoiceOK();
                break;
            case "createLineOK":
                createLineOK();
                break;
            case "createLineCancel":
                createLineCancel();
                break;
        }
            
    }

     @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = frame.getInvoicesTbl().getSelectedRow();
        
        if (selectedRow != -1){
            InvoiceHeader currentInv = frame.getInvHeader().get(selectedRow);
            frame.getInvNumLbl().setText("" + currentInv.getInvoiceNum());
            frame.getInvDateLbl().setText(currentInv.getInvoiceDate());
            frame.getCxLbl().setText(currentInv.getCustomerName());
            frame.getTotalLbl().setText(""+currentInv.getTotal());
            InvoiceLineTableModel invLineTableModel = new InvoiceLineTableModel(currentInv.getItems());
            frame.getLinesTbl().setModel(invLineTableModel);
            invLineTableModel.fireTableDataChanged();
        } else {
        }    
     }
    
    private void saveDate() {
          ArrayList<InvoiceHeader> invoices = frame.getInvHeader();
        String headers = "";
        String lines = "";
        for (InvoiceHeader invoice : invoices) {
            String invCSV = invoice.getAsCSV();
            headers += invCSV;
            headers += "\n";

            for (InvoiceLine invline : invoice.getItems()) {
                String lineCSV = invline.getAsCSV();
                lines += lineCSV;
                lines += "\n";
            }
        }
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                hfw.write(headers);
                hfw.flush();
                hfw.close();
                result = fc.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc.getSelectedFile();
                    FileWriter lfw = new FileWriter(lineFile);
                    lfw.write(lines);
                    lfw.flush();
                    lfw.close();
                }
            }
        } catch (Exception ex) {

        }
        
        
    }

    private void openFile() {
        JFileChooser fileChooser =new JFileChooser();
        try{
        int opndFile = fileChooser.showOpenDialog(frame);
        if (opndFile == JFileChooser.APPROVE_OPTION){
            File invHeaderFile = fileChooser.getSelectedFile();
            Path invHeaderFilePath = Paths.get(invHeaderFile.getAbsolutePath());
            List<String> invHeaderLines = Files.readAllLines(invHeaderFilePath);
            
            ArrayList<InvoiceHeader> invArray = new ArrayList<>();
            for (String invHeaderLine : invHeaderLines ){
                String[] invHeaderParts = invHeaderLine.split(",");
                int invoiceNum = Integer.parseInt(invHeaderParts[0]);
                String invoiceDate = invHeaderParts[1];
                String customerName = invHeaderParts[2];
                
                InvoiceHeader invHeader = new InvoiceHeader(invoiceNum, invoiceDate, customerName);
                invArray.add(invHeader);
                }
               opndFile = fileChooser.showOpenDialog(frame);
               if (opndFile == JFileChooser.APPROVE_OPTION){
                   File invLineFile = fileChooser.getSelectedFile();  
                   Path invLineFilePath = Paths.get(invLineFile.getAbsolutePath());
                   List<String> invLineFileLines = Files.readAllLines(invLineFilePath);
                            for (String invLineFileLine : invLineFileLines ){
                            String invLineFileLinesParts[] = invLineFileLine.split(",");

                            int invNum = Integer.parseInt(invLineFileLinesParts[0]);
                            String itemName = invLineFileLinesParts[1];
                             int itemCount = Integer.parseInt(invLineFileLinesParts[2]);
                             double itemPrice = Double.parseDouble(invLineFileLinesParts[3]) ;
                             InvoiceHeader inv = null;
                             for (InvoiceHeader invoiceHeader : invArray){
                                 if (invoiceHeader.getInvoiceNum() == invNum){
                                     inv = invoiceHeader;
                                     break;
                                 }
                             }
            InvoiceLine invLine = new InvoiceLine(inv,itemName, itemPrice, itemCount);
            inv.getItems().add(invLine);
                                System.out.println("stop");
                             
                        }
                
            }
               frame.setInvHeader(invArray);
               InvoiceHeaderTableModel invHeaderTbl = new InvoiceHeaderTableModel(invArray);
               frame.setInvTableModel(invHeaderTbl);
               frame.getInvoicesTbl().setModel(invHeaderTbl);
               frame.getInvTableModel().fireTableDataChanged();
        }
        } catch (IOException ioE){
            ioE.printStackTrace();
            }
        }
    

        private void cancelChng() {
        int selectedRow = frame.getInvoicesTbl().getSelectedRow();

        if (selectedRow != -1) {
            InvoiceLineTableModel linesTableModel = (InvoiceLineTableModel) frame.getLinesTbl().getModel();
            linesTableModel.getItems().remove(selectedRow);
            linesTableModel.fireTableDataChanged();
            frame.getInvTableModel().fireTableDataChanged();
            }
        }
    private void saveChng() {
        lineDialog = new LineDialog(frame);
        lineDialog.setVisible(true);    
    }

    private void deleteInv() {
        int selectedRow = frame.getInvoicesTbl().getSelectedRow();
        if (selectedRow != -1) {
            frame.getInvHeader().remove(selectedRow);
            frame.getInvTableModel().fireTableDataChanged();
            }
    }
    private void crtInv() {
        invoiceDialog = new InvoiceDialog(frame);
        invoiceDialog.setVisible(true);
    }

    private void createInvoiceCancel() {
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;    }

    private void createInvoiceOK() {
       String date = invoiceDialog.getInvDateField().getText();
       String customer = invoiceDialog.getCustNameField().getText();
       int num = frame.getNextInvNum();
        try {
            String[] dateParts = date.split("-");
            if (dateParts.length < 3) {
                JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);
                if (day > 31 || month > 12) {
                    JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    InvoiceHeader invoice = new InvoiceHeader(num, date, customer);
                    frame.getInvHeader().add(invoice);
                    frame.getInvTableModel().fireTableDataChanged();
                    invoiceDialog.setVisible(false);
                    invoiceDialog.dispose();
                    invoiceDialog = null;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createLineOK() {
        String item = lineDialog.getItemNameField().getText();
        String countStr = lineDialog.getItemCountField().getText();
        String priceStr = lineDialog.getItemPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = frame.getInvoicesTbl().getSelectedRow();
            if (selectedInvoice != -1) {
                InvoiceHeader invoice = frame.getInvHeader().get(selectedInvoice);
                InvoiceLine line = new InvoiceLine(invoice, item, price, count);
                invoice.getItems().add(line);
                InvoiceLineTableModel linesTableModel = (InvoiceLineTableModel) frame.getLinesTbl().getModel();
                linesTableModel.fireTableDataChanged();
                frame.getInvTableModel().fireTableDataChanged();
            }
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;    }

    private void createLineCancel() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
    }


   
    
}
