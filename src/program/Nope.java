package program;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Nope extends Frame {
	JPanel c;

	public Nope() {
		super();
		setBounds(130, 130, 665, 606);
		addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();
            }
        });
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		c = new JPanel();
		c.setLayout(new BorderLayout(100, 10));
		c.setBackground(Color.BLACK);
		c.setBorder(new EmptyBorder(15,15,15,15));
		JLabel resulT = new JLabel();
		resulT.setFont(new Font("MS PGothic", Font.PLAIN, 17));
		resulT.setBackground(Color.BLACK);
		resulT.setForeground(Color.YELLOW);
		resulT.setOpaque(true);
		String ff=("<html>Result:<br>I'm sorry,<br>I wasn't able to solve this...<br>:'(</html>");
		resulT.setText(ff);
		c.add(resulT);
		
		add(c);
		pack();
	}
	
	public Nope(String s) {
		super();
		setBounds(130, 130, 665, 606);
		addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();
            }
        });
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		c = new JPanel();
		c.setLayout(new BorderLayout(100, 10));
		c.setBackground(Color.BLACK);
		c.setBorder(new EmptyBorder(15,15,15,15));
		JLabel resulT = new JLabel();
		resulT.setFont(new Font("MS PGothic", Font.PLAIN, 17));
		resulT.setBackground(Color.BLACK);
		resulT.setForeground(Color.YELLOW);
		resulT.setOpaque(true);
		String ff=(s);
		resulT.setText(ff);
		c.add(resulT);
		
		add(c);
		pack();
	}
}
