import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;



import newpack.AllData;
import java.awt.Font;
import java.awt.SystemColor;

public class Client_TempDashBord {

	public static JFrame frame;
	private ClientMain clientMain = new ClientMain();
	private JTable table;
	private Timer timer;
	ArrayList<AllData> initialAlertList;

	public static void New_UI_Main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_TempDashBord window = new Client_TempDashBord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Client_TempDashBord() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    table = executeTable();
	    frame.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
	    frame.getContentPane().add(table, BorderLayout.CENTER);
	    
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setTitle("FIRE ALARM DATA");
	    refreshMYTimer();

	JButton btnAddSensor = new JButton("ADD");
	btnAddSensor.setBackground(SystemColor.textHighlight);
	btnAddSensor.setForeground(SystemColor.text);
	btnAddSensor.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnAddSensor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			AddMoreDevices AddBtn = new AddMoreDevices();
			AddBtn.AddSensor();
		}
	});
	frame.getContentPane().add(btnAddSensor, BorderLayout.SOUTH);
    
}

	public JTable executeTable(  ) {
		
		initialAlertList = new ArrayList<AllData>();
	    Object[] columns = new String[] {
	           
	            "ID" , "DEVICE ID", "DEVICE STATUS", "DEVICE FLOOR", "DEVICE ROOM", "SMOKE LEVEL" ,"CO2 LEVEL"
	    };

	    ArrayList<AllData> arrayList = ClientMain.TempAdd_Grid();

	    Object[][] data = new Object[arrayList.size()][7];
	    for(int i = 0; i < arrayList.size(); i++) {
	        data[i][0] = arrayList.get(i).getId();
	        data[i][1] = arrayList.get(i).getDevice_id();
	        data[i][2] = arrayList.get(i).getDevice_status();
	        data[i][3] = arrayList.get(i).getDevice_floor();
	        data[i][4] = arrayList.get(i).getDevice_room();
	        data[i][5] = arrayList.get(i).getDevice_smoke();
	        data[i][6] = arrayList.get(i).getDevice_co2();
	        
	        if( (arrayList.get(i).getDevice_co2() >= 5) || (arrayList.get(i).getDevice_smoke() >= 5)) {
	        	initialAlertList.add(arrayList.get(i));
	        }	     
	    }

	    table = new JTable(data,columns) {
	    	
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
			@Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				
                Component component = super.prepareRenderer(renderer, row, col);
                int co2Level = (int) getValueAt(row, 6);
                int smokeLevel = (int) getValueAt(row, 5);

                if ( (co2Level >= 5) || (smokeLevel >= 5) ) {
                	
                    component.setBackground(Color.RED);
                    component.setForeground(Color.BLACK);
                    
                } else {
    
                	component.setBackground(Color.YELLOW);
                    component.setForeground(Color.BLACK);
                }
                return component;
            }
	    	
	    };

	    frame.setTitle("FIRE ALARM DATA");
	    return table;
	}

		public void refreshMYTimer() {
		 
			timer = new Timer(0, new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				   
				initialAlertList = new ArrayList<AllData>();

			    Object[] columns = new String[] {
			            
			            "ID" , "DEVICE ID", "DEVICE STATUS", "DEVICE FLOOR", "DEVICE ROOM", "SMOKE LEVEL" ,"CO2 LEVEL"
			    };

			    ArrayList<AllData> arrayList = ClientMain.TempAdd_Grid();

			    Object[][] data = new Object[arrayList.size()][7];

			    for(int i = 0; i < arrayList.size(); i++) {
			        data[i][0] = arrayList.get(i).getId();
			        data[i][1] = arrayList.get(i).getDevice_id();
			        data[i][2] = arrayList.get(i).getDevice_status();
			        data[i][3] = arrayList.get(i).getDevice_floor();
			        data[i][4] = arrayList.get(i).getDevice_room();
			        data[i][5] = arrayList.get(i).getDevice_smoke();
			        data[i][6] = arrayList.get(i).getDevice_co2();
			        
			        if( (arrayList.get(i).getDevice_co2() >= 5) || (arrayList.get(i).getDevice_smoke() >= 5)) {
			        	initialAlertList.add(arrayList.get(i));
			        }	     
			    }
			    
				
				
				    
				TableModel tableModel = new DefaultTableModel(data, columns);
			      
				table.setDefaultRenderer(Object.class, (TableCellRenderer) new DefaultTableCellRenderer(){
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
			                
						super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
							return this;
						}   
				});
			        
			  
				table.removeAll();
				table.setModel(tableModel);
				System.out.println("Retrieving New Data!");
				   
			}});

			timer.setDelay(10000); // 10S Refresh
			timer.start();
		}
			


}
