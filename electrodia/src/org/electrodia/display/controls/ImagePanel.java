package org.electrodia.display.controls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1795925947819430674L;
	BufferedImage img;
	public ImagePanel(BufferedImage img){
		this.img = img;
	}
	
	@Override
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		if (img != null)
			g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}
}
