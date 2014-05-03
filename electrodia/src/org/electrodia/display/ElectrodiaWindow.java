package org.electrodia.display;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class ElectrodiaWindow extends JFrame {
	private static final long serialVersionUID = 2L;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmNew;
	private JMenuItem mntmOpen;
	private JSeparator separator;
	private JMenuItem mntmSave;
	private JMenuItem mntmSaveAs;
	private JSeparator separator_1;
	private JMenu mnImport;
	private JMenu mnExport;
	private JMenuItem mntmNothingHereYet;
	private JMenu mnEdit;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JMenuItem mntmNothingHereYet_1;
	private JSeparator separator_2;
	private JMenu mnClose;
	private JMenuItem mntmCurrent;
	private JMenuItem mntmAll;
	private JMenuItem mntmAllExceptCurrent;
	private JMenuItem mntmExit;
	private JMenuItem mntmCopy;
	private JMenuItem mntmCut;
	private JMenuItem mntmPaste;
	private JMenuItem mntmPreferences;
	private JMenuItem mntmContents;
	private JSeparator separator_3;
	private JMenuItem mntmAbout;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JSplitPane splitPane_2;
	private JTabbedPane rightTabbedPane;
	private JTabbedPane bottomTabbedPane;
	private JTabbedPane leftTabbedPane;
	private JPanel projectExplorer;
	private JPanel projectProperties;
	private JPanel containers;
	private JPanel panel;
	private JPanel projectFileHolder;
	private JTabbedPane tabbedPane;
	
	public ElectrodiaWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// do nothing, use default
		}
		setTitle("Electrodia");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNew = new JMenuItem("New...");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);
		
		mntmOpen = new JMenuItem("Open...");
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		
		separator = new JSeparator();
		mnFile.add(separator);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		
		mntmSaveAs = new JMenuItem("Save as...");
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mntmSaveAs);
		
		separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		mnImport = new JMenu("Import");
		mnFile.add(mnImport);
		
		mntmNothingHereYet = new JMenuItem("Nothing here yet");
		mnImport.add(mntmNothingHereYet);
		
		mnExport = new JMenu("Export");
		mnFile.add(mnExport);
		
		mntmNothingHereYet_1 = new JMenuItem("Nothing here yet");
		mnExport.add(mntmNothingHereYet_1);
		
		separator_2 = new JSeparator();
		mnFile.add(separator_2);
		
		mnClose = new JMenu("Close");
		mnFile.add(mnClose);
		
		mntmCurrent = new JMenuItem("Current");
		mntmCurrent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		mnClose.add(mntmCurrent);
		
		mntmAllExceptCurrent = new JMenuItem("All except current");
		mnClose.add(mntmAllExceptCurrent);
		
		mntmAll = new JMenuItem("All");
		mntmAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnClose.add(mntmAll);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		
		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		mntmCopy = new JMenuItem("Copy");
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCopy);
		
		mntmCut = new JMenuItem("Cut");
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCut);
		
		mntmPaste = new JMenuItem("Paste");
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnEdit.add(mntmPaste);
		
		mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		mntmPreferences = new JMenuItem("Preferences...");
		mntmPreferences.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, InputEvent.ALT_MASK));
		mnOptions.add(mntmPreferences);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmContents = new JMenuItem("Contents...");
		mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnHelp.add(mntmContents);
		
		separator_3 = new JSeparator();
		mnHelp.add(separator_3);
		
		mntmAbout = new JMenuItem("About...");
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_MASK));
		mnHelp.add(mntmAbout);
		
		splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		splitPane_1 = new JSplitPane();
		splitPane.setRightComponent(splitPane_1);
		
		splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(splitPane_2);
		
		bottomTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		bottomTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		splitPane_2.setRightComponent(bottomTabbedPane);
		
		panel = new JPanel();
		bottomTabbedPane.addTab("Not yet used", null, panel, null);
		
		projectFileHolder = new JPanel();
		splitPane_2.setLeftComponent(projectFileHolder);
		projectFileHolder.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		projectFileHolder.add(tabbedPane);
		
		rightTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		rightTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		splitPane_1.setRightComponent(rightTabbedPane);
		
		containers = new JPanel();
		rightTabbedPane.addTab("ContainerReference", null, containers, null);
		
		leftTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		leftTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		splitPane.setLeftComponent(leftTabbedPane);
		
		projectExplorer = new JPanel();
		leftTabbedPane.addTab("Project Explorer", null, projectExplorer, null);
		
		projectProperties = new JPanel();
		leftTabbedPane.addTab("Project Properties", null, projectProperties, null);
		
		this.setSize(800, 600);
		splitPane.setDividerLocation(225);
		splitPane_1.setDividerLocation(350);
		splitPane_2.setDividerLocation(375);
		setVisible(true);
		
	}
	
}
