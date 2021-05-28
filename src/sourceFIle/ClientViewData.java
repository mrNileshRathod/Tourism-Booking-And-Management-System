package sourceFIle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

 class ClientViewData extends javax.swing.JFrame {
     
    Connection con = null;
    PreparedStatement pst = null;
    String LoginedUserName;
    
    public ClientViewData() {
        initComponents();
        getLoginID();
        getPersonalInfo();
    }
    
    public ClientViewData(String User) {
        initComponents();
        LoginedUserName = User;
        getLoginID();
        getPersonalInfo();
    }
    
    private void getLoginID(){
        try{
            userid.setText(LoginedUserName);
            String sql = "SELECT TourId,UserId,Password FROM clientlogindata WHERE UserId = ?";
            con = db.Connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, LoginedUserName);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                tid.setText(rs.getString(1));
                userid.setText(rs.getString(2));
                pasword.setText(rs.getString(3));
            }
        }
        catch(ClassNotFoundException | SQLException  ex){
           JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void getPersonalInfo(){
        try{
            String sql = "SELECT FirstName,LastName,PhoneNo,Email,State,City,Gender FROM clientregistrationdata WHERE TourId = ?";
            con = db.Connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, tid.getText());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                FirstName.setText(rs.getString(1));
                LastName.setText(rs.getString(2));
                PhoneNo.setText(rs.getString(3));
                Email.setText(rs.getString(4));
                State.setText(rs.getString(5));
                City.setText(rs.getString(6));
                 if("Male".equals(rs.getString(7)))
                {
                    male.setSelected(true);
                }
                else 
                {
                    female.setSelected(true);
                }
            }
        }
        catch(ClassNotFoundException | SQLException  ex){
           JOptionPane.showMessageDialog(null, ex);
        }
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toppanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cloase = new javax.swing.JLabel();
        PersonalInfoPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        FirstName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PhoneNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        State = new javax.swing.JTextField();
        City = new javax.swing.JTextField();
        Gender = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        UserLoginPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pasword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        userid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client View Date");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1350, 840));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toppanel.setBackground(new java.awt.Color(9, 84, 127));
        toppanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        toppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Client View From");
        toppanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 50));

        cloase.setBackground(java.awt.Color.red);
        cloase.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        cloase.setForeground(java.awt.Color.red);
        cloase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cloase.setText("X");
        cloase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cloase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cloaseMouseClicked(evt);
            }
        });
        toppanel.add(cloase, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, -1, -1));

        getContentPane().add(toppanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 70));

        PersonalInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(9, 84, 127), 3, true), "Personal Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        PersonalInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setText("First name");
        PersonalInfoPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        FirstName.setEditable(false);
        FirstName.setBackground(new java.awt.Color(204, 204, 204));
        FirstName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        FirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PersonalInfoPanel.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 239, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Last name");
        PersonalInfoPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        LastName.setEditable(false);
        LastName.setBackground(new java.awt.Color(204, 204, 204));
        LastName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        LastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PersonalInfoPanel.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 239, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("Email");
        PersonalInfoPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        PhoneNo.setEditable(false);
        PhoneNo.setBackground(new java.awt.Color(204, 204, 204));
        PhoneNo.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        PhoneNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PersonalInfoPanel.add(PhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 239, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setText("Mobile number");
        PersonalInfoPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        Email.setEditable(false);
        Email.setBackground(new java.awt.Color(204, 204, 204));
        Email.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        Email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PersonalInfoPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 239, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("State");
        PersonalInfoPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("City");
        PersonalInfoPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        State.setEditable(false);
        State.setBackground(new java.awt.Color(204, 204, 204));
        State.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        State.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PersonalInfoPanel.add(State, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 239, 43));

        City.setEditable(false);
        City.setBackground(new java.awt.Color(204, 204, 204));
        City.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        City.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PersonalInfoPanel.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 239, 42));

        Gender.setBackground(new java.awt.Color(255, 255, 255));
        Gender.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Gender.setText("Gender");
        PersonalInfoPanel.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, 30));

        male.setBackground(new java.awt.Color(255, 255, 255));
        male.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        male.setText("Male");
        male.setEnabled(false);
        PersonalInfoPanel.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));

        female.setBackground(new java.awt.Color(255, 255, 255));
        female.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        female.setText("Female");
        female.setEnabled(false);
        PersonalInfoPanel.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, -1, -1));

        getContentPane().add(PersonalInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 600, 530));

        UserLoginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(9, 84, 127), 3, true), "Login Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        UserLoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("Tour ID ");
        UserLoginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        tid.setEditable(false);
        tid.setBackground(new java.awt.Color(204, 204, 204));
        tid.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        tid.setForeground(new java.awt.Color(255, 0, 0));
        tid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UserLoginPanel.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 250, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setText("User ID");
        UserLoginPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        pasword.setEditable(false);
        pasword.setBackground(new java.awt.Color(204, 204, 204));
        pasword.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        pasword.setForeground(new java.awt.Color(51, 51, 51));
        pasword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pasword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pasword.setCaretColor(new java.awt.Color(51, 51, 51));
        UserLoginPanel.add(pasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 251, 40));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setText("Password");
        UserLoginPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        userid.setEditable(false);
        userid.setBackground(new java.awt.Color(204, 204, 204));
        userid.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        userid.setForeground(new java.awt.Color(51, 51, 51));
        userid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        userid.setCaretColor(new java.awt.Color(51, 51, 51));
        UserLoginPanel.add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 251, 40));

        getContentPane().add(UserLoginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 520, 300));

        setBounds(500, 150, 1350, 840);
    }// </editor-fold>//GEN-END:initComponents

    private void cloaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cloaseMouseClicked
        this.dispose();
    }//GEN-LAST:event_cloaseMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientViewData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientViewData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientViewData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientViewData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientViewData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField City;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField FirstName;
    private javax.swing.JLabel Gender;
    private javax.swing.JTextField LastName;
    private javax.swing.JPanel PersonalInfoPanel;
    private javax.swing.JTextField PhoneNo;
    private javax.swing.JTextField State;
    private javax.swing.JPanel UserLoginPanel;
    private javax.swing.JLabel cloase;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField pasword;
    private javax.swing.JTextField tid;
    private javax.swing.JPanel toppanel;
    private javax.swing.JTextField userid;
    // End of variables declaration//GEN-END:variables
}