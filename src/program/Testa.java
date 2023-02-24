package program;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Testa extends JPanel {
	public Testa(){
		super();
		setLayout(new FlowLayout());
		Logo pan=new Logo();
		pan.setOpaque(false);
		add(pan);
		JLabel tz=new JLabel();
		tz.setText("Powered by Pucchosa ");
		tz.setForeground(Color.GREEN);
		tz.setOpaque(false);
		tz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tz.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	try {
		    		 Desktop.getDesktop().browse(new URI("https://github.com/Pucchosa"));
		    	 } catch (IOException | URISyntaxException e1) {}
		    }
		    @Override
		    public void mouseEntered(MouseEvent e) {}
		    @Override
		    public void mouseExited(MouseEvent e) {}
		});
		add(tz);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int wi = getWidth(), he = getHeight();
        GradientPaint gp = new GradientPaint(0,0,Color.DARK_GRAY,0,he,Color.BLACK);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, wi, he);
		
	}
	
}