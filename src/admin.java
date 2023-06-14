
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class admin extends JFrame implements ActionListener{
    int userCount = 3;
    int productCount =6;
    JButton btnBurger = new JButton("BURGER");
    JButton btnDrinks = new JButton("DRINKS");
    JButton btnAddons = new JButton("ADDONS");
    JPanel selPanel = new JPanel();
    JPanel updatePanel = new JPanel();
    //Product components
    JLabel lblAdmin = new JLabel("ADMIN");
    JButton btnProd = new JButton("PRODUCT");
    JButton btnEmployee = new JButton("EMPLOYEE");
    JLabel lblProdID = new JLabel("Product ID:");
    JLabel lblProdName = new JLabel("Product Name:");
    JLabel lblCategory = new JLabel("Category:");
    JLabel lblProdPrice = new JLabel("Product Price:");
    JLabel lblProdQty = new JLabel("Product Quantity:");
    JButton btnAddProd = new JButton("ADD");
    JButton btnUpdateProd = new JButton("UPDATE");
    JButton btnDeleteProd = new JButton("DELETE");
    JTextField txtProdId = new JTextField();
    JTextField txtProdName = new JTextField();
    JTextField txtProdPrice = new JTextField();
    JTextField txtProdQty = new JTextField();
    JComboBox cbCategory = new JComboBox();
    JButton btnConfirmUpdate = new JButton("CONFIRM");
    JButton btnConfirmAdd = new JButton("CONFIRM");
    JButton btnCancel = new JButton("CANCEL");

    //employee components
    JLabel lblUserID = new JLabel("User ID:");
    JLabel lblUserFName = new JLabel("Full Name:");
    JLabel lblUserLvl = new JLabel("User Level:");
    JLabel lblStatus = new JLabel("Status");
    JLabel lblUserUname= new JLabel("Username:");
    JLabel lblUserPass = new JLabel("Password:");
    JLabel lblUserConfirm = new JLabel("Confirm Password:");
    JButton btnAddUser = new JButton("ADD");
    JButton btnUpdateUser = new JButton("UPDATE");
    JButton btnDeleteUser = new JButton("DELETE");
    JButton btnConfirmUpdateUser = new JButton("CONFIRM");
    JButton btnConfirmAddUser = new JButton("CONFIRM");
    JButton btnCancelUser = new JButton("CANCEL");
    JComboBox txtStatus = new JComboBox();
    JTextField txtUserID = new JTextField();
    JTextField txtUserFName = new JTextField();
    JComboBox cbUserlevel = new JComboBox();
    JTextField txtUserUName = new JTextField();
    JPasswordField txtUserPass = new JPasswordField();
    JPasswordField txtUserConfirmPass = new JPasswordField();
    JButton btnLogout = new JButton(">LOGOUT");
    JPanel panelHeader = new JPanel();
    JLabel lblBq = new JLabel("BQ");
    JLabel lblBurgerQueen = new JLabel("Burger Queen");
    private static JTable tblProduct;
    JPanel panel = new JPanel();
    private static DefaultTableModel tblMenuModel;
    private static JTable tblUser;
    private static DefaultTableModel tblUserModel;
    private ImageIcon image1;
    int p = 0;
    public admin(){

        JPanel pnlBurger = new JPanel();
        this.setUndecorated(true);
        this.setSize(1100,860);
        this.setResizable(false);
        this.setLocationRelativeTo(this);//setLocationRelativeTo(this);
        this.setLayout(null);

        this.setDefaultCloseOperation(admin.EXIT_ON_CLOSE);
        JPanel pnlFadeBlack = new JPanel();
        this.add(pnlFadeBlack).setBounds(0,62,273,451);
        pnlFadeBlack.setBackground(new Color(0, 0, 0,50));
        this.add(pnlBurger).setBounds(0,62,273,451);

        JLabel lblimg;
        image1=new ImageIcon(".\\src\\resources\\banner.jpg");
        lblimg = new JLabel("",image1,JLabel.CENTER);
        pnlBurger.add(lblimg).setBounds(0,62,273,451);
        this.add(selPanel).setBounds(0,62 ,273,800);
        this.add(panelHeader).setBounds(0,0,1100,62);
        panelHeader.add(btnLogout).setBounds(913,0,187,62);
        btnLogout.setMargin(new Insets(0,0,0,0));
        btnLogout.setBackground(new Color(51, 0, 0));
        btnLogout.setForeground(Color.white);
        btnLogout.setBorder(null);
        btnLogout.setFocusable(false);
        btnLogout.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        panelHeader.setBackground(new Color(0,0,0));


        panelHeader.setLayout(null);
        panelHeader.add(lblAdmin).setBounds(34,9 ,135,53);
        lblAdmin.setFont(new Font("Segoe UI Light",Font.PLAIN,40));
        lblAdmin.setForeground(Color.white);

        selPanel.setLayout(null);
        selPanel.add(btnProd).setBounds(0,592,273,100);
        selPanel.setBackground(new Color(242, 170, 76));
        btnProd.setFont(new Font("Segoe UI Light",Font.PLAIN,40));
        btnProd.setMargin(new Insets(0,0,0,0));
        btnProd.setBackground(Color.black);
        btnProd.setForeground(Color.white);
        btnProd.setFocusable(false);
        btnProd.setBorder(null);
        selPanel.add(btnEmployee).setBounds(0,696,273,100);
        btnEmployee.setMargin(new Insets(0,0,0,0));
        btnEmployee.setBackground(Color.black);
        btnEmployee.setForeground(Color.white);
        btnEmployee.setFocusable(false);
        btnEmployee.setFont(new Font("Segoe UI Light",Font.PLAIN,40));
        btnEmployee.setBorder(null);
        selPanel.add(lblBq).setBounds(61,425,151,139);
        lblBq.setFont(new Font("Comic Sans MS",Font.PLAIN,100));

        selPanel.add(lblBurgerQueen).setBounds(14,538,246,53);
        lblBurgerQueen.setFont(new Font("Segoe UI Light",Font.PLAIN,40));
        this.add(updatePanel).setBounds(273,62,827,800);

        updatePanel.setLayout(null);

        //productLabel
        updatePanel.setBackground(new Color(0, 0, 51));
        updatePanel.add(lblProdID).setBounds(133,525,123,33);
        updatePanel.add(lblProdName).setBounds(133,580,197,33);
        updatePanel.add(lblCategory).setBounds(133,635,126,33);
        updatePanel.add(lblProdPrice).setBounds(133,690,182,33);
        updatePanel.add(lblProdQty).setBounds(133,745,232,33);
        lblProdID.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblProdID.setForeground(Color.white);
        lblProdName.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblProdName.setForeground(Color.white);
        lblCategory.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblCategory.setForeground(Color.white);
        lblProdPrice.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblProdPrice.setForeground(Color.white);
        lblProdQty.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblProdQty.setForeground(Color.white);

        //producttextbox
        updatePanel.add(txtProdId).setBounds(360,525,144,33);
        txtProdId.setFont(new Font("Segoe UI Light",Font.PLAIN,22));
        txtProdId.setForeground(Color.black);
        updatePanel.add(txtProdName).setBounds(360,580,203,33);
        txtProdName .setForeground(Color.black);
        txtProdName.setFont(new Font("Segoe UI Light",Font.PLAIN,22));
        updatePanel.add(cbCategory).setBounds(360,635,203,33);
        cbCategory .setForeground(Color.black);
        cbCategory.setFont(new Font("Segoe UI Light",Font.PLAIN,22));

        cbCategory.addItem("");
        cbCategory.addItem("Burger");
        cbCategory.addItem("Drinks");
        cbCategory.addItem("Addons");
        updatePanel.add(txtProdPrice).setBounds(360,690,203,33);
        txtProdPrice.setForeground(Color.black);
        txtProdPrice.setFont(new Font("Segoe UI Light",Font.PLAIN,22));
        updatePanel.add(txtProdQty).setBounds(360,745,203,33);
        txtProdQty.setForeground(Color.black);
        txtProdQty.setFont(new Font("Segoe UI Light",Font.PLAIN,22));


        //productButton
        updatePanel.add(btnAddProd).setBounds(645,467,146,68);
        btnAddProd.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnAddProd.setMargin(new Insets(0,0,0,0));
        btnAddProd.setBackground(new Color(0, 51, 0));
        btnAddProd.setForeground(Color.white);
        btnAddProd.setBorder(null);
        btnAddProd.setFocusable(false);

        updatePanel.add(btnDeleteProd).setBounds(645,548,146,68);
        btnDeleteProd.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnDeleteProd.setMargin(new Insets(0,0,0,0));
        btnDeleteProd.setBackground(new Color(51, 0, 0));
        btnDeleteProd.setForeground(Color.white);
        btnDeleteProd.setBorder(null);
        btnDeleteProd.setFocusable(false);

        updatePanel.add(btnUpdateProd).setBounds(645,629,146,68);
        btnUpdateProd.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnUpdateProd.setMargin(new Insets(0,0,0,0));
        btnUpdateProd.setBackground(new Color(242, 170, 76));
        btnUpdateProd.setForeground(Color.black);
        btnUpdateProd.setBorder(null);
        btnUpdateProd.setFocusable(false);

        updatePanel.add(btnConfirmAdd).setBounds(645,603,146,68);
        btnConfirmAdd.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnConfirmAdd.setMargin(new Insets(0,0,0,0));
        btnConfirmAdd.setBackground(new Color(0, 51, 0));
        btnConfirmAdd.setForeground(Color.white);
        btnConfirmAdd.setBorder(null);
        btnConfirmAdd.setFocusable(false);

        updatePanel.add(btnConfirmUpdate).setBounds(645,603,146,68);
        btnConfirmUpdate.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnConfirmUpdate.setMargin(new Insets(0,0,0,0));
        btnConfirmUpdate.setBackground(new Color(0, 51, 0));
        btnConfirmUpdate.setForeground(Color.white);
        btnConfirmUpdate.setBorder(null);
        btnConfirmUpdate.setFocusable(false);

        updatePanel.add(btnCancel).setBounds(645,679,146,68);
        btnCancel.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnCancel.setMargin(new Insets(0,0,0,0));
        btnCancel.setBackground(new Color(51, 0, 0));
        btnCancel.setForeground(Color.white);
        btnCancel.setBorder(null);
        btnCancel.setFocusable(false);

        updatePanel.add(btnBurger).setBounds(186,452,133,49);
        btnBurger.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        btnBurger.setMargin(new Insets(0,0,0,0));
        btnBurger.setBackground(new Color(51, 0, 0));
        btnBurger.setForeground(Color.white);
        btnBurger.setBorder(null);
        btnBurger.setFocusable(false);

        updatePanel.add(btnAddons).setBounds(319,452,133,49);
        btnAddons.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        btnAddons.setMargin(new Insets(0,0,0,0));
        btnAddons.setBackground(new Color(51, 0, 0));
        btnAddons.setForeground(Color.white);
        btnAddons.setBorder(null);
        btnAddons.setFocusable(false);

        updatePanel.add(btnDrinks).setBounds(452,452,133,49);
        btnDrinks.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        btnDrinks.setMargin(new Insets(0,0,0,0));
        btnDrinks.setBackground(new Color(51, 0, 0));
        btnDrinks.setForeground(Color.white);
        btnDrinks.setBorder(null);
        btnDrinks.setFocusable(false);

        //USERLABEL
        updatePanel.add(lblUserID).setBounds(138,474,144,33);
        lblUserID.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblUserID.setForeground(Color.white);
        updatePanel.add(lblUserFName).setBounds(138,515,117,33);
        lblUserFName.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblUserFName.setForeground(Color.white);
        updatePanel.add(lblUserLvl).setBounds(138,556,556,33);
        lblUserLvl.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblUserLvl.setForeground(Color.white);

        updatePanel.add(lblStatus).setBounds(138,597,72,33);
        lblStatus.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblStatus.setForeground(Color.white);

        updatePanel.add(lblUserUname).setBounds(138,638,116,33);
        lblUserUname.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblUserUname.setForeground(Color.white);
        updatePanel.add(lblUserPass).setBounds(138,679,109,25);
        lblUserPass.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblUserPass.setForeground(Color.white);
        updatePanel.add(lblUserConfirm).setBounds(138,720,204,33);
        lblUserConfirm.setFont(new Font("Segoe UI Light",Font.PLAIN,25));
        lblUserConfirm.setForeground(Color.white);
        lblUserID.hide();
        lblUserFName.hide();
        lblStatus.hide();
        lblUserLvl.hide();
        lblUserUname.hide();
        lblUserPass.hide();
        lblUserConfirm.hide();

        //USERTXTBOX
        updatePanel.add(txtUserID).setBounds(380,474,203,33);
        txtUserID .setForeground(Color.black);
        txtUserID.setFont(new Font("Segoe UI Light",Font.PLAIN,22));
        updatePanel.add(txtUserFName).setBounds(380,515,203,33);
        txtUserFName .setForeground(Color.black);
        txtUserFName.setFont(new Font("Segoe UI Light",Font.PLAIN,22));
        updatePanel.add(cbUserlevel).setBounds(380,556,203,33);
        cbUserlevel .setForeground(Color.black);
        cbUserlevel.setFont(new Font("Segoe UI Light",Font.PLAIN,22));

        updatePanel.add(txtStatus).setBounds(380,597,203,33);
        txtStatus .setForeground(Color.black);
        txtStatus.setFont(new Font("Segoe UI Light",Font.PLAIN,22));

        updatePanel.add(txtUserUName).setBounds(380,638,203,33);
        txtUserUName .setForeground(Color.black);
        txtUserUName.setFont(new Font("Segoe UI Light",Font.PLAIN,22));
        updatePanel.add(txtUserPass).setBounds(380,679,203,33);
        txtUserPass .setForeground(Color.black);
        txtUserPass.setFont(new Font("Segoe UI Light",Font.PLAIN,22));
        updatePanel.add(txtUserConfirmPass).setBounds(380,720,203,33);
        txtUserConfirmPass .setForeground(Color.black);
        txtUserConfirmPass.setFont(new Font("Segoe UI Light",Font.PLAIN,22));
        cbUserlevel.addItem("");
        cbUserlevel.addItem("Admin");
        cbUserlevel.addItem("Employee");
        txtStatus.addItem("");
        txtStatus.addItem("Locked");
        txtStatus.addItem("Active");
        txtUserID.hide();
        txtUserFName.hide();
        cbUserlevel.hide();
        txtUserUName.hide();
        txtUserPass.hide();
        txtUserConfirmPass.hide();
        txtStatus.hide();
        //USERBUTTON
        updatePanel.add(btnAddUser).setBounds(645,467,146,68);;
        btnAddUser.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnAddUser.setMargin(new Insets(0,0,0,0));
        btnAddUser.setBackground(new Color(0, 51, 0));
        btnAddUser.setForeground(Color.white);
        btnAddUser.setBorder(null);
        btnAddUser.setFocusable(false);

        updatePanel.add(btnDeleteUser).setBounds(645,548,146,68);
        btnDeleteUser.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnDeleteUser.setMargin(new Insets(0,0,0,0));
        btnDeleteUser.setBackground(new Color(51, 0, 0));
        btnDeleteUser.setForeground(Color.white);
        btnDeleteUser.setBorder(null);
        btnDeleteUser.setFocusable(false);

        updatePanel.add(btnUpdateUser).setBounds(645,629,146,68);
        btnUpdateUser.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnUpdateUser.setMargin(new Insets(0,0,0,0));
        btnUpdateUser.setBackground(new Color(242, 170, 76));
        btnUpdateUser.setForeground(Color.black);
        btnUpdateUser.setBorder(null);
        btnUpdateUser.setFocusable(false);

        updatePanel.add(btnConfirmAddUser).setBounds(645,603,146,68);
        btnConfirmAddUser.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnConfirmAddUser.setMargin(new Insets(0,0,0,0));
        btnConfirmAddUser.setBackground(new Color(0, 51, 0));;
        btnConfirmAddUser.setForeground(Color.white);
        btnConfirmAddUser.setBorder(null);
        btnConfirmAddUser.setFocusable(false);

        updatePanel.add(btnConfirmUpdateUser).setBounds(645,603,146,68);
        btnConfirmUpdateUser.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnConfirmUpdateUser.setMargin(new Insets(0,0,0,0));
        btnConfirmUpdateUser.setBackground(new Color(0, 51, 0));
        btnConfirmUpdateUser.setForeground(Color.white);
        btnConfirmUpdateUser.setBorder(null);
        btnConfirmUpdateUser.setFocusable(false);

        updatePanel.add(btnCancelUser).setBounds(645,679,146,68);
        btnCancelUser.setFont(new Font("Segoe UI Light",Font.PLAIN,30));
        btnCancelUser.setMargin(new Insets(0,0,0,0));
        btnCancelUser.setBackground(new Color(51, 0, 0));
        btnCancelUser.setForeground(Color.white);
        btnCancelUser.setBorder(null);
        btnCancelUser.setFocusable(false);

        btnCancelUser.hide();
        btnAddUser.hide();
        btnDeleteUser.hide();
        btnUpdateUser.hide();
        btnConfirmAddUser.hide();
        btnConfirmUpdateUser.hide();


        btnCancel.hide();
        btnConfirmAdd.hide();
        btnConfirmUpdate.hide();
        txtUserID.disable();
        txtUserFName.disable();
        cbUserlevel.disable();
        txtUserUName.disable();
        txtUserPass.disable();
        txtUserConfirmPass.disable();
        txtStatus.disable();
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm login = new LoginForm();
                login.show();
            }
        });
