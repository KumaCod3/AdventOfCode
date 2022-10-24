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
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

public class Program {

	private JFrame frame;
	static int day;
	static int part;
	static long ris;
	static int yea=0;
	static String ret;
	private JTextField resulT;
	
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
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 665, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel labYear = new JLabel("Choose  year:");
		labYear.setForeground(Color.LIGHT_GRAY);
		panel.add(labYear);
		
		Choice yeaCh = new Choice();
		yeaCh.setForeground(Color.DARK_GRAY);
		yeaCh.add("Choose");
		yeaCh.add("Year 2021");
		yeaCh.add("Year 2022");
		yeaCh.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				yea=yeaCh.getSelectedIndex();
			}
		});
		panel.add(yeaCh);
		
		JLabel labDay = new JLabel("Choose Day:");
		labDay.setForeground(Color.LIGHT_GRAY);
		panel.add(labDay);
		
		Choice dayCh = new Choice();
		dayCh.setForeground(Color.DARK_GRAY);
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
		day1.setBackground(Color.DARK_GRAY);
		day1.setForeground(Color.LIGHT_GRAY);
		day1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            part=1;
	        }
	    });
		panel.add(day1);
		
		JRadioButton day2 = new JRadioButton("Part 2");
		day2.setForeground(Color.LIGHT_GRAY);
		day2.setBackground(Color.DARK_GRAY);
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
	    panel_2.setBackground(Color.DARK_GRAY);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Your result for day -- part - is: ");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblNewLabel_1);
		
		resulT = new JTextField();
		resulT.setFont(new Font("MS PGothic", Font.PLAIN, 17));
		resulT.setBackground(Color.BLACK);
		resulT.setForeground(Color.YELLOW);
		panel_2.add(resulT);
		resulT.setColumns(15);
		resulT.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JTextArea input = new JTextArea();
		input.setFont(new Font("MS PGothic", Font.PLAIN, 15));
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		MyBut btnNewButton = new MyBut("Calcola!!!");
		btnNewButton.setText("Calculate!!!");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnNewButton.setAlignmentX(0.5f);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (day!=0&&part!=0) {
			    	// do stuff
			    	Handler hhh=new Handler(yea, day , part, ret);
			    	ris=hhh.calc();
			    	resulT.setText(""+ris);
			    	lblNewLabel_1.setText("(year 202"+yea+") Your result for day "+day+" part "+part+" is: ");
		    	}
		    	else {
		    		
		    	}
			}
		});
		panel_4.add(btnNewButton);
		panel_3.add(panel_4);
		panel_3.add(panel_2);
		
	}

}
// TO DO DAY 4