import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Information extends JFrame{
	public Information() {
		
		// Set up "Information" frame
		getContentPane().setBackground(new Color(224, 255, 255));
		setTitle("INFORMATION");
		setSize(450,300);
		getContentPane().setLayout(null);
		
		
		// Add content to text area
		JTextArea txtrdineIn = new JTextArea();
		txtrdineIn.setEditable(false);
		txtrdineIn.setBackground(new Color(224, 255, 255));
		txtrdineIn.setFont(new Font("Malayalam MN", Font.BOLD | Font.ITALIC, 16));
		txtrdineIn.setText("   -  \"Dine in\" option comes with 15% service fee \n on top of your subtotal." +
		 "\n\n  -  \"Take out\" option always come with an additional \n fixed charge of $2.00.");
		txtrdineIn.setBounds(26, 48, 403, 143);
		getContentPane().add(txtrdineIn);
		
		
		// Button to exit out the warning
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNewButton.setBounds(161, 214, 117, 36);
		getContentPane().add(btnNewButton);
		
		setVisible(true);
	}

}
