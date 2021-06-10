package imageviewer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageViewer implements ActionListener {
	private JFrame frame;
	
	public ImageViewer() {	
		//makeFrame();
	}
	
	public void start(String s) {
		makeFrame(s);
	}
	
	public void actionPerformed(ActionEvent event) {
		System.out.println("Menu item: " + event.getActionCommand());
	}
	
	private void makeFrame(String s) {
		frame = new JFrame("ImageViewer");
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu fileMenuA = new JMenu("A");
		menubar.add(fileMenuA);
		JMenuItem openItemA1 = new JMenuItem("Open A");
		openItemA1.addActionListener(this);
		fileMenuA.add(openItemA1);
		JMenuItem openItemA2 = new JMenuItem("Quit A");
		openItemA2.addActionListener((ActionListener) this);
		fileMenuA.add(openItemA2);
		
		JMenu fileMenuB = new JMenu("B");
		menubar.add(fileMenuB);
		JMenuItem openItemB1 = new JMenuItem("Open B");
		openItemB1.addActionListener((ActionListener) this);
		fileMenuB.add(openItemB1);
		JMenuItem openItemB2 = new JMenuItem("Quit B");
		openItemB2.addActionListener((ActionListener) this);
		fileMenuB.add(openItemB2);
		
		JMenu fileMenuC = new JMenu("C");
		menubar.add(fileMenuC);
		JMenuItem openItemC1 = new JMenuItem("Open C");
		openItemC1.addActionListener((ActionListener) this);
		fileMenuC.add(openItemC1);
		JMenuItem openItemC2 = new JMenuItem("Quit C");
		openItemC2.addActionListener((ActionListener) this);
		fileMenuC.add(openItemC2);
		
		Container contentPane =  frame.getContentPane();
		JLabel label = new JLabel(s + " I am a label.  I can display some text. ");
		contentPane.add(label);
		frame.setLocation(500, 500);
		frame.pack();
		frame.setVisible(true);
	}
}
