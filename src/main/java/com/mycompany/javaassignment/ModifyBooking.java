/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.javaassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ModifyBooking extends javax.swing.JFrame {

    /**
     * Creates new form ModifyBooking
     */

    String custNames;

    ArrayList <String> roomNo;
    Date checkInDate1, checkOutDate1;
    boolean initialiseStatus= true;
    private int rowNumber;
    private String[] inputData;
    
    public ModifyBooking(String[] rowData, int row) {
        initComponents();
        this.inputData = rowData;
        this.rowNumber = row;
        // CustID
        custIDBoxModifyBooking.setText(inputData[0]);
        
        // Custname
        String inputUserID = custIDBoxModifyBooking.getText();
        try {
            String[] dataArray;
            
            File cust = new File("customer.txt");
            Scanner s = new Scanner(cust);
            
            while (s.hasNextLine()) {
                dataArray = s.nextLine().split("\t");
                if (dataArray[0].equals(inputUserID)){
                    custNameBoxModifyBooking.setText(dataArray[1]);
                    this.custNames = dataArray[1];
                    break;
                }
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        
        // Check In
        String sdfOld = "yyyy-MM-dd";
        String sdfNew = "MMM d,y";
        SimpleDateFormat sdfs = new SimpleDateFormat(sdfOld);
        try {
            // Change data format
            // Reference: https://stackoverflow.com/questions/3469507/how-can-i-change-the-date-format-in-java
            Date dates = sdfs.parse(inputData[3]);
            sdfs.applyPattern(sdfNew);
            sdfs.format(dates);
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(dates);
            checkInDateEditBooking.setCalendar(cal);
            this.checkInDate1 = dates;
//            System.out.println(inputData[3]);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errorsss: " + e);
        }
       
         SimpleDateFormat sdf1 = new SimpleDateFormat(sdfOld);
        // Check Out
        try {
            Date date1 = sdf1.parse(inputData[4]);
            sdf1.applyPattern(sdfNew);
            sdf1.format(date1);
            
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            checkOutDateEditBooking.setCalendar(cal1);
            this.checkOutDate1 = date1;
//            System.out.println(inputData[4]);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        
        // Price
        priceBoxEditBooking.setText(inputData[5]);
        
        // Room type
        switch (inputData[1]) {
            case "seaview":
                seaviewRadio.setSelected(true);
                break;
            case "jungle":
                jungleViewRadio.setSelected(true);
                break;
            default:  
                JOptionPane.showMessageDialog(null, "New bugs boi");
                break;
        }
        
        
        // Room No (Check Available Room)
        try {
            File room = new File("room.txt");
            File booking = new File("booking.txt");
            Scanner sRoom = new Scanner(room);
            String line = "", lineBooking = "";
            boolean availableStatus = true;
            ArrayList <String> fileLines = new ArrayList <String>();

            while(sRoom.hasNextLine()) {
                Scanner sBooking = new Scanner(booking);
                line = sRoom.nextLine();
                String[] arrayRoom = line.split("\t");
                availableStatus = true;

                if (!(arrayRoom[0].equals(inputData[1]))) {
                    continue;
                }
                fileLines.add(arrayRoom[1]);

            }
            sRoom.close();
            roomNumberCombo.removeAllItems();
            this.roomNo = fileLines;
            for (String lineIndex : fileLines) {
                roomNumberCombo.addItem(lineIndex);
            }
            String indexString = inputData[2].substring(2);
            int index = Integer.valueOf(indexString);
            roomNumberCombo.setSelectedIndex(index-1);
            

//        roomNo.setText(inputData[2]);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Errorsssss: " + e);
        }
        initialiseStatus = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomTypesGroup = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        custIDModifyBooking = new javax.swing.JLabel();
        custIDBoxModifyBooking = new javax.swing.JTextField();
        CustNameModifyBooking = new javax.swing.JLabel();
        custNameBoxModifyBooking = new javax.swing.JTextField();
        roomTypeLabel = new javax.swing.JLabel();
        seaviewRadio = new javax.swing.JRadioButton();
        jungleViewRadio = new javax.swing.JRadioButton();
        roomNumber = new javax.swing.JLabel();
        checkInDateLabel = new javax.swing.JLabel();
        checkOutDateLabel = new javax.swing.JLabel();
        checkInDateEditBooking = new com.toedter.calendar.JDateChooser();
        saveBtn = new javax.swing.JButton();
        resetBookingForm = new javax.swing.JButton();
        checkOutDateEditBooking = new com.toedter.calendar.JDateChooser();
        priceLabel = new javax.swing.JLabel();
        priceBoxEditBooking = new javax.swing.JTextField();
        roomNumberCombo = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setInheritsPopupMenu(true);

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setText("< Back");
        jButton7.setOpaque(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel46.setText("Edit Booking  Record");

        custIDModifyBooking.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        custIDModifyBooking.setText("Customer ID");

        custIDBoxModifyBooking.setEditable(false);
        custIDBoxModifyBooking.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        custIDBoxModifyBooking.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                custIDBoxModifyBookingFocusLost(evt);
            }
        });
        custIDBoxModifyBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custIDBoxModifyBookingActionPerformed(evt);
            }
        });
        custIDBoxModifyBooking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                custIDBoxModifyBookingKeyTyped(evt);
            }
        });

        CustNameModifyBooking.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        CustNameModifyBooking.setText("Customer Name");

        custNameBoxModifyBooking.setEditable(false);
        custNameBoxModifyBooking.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        custNameBoxModifyBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameBoxModifyBookingActionPerformed(evt);
            }
        });

        roomTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        roomTypeLabel.setText("Room Type");

        roomTypesGroup.add(seaviewRadio);
        seaviewRadio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        seaviewRadio.setText("Seaview");
        seaviewRadio.setOpaque(false);
        seaviewRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seaviewRadioActionPerformed(evt);
            }
        });

        roomTypesGroup.add(jungleViewRadio);
        jungleViewRadio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jungleViewRadio.setText("JungleView");
        jungleViewRadio.setOpaque(false);
        jungleViewRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jungleViewRadioActionPerformed(evt);
            }
        });

        roomNumber.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        roomNumber.setText("Room Number");

        checkInDateLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        checkInDateLabel.setText("Check In Date");

        checkOutDateLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        checkOutDateLabel.setText("Check Out Date");

        checkInDateEditBooking.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                checkInDateEditBookingFocusLost(evt);
            }
        });
        checkInDateEditBooking.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                checkInDateEditBookingPropertyChange(evt);
            }
        });

        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        resetBookingForm.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        resetBookingForm.setText("Reset");
        resetBookingForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBookingFormActionPerformed(evt);
            }
        });

        checkOutDateEditBooking.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                checkOutDateEditBookingFocusLost(evt);
            }
        });
        checkOutDateEditBooking.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                checkOutDateEditBookingPropertyChange(evt);
            }
        });

        priceLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        priceLabel.setText("Price (RM)");

        priceBoxEditBooking.setEditable(false);
        priceBoxEditBooking.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        priceBoxEditBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceBoxEditBookingActionPerformed(evt);
            }
        });

        roomNumberCombo.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        roomNumberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roomNumberCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberComboActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 51, 51));
        jLabel54.setText("*");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 51, 51));
        jLabel55.setText("*");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 51, 51));
        jLabel56.setText("*");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 51, 51));
        jLabel57.setText("*");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 51, 51));
        jLabel58.setText("*");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 51, 51));
        jLabel59.setText("*");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 51, 51));
        jLabel60.setText("*");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(checkInDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel55))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(priceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel57))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(roomTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel56))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(custIDModifyBooking)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(seaviewRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jungleViewRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(checkInDateEditBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(custIDBoxModifyBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(109, 109, 109)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CustNameModifyBooking)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(roomNumber)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel60))
                                        .addComponent(checkOutDateLabel)
                                        .addComponent(resetBookingForm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel58)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(custNameBoxModifyBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel59)
                                        .addGap(27, 27, 27)
                                        .addComponent(checkOutDateEditBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(priceBoxEditBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(roomNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7)
                        .addGap(383, 383, 383)
                        .addComponent(jLabel46)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(custIDModifyBooking)
                            .addComponent(custIDBoxModifyBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustNameModifyBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custNameBoxModifyBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel54))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel58)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkOutDateEditBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkInDateEditBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(checkInDateLabel)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(checkOutDateLabel))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(roomTypeLabel)
                                .addComponent(seaviewRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jungleViewRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel60))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(roomNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel56)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceLabel)
                            .addComponent(priceBoxEditBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBookingForm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1161, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        initialiseStatus = true;
        Booking book1 = new Booking();
        book1.show();
        dispose();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void custIDBoxModifyBookingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_custIDBoxModifyBookingFocusLost
        // TODO add your handling code here:
        String inputUserID = custIDBoxModifyBooking.getText();
        if (inputUserID.equals("") || inputUserID == null) {
            JOptionPane.showMessageDialog(null, "UserID cannot be empty!");
            return;
        }

        try {
            String[] dataArray;

            File cust = new File("customer.txt");
            Scanner s = new Scanner(cust);

            while (s.hasNextLine()) {
                dataArray = s.nextLine().split("\t");
                if (dataArray[0].equals(inputUserID)){
                    custNameBoxModifyBooking.setText(dataArray[1]);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Invalid UserID");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_custIDBoxModifyBookingFocusLost

    private void custIDBoxModifyBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custIDBoxModifyBookingActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_custIDBoxModifyBookingActionPerformed

    private void custIDBoxModifyBookingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custIDBoxModifyBookingKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_custIDBoxModifyBookingKeyTyped

    private void custNameBoxModifyBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custNameBoxModifyBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custNameBoxModifyBookingActionPerformed
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    private void seaviewRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seaviewRadioActionPerformed
        // TODO add your handling code here:
        if (initialiseStatus) {
            return;
        }
        roomNumberCombo.removeAllItems();
        Date checkInDates = checkInDateEditBooking.getDate();
        Date checkOutDates = checkOutDateEditBooking.getDate();

        Date today = new Date();
        boolean valid = true;

        if (checkOutDates != null) {
            long diffMillies = Math.abs(checkOutDates.getTime() - today.getTime());
            long diffs = TimeUnit.DAYS.convert(diffMillies, TimeUnit.MILLISECONDS);

            if ((checkOutDates.compareTo(today)) <= 0) {
                JOptionPane.showMessageDialog(null, "Invalid Date");
                valid = false;
            }

            if (!valid) {
                checkOutDateEditBooking.setCalendar(null);
                return;
            }
        }

        if (checkInDates != null && checkOutDates != null && roomTypesGroup.getSelection() != null){
            if (checkOutDates.compareTo(checkInDates) < 0) {
                JOptionPane.showMessageDialog(null, "Check out date cannot smaller than check in date.");
                checkOutDateEditBooking.setCalendar(null);
                return;
            }
            else if (checkInDates.compareTo(today) <= 0) {
                JOptionPane.showMessageDialog(null, "Check In date cannot be today.");
                checkInDateEditBooking.setCalendar(null);
                return;
            }

            roomNumberCombo.removeAllItems();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String inString = sdf.format(checkInDates);
            String outString = sdf.format(checkOutDates);
            //            System.out.println(inString + " " + outString);
            long diffInMillies = Math.abs(checkOutDates.getTime() - checkInDates.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1;

            String price = df.format((diff * 350.00) * 110 / 100);
            priceBoxEditBooking.setText(price);

            // Check filter
            String filter = "";
            if (seaviewRadio.isSelected()) {
                filter = "seaview";
            }
            else if (jungleViewRadio.isSelected()) {
                filter = "jungle";
            }
            else {
                JOptionPane.showMessageDialog(null, "Error weh");
            }

            // Check available room
            try {
                File room = new File("room.txt");
                File booking = new File("booking.txt");
                Scanner sRoom = new Scanner(room);
                String line = "", lineBooking = "";
                boolean availableStatus = true;
                ArrayList <String> fileLines = new ArrayList <String>();

                while(sRoom.hasNextLine()) {
                    Scanner sBooking = new Scanner(booking);
                    line = sRoom.nextLine();
                    String[] arrayRoom = line.split("\t");
                    availableStatus = true;

                    if (!(arrayRoom[0].equals(filter))) {
                        //                        System.out.println(arrayRoom[0] + " " + filter);
                        continue;
                    }

                    while(sBooking.hasNextLine()) {
                        lineBooking = sBooking.nextLine();
                        String[] arrayBooking = lineBooking.split("\t");

                        // CheckIn
                        Date fileDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrayBooking[3]);
                        Date fileCheckOutDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrayBooking[4]);

                        if (arrayRoom[1].equals(arrayBooking[2])) {
                            // Check in compare
                            int diffInCheckIn = checkInDates.compareTo(fileDate);
                            int diffInCheckIn1 = checkOutDates.compareTo(fileDate);

                            // Check out compare
                            int diffInCheckout = checkInDates.compareTo(fileCheckOutDate);
                            int diffInCheckOut1 = checkOutDates.compareTo(fileCheckOutDate);

                            //                            System.out.println(arrayBooking[3] + " " + arrayBooking[4]);
                            //                            System.out.println(checkInDates + " " + fileDate + " " + checkOutDates + " " + fileCheckOutDate);
//                            System.out.println(diffInCheckIn + " " + diffInCheckIn1 +" " + diffInCheckout + " " + diffInCheckOut1 + "\n");
                            if (diffInCheckIn >= 0 && diffInCheckOut1 < 0){
                                //                                System.out.println(diffInCheckIn + " " + diffInCheckIn1);
                                availableStatus = false;
                                break;
                            }
                            else if (diffInCheckout < 0 && diffInCheckout < 0) {
                                availableStatus = false;
                                break;
                            }
                        }
                    }
                    if (availableStatus) {
                        fileLines.add(arrayRoom[1]);
                    }
                    sBooking.close();
                }
                sRoom.close();

                for (String lineIndex : fileLines) {
                    roomNumberCombo.addItem(lineIndex);
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }

        }
    }//GEN-LAST:event_seaviewRadioActionPerformed

    private void jungleViewRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jungleViewRadioActionPerformed
        // TODO add your handling code here:
        if (initialiseStatus) {
            return;
        }
        
        roomNumberCombo.removeAllItems();

        Date checkInDates = checkInDateEditBooking.getDate();
        Date checkOutDates = checkOutDateEditBooking.getDate();

        Date today = new Date();
        boolean valid = true;

        if (checkOutDates != null) {
            long diffMillies = Math.abs(checkOutDates.getTime() - today.getTime());
            long diffs = TimeUnit.DAYS.convert(diffMillies, TimeUnit.MILLISECONDS);

            if ((checkOutDates.compareTo(today)) <= 0) {
                JOptionPane.showMessageDialog(null, "Invalid Date");
                valid = false;
            }

            if (!valid) {
                checkOutDateEditBooking.setCalendar(null);
                return;
            }
        }

        if (!valid) {
            checkOutDateEditBooking.setCalendar(null);
            return;
        }

        if (checkInDates != null && checkOutDates != null && roomTypesGroup.getSelection() != null){
            if (checkOutDates.compareTo(checkInDates) <= 0) {
                JOptionPane.showMessageDialog(null, "Check out date cannot smaller than check in date.");
                checkOutDateEditBooking.setCalendar(null);
                return;
            }

            roomNumberCombo.removeAllItems();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String inString = sdf.format(checkInDates);
            String outString = sdf.format(checkOutDates);
            //            System.out.println(inString + " " + outString);
            long diffInMillies = Math.abs(checkOutDates.getTime() - checkInDates.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            String price = df.format((diff * 350.00) * 110 / 100);
            priceBoxEditBooking.setText(price);

            // Check filter
            String filter = "";
            if (seaviewRadio.isSelected()) {
                filter = "seaview";
            }
            else if (jungleViewRadio.isSelected()) {
                filter = "jungle";
            }
            else {
                JOptionPane.showMessageDialog(null, "Error weh");
            }

            // Check available room
            try {
                File room = new File("room.txt");
                File booking = new File("booking.txt");
                Scanner sRoom = new Scanner(room);
                String line = "", lineBooking = "";
                boolean availableStatus = true;
                ArrayList <String> fileLines = new ArrayList <String>();

                while(sRoom.hasNextLine()) {
                    Scanner sBooking = new Scanner(booking);
                    line = sRoom.nextLine();
                    String[] arrayRoom = line.split("\t");
                    availableStatus = true;

                    if (!(arrayRoom[0].equals(filter))) {
                        //                        System.out.println(arrayRoom[0] + " " + filter);
                        continue;
                    }

                    while(sBooking.hasNextLine()) {
                        lineBooking = sBooking.nextLine();
                        String[] arrayBooking = lineBooking.split("\t");

                        // CheckIn
                        Date fileDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrayBooking[3]);
                        Date fileCheckOutDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrayBooking[4]);

                        if (arrayRoom[1].equals(arrayBooking[2])) {
                            // Check in compare
                            int diffInCheckIn = checkInDates.compareTo(fileDate);
                            int diffInCheckIn1 = checkOutDates.compareTo(fileDate);

                            // Check out compare
                            int diffInCheckout = checkInDates.compareTo(fileCheckOutDate);
                            int diffInCheckOut1 = checkOutDates.compareTo(fileCheckOutDate);

                            //                            System.out.println(arrayBooking[3] + " " + arrayBooking[4]);
                            //                            System.out.println(checkInDates + " " + fileDate + " " + checkOutDates + " " + fileCheckOutDate);
                            //                            System.out.println(diffInCheckIn + " " + diffInCheckIn1 +" " + diffInCheckout + " " + diffInCheckOut1 + "\n");
                            if (diffInCheckIn >= 0 && diffInCheckOut1 < 0){
                                //                                System.out.println(diffInCheckIn + " " + diffInCheckIn1);
                                availableStatus = false;
                                break;
                            }
                            else if (diffInCheckout < 0 && diffInCheckout < 0) {
                                availableStatus = false;
                                break;
                            }
                        }
                    }
                    if (availableStatus) {
                        fileLines.add(arrayRoom[1]);
                    }
                    sBooking.close();
                }
                sRoom.close();

                for (String lineIndex : fileLines) {
                    roomNumberCombo.addItem(lineIndex);
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }

        }
    }//GEN-LAST:event_jungleViewRadioActionPerformed

    private void checkInDateEditBookingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_checkInDateEditBookingFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_checkInDateEditBookingFocusLost

    private void checkInDateEditBookingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_checkInDateEditBookingPropertyChange
        // TODO add your handling code here:
        if (initialiseStatus) {
            return;
        }
        Date checkInDates = checkInDateEditBooking.getDate();
        Date checkOutDates = checkOutDateEditBooking.getDate();

        Date today = new Date();
        boolean valid = true;

        if (checkInDates != null) {
            long diffMillies = Math.abs(checkInDates.getTime() - today.getTime());
            long diffs = TimeUnit.DAYS.convert(diffMillies, TimeUnit.MILLISECONDS);

            if ((checkInDates.compareTo(today)) < 0) {
                JOptionPane.showMessageDialog(null, "Invalid Date");
                valid = false;
            }

            if (!valid) {
                checkInDateEditBooking.setCalendar(null);
                return;
            }
        }

        if (checkInDates != null && checkOutDates != null && roomTypesGroup.getSelection() != null){
            if (checkOutDates.compareTo(checkInDates) <= 0) {
                JOptionPane.showMessageDialog(null, "Check out date cannot smaller than check in date.");
                checkOutDateEditBooking.setCalendar(null);
                return;
            }

            roomNumberCombo.removeAllItems();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String inString = sdf.format(checkInDates);
            String outString = sdf.format(checkOutDates);
            //            System.out.println(inString + " " + outString);
            long diffInMillies = Math.abs(checkOutDates.getTime() - checkInDates.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            String price = df.format((diff * 350.00) * 110 / 100);
            priceBoxEditBooking.setText(price);

            // Check filter
            String filter = "";
            if (seaviewRadio.isSelected()) {
                filter = "seaview";
            }
            else if (jungleViewRadio.isSelected()) {
                filter = "jungle";
            }
            else {
                JOptionPane.showMessageDialog(null, "Error weh");
            }

            // Check available room
            try {
                File room = new File("room.txt");
                File booking = new File("booking.txt");
                Scanner sRoom = new Scanner(room);
                String line = "", lineBooking = "";
                boolean availableStatus = true;
                ArrayList <String> fileLines = new ArrayList <String>();

                while(sRoom.hasNextLine()) {
                    Scanner sBooking = new Scanner(booking);
                    line = sRoom.nextLine();
                    String[] arrayRoom = line.split("\t");
                    availableStatus = true;

                    if (!(arrayRoom[0].equals(filter))) {
                        //                        System.out.println(arrayRoom[0] + " " + filter);
                        continue;
                    }

                    while(sBooking.hasNextLine()) {
                        lineBooking = sBooking.nextLine();
                        String[] arrayBooking = lineBooking.split("\t");

                        // CheckIn
                        Date fileDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrayBooking[3]);
                        Date fileCheckOutDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrayBooking[4]);

                        if (arrayRoom[1].equals(arrayBooking[2])) {
                            // Check in compare
                            int diffInCheckIn = checkInDates.compareTo(fileDate);
                            int diffInCheckIn1 = checkOutDates.compareTo(fileDate);

                            // Check out compare
                            int diffInCheckout = checkInDates.compareTo(fileCheckOutDate);
                            int diffInCheckOut1 = checkOutDates.compareTo(fileCheckOutDate);

                            //                            System.out.println(arrayBooking[3] + " " + arrayBooking[4]);
                            //                            System.out.println(checkInDates + " " + fileDate + " " + checkOutDates + " " + fileCheckOutDate);
                            //                            System.out.println(diffInCheckIn + " " + diffInCheckIn1 +" " + diffInCheckout + " " + diffInCheckOut1 + "\n");
                            if (diffInCheckIn >= 0 && diffInCheckOut1 < 0){
                                //                                System.out.println(diffInCheckIn + " " + diffInCheckIn1);
                                availableStatus = false;
                                break;
                            }
                            else if (diffInCheckout < 0 && diffInCheckout < 0) {
                                availableStatus = false;
                                break;
                            }
                        }
                    }
                    if (availableStatus) {
                        fileLines.add(arrayRoom[1]);
                    }
                    sBooking.close();
                }
                sRoom.close();

                for (String lineIndex : fileLines) {
                    roomNumberCombo.addItem(lineIndex);
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }

        }
    }//GEN-LAST:event_checkInDateEditBookingPropertyChange

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // Initialise string array to store data
        String[] bookingData = new String[6];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Customer ID
        bookingData[0] = custIDBoxModifyBooking.getText();

        // Room ID
        bookingData[2] = roomNumberCombo.getSelectedItem().toString();
        if (bookingData[2] == null) {
            JOptionPane.showMessageDialog(null, "Room Number cannot leave empty");
            return;
        }

        // Check In Date
        Date checkIn = checkInDateEditBooking.getDate();
        if (checkIn == null) {
            JOptionPane.showMessageDialog(null, "Check In Date cannot leave empty");
            return;
        }
        bookingData[3] = String.valueOf(dateFormat.format(checkIn));

        // Check Out Date
        Date checkOut = checkOutDateEditBooking.getDate();
        if (checkOut == null) {
            JOptionPane.showMessageDialog(null, "Check Out Date cannot leave empty");
            return;
        }
        bookingData[4] = String.valueOf(dateFormat.format(checkOut));

        // Room type
        if (seaviewRadio.isSelected()) {
            bookingData[1] = "seaview";
        }
        else if (jungleViewRadio.isSelected()) {
            bookingData[1] = "jungle";
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a room type!");
            return;
        }

        // Price
        bookingData[5] = priceBoxEditBooking.getText();

        // Copy all file content to arraylist
        File tmp = new File("booking.txt");
        int lineCounter = 0;
        try {
            Scanner countLine = new Scanner(tmp);
            while(countLine.hasNextLine()) {
                countLine.nextLine();

                lineCounter++;
            }
            countLine.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        String[][] fileContent = new String[lineCounter][6];
        
        String line;
        String[] lineArray;
        int counter = 0;
        try {
            Scanner read = new Scanner(tmp);
            while(read.hasNextLine()) {
                line = read.nextLine();
                lineArray = line.split("\t");
                System.out.println(rowNumber + " " + counter); 
                if (rowNumber == counter) {
                    fileContent[counter] = bookingData;
                    counter++;
                    continue;
                }
                fileContent[counter] = lineArray;
                System.out.println(fileContent[counter]);
                counter++;
            }
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }


        // Append data into text file
        try {
            File delete = new File("booking.txt");
            delete.delete();
            PrintWriter pw = new PrintWriter("booking.txt");
            for (int i = 0; i < fileContent.length; i++) {
                if (i != 0) {
                    pw.append("\n");
                }
                for (String lines:fileContent[i]) {
                   pw.append(lines);
                   
                   pw.append("\t");
                   System.out.println(lines);
                }
            }
            pw.close();



            
            JOptionPane.showMessageDialog(null, "Update Success!");
//
            // Redirect back to homepage
            Booking book = new Booking();
            book.show();
            dispose();
//
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void resetBookingFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBookingFormActionPerformed
        // TODO add your handling code here:
        custIDBoxModifyBooking.setText(inputData[0]);
        custNameBoxModifyBooking.setText(custNames);
        roomTypesGroup.clearSelection();
        if (inputData[1].equals("seaview")) {
            seaviewRadio.setSelected(true);
        }
        else if (inputData[1].equals("jungle")) {
            jungleViewRadio.setSelected(true);
        }
        else {
           JOptionPane.showMessageDialog(null, "Errors sia"); 
        }
        roomNumberCombo.removeAllItems();
        
        Calendar tmp = Calendar.getInstance();
        tmp.setTime(checkInDate1);
        checkInDateEditBooking.setCalendar(tmp);
        
        tmp.setTime(checkOutDate1);
        checkOutDateEditBooking.setCalendar(tmp);
        priceBoxEditBooking.setText(inputData[5]);
        
        for (String lineIndex : roomNo) {
            roomNumberCombo.addItem(lineIndex);
        }
    }//GEN-LAST:event_resetBookingFormActionPerformed

    private void checkOutDateEditBookingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_checkOutDateEditBookingFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_checkOutDateEditBookingFocusLost

    private void checkOutDateEditBookingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_checkOutDateEditBookingPropertyChange
        // TODO add your handling code here:
        if (initialiseStatus) {
            return;
        }
        Date checkInDates = checkInDateEditBooking.getDate();
        Date checkOutDates = checkOutDateEditBooking.getDate();

        Date today = new Date();
        boolean valid = true;

        if (checkOutDates != null) {
            long diffMillies = Math.abs(checkOutDates.getTime() - today.getTime());
            long diffs = TimeUnit.DAYS.convert(diffMillies, TimeUnit.MILLISECONDS);

            if ((checkOutDates.compareTo(today)) < 0) {
                JOptionPane.showMessageDialog(null, "Invalid Date");
                valid = false;
            }

            if (!valid) {
                checkOutDateEditBooking.setCalendar(null);
                return;
            }
        }

        if (checkInDates != null && checkOutDates != null && roomTypesGroup.getSelection() != null){
            if (checkOutDates.compareTo(checkInDates) <= 0) {
                JOptionPane.showMessageDialog(null, "Check out date cannot smaller than check in date.");
                checkOutDateEditBooking.setCalendar(null);
                return;
            }

            roomNumberCombo.removeAllItems();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //            String inString = sdf.format(checkInDates);
            //            String outString = sdf.format(checkOutDates);
            //            System.out.println(inString + " " + outString);
            long diffInMillies = Math.abs(checkOutDates.getTime() - checkInDates.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            String price = df.format(((diff * 350.00) * 110 / 100) + 10);
            priceBoxEditBooking.setText(price);

            // Check filter
            String filter = "";
            if (seaviewRadio.isSelected()) {
                filter = "seaview";
            }
            else if (jungleViewRadio.isSelected()) {
                filter = "jungle";
            }
            else {
                JOptionPane.showMessageDialog(null, "Error weh");
            }

            // Check available room
            try {
                File room = new File("room.txt");
                File booking = new File("booking.txt");
                Scanner sRoom = new Scanner(room);
                String line = "", lineBooking = "";
                boolean availableStatus = true;
                ArrayList <String> fileLines = new ArrayList <String>();

                while(sRoom.hasNextLine()) {
                    Scanner sBooking = new Scanner(booking);
                    line = sRoom.nextLine();
                    String[] arrayRoom = line.split("\t");
                    availableStatus = true;

                    if (!(arrayRoom[0].equals(filter))) {
                        //                        System.out.println(arrayRoom[0] + " " + filter);
                        continue;
                    }

                    while(sBooking.hasNextLine()) {
                        lineBooking = sBooking.nextLine();
                        String[] arrayBooking = lineBooking.split("\t");

                        // CheckIn
                        Date fileDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrayBooking[3]);
                        Date fileCheckOutDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrayBooking[4]);

                        if (arrayRoom[1].equals(arrayBooking[2])) {
                            // Check in compare
                            int diffInCheckIn = checkInDates.compareTo(fileDate);
                            int diffInCheckIn1 = checkOutDates.compareTo(fileDate);

                            // Check out compare
                            int diffInCheckout = checkInDates.compareTo(fileCheckOutDate);
                            int diffInCheckOut1 = checkOutDates.compareTo(fileCheckOutDate);

                            //                            System.out.println(arrayBooking[3] + " " + arrayBooking[4]);
                            //                            System.out.println(checkInDates + " " + fileDate + " " + checkOutDates + " " + fileCheckOutDate);
                                                        System.out.println(diffInCheckIn + " " + diffInCheckIn1 +" " + diffInCheckout + " " + diffInCheckOut1 + "\n");
                            if (diffInCheckIn >= 0 && diffInCheckOut1 < 0){
                                //                                System.out.println(diffInCheckIn + " " + diffInCheckIn1);
                                availableStatus = false;
                                break;
                            }
                            else if (diffInCheckout < 0 && diffInCheckout < 0) {
                                availableStatus = false;
                                break;
                            }
                        }
                    }
                    if (availableStatus) {
                        fileLines.add(arrayRoom[1]);
                    }
                    sBooking.close();
                }
                sRoom.close();

                for (String lineIndex : fileLines) {
                    roomNumberCombo.addItem(lineIndex);
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }

        }
    }//GEN-LAST:event_checkOutDateEditBookingPropertyChange

    private void priceBoxEditBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceBoxEditBookingActionPerformed

    }//GEN-LAST:event_priceBoxEditBookingActionPerformed

    private void roomNumberComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberComboActionPerformed

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
            java.util.logging.Logger.getLogger(ModifyBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ModifyBooking().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustNameModifyBooking;
    private com.toedter.calendar.JDateChooser checkInDateEditBooking;
    private javax.swing.JLabel checkInDateLabel;
    private com.toedter.calendar.JDateChooser checkOutDateEditBooking;
    private javax.swing.JLabel checkOutDateLabel;
    private javax.swing.JTextField custIDBoxModifyBooking;
    private javax.swing.JLabel custIDModifyBooking;
    private javax.swing.JTextField custNameBoxModifyBooking;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jungleViewRadio;
    private javax.swing.JTextField priceBoxEditBooking;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton resetBookingForm;
    private javax.swing.JLabel roomNumber;
    private javax.swing.JComboBox<String> roomNumberCombo;
    private javax.swing.JLabel roomTypeLabel;
    private javax.swing.ButtonGroup roomTypesGroup;
    private javax.swing.JButton saveBtn;
    private javax.swing.JRadioButton seaviewRadio;
    // End of variables declaration//GEN-END:variables
}
