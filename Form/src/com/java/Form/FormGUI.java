package com.java.Form;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class App extends Frame implements ActionListener {
	Button submit = new Button("Submit");
	TextField textField = new TextField(33);
	TextArea textArea = new TextArea(10, 30);
	Label id = new Label("Enter ID");

	App() {
		super("Form Details");
		setVisible(true);
		setSize(500, 500);
		setLayout(new FlowLayout());
		add(id);
		add(textField);
		add(submit);
		submit.addActionListener(this);
		add(textArea);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		try {
			Connection con = ConnectionProvider.CreateConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from students where sid = " + Integer.parseInt(textField.getText()));
			int size = 0;
			while (rs.next()) {
				textArea.setText("\nName:" + rs.getString("sname") + "\nPhone:" + rs.getString("sphone") + "\nCity:"
						+ rs.getString("scity"));
				size++;
			}
			if (size == 0) {
				textArea.setText("Data Not found with given ID");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}

public class FormGUI {

	public static void main(String[] args) {
		new App();
	}

}
