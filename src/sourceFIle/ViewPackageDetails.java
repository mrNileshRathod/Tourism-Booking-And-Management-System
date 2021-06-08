package sourceFIle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ViewPackageDetails extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    String LoginedUserName;
    
    public ViewPackageDetails() {
        initComponents();
        getLoginID();
        getPersonalInfo();
        getPackageInfo();
    }
    public ViewPackageDetails(String user) {
        initComponents();
        LoginedUserName=user;
        getLoginID();
        getPersonalInfo();
        getPackageInfo();
    }
    private void getLoginID(){
        try{
            userid.setText(LoginedUserName);
            String sql = "SELECT TourId,UserId FROM clientlogindata WHERE UserId = ?";
            con = db.Connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, LoginedUserName);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                tid.setText(rs.getString(1));
                userid.setText(rs.getString(2));
            }
        }
        catch(ClassNotFoundException | SQLException  ex){
           JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void getPersonalInfo(){
        try{
            String sql = "SELECT PhoneNo FROM clientregistrationdata WHERE TourId = ?";
            con = db.Connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, tid.getText());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                SelectPackage.setText(rs.getString(1));
            }
        }
        catch(ClassNotFoundException | SQLException  ex){
           JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void getPackageInfo(){
        try{
            String sql = "SELECT PhoneNo,PackageName,TotalPerson,PackagePrice FROM bookingdata WHERE TourId = ?";
            con = db.Connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, tid.getText());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                PhoneNo.setText(rs.getString(1));
                SelectPackage.setText(rs.getString(2));
                totPerson.setText(rs.getString(3));
                price.setText(rs.getString(4));
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
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        userid = new javax.swing.JTextField();
        SelectPackage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        totPerson = new javax.swing.JTextField();
        PhoneNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1350, 840));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1350, 840));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toppanel.setBackground(new java.awt.Color(9, 84, 127));
        toppanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        toppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View Package Details");
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

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bookedDetails.jpeg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 730, 710));

        jLabel5.setFont(new java.awt.Font("Magneto", 0, 50)); // NOI18N
        jLabel5.setForeground(java.awt.Color.darkGray);
        jLabel5.setText("Thank You !");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 700, 340, 60));

        tid.setEditable(false);
        tid.setBackground(new java.awt.Color(204, 204, 204));
        tid.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        tid.setForeground(new java.awt.Color(255, 0, 0));
        tid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 250, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("User Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        userid.setEditable(false);
        userid.setBackground(new java.awt.Color(204, 204, 204));
        userid.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        userid.setForeground(new java.awt.Color(51, 51, 51));
        userid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        userid.setCaretColor(new java.awt.Color(51, 51, 51));
        getContentPane().add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 251, 40));

        SelectPackage.setEditable(false);
        SelectPackage.setBackground(new java.awt.Color(204, 204, 204));
        SelectPackage.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        SelectPackage.setForeground(new java.awt.Color(51, 51, 51));
        SelectPackage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SelectPackage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SelectPackage.setCaretColor(new java.awt.Color(51, 51, 51));
        getContentPane().add(SelectPackage, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 251, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Select Package");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("Total Persons");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setText("Total Price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, -1, -1));

        price.setEditable(false);
        price.setBackground(new java.awt.Color(204, 204, 204));
        price.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        price.setForeground(java.awt.Color.red);
        price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        price.setCaretColor(new java.awt.Color(51, 51, 51));
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 251, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("Phone");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        totPerson.setEditable(false);
        totPerson.setBackground(new java.awt.Color(204, 204, 204));
        totPerson.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        totPerson.setForeground(java.awt.Color.red);
        totPerson.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totPerson.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        totPerson.setCaretColor(new java.awt.Color(51, 51, 51));
        getContentPane().add(totPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 251, 40));

        PhoneNo.setEditable(false);
        PhoneNo.setBackground(new java.awt.Color(204, 204, 204));
        PhoneNo.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        PhoneNo.setForeground(new java.awt.Color(51, 51, 51));
        PhoneNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PhoneNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PhoneNo.setCaretColor(new java.awt.Color(51, 51, 51));
        getContentPane().add(PhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 251, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("Tour ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/simile.png"))); // NOI18N
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 660, -1, -1));

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
            java.util.logging.Logger.getLogger(ViewPackageDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPackageDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPackageDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPackageDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPackageDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PhoneNo;
    private javax.swing.JTextField SelectPackage;
    private javax.swing.JLabel cloase;
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
    private javax.swing.JTextField price;
    private javax.swing.JTextField tid;
    private javax.swing.JPanel toppanel;
    private javax.swing.JTextField totPerson;
    private javax.swing.JTextField userid;
    // End of variables declaration//GEN-END:variables
}