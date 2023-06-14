import com.sun.jdi.request.ThreadDeathRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.List;

public class Main extends JFrame {
    JLabel txtMenu = new JLabel("MAIN MENU");
    JButton btnBurger = new JButton("BURGER");
    JButton btnDrinks = new JButton("DRINKS");
    JButton btnAddons = new JButton("ADDONS");
    JPanel pnlMenu = new JPanel();
    JPanel pnlTransac = new JPanel();

    private static int quantity;
    private static int qty;
    JPanel pnlCart = new JPanel();
    JLabel lblProdName = new JLabel("Product Name:");
    JLabel lblPrice = new JLabel("Price:");
    JLabel lblQuantity = new JLabel("Enter Quantity:");
    JLabel lblTotal = new JLabel("Total:");
    private static JLabel txtProdName;
    private static JLabel txtPrice;
    private static JTextField txtQty;
    private static JLabel txtTotal;
    private static JButton btnConfirm;
    private static JButton btnCancel;
    private static JButton btnVoid;
    private static JButton btnProceed;
    private static JButton btnDelete;
    JButton btnCancelVoid = new JButton("CANCEL");
    JLabel lblSubTotal = new JLabel("Subtotal:");
    JLabel lblDiscount = new JLabel("Discount:");
    JLabel lblTotalAmnt = new JLabel("Total Amount:");
    JLabel lblInputPymnt = new JLabel("Input Payment:");
    JLabel lblChange = new JLabel("Change:");

    JTextField txtSubtotal = new JTextField();
    JTextField txtDiscount = new JTextField();
    JTextField txtTotalAmount = new JTextField();
    JTextField txtInputPayment = new JTextField();
    JTextField txtChange = new JTextField();
    JLabel lblVoidProd = new JLabel("Product Name:");
    JLabel lblVoidPrice = new JLabel("Price:");
    JLabel lblVoidQuantity = new JLabel("Quantity:");
    JLabel lblVoidTotal = new JLabel("Total:");
    JTextField txtVoidProd = new JTextField();
    JTextField txtVoidPrice = new JTextField();
    JTextField txtVoidQty = new JTextField();
    JTextField txtVoidTotal = new JTextField();
    JButton btnLogout = new JButton(">LOGOUT");

