package org.electrodia.display;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import org.electrodia.display.controls.ImagePanel;

public class AboutWindow extends JDialog {
	private static final long serialVersionUID = -8109121960503382359L;
	private ImagePanel imgPane;

	public AboutWindow() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				resize();
			}
		});
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		
		JPanel contentPane = new JPanel();
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel staticPane = new JPanel();
		contentPane.add(staticPane, BorderLayout.NORTH);
		staticPane.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnElectrodiaV = new JTextPane();
		txtpnElectrodiaV.setEnabled(false);
		txtpnElectrodiaV.setEditable(false);
		txtpnElectrodiaV.setText("Electrodia v. 0.01\r\nWritten by Michael Johnson-Moore");
		txtpnElectrodiaV.setOpaque(false);
		staticPane.add(txtpnElectrodiaV, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextPane txtpnThisApplicationIs = new JTextPane();
		txtpnThisApplicationIs.setEnabled(false);
		txtpnThisApplicationIs.setEditable(false);
		txtpnThisApplicationIs.setText("This application is licensed as follows:\r\n\r\nThe MIT License (MIT)\r\n\r\nCopyright (c) 2014 Michael Johnson-Moore\r\n\r\nPermission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:\r\n\r\nThe above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.\r\n\r\nTHE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.");
		scrollPane.setViewportView(txtpnThisApplicationIs);
		txtpnThisApplicationIs.setCaretPosition(0);
		
		try{
			imgPane = new ImagePanel(ImageIO.read(new File("electrodia.png")));
			imgPane.setOpaque(false);
			imgPane.setPreferredSize(new Dimension(67,300));
			getContentPane().add(imgPane, BorderLayout.WEST);
		}
		catch (IOException e){
			
		}
		
		setSize(450,300);
	}
	
	private void resize(){
		imgPane.setPreferredSize(new Dimension((int)((getHeight() / 450.0) * 100), (int)((getHeight() / 450.0) * 450)));
	}
	
}
