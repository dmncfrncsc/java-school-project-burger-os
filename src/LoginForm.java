import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginForm extends JFrame implements ActionListener {
    JLabel labelUser = new JLabel("USERNAME:");
    JLabel labelPass = new JLabel("PASSWORD:");
    JTextField txtUser = new JTextField();
    JPasswordField txtPass = new JPasswordField();
    JButton btnConfirm = new JButton("LOGIN");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panelfade = new JPanel();

    private ImageIcon image1;
    public void MatteBorder(int top,
                            int left,
                            int bottom,
                            int right,
                            Color matteColor){
    }

    public LoginForm(){
        JLabel lblimg;
        image1=new ImageIcon(".\\src\\resources\\bgq.png");
        lblimg = new JLabel("",image1,JLabel.CENTER);
        panel2.add(lblimg).setBounds(0,30,400,200);
        this.setLayout(null);
        this.setSize(800,550);
        this.setLocationRelativeTo(this);
        this.setUndecorated(true);
        this.add(panelfade).setBounds(0,0,400,550);
        panelfade.setBackground(new Color(0, 0, 0,90));
        add(panel1);
        JLabel bg;
        ImageIcon img = new ImageIcon(".\\src\\resources\\burger.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        panel1.add(bg).setBounds(0,0,400,550);
        panel1.setLayout(new BorderLayout());
        panel1.setLayout(null);
        panel1.setBounds(0,0,400,550);


        add(panel2);
        panel2.setLayout(null);
        panel2.setBounds(400,0,400,550);
        panel2.setBackground(new Color(0));
        panel2.add(labelUser).setBounds(76,226,107,27);
        labelUser.setForeground(Color.white);
        labelUser.setFont(new Font("Segoe UI",Font.PLAIN,18));
        panel2.add(txtUser).setBounds(76,256,248,40);
        txtUser.setBackground(null);
        txtUser.setForeground(Color.white);
        txtUser.setCaretColor(Color.white);
        txtUser.setFont(new Font("Segoe UI",Font.PLAIN,15));
        txtUser.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));

        panel2.add(labelPass).setBounds(76,325,110,27);
        labelPass.setForeground(Color.white);
        labelPass.setFont(new Font("Segoe UI",Font.PLAIN,18));
        panel2.add(txtPass).setBounds(76,355,248,40);
        txtPass.setCaretColor(Color.white);
        txtPass.setBackground(null);
        txtPass.setForeground(Color.white);
        txtPass.setFont(new Font("Segoe UI",Font.PLAIN,15));
        txtPass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));

        panel2.add(btnConfirm).setBounds(214,423,110,39);
        btnConfirm.setFocusPainted(false);
        btnConfirm.setBorder(null);
        btnConfirm.setForeground(Color.black);
        btnConfirm.setBackground(new Color(242, 170, 76));
        btnConfirm.setFont(new Font("Segoe UI",Font.PLAIN,20));

        btnConfirm.addActionListener(this);

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data data = Data.getInstance();
                if(txtUser.getText().isEmpty()||txtPass.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please complete the form to continue","Empty Fields",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for(users o: data.getUserList()){
                    if(o.getUsername().equals(txtUser.getText())){
                        if(o.getStatus().equals("Locked")){
                            JOptionPane.showMessageDialog(null,"Login Attempt Limit Reached\nYour account has been locked, please contact admin.");
                            return;
                        }
                    }
                }
                if(data.isAccountAdminLevel(txtUser.getText(),txtPass.getText())){
                    dispose();
                    admin adminForm = new admin();
                    adminForm.show();
                } else if(data.isAccountEmployeeLevel(txtUser.getText(),txtPass.getText())){
                            dispose();
                            Main main = new Main();
                            main.show();
                }else {
                    if(data.isUsernameAdmin(txtUser.getText())){
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                    }else{
                        data.userAttempt(txtUser.getText());
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                    }
                }

            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }



    public static void main (String[] args){
        LoginForm loginFrame = new LoginForm();
        loginFrame.setVisible(true);
    }

}
