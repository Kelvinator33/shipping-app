package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import items.item;
import methods.*;
//Kelvin Amoah
public class gui implements ActionListener{
	//create variables needed for gui
		private JLabel label;
		private JFrame frame;
		private JPanel panel;
		private JButton addproduct;
		private JButton checkout;
		private JPanel lp;
		private JScrollPane scroll;
		private JFormattedTextField quant;
		private JTextArea output;
		private JComboBox<String> options;
		private JLabel l1;
		private JLabel l2;
		private Calculation c;
		private ArrayList<item> Aproducts= new ArrayList<>();
		//method to check if a number was entered in the quantity text area
		public boolean ValidNumber(String input) {
	        try {
	            Double.parseDouble(input);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
		
		
	gui(){
		//constructor for creating gui
		
		//store the available products for shipping
		Aproducts.addAll(Arrays.asList(
			    new item("laptop"),
			    new item("mouse"),
			    new item("Desktop"),
			    new item("lcdscreens")
			));
		//initialize panel,label,frame,text area, image icon and buttons
		frame=new JFrame();
		panel=new JPanel();
		label=new JLabel("Number of clicks:0");
		addproduct=new JButton("Add Product");
		lp=new JPanel();
		options=new JComboBox<>();
		l1=new JLabel();
		l2=new JLabel();
		quant=new JFormattedTextField();
		output=new JTextArea();
		checkout=new JButton("Checkout");
		c=new Calculation();
		ImageIcon image= new ImageIcon("shipping3.png");
		scroll = new JScrollPane(output);
		
		//create frame for the gui
		frame.setSize(750, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Kelvin's Shipping");
		frame.setResizable(true);
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(new Color(214,213,244));
		
		//set title label
		label.setText("WELCOME TO KELVIN SHIPPING.CO");
		label.setIcon(image);//add image to label
		label.setHorizontalTextPosition(JLabel.CENTER);//set horizontal position of text to the center of image
		label.setVerticalTextPosition(JLabel.TOP);// set vertical position of text to the top of image
		label.setForeground(new Color(114,113,144));//set color of text 
		label.setFont(new Font("Times New Roman", Font.BOLD,40));//set font style and font size
		label.setBackground(Color.black);//set background color of text
		label.setVerticalAlignment(JLabel.TOP);//set vertical position of icon and text;
		label.setHorizontalAlignment(JLabel.CENTER);//set horizontal position of icon and text;
		label.setBorder(BorderFactory.createEmptyBorder());
		//set the panel for the labels and buttons
		lp.setBackground(new Color(214,213,244));
		lp.setBorder(BorderFactory.createEmptyBorder());
		lp.setOpaque(true);
		lp.setLayout(new BoxLayout(lp,BoxLayout.Y_AXIS));
		
		//top label for lp panel
		l1.setText("Products: ");
		l1.setHorizontalTextPosition(JLabel.CENTER);//set horizontal position of text to the center of image
		l1.setVerticalTextPosition(JLabel.TOP);
		
		
		//combobox for items available (Aproducts)
		options.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));

		options.setPreferredSize(new Dimension(150, 25));;
		for(item i:Aproducts) {
			options.addItem(i.getItemName());
		}
		
		//label to display quantity text
		l2.setText("Quantity: ");
		l2.setHorizontalTextPosition(JLabel.CENTER);//set horizontal position of text to the center of image
		l2.setVerticalTextPosition(JLabel.TOP);
		
		//text area to accept quantity input
		quant.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
		quant.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

		
		//button for adding product details and quantity
		addproduct.setHorizontalAlignment(JButton.CENTER);;
		addproduct.setFocusable(false);
		addproduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//check if the input is a number and if it is not display the error message
				if(!ValidNumber(quant.getText())) {
					JOptionPane.showMessageDialog(frame, "Invalid input!","Error",
	                        JOptionPane.ERROR_MESSAGE);
					quant.requestFocusInWindow();
				}
				//make sure an item is selected
				if(options.getSelectedIndex()!=-1) {
					//if the quantity text area is not empty
					//check if the number entered is greater than zero
					//if it is add the itemselected and its quantity
					//display the item info
					//clear the quantity text area
					//if input is not greater then display error message
					//if quantity text area is empty display error message
					if(!quant.getText().isEmpty()) {
						if(Integer.parseInt(quant.getText())>0) {
							c.addItems(Aproducts.get(options.getSelectedIndex()));
							c.addOrder(Integer.parseInt(quant.getText()));
							output.setText(c.printItem());
							quant.setText("");
						}else {
	                        JOptionPane.showMessageDialog( quant, "Quantity must be a positive integer.");
	                    }
					}else {
	                    JOptionPane.showMessageDialog(quant, "Please enter a quantity.");
	                }
				}
			}
			
		}
				
				
				
				
				);
		
		//button for prining order
		checkout.setFocusable(false);
		checkout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//if the items variable is not empty
				//display the users order
				//else display error message
				if(!c.getItems().isEmpty()) {
					output.setText("" );
					output.setText(c.printOrder());
					c.clear();
				}else {
					JOptionPane.showMessageDialog(output, "Basket is empty please add the item for shipment");
				}
			}
			
		});
		
		//main panel for frame
		panel.setBackground(new Color(214,213,244));
		panel.setPreferredSize(new Dimension(frame.getWidth(), 100));
		panel.setLayout(new BorderLayout( ));
		
	
		
		
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);




		
		
		
		
		
		
		
		frame.add(panel);
		lp.add(l1);
		lp.add(options);
		lp.add(l2);
		lp.add(quant);
		lp.add(addproduct);
		lp.add(scroll);
		lp.add(scroll);
		lp.add(checkout);
		panel.add(lp, BorderLayout.CENTER);
		panel.add(label, BorderLayout.NORTH);
		frame.setVisible(true);
	
	}
	public static void main(String[] args) {
		//run gui
		new gui();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
