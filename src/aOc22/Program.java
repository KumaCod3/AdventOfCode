package aOc22;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.TextArea;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JRadioButton;

public class Program {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Choose Day:");
		panel.add(lblNewLabel);
		
		Choice choice = new Choice();
		panel.add(choice);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Part 1");
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Part 2");
		panel.add(rdbtnNewRadioButton_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JTextArea textArea = new JTextArea();
		panel_1.add(textArea);
		
		JButton btnNewButton = new JButton("Calculate!");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Your result is:");
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("XXX");
		panel_2.add(lblNewLabel_2);
	}

}
