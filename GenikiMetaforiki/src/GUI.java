import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class GUI extends JFrame{
	private JPanel panel = new JPanel();
	private JButton materialButton = new JButton("Add Material");
	private JButton chargeButton = new JButton("Calculate Charge");
	private JList poolList = new JList();
	private JTextField chargeField = new JTextField("Total Charge");
	private ArrayList<Pool> trucks = new ArrayList<Pool>();
	
	public GUI() {
		
		trucks.add(new Pool("AL01", 1000.00, true));
		trucks.add(new Pool("AL02", 800.00, true));
		trucks.add(new Pool("AI03", 1000.00, false));
		trucks.add(new Pool("AI04", 800.00, false));
		
		panel.add(materialButton);
		panel.add(chargeButton);
		panel.add(poolList);
		panel.add(chargeField);
		
		DefaultListModel listModel = new DefaultListModel();
		
		for(Pool t: trucks) {
			String noOfTruck = t.getNoOfTruck();
			listModel.addElement(noOfTruck);
		}
		
		poolList.setModel(listModel);
		
		this.setContentPane(panel);
		
		ButtonListener1 listener1 = new ButtonListener1();
		ButtonListener2 listener2 = new ButtonListener2();
		
		materialButton.addActionListener(listener1);
		chargeButton.addActionListener(listener2);
		
		this.setSize(300, 200);
		this.setVisible(true);
		this.setTitle("GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	class ButtonListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new MaterialGUI(trucks);	
		}
		
	}
	
	class ButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String selectedPoolText = (String)poolList.getSelectedValue();
			double charge;
			for(Pool t : trucks) {
				if(t.getNoOfTruck() == selectedPoolText) {
					charge = t.getTotalCharge();
					chargeField.setText(Double.toString(charge));
				}
			}
		}
		
	}
}
