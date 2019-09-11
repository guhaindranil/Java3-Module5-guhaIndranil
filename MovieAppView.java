package module5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;


public class MovieAppView extends JFrame{
	
	private JLabel     labelID = new JLabel("ID");
	private JTextField textID = new JTextField();
	private JLabel     labelName = new JLabel("Movie Name");
	private JTextField textName = new JTextField();
	private JLabel     labelRating = new JLabel("Rating 1 to 10");
	private JTextField textRating = new JTextField();
	private JLabel     labelDesc = new JLabel("Description");
	private JTextField textDesc = new JTextField();
	private JButton buttonAdd = new JButton("Insert");
	private JButton buttonRef = new JButton("Refresh");
	
	
	MovieResultSetTableModel model = new MovieResultSetTableModel(); 
	
	MovieAppView() {
		
	this.setLayout(null);
	
	this.setSize(900,400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JTable jtbl = new JTable(model);
	jtbl.setRowHeight(30);
	labelID.setBounds(20,220,100,25);	
	textID.setBounds(130,220,255,25);
	labelName.setBounds(20,250,100,25);	
	textName.setBounds(130,250,255,25);
	labelRating.setBounds(20,280,100,25);	
	textRating.setBounds(130,280,255,25);
	labelDesc.setBounds(20,310,100,25);	
	textDesc.setBounds(130,310,255,25);
	
	buttonAdd.setBounds(20,340,100,25);
	buttonRef.setBounds(130,340,100,25);
	
	JScrollPane pg = new JScrollPane(jtbl);
	pg.setBounds(0,0,900,220);
	this.add(pg);
	this.add(labelID);
	this.add(labelName);
	this.add(labelRating);
	this.add(labelDesc);
	this.add(textID);
	this.add(textName);
	this.add(textRating);
	this.add(textDesc);
	this.add(buttonAdd);
	this.add(buttonRef);
	
    
    }
	
	public int getID() {
		return Integer.parseInt(this.textID.getText());
		
	}
	
	public String getMovieName() {
		return this.textName.getText();
		
	}
	
	public int getRating() {
		return Integer.parseInt(this.textRating.getText());
		
	}
	
	public String getDesc() {
		return this.textDesc.getText();
		
	}
	
	void buttonAddListener(ActionListener listenForAddButton) {
		this.buttonAdd.addActionListener(listenForAddButton);
	}
	
	void buttonRefListener(ActionListener listenForRefButton) {
		this.buttonRef.addActionListener(listenForRefButton);
	}
	
	
}
	