/*        lblProdID.hide();
        lblProdName.hide();
        lblProdPrice.hide();
        lblProdQty.hide();
        lblCategory.hide();
        txtProdId.hide();
        txtProdName.hide();
        txtProdPrice.hide();
        txtProdQty.hide();
        txtCat.hide();
        btnAddProd.hide();
        btnDeleteProd.hide();
        btnUpdateProd.hide();*/
        txtProdId.disable();
        cbCategory.disable();
        txtProdName.disable();
        txtProdPrice.disable();
        txtProdQty.disable();
        btnEmployee.setFocusable(false);
        btnUpdateProd.setFocusable(false);
        btnDeleteProd.setFocusable(false);
        btnAddProd.setFocusable(false);
        btnProd.setFocusable(false);
        btnEmployee.setFocusable(false);
        btnProd.addActionListener(this);
        tblProduct = new JTable();
        tblUser = new JTable();
        Data data = Data.getInstance();
        generateMenu(data);
        JScrollPane paneProd = new JScrollPane(tblProduct);
        JScrollPane paneUsers = new JScrollPane(tblUser);
        updatePanel.add(paneUsers).setBounds(0,0,827,452);
        paneUsers.hide();
        updatePanel.add(paneProd).setBounds(0,0,827,452);

        btnBurger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCategory("Burger");
            }
        });

        btnAddons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCategory("Addons");
            }
        });

        btnDrinks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCategory("Drinks");
            }
        });

        tblProduct.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndexRow = tblProduct.getSelectedRow();
                txtProdId.setText(tblMenuModel.getValueAt(selectedIndexRow,0).toString());
                txtProdName.setText(tblMenuModel.getValueAt(selectedIndexRow,1).toString());
                cbCategory.setSelectedItem(tblMenuModel.getValueAt(selectedIndexRow,2).toString());
                txtProdPrice.setText(tblMenuModel.getValueAt(selectedIndexRow,3).toString());
                txtProdQty.setText(tblMenuModel.getValueAt(selectedIndexRow,4).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndexRow = tblProduct.getSelectedRow();
                txtProdId.setText(tblMenuModel.getValueAt(selectedIndexRow,0).toString());
                txtProdName.setText(tblMenuModel.getValueAt(selectedIndexRow,1).toString());
                cbCategory.setSelectedItem(tblMenuModel.getValueAt(selectedIndexRow,2).toString());
                txtProdPrice.setText(tblMenuModel.getValueAt(selectedIndexRow,3).toString());
                txtProdQty.setText(tblMenuModel.getValueAt(selectedIndexRow,4).toString());
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
        tblUser.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedIndexRow = tblUser.getSelectedRow();
                txtUserID.setText(tblUserModel.getValueAt(selectedIndexRow,0).toString());
                txtUserFName.setText(tblUserModel.getValueAt(selectedIndexRow,1).toString());
                cbUserlevel.setSelectedItem(tblUserModel.getValueAt(selectedIndexRow,2).toString());
                txtStatus.setSelectedItem(tblUserModel.getValueAt(selectedIndexRow,3).toString());
                txtUserUName.setText(tblUserModel.getValueAt(selectedIndexRow,4).toString());
                txtUserPass.setText(tblUserModel.getValueAt(selectedIndexRow,5).toString());

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndexRow = tblUser.getSelectedRow();
                txtUserID.setText(tblUserModel.getValueAt(selectedIndexRow,0).toString());
                txtUserFName.setText(tblUserModel.getValueAt(selectedIndexRow,1).toString());
                cbUserlevel.setSelectedItem(tblUserModel.getValueAt(selectedIndexRow,2).toString());
                txtStatus.setSelectedItem(tblUserModel.getValueAt(selectedIndexRow,3).toString());
                txtUserUName.setText(tblUserModel.getValueAt(selectedIndexRow,4).toString());
                txtUserPass.setText(tblUserModel.getValueAt(selectedIndexRow,5).toString());
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

        btnProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBurger.show();
                btnAddons.show();
                btnDrinks.show();
                btnConfirmUpdateUser.hide();
                btnConfirmAddUser.hide();
                btnCancelUser.hide();
                paneProd.show();
                paneUsers.hide();
                btnAddUser.hide();
                btnDeleteUser.hide();
                btnUpdateUser.hide();
                txtUserID.hide();
                txtUserFName.hide();
                cbUserlevel.hide();
                txtUserUName.hide();
                txtUserPass.hide();
                txtUserConfirmPass.hide();
                txtStatus.hide();
                lblStatus.hide();
                lblUserID.hide();
                lblUserFName.hide();
                lblUserLvl.hide();
                lblUserUname.hide();
                lblUserPass.hide();
                lblUserConfirm.hide();
                //showrelatingtoproducts
                tblProduct.show();
                generateMenu(data);
                lblProdID.show();
                lblProdName.show();
                lblCategory.show();
                lblProdPrice.show();
                lblProdQty.show();
                txtProdId.show();
                cbCategory.show();
                txtProdName.show();
                txtProdPrice.show();
                txtProdQty.show();
                btnAddProd.show();
                btnDeleteProd.show();
                btnUpdateProd.show();
                txtProdId.disable();
                cbCategory.disable();
                txtProdName.disable();
                txtProdPrice.disable();
                txtProdQty.disable();
                btnProd.setEnabled(false);
                btnEmployee.setEnabled(true);
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtProdId.setText("");
                cbCategory.setSelectedItem("");
                txtProdName.setText("");
                txtProdPrice.setText("");
                txtProdQty.setText("");
                txtProdId.disable();
                cbCategory.disable();
                txtProdName.disable();
                txtProdPrice.disable();
                txtProdQty.disable();
                btnCancel.hide();
                btnCancelUser.hide();
                btnConfirmUpdateUser.hide();
                btnConfirmUpdate.hide();
                btnConfirmAdd.hide();
                btnAddProd.show();
                btnDeleteProd.show();
                btnUpdateProd.show();

            }
        });
        btnCancelUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUserID.setText("");
                cbUserlevel.setSelectedItem("");
                txtUserFName.setText("");
                txtUserUName.setText("");
                txtUserPass.setText("");
                txtStatus.setSelectedItem("");
                txtUserID.disable();
                cbUserlevel.disable();
                txtUserFName.disable();
                txtUserUName.disable();
                txtUserPass.disable();
                btnCancelUser.hide();
                btnConfirmAddUser.hide();
                btnConfirmUpdateUser.hide();
                btnAddUser.show();
                btnDeleteUser.show();
                btnUpdateUser.show();
            }
        });
        //addProduct
        btnAddProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
