import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;

public class Main{

	static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {

	        		frame.setTitle("다중 문자 치환");
	        		frame.setPreferredSize(new Dimension(800,650));
	        		frame.setResizable(false);
	        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        		frame.setLocationRelativeTo(null);
	        		frame.add(new Encryption());
	        		frame.pack();
	        		frame.setVisible(true);
	            }
	        });
	}
	
    static public void change(JPanel removePanel, JPanel addPanel) {
    	frame.remove(removePanel);
    	frame.add(addPanel);
    	frame.repaint();
    	frame.revalidate();
    }
}
