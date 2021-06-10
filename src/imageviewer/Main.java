package imageviewer;

import imageviewer.ImageViewer;

public class Main {

	public static void main(String[] args) {
		ImageViewer viewer1 = new ImageViewer();
		viewer1.start("V1");
		
		ImageViewer viewer2 = new ImageViewer();
		viewer2.start("V2");
		
		ImageViewer viewer3 = new ImageViewer();
		viewer3.start("V3");
	}
}
