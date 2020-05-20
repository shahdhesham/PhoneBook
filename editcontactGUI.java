/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecaller;

import truecaller.DashboardGUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * 
 */
public class editcontactGUI extends JFrame {

    private JLabel pnLabel;
    private JTextField pnField;

    private JLabel fnameLabel;
    private JTextField fnameField;

    private JLabel emailLabel;
    private JTextField emailField;

    private JButton saveButton;

    public editcontactGUI(String fname, String lname, String email, String phonenumber,int index) {

        setTitle("Edit contact");
        setSize(600, 400);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int x_cor = 50;
        int y_cor = 50;
        int width = 300;
        int height = 30;

        pnLabel = new JLabel(" phone number");
        pnField = new JTextField(phonenumber);
        fnameLabel = new JLabel("Student Name");
        fnameField = new JTextField(fname);
        emailLabel = new JLabel("Student Level");
        emailField = new JTextField(email);
        saveButton = new JButton("SAVE");

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
                //Student newStudent = new Student(idField.getText(), nameField.getText(), Integer.parseInt(levelField.getText()));
                Phonebook updatedcontact = new Phonebook(pnField.getText(), fnameField.getText(), emailField.getText());
                DashboardGUI.contactsArrayList.set(index,updatedcontact);
                DashboardGUI dashboardGUI = new DashboardGUI();
                dispose();
                // DashboardGUI dashboardGUI = new DashboardGUI(idField.getText(), nameField.getText(), levelField.getText());

            }
        });
    }

    //Encapsulation
    public editcontactGUI(int index, Phonebook contact) {

        setTitle("Edit Contact");
        setSize(600, 400);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int x_cor = 50;
        int y_cor = 50;
        int width = 300;
        int height = 30;

        pnLabel = new JLabel("phone number");
        pnField = new JTextField(contact.getPhonenumber());
        fnameLabel = new JLabel("first Name");
        fnameField = new JTextField(contact.getFirstname());
        emailLabel = new JLabel("email");
        emailField = new JTextField(contact.getEmail());
        saveButton = new JButton("EDIT");

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
                Phonebook updatedcontact = new Phonebook(pnField.getText(), fnameField.getText(), emailField.getText());
                truecaller.DashboardGUI.contactsArrayList.set(index, updatedcontact);
                DashboardGUI dashboardGUI = new DashboardGUI();
                dispose();                
            }
        });
    }

    editcontactGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
