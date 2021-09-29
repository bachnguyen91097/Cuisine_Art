import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class RestaurantSelection extends JFrame{
	private JTextField welcomeSign;
	private JTextField selectionSign;
	
	public RestaurantSelection() {
		
		// Set up frame's size, title and background color
		getContentPane().setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		setTitle("WELCOME TO THE HEAVEN OF FOODS");
		setSize(450,300);
		getContentPane().setLayout(null);
		
		
		// Set up "Welcome Sign"
		welcomeSign = new JTextField();
		welcomeSign.setEditable(false);
		welcomeSign.setBounds(0, 16, 450, 29);
		welcomeSign.setFont(new Font("SignPainter", Font.BOLD, 21));
		welcomeSign.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeSign.setText("WELCOME TO BB'S RESTAURANT CHAINS!");
		getContentPane().add(welcomeSign);
		welcomeSign.setColumns(10);
		
		
		// Set up "Selection Sign"
		selectionSign = new JTextField();
		selectionSign.setEditable(false);
		selectionSign.setHorizontalAlignment(SwingConstants.CENTER);
		selectionSign.setText("Please select your favorite restaurant to either dine in or takeout");
		selectionSign.setBounds(0, 67, 450, 67);
		getContentPane().add(selectionSign);
		
		
		
		// Buttons for different restaurant options
		
		// Viet Restaurant
		JButton VietRes = new JButton("Vietnamese");
		VietRes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new VietCuisine();
				dispose();
			}
		});
		VietRes.setBackground(UIManager.getColor("Button.highlight"));
		VietRes.setFont(new Font("Nanum Myeongjo", Font.BOLD, 13));
		VietRes.setBounds(6, 156, 117, 52);
		getContentPane().add(VietRes);
		
		
		// Korea Restaurant
		JButton KorRes = new JButton("Korean");
		KorRes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new KoreaCuisine();
				dispose();
			}
		});
		KorRes.setBackground(UIManager.getColor("Button.highlight"));
		KorRes.setFont(new Font("Nanum Myeongjo", Font.BOLD, 13));
		KorRes.setBounds(163, 156, 117, 52);
		getContentPane().add(KorRes);

		
		// Thai Restaurant
		JButton ThaiRes = new JButton("Thai");
		ThaiRes.setBackground(UIManager.getColor("Button.highlight"));
		ThaiRes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ThaiCuisine();
				dispose();
			}
		});
		ThaiRes.setFont(new Font("Nanum Myeongjo", Font.BOLD, 13));
		ThaiRes.setBounds(316, 156, 117, 52);
		getContentPane().add(ThaiRes);
		
		setVisible(true);
		
	}
}
