package test;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class MyClass {
	
	int a = 5000;
	int b = 5000;
	int c = a + b;
	
	public static void main(String args[]) {
	try {

	    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

	} 
	catch (Exception e) {
	   // handle exception
	}
	
	JFileChooser chooser = new JFileChooser(); 
	int retval = chooser.showSaveDialog(null);
	
	if (retval == JFileChooser.APPROVE_OPTION) {
		File f = chooser.getSelectedFile();
		System.out.println(f.getAbsolutePath());
	}
	
	}
	//etc
}