package com.airticket.project.GUI.Menu;

import com.airticket.project.GUI.Booking.frmBooking;
import com.airticket.project.GUI.Checking.CheckingCode;
import com.airticket.project.GUI.Flight.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class frmMainPage extends JFrame implements ActionListener {
    private JButton btn1,btn2,btn3,btn4;

    public frmMainPage() {
        setTitle("Menu");
        setLayout(new GridLayout(3, 2, 5, 5));
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create image
        Icon icon = new ImageIcon(getClass().getResource("airplane.png"));

        //create label
        btn1 = createJButton("Booking", Color.red, Color.pink);
        btn2 = createJButton("Checking", Color.red, Color.yellow);
        btn3 = createJButton("Function 3", Color.red, Color.cyan);
        btn4 = createJButton("Function 4", Color.red, Color.gray);
        JLabel lb5 = new JLabel("icon", icon, JLabel.CENTER);

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(lb5);

        //display
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createJButton(String txt, Color txtColor, Color bgColor){
        JButton btn = new JButton(txt);
        btn.setForeground(txtColor);
        //set bg color
        btn.setOpaque(true);
        btn.setBackground(bgColor);
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command == "Booking"){
            setVisible(false);
            try {
                new frmBooking();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        if (command == "Checking") {
            setVisible(false);
            try {
                new CheckingCode();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        if(command == "Airport"){
            try {
                new frmAirport();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new frmMainPage();
    }
}
