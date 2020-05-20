/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecaller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import truecaller.DashboardGUI;


/**
 *
 * 
 */
public class AddcontactGUI extends JFrame {

    private JLabel pnLabel;
    private JTextField pnField;

    private JLabel fnameLabel;
    private JTextField fnameField;
    private JLabel lnameLabel;
    private JTextField lnameField;

    private JLabel emailLabel;
    private JTextField emailField;

    private JButton saveButton;

    int x_cor = 50;
    int y_cor = 50;
    int width = 300;
    int height = 30;

    public AddcontactGUI() {

        setTitle("Add contact");
        setSize(600, 400);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnLabel = new JLabel("phone number");
        pnField = new JTextField();
        fnameLabel = new JLabel("name");
        fnameField = new JTextField();

        emailLabel = new JLabel("email");
        emailField = new JTextField();

        saveButton = new JButton("ADD");

        pnLabel.setBounds(50, 50, width, height);
        pnField.setBounds(200, 50, width, height);
        fnameLabel.setBounds(50, 100, width, height);
        fnameField.setBounds(200, 100, width, height);
        emailLabel.setBounds(50, 150, width, height);
        emailField.setBounds(200, 150, width, height);
        saveButton.setBounds(200, 200, 100, height);

        add(pnLabel);
        add(pnField);
        add(fnameLabel);
        add(fnameField);
        add(emailLabel);
        add(emailField);
        add(saveButton);
        

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Phonebook newContact = new Phonebook();
                newContact.setEmail(emailField.getText());
                newContact.setFirstname(fnameField.getText());
              
                newContact.setPhonenumber(pnField.getText());
                DashboardGUI.contactsArrayList.add(newContact);
                newContact.index= DashboardGUI.contactsArrayList.size()-1;
                DashboardGUI dashboardGUI = new DashboardGUI();
                dispose();
                

            }
        });
    }

}
