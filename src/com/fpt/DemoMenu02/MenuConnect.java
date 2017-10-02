/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.DemoMenu02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Nam Nguyen
 */
public class MenuConnect extends JFrame {

    private JMenuBar mbMenuBar;
    private JMenu mMenu, language;
    private JMenuItem connect;
    private JMenuItem vietNamese, english, japanese;
    private JTextArea txtTextArea;
    private JTextField txtText;
    private JButton btnClick;

    public MenuConnect() {
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.mbMenuBar = new JMenuBar();
        this.txtTextArea = new JTextArea();
        this.txtText = new JTextField();
        this.btnClick = new JButton("Click");
        this.mMenu = new JMenu("Menu");
        this.connect = new JMenuItem("Connect");

        this.language = new JMenu("Language");

        this.vietNamese = new JMenuItem("Vietnamese");
        vietNamese.setActionCommand("vn");
        vietNamese.addActionListener(new EventConnect());
        this.english = new JMenuItem("English");
        english.setActionCommand("en");
        english.addActionListener(new EventConnect());
        this.japanese = new JMenuItem("Japanese");

        txtTextArea.setBounds(100, 50, 500, 300);
        txtText.setBounds(100, 400, 300, 50);
        btnClick.setBounds(400, 400, 200, 50);

        setJMenuBar(mbMenuBar);
        this.add(btnClick);
        this.add(txtText);
        this.add(txtTextArea);
        mbMenuBar.add(mMenu);
        mMenu.add(connect);
        mMenu.add(language);
        language.add(vietNamese);
        language.add(english);
        language.add(japanese);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    class EventConnect implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if ("vn".equals(ae.getActionCommand())) {
                Locale localeVN = new Locale("vi", "VN");
                ResourceBundle resource = ResourceBundle.getBundle("language/language", localeVN);
                connect.setText(resource.getString("Ket_noi"));
                language.setText(resource.getString("ngon_ngu"));
                vietNamese.setText(resource.getString("vi"));
                english.setText(resource.getString("en"));
                japanese.setText(resource.getString("jp"));
            }
            if ("en".equals(ae.getActionCommand())) {
                Locale localeEn = new Locale("en", "EN");
                ResourceBundle resource = ResourceBundle.getBundle("language/language", localeEn);
                connect.setText(resource.getString("cnt"));
                language.setText(resource.getString("lang"));
                vietNamese.setText(resource.getString("vi"));
                english.setText(resource.getString("en"));
                japanese.setText(resource.getString("jp"));

            }

        }
    }
}
