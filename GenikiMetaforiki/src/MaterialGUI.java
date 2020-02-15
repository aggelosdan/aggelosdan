import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

//import ContainerFrame.ButtonListener1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MaterialGUI extends JFrame{
	private JPanel mainPanel = new JPanel();
	private JPanel panelTop = new JPanel(new GridLayout(3, 1));
	private JPanel panelCen = new JPanel(new GridLayout(3, 1));
	private JPanel panelBot = new JPanel();
	private JLabel materialCodeLbl = new JLabel("Material Code: ");
	private JLabel distanceLbl = new JLabel("Distance to: ");
	private JLabel weightLbl = new JLabel("Weight: ");
	private JTextField codeField = new JTextField(10);
	private JTextField distanceField = new JTextField(5);
	private JTextField weightField = new JTextField(5);
	//private JCheckBox food = new JCheckBox("FOOD?");
	private JCheckBox island= new JCheckBox("FOR_ISLAND?");
	private JButton foodButton = new JButton("Add Food");
	private JButton noFoodButton = new JButton("Add NoFood");
	private JList poolList = new JList();
	private ArrayList<Pool> trucks;

	public MaterialGUI(ArrayList<Pool> trucks) {
		
		this.trucks = trucks;
		panelTop.add(materialCodeLbl);
		panelTop.add(codeField);
		panelTop.add(distanceLbl);
		panelTop.add(distanceField);		
		panelTop.add(weightLbl);
		panelTop.add(weightField);
		//panelCen.add(food);
		panelCen.add(island);
		panelCen.add(poolList);
		panelBot.add(foodButton);
		panelBot.add(noFoodButton);
		
		
		DefaultListModel listModel = new DefaultListModel();
		
		for(Pool t: trucks) {
			String name = t.getNoOfTruck();
			listModel.addElement(name);
		}
		
		mainPanel.add(panelTop, BorderLayout.NORTH);
		mainPanel.add(panelCen, BorderLayout.CENTER);
		mainPanel.add(panelBot, BorderLayout.SOUTH);
		
		poolList.setModel(listModel);
		
		this.setContentPane(mainPanel);
		
		ButtonListener1 listener1 = new ButtonListener1();
		foodButton.addActionListener(listener1);
		noFoodButton.addActionListener(listener1);
		
		this.pack();
		this.setLocation(200, 200);
		this.setVisible(true);
		this.setTitle("MaterialGUI");	
	}
	
	class ButtonListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == foodButton) {
				String code = codeField.getText();
				Double kilomet = Double.parseDouble(distanceField.getText());
				Double klg = Double.parseDouble(weightField.getText());
				boolean f = true;
				boolean destin = island.isSelected();
				
				String selectedPoolText = (String)poolList.getSelectedValue();
			
				codeField.setText("");
				distanceField.setText("");
				weightField.setText("");
			
				for(Pool t : trucks) {
					if(t.getNoOfTruck() == selectedPoolText) 
						t.addTruck(new Food(code, kilomet, klg, destin), t);
				}
			}
			else{
				String code = codeField.getText();
				Double kilomet = Double.parseDouble(distanceField.getText());
				Double klg = Double.parseDouble(weightField.getText());
				boolean f = false;
				boolean destin = island.isSelected();
					
				String selectedPoolText = (String)poolList.getSelectedValue();
				
				codeField.setText("");
				distanceField.setText("");
				weightField.setText("");
				
				for(Pool t : trucks) {
					if(t.getNoOfTruck() == selectedPoolText) 
						t.addTruck(new NoFood(code, kilomet, klg, destin), t);					
				}
			}
		}
	}
}
