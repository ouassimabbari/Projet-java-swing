package fenetre;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class dalto extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;

	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dalto frame = new dalto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dalto() {
		
		
			
			
			
		
		
		
		String str=" ";
		
		
		
		
		

		setBounds(100, 100, 978, 733);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(10, 11, 942, 640);
		contentPane.add(mainPanel);
		
		JButton btnPrecedent = new JButton("PRECEDENT");
		btnPrecedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cardLayout.previous(mainPanel);
				
				
				
			}
		});
		btnPrecedent.setBounds(10, 653, 139, 31);
		contentPane.add(btnPrecedent);
		
		JButton btnNewButton = new JButton("SUIVANT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cardLayout.next(mainPanel);
				
				
			}
		});
		btnNewButton.setBounds(803, 654, 128, 29);
		contentPane.add(btnNewButton);
		
		
		
		

		String[] fileImage = {"1.png","2.png","3.png","4.png","5.png"} ;
		
		for(String s : fileImage) {
			
			Icon icone = new ImageIcon("C:/Users/user/Documents/NetBeansProjects/med/src/image/"+s);
			JLabel label = new JLabel(icone); 
			mainPanel.add(label);
			str=" Si vous avez une vision normale vous voyez le nombre 42.\n" + 
					"\r\n" + 
					"Les daltoniens �rouge� voient un 2.\r\n" + 
					"\r\n" + 
					"Les daltoniens �vert� verront un 4.";
			
		}
		
		cardLayout = new CardLayout();
		mainPanel.setLayout(cardLayout);
		
		
		
		
		
		
		
	}
}