    JButton btnUpdate = new JButton("UPDATE");
    private static JTable tblMenu;
    private static DefaultTableModel tblMenuModel;
    private static JTable tblCart;
    private static DefaultTableModel tblCartModel;
    private static DecimalFormat df;
    JPanel pnlHeader = new JPanel();
    private ImageIcon image1;
    public Main(){
        lblProdName.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblProdName.setForeground(Color.white);

        lblPrice.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblPrice.setForeground(Color.white);

        lblQuantity.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblQuantity.setForeground(Color.white);

        lblTotal.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblTotal.setForeground(Color.white);




        this.setLayout(null);
        this.setSize(1280,860);
        this.setLocationRelativeTo(this);
        this.setUndecorated(true);
        JPanel pnlImage = new JPanel();
        this.add(pnlImage).setBounds(0,62,273,450);
        JLabel lblimg;
        image1=new ImageIcon(".\\src\\resources\\logo.jpg");
        lblimg = new JLabel("",image1,JLabel.CENTER);
        pnlImage.setLayout(null);
        pnlImage.add(lblimg).setBounds(0,0,273,450);
        this.add(pnlMenu).setBounds(0,62,273,800);
        this.add(pnlHeader).setBounds(0,0,1280,62);
        pnlHeader.setBackground(Color.black);
        pnlHeader.setLayout(null);
        pnlHeader.add(txtMenu).setBounds(32,3,227,53);
        txtMenu.setForeground(Color.white);
        txtMenu.setFont(new Font("Segoe UI Light",Font.PLAIN,40));
        pnlHeader.add(btnLogout).setBounds(1093,0,187,62);
        btnLogout.setMargin(new Insets(0,0,0,0));
        btnLogout.setBackground(new Color(51, 0, 0));
        btnLogout.setForeground(Color.white);
        btnLogout.setBorder(null);
        btnLogout.setFocusable(false);
        btnLogout.setFont(new Font("Segoe UI Light",Font.PLAIN,30));

        //buttonsdisableOnLoadandsetting it to privateStatic
        btnConfirm = new JButton("CONFIRM");
        btnConfirm.setMargin(new Insets(0,0,0,0));
        btnConfirm.setBackground(new Color(0, 51, 0));
        btnConfirm.setForeground(Color.white);
        btnConfirm.setBorder(null);
        btnConfirm.setFocusable(false);
        btnConfirm.setFont(new Font("Segoe UI Light",Font.PLAIN,30));

        btnCancel = new JButton("CANCEL");
        btnCancel.setMargin(new Insets(0,0,0,0));
        btnCancel.setBackground(new Color(51, 0, 0));
        btnCancel.setForeground(Color.white);
        btnCancel.setBorder(null);
        btnCancel.setFocusable(false);
        btnCancel.setFont(new Font("Segoe UI Light",Font.PLAIN,30));

        btnProceed = new JButton("PROCEED");
        btnProceed.setMargin(new Insets(0,0,0,0));
        btnProceed.setBackground(new Color(0, 51, 0));
        btnProceed.setForeground(Color.white);
        btnProceed.setBorder(null);
        btnProceed.setFocusable(false);
        btnProceed.setFont(new Font("Segoe UI Light",Font.PLAIN,30));

        btnVoid = new JButton("VOID");
        btnVoid.setMargin(new Insets(0,0,0,0));
        btnVoid.setBackground(new Color(51, 0, 0));
        btnVoid.setForeground(Color.white);
        btnVoid.setBorder(null);
        btnVoid.setFocusable(false);
        btnVoid.setFont(new Font("Segoe UI Light",Font.PLAIN,30));

        btnDelete = new JButton("DELETE");
        btnDelete.setMargin(new Insets(0,0,0,0));
        btnDelete.setBackground(new Color(51, 0, 0));
        btnDelete.setForeground(Color.white);
        btnDelete.setBorder(null);
        btnDelete.setFocusable(false);
        btnDelete.setFont(new Font("Segoe UI Light",Font.PLAIN,30));

        btnCancelVoid.setMargin(new Insets(0,0,0,0));
        btnCancelVoid.setBackground(new Color(242, 170, 76));
        btnCancelVoid.setForeground(Color.black);
        btnCancelVoid.setBorder(null);
        btnCancelVoid.setFocusable(false);
        btnCancelVoid.setFont(new Font("Segoe UI Light",Font.PLAIN,30))
        ;
        btnConfirm.setEnabled(false);
        btnCancel.setEnabled(false);
        btnProceed.setEnabled(false);
        btnVoid.setEnabled(false);
        btnDelete.setEnabled(false);
        btnBurger.setEnabled(true);
        btnDrinks.setEnabled(true);
        btnAddons.setEnabled(true);

        txtProdName = new JLabel("______");
        txtTotal = new JLabel("______");
        txtQty = new JTextField();
        txtPrice = new JLabel("______");
        pnlMenu.setLayout(null);
        txtTotal.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        txtTotal.setForeground(Color.white);
        pnlMenu.add(btnBurger).setBounds(0,450,273,100);
        btnBurger.setMargin(new Insets(0,0,0,0));
        btnBurger.setBackground(Color.black);
        btnBurger.setForeground(Color.white);
        btnBurger.setBorder(null);
        btnBurger.setFocusable(false);
        btnBurger.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        pnlMenu.add(btnDrinks).setBounds(0,567,273,100);
        btnDrinks.setMargin(new Insets(0,0,0,0));
        btnDrinks.setBackground(Color.black);
        btnDrinks.setForeground(Color.white);
        btnDrinks.setBorder(null);
        btnDrinks.setFocusable(false);
        btnDrinks.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        pnlMenu.add(btnAddons).setBounds(0,684,273,100);
        btnAddons.setMargin(new Insets(0,0,0,0));
        btnAddons.setBackground(Color.black);
        btnAddons.setForeground(Color.white);
        btnAddons.setBorder(null);
        btnAddons.setFocusable(false);
        btnAddons.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        pnlMenu.setBackground(new Color(242, 170, 76));

        tblMenu = new JTable();
        JScrollPane paneMenu = new JScrollPane(tblMenu);

        tblCart = new JTable();
        JScrollPane paneCart = new JScrollPane(tblCart);

        this.add(pnlTransac).setBounds(273,60,569,800);
        pnlTransac.setLayout(null);
        pnlTransac.setBackground(new Color(0,0,51));
        pnlTransac.add(paneMenu).setBounds(0,0,569,450);
        pnlTransac.add(lblProdName).setBounds(28,467,197,40);
        pnlTransac.add(lblPrice).setBounds(28,525,71,40);
       pnlTransac.add(lblQuantity).setBounds(28,583,197,40);
        pnlTransac.add(lblTotal).setBounds(155,641,70,40);

        pnlTransac.add(txtProdName).setBounds(256,467,235,40);
        pnlTransac.add(txtPrice).setBounds(256,525,156,40);
        pnlTransac.add(txtQty).setBounds(256,583,156,40);
        pnlTransac.add(txtTotal).setBounds(256,641,156,40);

        pnlTransac.add(btnConfirm).setBounds(409,701,133,62);
        pnlTransac.add(btnCancel).setBounds(259,701,133,62);
        txtPrice.disable();
        txtProdName.disable();
        txtQty.disable();
        txtTotal.disable();




        txtInputPayment.disable();
        txtDiscount.disable();
        this.add(pnlCart).setBounds(842,60,438,800);
        pnlCart.setBackground(new Color(0,0,51));
        pnlCart.add(paneCart).setBounds(0,0,438,450);
        pnlCart.setLayout(null);
        pnlCart.add(lblVoidProd).setBounds(22,458,197,40);
        pnlCart.add(lblVoidPrice).setBounds(22,506,71,40);
        pnlCart.add(lblVoidQuantity).setBounds(22,554,120,40);
        pnlCart.add(lblVoidTotal).setBounds(22,602,70,40);
        pnlCart.add(txtVoidProd).setBounds(245,458,180,40);
        pnlCart.add(txtVoidPrice).setBounds(245,506,180,40);
        pnlCart.add(txtVoidQty).setBounds(245,554,180,40);
        pnlCart.add(txtVoidTotal).setBounds(245,602,180,40);
        pnlCart.add(btnDelete).setBounds(252,706,133,62);
        pnlCart.add(btnCancelVoid).setBounds(66,706,133,62);
        lblVoidProd.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblVoidProd.setForeground(Color.white);
        lblVoidPrice.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblVoidPrice.setForeground(Color.white);
        lblVoidQuantity.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblVoidQuantity.setForeground(Color.white);
        lblVoidTotal.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblVoidTotal.setForeground(Color.white);


        lblVoidProd.hide();
        lblVoidPrice.hide();
        lblVoidQuantity.hide();
        lblVoidTotal.hide();
        txtVoidProd.hide();
        txtVoidPrice.hide();
        txtVoidQty.hide();
        txtVoidTotal.hide();
        btnDelete.hide();
        btnUpdate.hide();
        txtVoidProd.disable();
        txtVoidPrice.disable();
        txtVoidQty.disable();
        txtVoidTotal.disable();
        btnCancelVoid.hide();
        pnlCart.add(lblSubTotal).setBounds(62,458,129,40);
        pnlCart.add(lblDiscount).setBounds(62,506,123,40);
        pnlCart.add(lblTotalAmnt).setBounds(62,554,185,40);
        pnlCart.add(lblInputPymnt).setBounds(62,602,199,40);
        pnlCart.add(lblChange).setBounds(62,650,108,40);
        pnlCart.add(txtSubtotal).setBounds(297,458,110,40);
        pnlCart.add(txtDiscount).setBounds(297,506,110,40);
        pnlCart.add(txtTotalAmount).setBounds(297,554,110,40);
        pnlCart.add(txtInputPayment).setBounds(297,602,110,40);
        pnlCart.add(txtChange).setBounds(297,650,110,40);
        lblSubTotal.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblSubTotal.setForeground(Color.white);
        lblDiscount.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblDiscount.setForeground(Color.white);
        lblTotalAmnt.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblTotalAmnt.setForeground(Color.white);
        lblInputPymnt.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblInputPymnt.setForeground(Color.white);
        lblChange.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        lblChange.setForeground(Color.white);

        txtSubtotal.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        txtSubtotal.setForeground(Color.white);
        txtSubtotal.setBackground(null);
        txtDiscount.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        txtDiscount.setForeground(Color.BLACK);

        txtTotalAmount.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        txtTotalAmount.setForeground(Color.BLACK);
        txtTotalAmount.setBackground(null);
        txtInputPayment.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        txtInputPayment.setForeground(Color.BLACK);
        txtChange.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        txtChange.setForeground(Color.BLACK);
        txtChange.setBackground(null);


/*        lblSubTotal.setFont(new Font("Segoe UI",Font.PLAIN,30));
        lblDiscount.setFont(new Font("Segoe UI",Font.PLAIN,30));
        lblTotalAmnt.setFont(new Font("Segoe UI",Font.PLAIN,30));*/
        pnlCart.add(btnVoid).setBounds(66,706,133,62);
        pnlCart.add(btnProceed).setBounds(252,706,133,62);
        Data data = Data.getInstance();
        generateMenu(data);
        generateCart(data);
        txtSubtotal.disable();
        txtTotalAmount.disable();
        txtChange.disable();

        //receipt


        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm login = new LoginForm();
                login.show();
            }
        });
        btnBurger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data data = Data.getInstance();
                generateCategory(data, "Burger");

                btnBurger.setEnabled(false);
                btnDrinks.setEnabled(true);
                btnAddons.setEnabled(true);

            }
        });
        btnDrinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCategory(data, "Drinks");

                btnBurger.setEnabled(true);
                btnDrinks.setEnabled(false);
                btnAddons.setEnabled(true);
            }
        });
        btnAddons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCategory(data, "Addons");

                btnBurger.setEnabled(true);
                btnDrinks.setEnabled(true);
                btnAddons.setEnabled(false);
            }
        });
        txtQty.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(txtQty.getText().isEmpty()){
                    txtTotal.setText("0.00");
                }else if(Integer.parseInt(txtQty.getText())<0){
                    btnConfirm.hide();
                    txtQty.setForeground(Color.red);
                }else if(Integer.parseInt(txtQty.getText())>quantity){
                    btnConfirm.hide();
                    txtQty.setForeground(Color.red);
                }else{
                    txtQty.setForeground(Color.black);
                    btnConfirm.show();
                    double price = Double.parseDouble(txtPrice.getText());
                    int qty = Integer.parseInt(txtQty.getText());
                    txtTotal.setText(String.valueOf(df.format(price*qty)));
                }

            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtProdName.setText("______");
                txtPrice.setText("______");
                txtQty.setText("______");
                txtTotal.setText("______");
                txtQty.disable();
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtQty.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Enter Quantity.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                }if(txtQty.getText().equals("0")){
                    JOptionPane.showMessageDialog(null,"Please Enter Quantity.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                }else{
                    Data data1 = Data.getInstance();
                    qty = quantity - (Integer.parseInt(txtQty.getText()));
;
                    String name = txtProdName.getText().toLowerCase();

                    data1.editQty(name, qty);
                    generateMenu(data1);
                    data1.addtoCart(new cart(txtProdName.getText(),Double.parseDouble(txtPrice.getText()),Integer.parseInt(txtQty.getText()),Double.parseDouble(txtTotal.getText())));
                    generateCart(data1);
                    txtSubtotal.setText(String.valueOf(df.format(data1.getSubtotal())));
                    txtProdName.setText("");
                    txtTotal.setText("");
                    txtPrice.setText("");
                    txtQty.setText("");
                    txtQty.disable();
                    txtDiscount.enable();
                    btnVoid.setEnabled(true);
                }
            }
        });

        txtDiscount.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                double bill;
                bill = Double.parseDouble(txtSubtotal.getText());

                if(txtDiscount.getText().isEmpty()){
                    txtTotalAmount.setText(String.valueOf(bill));
                }else if(Integer.parseInt(txtDiscount.getText())<0){
                    txtDiscount.setForeground(Color.red);
                    txtInputPayment.setEnabled(false);
                }else{
                    txtDiscount.setForeground(Color.black);
                    double discount;
                    discount = Double.parseDouble(txtDiscount.getText());
                    double totalAmount = bill-(bill*discount/100);
                    txtTotalAmount.setText(String.valueOf(df.format(totalAmount)));
                    txtInputPayment.enable();
                }

            }
        });
        txtInputPayment.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                double total = Double.parseDouble(txtTotalAmount.getText());

                if(txtInputPayment.getText().isEmpty()){
                    txtChange.setText("");
                }else if(Double.parseDouble(txtInputPayment.getText())<total){
                    btnProceed.hide();
                    txtChange.setText("");
                    txtInputPayment.setForeground(Color.red);
                }else if(Double.parseDouble(txtInputPayment.getText())>=total){
                    txtInputPayment.setForeground(Color.black);
                    double payment = Double.parseDouble(txtInputPayment.getText());
                    double change = payment-total;
                    txtChange.setText(String.valueOf(df.format(change)));
                    btnProceed.show();
                    btnProceed.enable();
                    btnVoid.enable();

                    btnProceed.setEnabled(true);

                }else{
                    txtChange.setText("0.00");
                }


            }
        });
        btnProceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int sel = JOptionPane.showConfirmDialog(null,"Are you sure you want to proceed?","Transaction Alert", JOptionPane.YES_NO_OPTION);
                if(sel ==0 ) {
                    JOptionPane.showMessageDialog(null, "Transaction Complete", "Transaction Alert", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    generateReceipt receipt = new generateReceipt();
                    receipt.show();
                    receipt.st.setText(txtSubtotal.getText());
                    receipt.ds.setText(txtDiscount.getText());
                    receipt.tt.setText(txtTotalAmount.getText());
                }
            }
        });
        btnVoid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Box userBox = Box.createVerticalBox();
                JLabel JL = new JLabel("Username: ");
                userBox.add(JL);
                JTextField jtf = new JTextField(24);
                userBox.add(jtf);

                JLabel JPL = new JLabel("Password: ");
                userBox.add(JPL);
                JPasswordField JPF = new JPasswordField(24);
                userBox.add(JPF);

                Data data = Data.getInstance();
                int button = JOptionPane.showConfirmDialog(null, userBox, "Enter Admin Account", JOptionPane.OK_CANCEL_OPTION);

                if (button == JOptionPane.OK_OPTION) {
                   String user = jtf.getText();
                   char[] pass = JPF.getPassword();
                    if(data.isAccountAdminLevel(user, String.valueOf(pass))){
                        btnDelete.setEnabled(true);
                        tblCart.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                int rowIndex = tblCart.getSelectedRow();
                                txtVoidProd.setText(String.valueOf(tblCart.getModel().getValueAt(rowIndex, 0)));
                                txtVoidPrice.setText(String.valueOf(tblCart.getModel().getValueAt(rowIndex,1)));
                                txtVoidQty.enable();
                                txtVoidQty.setText(String.valueOf(tblCart.getModel().getValueAt(rowIndex,2)));
                                txtVoidTotal.setText(String.valueOf(tblCart.getModel().getValueAt(rowIndex,3)));
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {

                            }

                            @Override
                            public void mouseExited(MouseEvent e) {

                            }
                        });
                        lblVoidProd.show();
                        lblVoidPrice.show();
                        lblVoidQuantity.show();
                        lblVoidTotal.show();
                        txtVoidProd.show();
                        txtVoidPrice.show();
                        txtVoidQty.show();
                        txtVoidTotal.show();
                        btnDelete.show();
                        btnUpdate.show();
                        btnCancelVoid.show();

                        lblTotalAmnt.hide();
                        lblDiscount.hide();
                        lblSubTotal.hide();
                        lblInputPymnt.hide();
                        lblChange.hide();
                        txtDiscount.hide();
                        txtSubtotal.hide();
                        txtInputPayment.hide();
                        txtChange.hide();
                        txtTotalAmount.hide();
                        btnVoid.hide();
                        btnProceed.hide();
                    }else{
                       JOptionPane.showMessageDialog(null,"Invalid Admin Account","Invalid Account",JOptionPane.ERROR_MESSAGE);
                    }


                }



            }
        });
        btnCancelVoid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblVoidProd.hide();
                lblVoidPrice.hide();
                lblVoidQuantity.hide();
                lblVoidTotal.hide();
                txtVoidProd.hide();
                txtVoidPrice.hide();
                txtVoidQty.hide();
                txtVoidTotal.hide();
                btnDelete.hide();
                btnUpdate.hide();
                btnCancelVoid.hide();
                lblTotalAmnt.show();
                lblDiscount.show();
                lblSubTotal.show();
                lblInputPymnt.show();
                lblChange.show();
                txtDiscount.show();
                txtSubtotal.show();
                txtInputPayment.show();
                txtChange.show();
                txtTotalAmount.show();
                btnVoid.show();
                btnProceed.show();
                txtSubtotal.setText(String.valueOf(df.format(data.getSubtotal())));
            }
        });

        /*btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(txtVoidQty.getText().isEmpty()){
                   JOptionPane.showMessageDialog(null,"Empty Fields Detected","Empty Field",JOptionPane.WARNING_MESSAGE);
               }else{
                   Data data = Data.getInstance();

                   quantity = quantity - (Integer.parseInt(txtVoidQty.getText()));
                   data.editQty(txtVoidProd.getText(), quantity);
                   generateMenu(data);
                   data.editCartQty(txtVoidProd.getText(), Integer.parseInt(txtVoidQty.getText()));
                   generateCart(data);
                   lblVoidProd.hide();
                   lblVoidPrice.hide();
                   lblVoidQuantity.hide();
                   lblVoidTotal.hide();

                   txtVoidProd.hide();
                   txtVoidPrice.hide();
                   txtVoidQty.hide();
                   txtVoidTotal.hide();
                   btnDelete.hide();
                   btnUpdate.hide();

                   lblTotalAmnt.show();
                   lblDiscount.show();
                   lblSubTotal.show();
                   lblInputPymnt.show();
                   lblChange.show();
                   txtDiscount.show();
                   txtSubtotal.show();
                   txtInputPayment.show();
                   txtChange.show();
                   txtTotalAmount.show();
                   btnVoid.show();
                   btnProceed.show();
               }
            }
        });*/
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtVoidProd.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please select an item to delete","Delete Item",JOptionPane.WARNING_MESSAGE);
                }else{
                    int sel= JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this item?","Confirm Delete",JOptionPane.YES_NO_OPTION);
                    if(sel==0){
                        Data data = Data.getInstance();
                        data.editVoidQty(txtVoidProd.getText(),quantity);
                        data.deleteCart(txtVoidProd.getText());
                        generateCart(data);
                        generateMenu(data);

                    }else{
                        return;
                    }
                }
            }
        });
    }

    public static void generateMenu(Data data){
        df = new DecimalFormat("#.##");
        String[] colsMenu = {"Item","Price","Quantity",""};
        tblMenuModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
                return getValueAt(0,column).getClass();
            }
        };
        tblMenu.getTableHeader().setResizingAllowed(false);
        tblMenu.getTableHeader().setReorderingAllowed(false);

        tblMenu.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        List<Product> products = data.getProductList();
        for (Product o: products){
            if(o.getQty()!=0 &&o.getQty()>0){
                Object[] newRow = {o.getName().toUpperCase(),o.getPrice(),o.getQty(),"ORDER"};
                tblMenuModel.addRow(newRow);
            }
        }
        tblMenu.setModel(tblMenuModel);
        tblMenu.setSelectionBackground(new Color(242,242,242));

        tblMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblMenu.setRowHeight(100);
        tblMenu.setGridColor(Color.WHITE);
        tblMenu.setBorder(BorderFactory.createEmptyBorder());
        tblMenu.setRowMargin(10);
        tblMenu.setDefaultEditor(Object.class, null); // editable = false
        tblMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMenu.setFocusable(false);
        tblMenu.setShowHorizontalLines(false);
        tblMenu.setShowVerticalLines(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblMenu.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        Action OrderEvent = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = Integer.valueOf(e.getActionCommand());
                txtProdName.setText(String.valueOf(tblMenu.getModel().getValueAt(rowIndex, 0)));

                double price = Double.parseDouble(String.valueOf(tblMenu.getModel().getValueAt(rowIndex, 1)));
                txtPrice.setText(String.valueOf(df.format(price)));
                txtPrice.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
                txtPrice.setForeground(Color.white);
                txtProdName.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
                txtProdName.setForeground(Color.white);
                txtQty.enable();
                quantity = Integer.parseInt(tblMenu.getModel().getValueAt(rowIndex,2).toString());
                btnConfirm.setEnabled(true);
                btnCancel.setEnabled(true);
                txtQty.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
                txtQty.setForeground(Color.black);
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tblMenu, OrderEvent, 3);

    }
    public static void generateCategory(Data data,String category){
        df = new DecimalFormat("#.##");
        String[] colsMenu = {"Item","Price","Quantity",""};
        tblMenuModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
                return getValueAt(0,column).getClass();
            }
        };
        tblMenu.getTableHeader().setResizingAllowed(false);
        tblMenu.getTableHeader().setReorderingAllowed(false);
        tblMenu.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        List<Product> products = data.getProductList();
        for (Product o: products){
            if(o.getQty()!=0 &&o.getQty()>0){
                if(o.getCategory().equals(category)){
                    Object[] newRow = {o.getName().toUpperCase(),o.getPrice(),o.getQty(),"ORDER"};

                    tblMenuModel.addRow(newRow);
                }
            }

        }
        tblMenu.setModel(tblMenuModel);
        tblMenu.setSelectionBackground(new Color(242,242,242));
        tblMenu.setModel(tblMenuModel);

        tblMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblMenu.setRowHeight(100);
        tblMenu.setGridColor(Color.WHITE);
        tblMenu.setBorder(BorderFactory.createEmptyBorder());
        tblMenu.setRowMargin(10);
        tblMenu.setDefaultEditor(Object.class, null); // editable = false
        tblMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMenu.setFocusable(false);
        tblMenu.setShowHorizontalLines(false);
        tblMenu.setShowVerticalLines(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblMenu.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        Action OrderEvent = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = Integer.valueOf(e.getActionCommand());
                txtProdName.setText(String.valueOf(tblMenu.getModel().getValueAt(rowIndex, 0)));
                double price = Double.parseDouble(String.valueOf(tblMenu.getModel().getValueAt(rowIndex, 1)));
                txtProdName.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
                txtProdName.setForeground(Color.white);
                txtPrice.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
                txtPrice.setForeground(Color.white);
                txtPrice.setText(String.valueOf(df.format(price)));
                txtQty.enable();
                quantity = Integer.parseInt(tblMenu.getModel().getValueAt(rowIndex,2).toString());
                btnConfirm.setEnabled(true);
                btnCancel.setEnabled(true);
                txtQty.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
                txtQty.setForeground(Color.black);
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tblMenu, OrderEvent, 3);

        // Modify Column
        TableColumnModel tableColumnModel = tblMenu.getColumnModel();

    }
    public static void generateCart(Data data){
        String[] colsMenu = {"Item","Price","Quantity","Total"};
        tblCartModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
                return getValueAt(0,column).getClass();
            }
        };

        List<cart> carts = data.getCartList();
        for (cart o: carts){
                Object[] newRow = {o.getName(),o.getPrice(),o.getQty(),o.getTotal()};
                tblCartModel.addRow(newRow);
        }
        tblCart.setModel(tblCartModel);
        tblCart.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblCart.setRowHeight(25);
        tblCart.setGridColor(Color.WHITE);
        tblCart.setBorder(BorderFactory.createEmptyBorder());
        tblCart.setRowMargin(5);
        tblCart.setDefaultEditor(Object.class, null); // editable = false
        tblCart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblCart.setFocusable(false);
        tblCart.setShowHorizontalLines(false);
        tblCart.setShowVerticalLines(false);

    }


    public static void main (String[] args){
        Main orderingFrame = new Main();
        orderingFrame.setVisible(true);
    }
}
