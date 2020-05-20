/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecaller;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class edituserGUI extends JFrame  implements iFile{

    private JLabel fnlb;
    private JLabel lnlb;
    private JLabel emlb;
    private JLabel nolb;
    private JLabel uslb;
    private JLabel pslb;

    private TextField fntx;
    private TextField lntx;
    private TextField emtx;
    private TextField notx;
    private TextField ustx;
    private TextField pstx;

    private JButton save;

    public edituserGUI() {
        fnlb = new JLabel("First Name :");
        fntx = new TextField();
        lnlb = new JLabel("Last Name :");
        lntx = new TextField();
        emlb = new JLabel("Email :");
        emtx = new TextField();
        uslb = new JLabel("User Name :");
        ustx = new TextField();
        nolb = new JLabel("Numbre :");
        notx = new TextField();
        pslb = new JLabel("Password :");
        pstx = new TextField();

        save = new JButton("Save");

        fnlb.setBounds(50, 30, 90, 50);
        lnlb.setBounds(50, 60, 90, 50);
        emlb.setBounds(50, 90, 90, 50);
        nolb.setBounds(50, 120, 90, 50);
        uslb.setBounds(50, 150, 90, 50);
        pslb.setBounds(50, 180, 90, 50);

        add(fnlb);
        add(lnlb);
        add(emlb);
        add(nolb);
        add(uslb);
        add(pslb);

         fntx.setBounds(200, 50, 90, 20);
        lntx.setBounds(200, 80, 90, 20);
        emtx.setBounds(200, 110, 90, 20);
        notx.setBounds(200, 140, 90, 20);
        ustx.setBounds(200, 170, 90, 20);
        pstx.setBounds(200, 200, 90, 20);

         add(fntx);
        add(lntx);
        add(emtx);
        add(notx);
        add(ustx);
        add(pstx);
        
        save.setBounds(350, 300, 90, 20);
        add(save);
        
        setTitle("Edit User");
        setSize(500, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        save.addActionListener(new Action ());
        

    }

    @Override
    public boolean save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private class Action implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
            User x = new User();
            x.load();
            {
            remove(x);
            x.setFirstname(fntx.getText())  ;
            x.setLasttname(lntx.getText()) ;
            x.setEmail(emtx.getText()) ;
            x.setPhonenumber(notx.getText()) ;
            x.setUsername(ustx.getText()) ;
            x.setPassword(pstx.getText()) ;
            
            add(x);
            x.alphabeticSort();
            
            
            x.save();
            
            
            
            
        }}
}}