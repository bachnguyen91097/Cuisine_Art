import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class Warning2 extends JFrame {
	public Warning2() {
		
		// Set up "Warning 2" frame
		getContentPane().setFont(new Font("Lucida Grande", Font.BOLD, 13));
		getContentPane().setBackground(UIManager.getColor("List.selectionBackground"));
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
		btnNewButton.setBounds(161, 189, 131, 41);
		getContentPane().add(btnNewButton);
		
		
		// Add content to text area
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lao MN", Font.BOLD, 13));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.window);
		textArea.setBounds(54, 76, 343, 91);
		textArea.setBorder(new LineBorder(Color.BLACK, 2, true));
		textArea.setText("\n      YOU FORGET TO ENTER THE QUANTITY FOR \n      ONE OF YOUR SELECTED ITEMS !! \n      PLEASE CHECK !!!");
		getContentPane().add(textArea);
		
		setVisible(true);
	}
}
