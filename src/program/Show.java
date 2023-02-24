package program;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Show extends JFrame {
	JPanel c= new JPanel();

	public Show(String fin) {
		super();
		setPreferredSize(new Dimension(300, 200));
		addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });
		setLocation(110, 110);
		c.setLayout(new BorderLayout(100, 10));
		c.setOpaque(false);
		JTextArea resulT = new JTextArea();
		resulT.setFont(new Font("MS PGothic", Font.PLAIN, 17));
		resulT.setBackground(Color.BLACK);
		resulT.setForeground(Color.YELLOW);
		resulT.setOpaque(true);
		resulT.setLineWrap(true);
		resulT.setWrapStyleWord(true);
		resulT.setBounds(10,10,100,20);
		String ff=("Result: "+fin);
		resulT.setText(ff);
		c.add(resulT);
		add(c);
		pack();
		this.setVisible(true);
	}
	
	public Show(char[][] fin) {
		super();
		addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });
		c.setLayout(new BorderLayout(100, 10));
		c.setOpaque(false);
		
		JLabel resulT = new JLabel();
		resulT.setFont(new Font("MS PGothic", Font.PLAIN, 17));
		resulT.setBackground(Color.BLACK);
		resulT.setForeground(Color.YELLOW);
		resulT.setOpaque(true);
		String ff=("<html>Result:");
		for (char[] a : fin) {
			ff=ff+"<br>"+(Arrays.toString(a));
		}
		ff=ff+"</html>";
		resulT.setText(ff);
		c.add(resulT);
		
		add(c);
		pack();
	}
}
