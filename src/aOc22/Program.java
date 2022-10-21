package aOc22;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;

public class Program {

	private JFrame frame;
	static int day;
	static int part;
	static long ris;
	static String ret;
	
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

	public Program() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Choose Day:");
		panel.add(lblNewLabel);
		
		Choice dayCh = new Choice();
		dayCh.add("Choose");
		for (int i=1;i<=25;i++) {
			dayCh.add("Day "+i);
		}
		dayCh.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				day=dayCh.getSelectedIndex();
			}
		});
		panel.add(dayCh);
		
		JRadioButton day1 = new JRadioButton("Part 1");
		day1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            part=1;
	        }
	    });
		panel.add(day1);
		
		JRadioButton day2 = new JRadioButton("Part 2");
		day2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            part=2;
	        }
	    });
		panel.add(day2);
		ButtonGroup group = new ButtonGroup();
	    group.add(day1);
	    group.add(day2);
		
	    JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Your result for day -- part - is: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HERE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JTextArea input = new JTextArea();
		input.setBackground(Color.BLACK);
		input.setForeground(Color.GREEN);
		input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				if (input.getText().isEmpty()){
				}
				else ret=input.getText();
			}
		});
		panel_1.add(input);
		
		JButton btnNewButton = new JButton("Calculate!");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (day!=0&&part!=0) {
			    	// do stuff
			    	Handler hhh=new Handler(day , part, ret);
			    	ris=hhh.calc();
			    	lblNewLabel_2.setText(""+ris+ret);
			    	lblNewLabel_1.setText("Your result for day "+day+" part "+part+" is: ");
		    	}
		    	else {
		    		
		    	}
			}
		});
		panel_1.add(btnNewButton);
		
	}

}
