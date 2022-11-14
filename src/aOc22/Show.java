package aOc22;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Show extends Frame {
	JPanel c;

	public Show(char[][] fin) {
		super();
		addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		c = new JPanel();
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
