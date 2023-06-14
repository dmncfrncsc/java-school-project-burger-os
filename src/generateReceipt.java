import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Locale;


public class generateReceipt extends JFrame {


    private static JPanel receiptPanel;
    JLabel lblTitle = new JLabel("BURGER QUEEN");
    JLabel addressLbl = new JLabel("Baliuag, Bulacan");
    JLabel lblNum = new JLabel("+639123456789");
    JLabel lblItem = new JLabel("Item\\s");
    JLabel lblPrice = new JLabel("Price");
    JLabel lblQty = new JLabel("Qty");
    JLabel lblTotal = new JLabel("Total");
    JLabel lblSubT = new JLabel("Subtotal:");
    JLabel lblDiscount = new JLabel("Discount:");
    JLabel lblTotalAmnt = new JLabel("Total:");
    JLabel st = new JLabel("");
    JLabel ds = new JLabel("");
    JLabel tt = new JLabel("");
    JTextArea taItems = new JTextArea();
    JButton btnClose = new JButton("CLOSE");
    JButton btnPrint = new JButton("PRINT");
    JLabel lblThankYou = new JLabel("THANK YOU - PLEASE COME AGAIN");
    public generateReceipt(){
        taItems.setEditable(false);
        this.setBackground(Color.white);
        this.setUndecorated(true);
        this.setSize(306,573);
        this.setResizable(false);
        this.setLocationRelativeTo(this);//setLocationRelativeTo(this);
        this.setLayout(null);
        receiptPanel = new JPanel();
        this.add(receiptPanel).setBounds(0,0,306,519);
        receiptPanel.add(lblThankYou).setBounds(10,454,290,24);
        lblThankYou.setFont(new Font("Segoe UI",Font.PLAIN,18));
        receiptPanel.setLayout(null);
        receiptPanel.add(taItems).setBounds(0,114,306,212);
        receiptPanel.add(lblTitle).setBounds(78,0,153,27);
        receiptPanel.add(addressLbl).setBounds(92,27,125,22);
        receiptPanel.add(lblNum).setBounds(100,49,107,20);
        receiptPanel.add(lblItem).setBounds(0,94,35,29);
        receiptPanel.add(lblPrice).setBounds(73,94,30,20);
        receiptPanel.add(lblQty).setBounds(146,94,23,20);
        receiptPanel.add(lblTotal).setBounds(219,94,29,20);
        receiptPanel.add(lblSubT).setBounds(201,334,55,20);
        receiptPanel.add(lblDiscount).setBounds(201,361,58,20);
        receiptPanel.add(lblTotalAmnt).setBounds(201,388,32,20);
        receiptPanel.add(st).setBounds(272,334,30,20);
        receiptPanel.add(ds).setBounds(272,361,30,20);
        receiptPanel.add(tt).setBounds(272,388,30,20);
        taItems.setFont(new Font("Segoe UI",Font.PLAIN,11));
        lblTitle.setFont(new Font("Segoe UI",Font.BOLD,20));
        addressLbl.setFont(new Font("Segoe UI",Font.PLAIN,17));
        lblNum.setFont(new Font("Segoe UI",Font.PLAIN,15));
        lblItem.setFont(new Font("Segoe UI",Font.BOLD,11));
        lblPrice.setFont(new Font("Segoe UI",Font.BOLD,11));
        lblQty.setFont(new Font("Segoe UI",Font.BOLD,11));
        lblTotal.setFont(new Font("Segoe UI",Font.BOLD,11));
        lblSubT.setFont(new Font("Segoe UI",Font.PLAIN,11));
        lblDiscount.setFont(new Font("Segoe UI",Font.PLAIN,11));
        lblTotalAmnt.setFont(new Font("Segoe UI",Font.PLAIN,11));
        st.setFont(new Font("Segoe UI",Font.PLAIN,11));
        ds.setFont(new Font("Segoe UI",Font.PLAIN,11));
        tt.setFont(new Font("Segoe UI",Font.PLAIN,11));

        this.add(btnClose).setBounds(153,519,153,54);
        this.add(btnPrint).setBounds(0,519,153,54);
        Data data = Data.getInstance();
        List<cart> carts = data.getCartList();

        for (cart o: carts){
            taItems.append(o.getName()+"\t"+o.getPrice()+"\t"+o.getQty()+"\t"+o.getTotal()+"\n");

        }
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main main = new Main();
                main.show();
                Data data = Data.getInstance();
                data.clearCart();
            }
        });

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data data = Data.getInstance();
                data.clearCart();
                printReceipt(receiptPanel);
            }
        });
    }


    public void printReceipt(JPanel panel){
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Receipt");
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
               if(pageIndex >0){
                   return  Printable.PAGE_EXISTS;
               }
                Graphics2D graphics2D = (Graphics2D)graphics;
                graphics2D.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
                graphics2D.scale(0.5,0.5);
                panel.paint(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult=printerJob.printDialog();
        if(returningResult){
            try {
                printerJob.print();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(this,"Print Error" + e);
            }
        }
    }
    public static  void main (String [] args){
        generateReceipt generateReceipt = new generateReceipt();
        generateReceipt.show();
    }
}
