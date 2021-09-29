import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class KoreaCuisine extends JFrame{
	private JLabel background, customerName, contactNumber;
	private JButton Reset, Print, Calculate;
	private JButton btnNewButton;
	private JTextArea area1;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JTextField tfCustomerName, tfContactNumber;
	private JTextField txtAppetizer;	
	private JTextField txtEntree;
	private JTextField txtDessert;
	private JTextField txtWine;
	private JTextField txtSoftDrinks;
	private JTextField txtOptions;	
	private JTextField a1q;
	private JTextField a2q;
	private JTextField a3q;
	private JTextField e1q;
	private JTextField e2q;
	private JTextField e3q;
	private JTextField e4q;
	private JTextField d1q;
	private JTextField d2q;
	private JTextField w1q;
	private JTextField w2q;
	private JTextField w3q;
	private JTextField s1q;
	private JTextField s2q;
	private JTextField txtAllPricesAre;
	
	private double subTotal, tax, fee, total;
	private double[] itemsCost = new double[14];
	
	private double taxRate = 6.25;
	
	private double a1Price = 4.99;
	private double a2Price = 5.99;
	private double a3Price = 6.99;
	private double e1Price = 7.99;
	private double e2Price = 7.99;
	private double e3Price = 9.99;
	private double e4Price = 10.99;
	private double d1Price = 5.99;
	private double d2Price = 5.95;
	private double w1Price = 8.00;
	private double w2Price = 10.00;
	private double w3Price = 30.00;
	private double s1Price = 3.99;
	private double s2Price = 1.99;

	
	public KoreaCuisine() {
		
		// Set up size, title and background for our menu window	
		setTitle("Charming Korean Restaurant");
		setSize(700, 700);
		getContentPane().setLayout(null);
		
		ImageIcon img = new ImageIcon("koreaRestaurant.jpeg");
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, 700, 700);
		getContentPane().add(background);
		
		
		// BACK Button
		btnNewButton = new JButton("BACK");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RestaurantSelection();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnNewButton.setBounds(18, 6, 118, 30);
		background.add(btnNewButton);
		
		
		// Price currency information 
		txtAllPricesAre = new JTextField();
		txtAllPricesAre.setFont(new Font("Lao MN", Font.BOLD | Font.ITALIC, 15));
		txtAllPricesAre.setHorizontalAlignment(SwingConstants.CENTER);
		txtAllPricesAre.setText("All Prices Are In USD For Your Information");
		txtAllPricesAre.setBounds(265, 8, 414, 26);
		background.add(txtAllPricesAre);
		txtAllPricesAre.setColumns(10);
		txtAllPricesAre.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		// Set up border line
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		
		// Add information fields "Customer Name" and "Contact Number"
		customerName = new JLabel("  Customer Name ");
		background.add(customerName);
		customerName.setBounds(19, 57, 125, 30);
		customerName.setBorder(blackline);
		customerName.setBackground(Color.WHITE);
		customerName.setOpaque(true);
		tfCustomerName = new JTextField();
		background.add(tfCustomerName);
		tfCustomerName.setBounds(153, 57, 200, 30);
		tfCustomerName.setBorder(blackline);
			
		contactNumber = new JLabel("  Contact Number ");
		background.add(contactNumber);
		contactNumber.setBounds(19, 99, 125, 30);
		contactNumber.setBorder(blackline);
		contactNumber.setBackground(Color.WHITE);
		contactNumber.setOpaque(true);
		tfContactNumber = new JTextField();
		// Don't allow customer to enter characters into the "Contact Number" field
		tfContactNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		background.add(tfContactNumber);
		tfContactNumber.setBounds(153, 99, 200, 30);
		tfContactNumber.setBorder(blackline);
		
		
		// Add "Reset", "Calculate" and "Print" buttons
		Reset = new JButton("Reset");
		background.add(Reset);
		Reset.setBounds(399, 53, 80, 40);
		Calculate = new JButton("Calculate");
		background.add(Calculate);
		Calculate.setBounds(487, 53, 80, 40);
		Print = new JButton("Print Receipt");
		background.add(Print);
		Print.setBounds(579, 53, 100, 40);
		
		
		// Add text area to record customer's order information
		area1 = new JTextArea();
		background.add(area1);
		area1.setBounds(393, 105, 301, 406);
		area1.setBorder(blackline);
		area1.setText("  Welcome to Charming Korean Restaurant!\n  What are on your mind today?\n (Please "
						+ "remember to enter the quantity \n to the box next to the item you selected)\n");
		
	
		
		// Set up the menu panel for foods selection
		JPanel panel = new JPanel();
		background.add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 143, 379, 303);
		panel.setLayout(null);

		
		// APPETIZER SECTION
		txtAppetizer = new JTextField();
		txtAppetizer.setHorizontalAlignment(SwingConstants.CENTER);
		txtAppetizer.setText("Appetizer");
		txtAppetizer.setBounds(0, 17, 90, 46);
		panel.add(txtAppetizer);
		txtAppetizer.setColumns(10);
		
		// First appetizer
		JCheckBox a1 = new JCheckBox("Pajeon (4.99)");
		a1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a1.isSelected()) {
					a1q.setEnabled(true);
					a1q.requestFocus();
					a1q.setText("");
				} else {
					a1q.setEnabled(false);
					a1q.setText("0");
				}
			}
		});
		a1.setBounds(94, 6, 218, 23);
		panel.add(a1);
		
		a1q = new JTextField();
		a1q.setHorizontalAlignment(SwingConstants.CENTER);
		a1q.setEnabled(false);
		a1q.setText("0");
		a1q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		a1q.setBounds(324, 5, 49, 26);
		panel.add(a1q);
		a1q.setColumns(10);
		
		
		// Second appetizer
		JCheckBox a2 = new JCheckBox("Cucumber K Salad (5.99)");
		a2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a2.isSelected()) {
					a2q.setEnabled(true);
					a2q.requestFocus();
					a2q.setText("");
				} else {
					a2q.setEnabled(false);
					a2q.setText("0");
				}
			}
		});
		a2.setBounds(94, 28, 190, 23);
		panel.add(a2);
		
		a2q = new JTextField();
		a2q.setEnabled(false);
		a2q.setHorizontalAlignment(SwingConstants.CENTER);
		a2q.setText("0");
		a2q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		a2q.setColumns(10);
		a2q.setBounds(324, 29, 49, 26);
		panel.add(a2q);
		
		
		// Third appetizer
		JCheckBox a3 = new JCheckBox("Dakgang Jeong (6.99)");
		a3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a3.isSelected()) {
					a3q.setEnabled(true);
					a3q.requestFocus();
					a3q.setText("");
				} else {
					a3q.setEnabled(false);
					a3q.setText("0");
				}
			}
		});
		a3.setBounds(94, 53, 180, 23);
		panel.add(a3);
		
		a3q = new JTextField();
		a3q.setEnabled(false);
		a3q.setHorizontalAlignment(SwingConstants.CENTER);
		a3q.setText("0");
		a3q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		a3q.setColumns(10);
		a3q.setBounds(324, 52, 49, 26);
		panel.add(a3q);
		
		
		// Create a line separator
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 75, 334, 12);
		panel.add(separator);
		
		
		// ENTREE SECTION
		txtEntree = new JTextField();
		txtEntree.setHorizontalAlignment(SwingConstants.CENTER);
		txtEntree.setText("Entree");
		txtEntree.setBounds(6, 133, 76, 26);
		panel.add(txtEntree);
		txtEntree.setColumns(10);
		
		
		// First entree
		JCheckBox e1_1 = new JCheckBox("Jap Chae Noodle (7.99)");
		e1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e1_1.isSelected()) {
					e1q.setEnabled(true);
					e1q.requestFocus();
					e1q.setText("");
				} else {
					e1q.setEnabled(false);
					e1q.setText("0");
				}
			}
		});
		e1_1.setBounds(94, 88, 190, 23);
		panel.add(e1_1);
		
		e1q = new JTextField();
		e1q.setEnabled(false);
		e1q.setHorizontalAlignment(SwingConstants.CENTER);
		e1q.setText("0");
		e1q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		e1q.setColumns(10);
		e1q.setBounds(324, 87, 49, 26);
		panel.add(e1q);
		
		
		// Second entree
		JCheckBox e2 = new JCheckBox("Tokbukki (7.99)");
		e2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e2.isSelected()) {
					e2q.setEnabled(true);
					e2q.requestFocus();
					e2q.setText("");
				} else {
					e2q.setEnabled(false);
					e2q.setText("0");
				}
			}
		});
		e2.setBounds(94, 123, 218, 23);
		panel.add(e2);
		
		e2q = new JTextField();
		e2q.setEnabled(false);
		e2q.setHorizontalAlignment(SwingConstants.CENTER);
		e2q.setText("0");
		e2q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		e2q.setColumns(10);
		e2q.setBounds(324, 122, 49, 26);
		panel.add(e2q);
		
		
		// Third entree
		JCheckBox e3 = new JCheckBox("Army Soup (9.99)");
		e3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e3.isSelected()) {
					e3q.setEnabled(true);
					e3q.requestFocus();
					e3q.setText("");
				} else {
					e3q.setEnabled(false);
					e3q.setText("0");
				}
			}
		});
		e3.setBounds(94, 158, 203, 23);
		panel.add(e3);
		
		e3q = new JTextField();
		e3q.setEnabled(false);
		e3q.setHorizontalAlignment(SwingConstants.CENTER);
		e3q.setText("0");
		e3q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		e3q.setColumns(10);
		e3q.setBounds(324, 157, 49, 26);
		panel.add(e3q);
		
		
		// Fourth entree
		JCheckBox e4 = new JCheckBox("Pork Chop (10.99)");
		e4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e4.isSelected()) {
					e4q.setEnabled(true);
					e4q.requestFocus();
					e4q.setText("");
				} else {
					e4q.setEnabled(false);
					e4q.setText("0");
				}
			}
		});
		e4.setBounds(94, 193, 228, 23);
		panel.add(e4);
		
		e4q = new JTextField();
		e4q.setEnabled(false);
		e4q.setHorizontalAlignment(SwingConstants.CENTER);
		e4q.setText("0");
		e4q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		e4q.setColumns(10);
		e4q.setBounds(324, 192, 49, 26);
		panel.add(e4q);
		
		
		// Line separator
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 220, 334, 12);
		panel.add(separator_1);
		
		
		// DESSERT SECTION 
		txtDessert = new JTextField();
		txtDessert.setHorizontalAlignment(SwingConstants.CENTER);
		txtDessert.setText("Dessert");
		txtDessert.setBounds(6, 244, 81, 26);
		panel.add(txtDessert);
		txtDessert.setColumns(10);
		
		
		// First dessert
		JCheckBox d1 = new JCheckBox("Hotteok (5.99)");
		d1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (d1.isSelected()) {
					d1q.setEnabled(true);
					d1q.requestFocus();
					d1q.setText("");
				} else {
					d1q.setEnabled(false);
					d1q.setText("0");
				}
			}
		});
		d1.setBounds(94, 232, 218, 23);
		panel.add(d1);
		
		d1q = new JTextField();
		d1q.setEnabled(false);
		d1q.setHorizontalAlignment(SwingConstants.CENTER);
		d1q.setText("0");
		d1q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		d1q.setColumns(10);
		d1q.setBounds(324, 231, 49, 26);
		panel.add(d1q);
		
		
		// Second dessert
		JCheckBox d2 = new JCheckBox("Sweet Rice Balls (5.95)");
		d2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (d2.isSelected()) {
					d2q.setEnabled(true);
					d2q.requestFocus();
					d2q.setText("");
				} else {
					d2q.setEnabled(false);
					d2q.setText("0");
				}
			}
		});
		d2.setBounds(94, 260, 203, 23);
		panel.add(d2);
		
		d2q = new JTextField();
		d2q.setEnabled(false);
		d2q.setHorizontalAlignment(SwingConstants.CENTER);
		d2q.setText("0");
		d2q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		d2q.setColumns(10);
		d2q.setBounds(324, 259, 49, 26);
		panel.add(d2q);
		
		
		// Create a Drink Panel
		JPanel panel_1 = new JPanel();
		background.add(panel_1);
		panel_1.setBorder(new LineBorder(Color.BLACK, 1, true));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(6, 461, 379, 128);
		panel_1.setLayout(null);
		
		
		// WINE SECTION
		txtWine = new JTextField();
		txtWine.setHorizontalAlignment(SwingConstants.CENTER);
		txtWine.setText("Wine");
		txtWine.setBounds(10, 15, 130, 42);
		panel_1.add(txtWine);
		txtWine.setColumns(10);
		
		
		// First wine
		JCheckBox w1 = new JCheckBox("Soju (8.00)");
		w1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (w1.isSelected()) {
					w1q.setEnabled(true);
					w1q.requestFocus();
					w1q.setText("");
				} else {
					w1q.setEnabled(false);
					w1q.setText("0");
				}
			}
		});
		w1.setBounds(149, 3, 151, 23);
		panel_1.add(w1);
		
		w1q = new JTextField();
		w1q.setEnabled(false);
		w1q.setHorizontalAlignment(SwingConstants.CENTER);
		w1q.setText("0");
		w1q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		w1q.setColumns(10);
		w1q.setBounds(319, 2, 49, 26);
		panel_1.add(w1q);
		
		
		// Second wine
		JCheckBox w2 = new JCheckBox("White Rice (10.00)");
		w2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (w2.isSelected()) {
					w2q.setEnabled(true);
					w2q.requestFocus();
					w2q.setText("");
				} else {
					w2q.setEnabled(false);
					w2q.setText("0");
				}
			}
		});
		w2.setBounds(149, 21, 151, 23);
		panel_1.add(w2);
		
		w2q = new JTextField();
		w2q.setEnabled(false);
		w2q.setHorizontalAlignment(SwingConstants.CENTER);
		w2q.setText("0");
		w2q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		w2q.setColumns(10);
		w2q.setBounds(319, 20, 49, 26);
		panel_1.add(w2q);
		
		
		// Third wine
		JCheckBox w3 = new JCheckBox("Sake (30.00)");
		w3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (w3.isSelected()) {
					w3q.setEnabled(true);
					w3q.requestFocus();
					w3q.setText("");
				} else {
					w3q.setEnabled(false);
					w3q.setText("0");
				}
			}
		});
		w3.setBounds(149, 40, 158, 23);
		panel_1.add(w3);
		
		w3q = new JTextField();
		w3q.setEnabled(false);
		w3q.setHorizontalAlignment(SwingConstants.CENTER);
		w3q.setText("0");
		w3q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		w3q.setColumns(10);
		w3q.setBounds(319, 39, 49, 26);
		panel_1.add(w3q);
		
		
		// Line separator
		separator_2 = new JSeparator();
		separator_2.setBounds(0, 69, 368, 12);
		panel_1.add(separator_2);
		
		
		// SOFTDRINK SECTION
		txtSoftDrinks = new JTextField();
		txtSoftDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoftDrinks.setText("Soft Drinks");
		txtSoftDrinks.setBounds(10, 82, 130, 33);
		panel_1.add(txtSoftDrinks);
		txtSoftDrinks.setColumns(10);
		
		
		// First Soft Drink
		JCheckBox s1 = new JCheckBox("Yogurt (3.99)");
		s1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s1.isSelected()) {
					s1q.setEnabled(true);
					s1q.requestFocus();
					s1q.setText("");
				} else {
					s1q.setEnabled(false);
					s1q.setText("0");
				}
			}
		});
		s1.setBounds(149, 81, 151, 23);
		panel_1.add(s1);
		
		s1q = new JTextField();
		s1q.setEnabled(false);
		s1q.setHorizontalAlignment(SwingConstants.CENTER);
		s1q.setText("0");
		s1q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		s1q.setColumns(10);
		s1q.setBounds(319, 79, 49, 26);
		panel_1.add(s1q);
		
		
		// Second Soft Drink
		JCheckBox s2 = new JCheckBox("Water (1.99)");
		s2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s2.isSelected()) {
					s2q.setEnabled(true);
					s2q.requestFocus();
					s2q.setText("");
				} else {
					s2q.setEnabled(false);
					s2q.setText("0");
				}
			}
		});
		s2.setBounds(149, 102, 120, 23);
		panel_1.add(s2);
		
		s2q = new JTextField();
		s2q.setEnabled(false);
		s2q.setHorizontalAlignment(SwingConstants.CENTER);
		s2q.setText("0");
		s2q.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char aChar = e.getKeyChar();
				if ( !(Character.isDigit(aChar)) || aChar == KeyEvent.VK_BACK_SPACE || aChar == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		s2q.setColumns(10);
		s2q.setBounds(319, 102, 49, 26);
		panel_1.add(s2q);
		
		

		// Create a panel for SERVICE OPTIONS
		JPanel panel_2 = new JPanel();
		background.add(panel_2);
		panel_2.setBorder(new LineBorder(Color.BLACK, 1, true));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(6, 598, 379, 49);
		panel_2.setLayout(null);
		
		txtOptions = new JTextField();
		txtOptions.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		txtOptions.setHorizontalAlignment(SwingConstants.CENTER);
		txtOptions.setText("SERVICE OPTIONS");
		txtOptions.setBounds(6, 3, 140, 45);
		panel_2.add(txtOptions);
		txtOptions.setColumns(10);
		
		// First service option
		JRadioButton r1 = new JRadioButton("Dine in");
		r1.setBounds(150, 16, 91, 23);
		panel_2.add(r1);
		
		// Second service option
		JRadioButton r2 = new JRadioButton("Take out");
		r2.setBounds(253, 16, 110, 23);
		panel_2.add(r2);
		
		// Add 2 service options to button group
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		
		
		// Add panel for check-out section
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(399, 523, 301, 124);
		panel_3.setBorder(new LineBorder(Color.BLACK, 1, true));
		background.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel subTotalLabel = new JLabel("Subtotal");
		subTotalLabel.setBackground(Color.WHITE);
		subTotalLabel.setBounds(28, 16, 91, 25);
		panel_3.add(subTotalLabel);
		
		JLabel subTotaltf = new JLabel("");
		subTotaltf.setBounds(189, 20, 61, 16);
		panel_3.add(subTotaltf);
		
		JLabel taxLabel = new JLabel("Tax (6.25%)");
		taxLabel.setBackground(new Color(238, 238, 238));
		taxLabel.setBounds(28, 41, 78, 16);
		panel_3.add(taxLabel);
		
		JLabel taxtf = new JLabel("");
		taxtf.setBounds(189, 41, 61, 16);
		panel_3.add(taxtf);
		
		JLabel feeLabel = new JLabel("Service Fee");
		feeLabel.setBounds(28, 63, 78, 16);
		panel_3.add(feeLabel);
		
		JLabel feetf = new JLabel("");
		feetf.setBounds(189, 63, 61, 16);
		panel_3.add(feetf);
		
		JLabel totalLabel = new JLabel("Total");
		totalLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		totalLabel.setBounds(28, 91, 61, 16);
		panel_3.add(totalLabel);
	
		JLabel totaltf = new JLabel("");
		totaltf.setBounds(189, 91, 61, 16);
		panel_3.add(totaltf);
		
		
		// Add information button
		JButton btnNewButton_1 = new JButton("?");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Information();
			}
		});
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(104, 63, 18, 17);
		panel_3.add(btnNewButton_1);
		
		
		
		// Add function for Print button
		Print.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					area1.print();
				} catch (PrinterException e1) { 
					System.out.println("Printer Not Found!!");
				}
			}	
		});
		
		
		
		// Add function for Reset button
		Reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfContactNumber.setText(null);
				tfCustomerName.setText(null);
				area1.setText("  Welcome to Charming Korean Restaurant!\n  What are on your mind today?\n (Please "
						+ "remember to enter the quantity \n to the box next to the item you selected)\n");
				
				a1.setSelected(false);
				a1q.setEnabled(false);
				a1q.setText("0");
				
				a2.setSelected(false);
				a2q.setEnabled(false);
				a2q.setText("0");
				
				a3.setSelected(false);
				a3q.setEnabled(false);
				a3q.setText("0");
				
				e1_1.setSelected(false);
				e1q.setEnabled(false);
				e1q.setText("0");
				
				e2.setSelected(false);
				e2q.setEnabled(false);
				e2q.setText("0");
				
				e3.setSelected(false);
				e3q.setEnabled(false);
				e3q.setText("0");
				
				e4.setSelected(false);
				e4q.setEnabled(false);
				e4q.setText("0");
				
				d1.setSelected(false);
				d1q.setEnabled(false);
				d1q.setText("0");
				
				d2.setSelected(false);
				d2q.setEnabled(false);
				d2q.setText("0");
				
				w1.setSelected(false);
				w1q.setEnabled(false);
				w1q.setText("0");
				
				w2.setSelected(false);
				w2q.setEnabled(false);
				w2q.setText("0");
				
				w3.setSelected(false);
				w3q.setEnabled(false);
				w3q.setText("0");
				
				s1.setSelected(false);
				s1q.setEnabled(false);
				s1q.setText("0");
				
				s2.setSelected(false);
				s2q.setEnabled(false);
				s2q.setText("0");
				
				bg.clearSelection();
				
				subTotaltf.setText(null);
				taxtf.setText(null);
				feetf.setText(null);
				totaltf.setText(null);

				
				
			}	
		});
		

		
		// Add function for Calculate button
		Calculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(r1.isSelected() || r2.isSelected()) || 
						tfCustomerName.getText().equals("") || 
						tfContactNumber.getText().equals("")) {
					new Warning1();
				} else if ((a1.isSelected() && a1q.getText().equals("")) || 
						(a2.isSelected() && a2q.getText().equals("")) || 
						(a3.isSelected() && a3q.getText().equals("")) || 
						(e1_1.isSelected() && e1q.getText().equals("")) || 
						(e2.isSelected() && e2q.getText().equals("")) || 
						(e3.isSelected() && e3q.getText().equals("")) || 
						(e4.isSelected() && e4q.getText().equals("")) || 
						(d1.isSelected() && d1q.getText().equals("")) || 
						(d2.isSelected() && d2q.getText().equals("")) || 
						(w1.isSelected() && w1q.getText().equals("")) || 
						(w2.isSelected() && w2q.getText().equals("")) || 
						(w3.isSelected() && w3q.getText().equals("")) || 
						(s1.isSelected() && s1q.getText().equals("")) || 
						(s2.isSelected() && s2q.getText().equals(""))) {
					new Warning2();
				} else {
				
					area1.setText(area1.getText() + "\n Customer Name: " + tfCustomerName.getText()
												  + "\n Contact Number: " + tfContactNumber.getText() + "\n\n Your order includes: \n");
					
					if (a1.isSelected()) {
						area1.setText(area1.getText() + "\n - " + a1.getText() + " x " + a1q.getText());
					}
					
					if (a2.isSelected()) {
						area1.setText(area1.getText() + "\n - " + a2.getText() + " x " + a2q.getText());
					}
					
					if (a3.isSelected()) {
						area1.setText(area1.getText() + "\n - " + a3.getText() + " x " + a3q.getText());
					}
					
					if (e1_1.isSelected()) {
						area1.setText(area1.getText() + "\n - " + e1_1.getText() + " x " + e1q.getText());
					}
					
					if (e2.isSelected()) {
						area1.setText(area1.getText() + "\n - " + e2.getText() + " x " + e2q.getText());
					}
					
					if (e3.isSelected()) {
						area1.setText(area1.getText() + "\n - " + e3.getText() + " x " + e3q.getText());
					}
					
					if (e4.isSelected()) {
						area1.setText(area1.getText() + "\n - " + e4.getText() + " x " + e4q.getText());
					}
					
					if (d1.isSelected()) {
						area1.setText(area1.getText() + "\n - " + d1.getText() + " x " + d1q.getText());
					}
					
					if (d2.isSelected()) {
						area1.setText(area1.getText() + "\n - " + d2.getText() + " x " + d2q.getText());
					}
					
					if (w1.isSelected()) {
						area1.setText(area1.getText() + "\n - " + w1.getText() + " x " + w1q.getText());
					}
					
					if (w2.isSelected()) {
						area1.setText(area1.getText() + "\n - " + w2.getText() + " x " + w2q.getText());
					}
					
					if (w3.isSelected()) {
						area1.setText(area1.getText() + "\n - " + w3.getText() + " x " + w3q.getText());
					}
					
					if (s1.isSelected()) {
						area1.setText(area1.getText() + "\n - " + s1.getText() + " x " + s1q.getText());
					}
					
					if (s2.isSelected()) {
						area1.setText(area1.getText() + "\n - " + s2.getText() + " x " + s2q.getText());
					}
					
					itemsCost[0] = Double.parseDouble(a1q.getText());
					itemsCost[1] = Double.parseDouble(a2q.getText());
					itemsCost[2] = Double.parseDouble(a3q.getText());
					itemsCost[3] = Double.parseDouble(e1q.getText());
					itemsCost[4] = Double.parseDouble(e2q.getText());
					itemsCost[5] = Double.parseDouble(e3q.getText());
					itemsCost[6] = Double.parseDouble(e4q.getText());
					itemsCost[7] = Double.parseDouble(d1q.getText());
					itemsCost[8] = Double.parseDouble(d2q.getText());
					itemsCost[9] = Double.parseDouble(w1q.getText());
					itemsCost[10] = Double.parseDouble(w2q.getText());
					itemsCost[11] = Double.parseDouble(w3q.getText());
					itemsCost[12] = Double.parseDouble(s1q.getText());
					itemsCost[13] = Double.parseDouble(s2q.getText());
					
					subTotal = a1Price * itemsCost[0] + a2Price * itemsCost[1] + a3Price * itemsCost[2] +
							e1Price * itemsCost[3] + e2Price * itemsCost[4] + e3Price * itemsCost[5] +
							e4Price * itemsCost[6] + d1Price * itemsCost[7] + d2Price * itemsCost[8] +
							w1Price * itemsCost[9] + w2Price * itemsCost[10] + w3Price * itemsCost[11] +
							s1Price * itemsCost[12] + s2Price * itemsCost[13];
					String subTotalStr = String.format("$%.2f", subTotal);
					subTotaltf.setText(subTotalStr);
					
					tax = (subTotal * taxRate) / 100;
					String taxStr = String.format("$%.2f", tax);
					taxtf.setText(taxStr);
					
					
					if (r1.isSelected()) {
						fee = (subTotal * 15) / 100;
						String feeStr = String.format("$%.2f", fee);
						feetf.setText(feeStr);
					}
					if (r2.isSelected()) {
						fee = 2;
						String feeStr = String.format("$%.2f", fee);
						feetf.setText(feeStr);
					}
					
					
					total = subTotal + tax + fee;
					String totalStr = String.format("$%.2f", total);
					totaltf.setText(totalStr);
				}
			}	
		});
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
}
