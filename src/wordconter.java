import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class wordconter extends javax.swing.JFrame {

    /**
     * Creates new form WordsCountApp
     */
	
    public wordconter() {
    	setResizable(false);
    	setTitle("Word and Character Counter");
    	getContentPane().setBackground(Color.WHITE);
        initComponents();
    }
  

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea1.setForeground(Color.BLACK);
        jTextArea1.setBackground(UIManager.getColor("Button.background"));
        jTextArea1.setWrapStyleWord(true);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("Words");
        jLabel1.setBackground(UIManager.getColor("CheckBox.light"));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setText("Characters");
        jLabel2.setBackground(UIManager.getColor("CheckBox.light"));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jButton1 = new javax.swing.JButton();
      
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new Font("Arial", Font.BOLD, 20)); 
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new Font("Arial", Font.BOLD, 20)); 
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jButton1.setText("Count");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        btnAbout = new JButton();
        btnAbout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		final String aboutText=
        				"<html><big>Word and Character Counter</big><hr>"
        				+"<p align=right>Created and Designed by A Vats"
        				+"<hr><p align=left>I Used jdk1.8 to compile the source code.<br><br>"
        				+"<strong>Thanx for using <u>Word and Character Counter</u></strong><br>"
        				+"Your Comments as well as bug reports are very welcome at<p align=center>";
				JOptionPane.showMessageDialog(wordconter.this.rootPane,aboutText,"Dedicated To You!",JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        btnAbout.setText("ABOUT");
        btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(73)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        				.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        				.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
        					.addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(32)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(64, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String text=jTextArea1.getText();
       String[] words=text.split("\\s+");
     
  
       
       
       
       jLabel1.setText("Words: "+words.length);
       jLabel2.setText("Characters: "+text.length());

    }

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
                if ("add here".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(wordconter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(wordconter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(wordconter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(wordconter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wordconter().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private JButton btnAbout;
}