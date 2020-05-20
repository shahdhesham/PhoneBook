/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truecaller;

import truecaller.AddcontactGUI;
import truecaller.editcontactGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class DashboardGUI extends JFrame {

    private JLabel pnTagLabel;
    private JLabel fnameTagLabel;
    private JLabel emailTagLabel;
    private JLabel actionsTagLabel;

    private JLabel pnLabel;
    private JLabel fnameLabel;
    private JLabel emailLabel;

    private JButton addButton;
    private JButton saveButton;
    public static ArrayList<Phonebook> contactsArrayList = new ArrayList<Phonebook>();
    int x_cor = 50;
    int y_cor = 80;

    public DashboardGUI() {

        if (contactsArrayList.size() == 0) {
            
            JLabel noStudentsLabel = new JLabel("No available contacts !\n\n Add new contacts to be displayed.");
            noStudentsLabel.setBounds(150, 50, 400, 100);
            add(noStudentsLabel);
        } else {

            pnTagLabel = new JLabel("phone number");
            fnameTagLabel = new JLabel("first name");
            emailTagLabel = new JLabel("email");
            actionsTagLabel = new JLabel("Actions");

            pnTagLabel.setBounds(x_cor, y_cor - 50, 100, 30);
            fnameTagLabel.setBounds(x_cor + 150, y_cor - 50, 100, 30);
            emailTagLabel.setBounds(x_cor + 250, y_cor - 50, 100, 30);
            actionsTagLabel.setBounds(x_cor + 400, y_cor - 50, 100, 30);

            pnTagLabel.setForeground(Color.red);
            fnameTagLabel.setForeground(Color.red);
            emailTagLabel.setForeground(Color.red);
            actionsTagLabel.setForeground(Color.red);

            add(pnTagLabel);
            add(fnameTagLabel);
            add(emailTagLabel);
            add(actionsTagLabel);

            for (int i = 0; i < contactsArrayList.size(); i++) {

                JLabel pnLabel = new JLabel(contactsArrayList.get(i).getFirstname());
                pnLabel.setBounds(x_cor, y_cor, 100, 30);
                add(pnLabel);

                JLabel fnameLabel = new JLabel(contactsArrayList.get(i).getLastname());
                fnameLabel.setBounds(x_cor + 150, y_cor, 100, 30);
                add(fnameLabel);

                JLabel levelLabel = new JLabel(contactsArrayList.get(i).getPhonenumber()+ "");
                levelLabel.setBounds(x_cor + 250, y_cor, 100, 30);
                add(levelLabel);
                JLabel Label = new JLabel(contactsArrayList.get(i).getEmail()+ "");

                JButton editButton = new JButton("EDIT");
                editButton.setBounds(x_cor + 370, y_cor, 70, 30);
                add(editButton);
                editButton.setActionCommand(i + "");
                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int index = Integer.parseInt(e.getActionCommand());
                        
                        editcontactGUI editcontactGUI = new editcontactGUI(index, contactsArrayList.get(index));
                        dispose();
                    }
                });

                JButton deleteButton = new JButton("Delete");
                deleteButton.setBounds(x_cor + 450, y_cor, 70, 30);
                add(deleteButton);
                deleteButton.setActionCommand(i + "");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int index = Integer.parseInt(e.getActionCommand());
                        int selectedOption = JOptionPane.showConfirmDialog(null,
                                "Are you sure to delete this Student",
                                "Confirmation",
                                JOptionPane.YES_NO_OPTION);
                        if (selectedOption == JOptionPane.YES_OPTION) {
                            contactsArrayList.remove(index);
                            dispose();
                            DashboardGUI dashboardGUI = new DashboardGUI();
                        }
                    }
                });

                y_cor += 40;
            }
        }
        addButton = new JButton("Add");
        addButton.setBounds(400, 600, 80, 30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AddcontactGUI addcontactGUI = new AddcontactGUI();
                //setVisible(false);
                dispose();
            }
        });

        saveButton = new JButton("SAVE");
        saveButton.setBounds(500, 600, 80, 30);
        add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Phonebook contact = new Phonebook();
                boolean isSaved = contact.save();
                if (isSaved) {
                    JOptionPane.showMessageDialog(null, "Saved successfully in the binary files!", "Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error in saving!", "Message", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        setTitle("Contacts List");
        setSize(650, 700);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}
