package program;
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
import java.lang.reflect.Method;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Main {

	private JFrame frame;
	static int day;
	static int part;
	static long ris;
	static int yea=0;
	static String ret;
	static public JTextField resulT;
	static Method meth;
	private Dimension pulsante=new Dimension(160,50);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 665, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel top = new JPanel();
		top.setBackground(Color.DARK_GRAY);
		
		JPanel head = new JPanel();
		head.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(head, BorderLayout.NORTH);
		
		JLabel titolo = new JLabel("Advent of Code solutions for years 2021/2022!");
		titolo.setForeground(Color.GREEN);
		titolo.setFont(new Font("Century Gothic", Font.BOLD, 21));
		head.add(titolo);
		
		JPanel center = new JPanel();
		center.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(center, BorderLayout.CENTER);
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.add(top);
		
		JLabel labYear = new JLabel("Choose  year:");
		labYear.setForeground(Color.LIGHT_GRAY);
		top.add(labYear);
		
		Choice yeaCh = new Choice();
		yeaCh.setBackground(Color.GRAY);
		yeaCh.setForeground(new Color(255, 255, 255));
		yeaCh.add("Choose");
		yeaCh.add("Year 2021");
		yeaCh.add("Year 2022");
		yeaCh.add("Year 2023");
		yeaCh.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
			}
			public void focusLost(FocusEvent e){
				yea=yeaCh.getSelectedIndex();
			}
		});
		top.add(yeaCh);
		
		JLabel labDay = new JLabel("Choose Day:");
		labDay.setForeground(Color.LIGHT_GRAY);
		top.add(labDay);
		
		Choice dayCh = new Choice();
		dayCh.setBackground(Color.GRAY);
		dayCh.setForeground(new Color(255, 255, 255));
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
		top.add(dayCh);
		
		JRadioButton day1 = new JRadioButton("Part 1");
		day1.setBackground(Color.DARK_GRAY);
		day1.setForeground(Color.LIGHT_GRAY);
		day1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            part=1;
	        }
	    });
		top.add(day1);
		
		JRadioButton day2 = new JRadioButton("Part 2");
		day2.setForeground(Color.LIGHT_GRAY);
		day2.setBackground(Color.DARK_GRAY);
		day2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            part=2;
	        }
	    });
		top.add(day2);
		ButtonGroup group = new ButtonGroup();
	    group.add(day1);
	    group.add(day2);
		
	    JPanel bottom = new JPanel();
	    bottom.setBackground(Color.DARK_GRAY);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new GridLayout(3, 1, 0, 0));
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JLabel risultatoE = new JLabel("Your result for day -- part - is: ");
		risultatoE.setForeground(Color.LIGHT_GRAY);
		risultatoE.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bottom.add(risultatoE);
		
		resulT = new JTextField();
		resulT.setFont(new Font("MS PGothic", Font.PLAIN, 17));
		resulT.setBackground(Color.BLACK);
		resulT.setForeground(Color.YELLOW);
		bottom.add(resulT);
		resulT.setColumns(15); 
		resulT.setEditable(false);
		
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
		center.add(input);
		
		JPanel buttons = new JPanel();
		buttons.setBackground(Color.DARK_GRAY);
		MyBut calcola = new MyBut("Calcola!!!", Color.YELLOW, Color.MAGENTA);
		calcola.setPreferredSize(pulsante);
		calcola.setText("Calculate!!!");
		calcola.setForeground(Color.DARK_GRAY);
		calcola.setFont(new Font("Century Gothic", Font.BOLD, 15));
		calcola.setAlignmentX(0.5f);
		calcola.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (day!=0&&part!=0&&yea!=0) {
		    		String cl="aOc2"+yea+".Day"+day+"_202"+yea;
		    		Class<?> ccc=null;
		    		try {
		    			ccc=Class.forName(cl);
		    		}
		    		catch (Exception eeeee) {System.out.println("no0"+eeeee);}
		    		try {
		    				String nn="calculate"+part;
		    				meth=ccc.getMethod(nn, new Class[] {String.class});
		    		}
		    		catch (Exception ex) {System.out.println("no1"+ex);}
		    		if (meth!=null) {
		    			try {
		    				ris=(long) meth.invoke(null, ret);
		    			}
		    			catch (Exception ee) {System.out.println("no2"+ee);}
		    		}
		    		
			    	resulT.setText(""+ris);
			    	risultatoE.setText("(year 202"+yea+") Your result for day "+day+" part "+part+" is: ");
		    	}
		    	else {
//		    		ris=Prova.calculate1(ret);
//		    		resulT.setText(""+ris);
//			    	risultatoE.setText("Your result for PROVA is: ");
		    	}
			}
		});
		buttons.add(calcola);
		panel_3.add(buttons);
		
		MyBut esci = new MyBut("--EXIT--", Color.BLACK, Color.GRAY);
		esci.setForeground(Color.MAGENTA);
		esci.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		esci.setPreferredSize(pulsante);
		esci.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.setVisible(false);
            	frame.dispose();
            	System.exit(0);
        	}
		});
		buttons.add(esci);
		panel_3.add(bottom);
		
		Testa tt=new Testa();
		panel_3.add(tt);
	}
}