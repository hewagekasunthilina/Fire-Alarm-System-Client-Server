import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.handler.MessageContext;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.*;

public class Admin_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUN;
	private JPasswordField textPW;
	static Admin_Login frame = new Admin_Login();

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN TO FIRE ALARM DASH BOARD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(58, 33, 504, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(123, 175, 114, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(123, 275, 114, 20);
		contentPane.add(lblNewLabel_2);
		
		textUN = new JTextField();
		textUN.setBounds(284, 175, 170, 26);
		contentPane.add(textUN);
		textUN.setColumns(10);
		
		textPW = new JPasswordField();
		textPW.setBounds(284, 275, 170, 26);
		contentPane.add(textPW);
		
		
		
		JButton loginBTN = new JButton("LOG IN");
		loginBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String UserName = textUN.getText();
				String password = textPW.getText();
				
				if(UserName.contains("Admin")  && password.contains("admin@123"))
				{
					Client_TempDashBord dashbord = new Client_TempDashBord();
					dashbord.New_UI_Main();
					frame.setVisible(false);
					
					
				}
				else 
				{
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"SORRY INVALID");
				
				}
			}
		});
		loginBTN.setForeground(SystemColor.menu);
		loginBTN.setBackground(SystemColor.textHighlight);
		loginBTN.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginBTN.setBounds(123, 374, 344, 40);
		contentPane.add(loginBTN);
		
		JButton resetBTN = new JButton("RESET");
		resetBTN.setForeground(SystemColor.menu);
		resetBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textUN.setText(null);
				textPW.setText(null);
			}
		});
		resetBTN.setFont(new Font("Tahoma", Font.BOLD, 18));
		resetBTN.setBackground(SystemColor.textHighlight);
		resetBTN.setBounds(123, 443, 344, 40);
		contentPane.add(resetBTN);
	}
}