/*                Data data1 = Data.getInstance();
                data1.addProduct(new Product(("P00"+txtProdId.getText()),txtProdName.getText(),txtCat.getText(),Double.parseDouble(txtProdPrice.getText()),Double.parseDouble(txtProdQty.getText())));
                generateMenu(data1);*/
                txtProdId.setText("PRD"+(productCount+1));
                cbCategory.setSelectedItem("");
                txtProdName.setText("");
                txtProdPrice.setText("");
                txtProdQty.setText("");
                txtProdId.disable();
                cbCategory.enable();
                txtProdName.enable();
                txtProdPrice.enable();
                txtProdQty.enable();
                btnAddProd.hide();
                btnDeleteProd.hide();
                btnUpdateProd.hide();
                btnCancel.show();
                btnConfirmAdd.show();
            }
        });

        btnConfirmAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sel = JOptionPane.showConfirmDialog(null,"Confirm Add Product?","Add Product", JOptionPane.YES_NO_OPTION);
                if(sel == 0){
                    Data data1 = Data.getInstance();
                    for(int x=0;x<data1.getProductList().size();x++){
                       String prodname= data1.getProductList().get(x).getName();
                        if(txtProdName.getText().equalsIgnoreCase(prodname)){
                            JOptionPane.showMessageDialog(null,"Item"+txtProdName.getText()+" is already added","Add Product",JOptionPane.WARNING_MESSAGE);
                            break;
                        }else if(txtProdName.getText().isEmpty()||cbCategory.getSelectedItem().equals("")||txtProdPrice.getText().isEmpty()||txtProdQty.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null,"Empty text box detected.\n Please fill up the form","Add Product",JOptionPane.WARNING_MESSAGE);
                            break;
                        }else if(Integer.parseInt(txtProdQty.getText())<0 ){
                            JOptionPane.showMessageDialog(null,"Cannont input negative value","Negative Value",JOptionPane.ERROR_MESSAGE);
                            break;
                        }else{
                            data1.addProduct(new Product(txtProdId.getText(),txtProdName.getText(),cbCategory.getSelectedItem().toString(),Double.parseDouble(txtProdPrice.getText()),Integer.parseInt(txtProdQty.getText())));
                            productCount= productCount+1;
                            generateMenu(data1);
                            txtProdId.setText("");
                            cbCategory.setSelectedItem("");
                            txtProdName.setText("");
                            txtProdPrice.setText("");
                            txtProdQty.setText("");

                            txtProdId.disable();
                            cbCategory.disable();
                            txtProdName.disable();
                            txtProdPrice.disable();
                            txtProdQty.disable();
                            btnCancel.hide();
                            btnConfirmAdd.hide();
                            btnConfirmUpdate.hide();
                            btnAddProd.show();
                            btnDeleteProd.show();
                            btnUpdateProd.show();
                            break;
                        }

                    }

                }else{
                    return;
                }
            }
        });

        //deleting Product
        btnDeleteProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(txtProdId.getText().isEmpty()){
                   JOptionPane.showMessageDialog(null,"Please select a product to delete.","Delete Product",JOptionPane.WARNING_MESSAGE);
               }else{
                   int sel = JOptionPane.showConfirmDialog(null,"Confirm Delete Product?","Delete Product", JOptionPane.YES_NO_OPTION);
                   if(sel == 0){
                       Data data = Data.getInstance();
                       data.deleteProduct(txtProdId.getText());
                       generateMenu(data);
                       data.getProductList().forEach(product1 -> {
                           System.out.println(product1.getId());
                           System.out.println(product1.getName());
                           System.out.println(product1.getPrice());
                           System.out.println(product1.getQty());
                       });
                       txtProdId.setText("");
                       cbCategory.setSelectedItem("");
                       txtProdName.setText("");
                       txtProdPrice.setText("");
                       txtProdQty.setText("");
                       txtProdId.disable();
                       cbCategory.disable();
                       txtProdName.disable();
                       txtProdPrice.disable();
                       txtProdQty.disable();
                       btnCancel.hide();
                       btnConfirmAdd.hide();
                       btnConfirmUpdate.hide();
                       btnAddProd.show();
                       btnDeleteProd.show();
                       btnUpdateProd.show();
                   }else{
                       return;
                   }
               }

            }
        });

        //UPDATE PRODUCT
        btnUpdateProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtProdQty.getText().isEmpty() || txtProdName.getText().isEmpty() || txtProdPrice.getText().isEmpty() || cbCategory.getSelectedItem().toString().equals("")) {

                    JOptionPane.showMessageDialog(null,"Empty Form Detected. \nPlease select a product to continue","Update User",JOptionPane.WARNING_MESSAGE);
                    return;
                }else{
                    cbCategory.enable();
                    txtProdName.enable();
                    txtProdPrice.enable();
                    txtProdQty.enable();
                    btnAddProd.hide();
           /*     Data data = Data.getInstance();
                data.editProduct(txtProdId.getText(),txtProdName.getText(), Double.parseDouble(txtProdPrice.getText()),Double.parseDouble(txtProdQty.getText()));
                generateMenu(data);*/
                    btnDeleteProd.hide();
                    btnUpdateProd.hide();
                    btnCancel.show();
                    btnConfirmUpdate.show();
                }

            }
        });
        btnConfirmUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sel = JOptionPane.showConfirmDialog(null,"Confirm Update Product?","Update Product", JOptionPane.YES_NO_OPTION);
                if(sel == 0){
                    Data data = Data.getInstance();
                    if(txtProdQty.getText().isEmpty() || txtProdName.getText().isEmpty() || txtProdPrice.getText().isEmpty() || cbCategory.getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null,"Empty Form Detected. \n Please complete the form to continue","Update User",JOptionPane.WARNING_MESSAGE);
                        return;
                    }else if(Integer.parseInt(txtProdQty.getText())<0 ) {
                        JOptionPane.showMessageDialog(null, "Cannont input negative value", "Negative Value", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else{
                        String prodId = txtProdId.getText();
                        String prodName = txtProdName.getText();
                        String category = cbCategory.getSelectedItem().toString();
                        double price = Double.parseDouble(txtProdPrice.getText());
                        int qty = Integer.parseInt(txtProdQty.getText());
                        data.editProduct(prodId,prodName, category,price,qty);
                        generateMenu(data);
                        txtProdId.setText("");
                        cbCategory.setSelectedItem("");
                        txtProdName.setText("");
                        txtProdPrice.setText("");
                        txtProdQty.setText("");
                        txtProdId.disable();
                        cbCategory.disable();
                        txtProdName.disable();
                        txtProdPrice.disable();
                        txtProdQty.disable();
                        btnCancel.hide();
                        btnConfirmAdd.hide();
                        btnConfirmUpdate.hide();
                        btnAddProd.show();
                        btnDeleteProd.show();
                        btnUpdateProd.show();
                    }
                }else{
                    return;
                }
            }
        });
        //END PRODUCT

        //START USER
        btnEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnProd.setEnabled(true);
                btnEmployee.setEnabled(false);
                btnDrinks.hide();
                btnAddons.hide();
                btnBurger.hide();
                btnCancel.hide();
                btnConfirmAdd.hide();
                btnConfirmUpdate.hide();
                paneUsers.show();
                paneProd.hide();
                generateEmployee(data);
                //productHide
                lblProdID.hide();
                lblProdName.hide();
                lblProdPrice.hide();
                lblProdQty.hide();
                lblCategory.hide();
                txtProdId.hide();
                txtProdName.hide();
                txtProdPrice.hide();
                txtProdQty.hide();
                cbCategory.hide();
                btnAddProd.hide();
                btnDeleteProd.hide();
                btnUpdateProd.hide();

                //employeeShow
                btnAddUser.show();
                btnDeleteUser.show();
                btnUpdateUser.show();
                txtUserID.show();
                txtUserFName.show();
                cbUserlevel.show();
                txtUserUName.show();
                txtUserPass.show();
                txtUserConfirmPass.show();
                txtStatus.show();
                lblStatus.show();
                lblUserID.show();
                lblUserFName.show();
                lblUserLvl.show();
                lblUserUname.show();
                lblUserPass.show();
                lblUserConfirm.show();

            }
        });

        //addUser
        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUserID.setText("USR"+(userCount+1));
                txtUserFName.setText("");
                cbUserlevel.setSelectedItem("");
                txtUserUName.setText("");
                txtUserPass.setText("");
                txtUserConfirmPass.setText("");
                txtStatus.setSelectedItem("");
                txtStatus.enable();
                txtUserID.disable();
                txtUserFName.enable();
                cbUserlevel.enable();
                txtUserUName.enable();
                txtUserPass.enable();
                txtUserConfirmPass.enable();

                btnAddUser.hide();
                btnDeleteUser.hide();
                btnUpdateUser.hide();
                btnCancelUser.show();
                btnConfirmAddUser.show();
            }
        });

        btnConfirmAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sel = JOptionPane.showConfirmDialog(null,"Confirm Add User?","Add Employee", JOptionPane.YES_NO_OPTION);
                if(sel == 0) {
                    if(txtUserFName.getText().isEmpty()||txtUserUName.getText().isEmpty()||cbUserlevel.getSelectedItem().equals("")||txtUserPass.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Empty text box detected.\n Please fill up the form","Add Product",JOptionPane.WARNING_MESSAGE);
                    }else{
                        for(int x=0;x<data.getUserList().size();x++){
                            if(txtUserUName.getText().equals(data.getUserList().get(x).getUsername())){
                                JOptionPane.showMessageDialog(null,"Username has already been taken","Add Employee",JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                            else if(txtUserPass.getText().equals(txtUserConfirmPass.getText())){
                                data.addUser(new users((txtUserID.getText()),txtUserFName.getText(),cbUserlevel.getSelectedItem().toString(),txtUserUName.getText(),txtUserPass.getText(),txtStatus.getSelectedItem().toString()));
                                userCount = userCount+1;
                                generateEmployee(data);
                                txtUserID.setText("");
                                txtUserFName.setText("");
                                cbUserlevel.setSelectedItem("");
                                txtUserUName.setText("");
                                txtUserPass.setText("");
                                txtStatus.setSelectedItem("");
                                txtUserConfirmPass.setText("");
                                txtUserID.disable();
                                txtUserFName.disable();
                                cbUserlevel.disable();
                                txtUserUName.disable();
                                txtUserPass.disable();
                                txtUserConfirmPass.disable();
                                txtStatus.disable();
                                btnCancelUser.hide();
                                btnConfirmAddUser.hide();
                                btnConfirmUpdateUser.hide();
                                btnAddUser.show();
                                btnDeleteUser.show();
                                btnUpdateUser.show();
                                break;
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Password not match","Password Mismatch",JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        /*else{
                            if(txtUserPass.getText().equals(txtUserConfirmPass.getText())){
                                if(txtUserFName.getText().isEmpty()&&txtUserUName.getText().isEmpty()&&cbUserlevel.getSelectedItem().equals("")&&txtUserPass.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null,"Empty text box detected.\n Please fill up the form","Add Product",JOptionPane.WARNING_MESSAGE);
                                    break;
                                }else{
                                    data.addUser(new users((txtUserID.getText()),txtUserFName.getText(),cbUserlevel.getSelectedItem().toString(),txtUserUName.getText(),txtUserPass.getText()));
                                    generateEmployee(data);
                                    txtUserID.setText("");
                                    txtUserFName.setText("");
                                    cbUserlevel.setSelectedItem("");
                                    txtUserUName.setText("");
                                    txtUserPass.setText("");
                                    txtUserConfirmPass.setText("");
                                    txtUserID.disable();
                                    txtUserFName.disable();
                                    cbUserlevel.disable();
                                    txtUserUName.disable();
                                    txtUserPass.disable();
                                    txtUserConfirmPass.disable();

                                    btnCancelUser.hide();
                                    btnConfirmAddUser.hide();
                                    btnConfirmUpdateUser.hide();
                                    btnAddUser.show();
                                    btnDeleteUser.show();
                                    btnUpdateUser.show();
                                }

                            }else{
                                JOptionPane.showMessageDialog(null,"Password not match","Password Mismatch",JOptionPane.WARNING_MESSAGE);
                                break;
                            }

                        }*/

                        }
                    }


                }
            }
        });

        //deleteUser
        btnDeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtUserFName.getText().isEmpty() && cbUserlevel.getSelectedItem().equals("")&&txtUserUName.getText().isEmpty()&&txtUserPass.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Select Account To Delete","Delete Account",JOptionPane.WARNING_MESSAGE);
                    return;
                }else{
                    int sel = JOptionPane.showConfirmDialog(null,"Confirm Delete User?","Delete User", JOptionPane.YES_NO_OPTION);
                    if(sel == 0) {
                        Data data = Data.getInstance();
                        data.deleteUser(txtUserID.getText());

                        data.getUserList().forEach(users -> {
                            System.out.println(users.getId());
                            System.out.println(users.getName());
                            System.out.println(users.getLevel());
                            System.out.println(users.getUsername());
                            System.out.println(users.getPassword());
                        });
                        generateEmployee(data);
                    }
                }

            }
        });

        //updateUser
        btnUpdateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtUserID.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Select Account To Update","Update Account",JOptionPane.WARNING_MESSAGE);
                    return;
                }else{
                    txtUserFName.enable();
                    txtUserPass.enable();
                    txtUserUName.enable();
                    txtUserConfirmPass.enable();
                    txtStatus.enable();
                    cbUserlevel.enable();
                    btnCancelUser.show();
                    btnConfirmAddUser.hide();
                    btnConfirmUpdateUser.show();
                    btnAddUser.hide();
                    btnDeleteUser.hide();
                    btnUpdateUser.hide();
                }
            }
        });
        btnConfirmUpdateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data data2 = Data.getInstance();
                int sel = JOptionPane.showConfirmDialog(null,"Confirm Update User?","Update User", JOptionPane.YES_NO_OPTION);
                if(sel == 0){
                    if(txtUserFName.getText().isEmpty()||txtUserUName.getText().isEmpty()||txtUserPass.getText().isEmpty()||cbUserlevel.getSelectedItem().toString().equals("")){
                        JOptionPane.showMessageDialog(null,"Empty text box detected.\n Please fill up the form","Add Product",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        for(int x=0;x<data2.getUserList().size();x++){
                            if(txtUserUName.getText().equals(data2.getUserList().get(x).getUsername())){
                                JOptionPane.showMessageDialog(null,"Existing username","Update Employee",JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                            else if(txtUserPass.getText().equals(txtUserConfirmPass.getText())){
                                data2.ediUser(txtUserID.getText(),txtUserFName.getText(),cbUserlevel.getSelectedItem().toString(),txtUserUName.getText(),txtUserPass.getText(),txtStatus.getSelectedItem().toString());
                                generateEmployee(data2);
                                txtUserFName.setText("");
                                cbUserlevel.setSelectedItem("");
                                txtUserID.setText("");
                                txtUserUName.setText("");
                                txtUserPass.setText("");
                                txtStatus.setSelectedItem("");
                                txtStatus.disable();
                                txtUserConfirmPass.setText("");
                                txtUserFName.disable();
                                cbUserlevel.disable();
                                txtUserID.disable();
                                txtUserUName.disable();
                                txtUserPass.disable();
                                txtUserConfirmPass.disable();
                                btnCancelUser.hide();
                                btnConfirmAddUser.hide();
                                btnConfirmUpdateUser.hide();
                                btnAddUser.show();
                                btnDeleteUser.show();
                                btnUpdateUser.show();
                                break;
                            }else{
                                JOptionPane.showMessageDialog(null,"Password do not match.","Password Erorr",JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                    }
                }else{
                    return;
                }
            }
        });
    }

    public static void generateEmployee(Data data){

        String[] colsMenu = {"Employee ID","Employee Name","Level","Status","Username","Password"};
        tblUserModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
                return getValueAt(0,column).getClass();
            }
        };
        tblUser.getTableHeader().setResizingAllowed(false);
        tblUser.getTableHeader().setReorderingAllowed(false);
        tblUser.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        List<users> user = data.getUserList();
        for (users o: user){
            Object[] newRow = {o.getId(),o.getName(),o.getLevel(),o.getStatus(),o.getUsername(),o.getPassword()};
            tblUserModel.addRow(newRow);
        }
        tblUser.setModel(tblUserModel);
        tblUser.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblUser.setRowHeight(100);
        tblUser.setGridColor(Color.WHITE);
        tblUser.setBorder(BorderFactory.createEmptyBorder());
        tblUser.setRowMargin(10);
        tblUser.setDefaultEditor(Object.class, null); // editable = false
        tblUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblUser.getTableHeader().setResizingAllowed(false);
        tblUser.getTableHeader().setReorderingAllowed(false);
        tblUser.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblUser.getTableHeader().setBackground(Color.white);



    }


    public static void generateMenu(Data data){
        String[] colsMenu = {"Product ID","Product Name","Category","Product Price","Product Quantity"};
        tblMenuModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
                return getValueAt(0,column).getClass();
            }
        };

        List<Product> products = data.getProductList();
        for (Product o: products){
                    Object[] newRow = {o.getId(), o.getName(),o.getCategory(),o.getPrice(),o.getQty()};
                    tblMenuModel.addRow(newRow);
        }
        tblProduct.setModel(tblMenuModel);
        tblProduct.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblProduct.setRowHeight(100);
        tblProduct.setGridColor(Color.WHITE);
        tblProduct.setBorder(BorderFactory.createEmptyBorder());
        tblProduct.setRowMargin(10);
        tblProduct.setDefaultEditor(Object.class, null); // editable = false
        tblProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblProduct.setFocusable(false);
        tblProduct.setShowHorizontalLines(false);
        tblProduct.setShowVerticalLines(false);
        tblProduct.getTableHeader().setResizingAllowed(false);
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblProduct.getTableHeader().setBackground(Color.white);
    }

    public static void generateCategory(String category){
        String[] colsMenu = {"Product ID","Product Name","Category","Product Price","Product Quantity"};
        tblMenuModel = new DefaultTableModel(colsMenu, 0){
            public Class getColumnClass(int column){
                return getValueAt(0,column).getClass();
            }
        };
        Data data = Data.getInstance();
        tblProduct.getTableHeader().setResizingAllowed(false);
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        List<Product> products = data.getProductList();
        for (Product o: products){
                if(o.getCategory().equals(category)){
                    Object[] newRow = {o.getId(), o.getName(),o.getCategory(),o.getPrice(),o.getQty()};
                    tblMenuModel.addRow(newRow);
                }

        }
        tblProduct.setModel(tblMenuModel);
        tblProduct.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblProduct.setRowHeight(100);
        tblProduct.setGridColor(Color.WHITE);
        tblProduct.setBorder(BorderFactory.createEmptyBorder());
        tblProduct.setRowMargin(10);
        tblProduct.setDefaultEditor(Object.class, null); // editable = false
        tblProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblProduct.setFocusable(false);
        tblProduct.setShowHorizontalLines(false);
        tblProduct.setShowVerticalLines(false);
        tblProduct.getTableHeader().setResizingAllowed(false);
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblProduct.getTableHeader().setBackground(Color.white);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String [] args){
        admin admin = new admin();
        admin.setVisible(true);
    }

}
