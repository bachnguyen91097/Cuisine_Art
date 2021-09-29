import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class Warning1 extends JFrame{
	
	public Warning1() {
		
		// Set up "Warning 1" frame
		getContentPane().setFont(new Font("Lucida Grande", Font.BOLD, 13));
		getContentPane().setBackground(Color.ORANGE);
		setTitle("WARNING!!!");
		setSize(450,300);
		getContentPane().setLayout(null);
		
		
		// Button to exit out the warning
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(161, 217, 131, 41);
		getContentPane().add(btnNewButton);
		
		
		// Add content to text area
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lao MN", Font.BOLD, 13));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.window);
		textArea.setBounds(55, 33, 343, 172);
		textArea.setBorder(new LineBorder(Color.BLACK, 2, true));
		textArea.setText("\n  THE FOLLOWING FIELDS ARE REQUIRED: \n\n -  Customer Name \n\n -  Contact Number \n\n -  SERVICE OPTIONS");
		getContentPane().add(textArea);
		
		setVisible(true);
	}
}
