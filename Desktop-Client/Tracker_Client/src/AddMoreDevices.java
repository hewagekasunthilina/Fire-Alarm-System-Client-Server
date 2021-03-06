import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddMoreDevices {

	private JFrame frame;
	private JTextField roomNo;
	private JTextField floorNo;
	private ClientMain clientMain = new ClientMain();
	private JTextField deviceId;

	public static void AddSensor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMoreDevices window = new AddMoreDevices();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AddMoreDevices() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 687, 567);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		roomNo = new JTextField();
		roomNo.setColumns(10);
		
		floorNo = new JTextField();
		floorNo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Floor Number");
		
		JLabel lblNewLabel_1 = new JLabel("Room Number");
		
		//action on add sensor button pushed
		JButton btnAddSensor = new JButton("Add");
		btnAddSensor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clientMain.AddMore(deviceId.getText(),roomNo.getText(), floorNo.getText());
				frame.dispose();
			}
		});
		
		JLabel lblDeviceId = new JLabel("Device ID");
		
		deviceId = new JTextField();
		deviceId.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(floorNo, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(148)
							.addComponent(btnAddSensor, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
									.addGap(50))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDeviceId, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
									.addGap(48)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deviceId, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(roomNo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
					.addGap(185))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblDeviceId, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(deviceId, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(roomNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(floorNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(btnAddSensor, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
