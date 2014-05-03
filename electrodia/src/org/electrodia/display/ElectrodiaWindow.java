package org.electrodia.display;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ElectrodiaWindow extends JFrame {
	private static final long serialVersionUID = 3L;
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
	
	private final Action newButtonClicked = new NewButtonClicked();
	private final Action openButtonClicked = new OpenButtonClicked();
	private final Action saveButtonClicked = new SaveButtonClicked();
	private final Action saveAsButtonClicked = new SaveAsButtonClicked();
	private final Action closeCurrentButtonClicked = new CloseCurrentButtonClicked();
	private final Action closeAllButtonClicked = new CloseAllButtonClicked();
	private final Action closeAllButCurrentButtonClicked = new CloseAllButCurrentButtonClicked();
	private final Action exitApplicationButtonClicked = new ExitApplicationButtonClicked();
	private final Action copyButtonClicked = new CopyButtonClicked();
	private final Action cutButtonClicked = new CutButtonClicked();
	private final Action pasteButtonClicked = new PasteButtonClicked();
	private final Action preferencesButtonClicked = new PreferencesButtonClicked();
	private final Action helpButtonClicked = new HelpButtonClicked();
	private final Action aboutButtonClicked = new AboutButtonClicked();
	
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
		
		mntmNew = new JMenuItem();
		mntmNew.setAction(newButtonClicked);
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);
		
		mntmOpen = new JMenuItem();
		mntmOpen.setAction(openButtonClicked);
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		
		separator = new JSeparator();
		mnFile.add(separator);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.setAction(saveButtonClicked);
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		
		mntmSaveAs = new JMenuItem("Save as...");
		mntmSaveAs.setAction(saveAsButtonClicked);
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
		mntmCurrent.setAction(closeCurrentButtonClicked);
		mntmCurrent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		mnClose.add(mntmCurrent);
		
		mntmAllExceptCurrent = new JMenuItem("All except current");
		mntmAllExceptCurrent.setAction(closeAllButCurrentButtonClicked);
		mnClose.add(mntmAllExceptCurrent);
		
		mntmAll = new JMenuItem("All");
		mntmAll.setAction(closeAllButtonClicked);
		mntmAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnClose.add(mntmAll);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setAction(exitApplicationButtonClicked);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		
		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		mntmCopy = new JMenuItem("Copy");
		mntmCopy.setAction(copyButtonClicked);
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCopy);
		
		mntmCut = new JMenuItem("Cut");
		mntmCut.setAction(cutButtonClicked);
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCut);
		
		mntmPaste = new JMenuItem("Paste");
		mntmPaste.setAction(pasteButtonClicked);
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnEdit.add(mntmPaste);
		
		mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		mntmPreferences = new JMenuItem("Preferences...");
		mntmPreferences.setAction(preferencesButtonClicked);
		mntmPreferences.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, InputEvent.ALT_MASK));
		mnOptions.add(mntmPreferences);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmContents = new JMenuItem("Contents...");
		mntmContents.setAction(helpButtonClicked);
		mntmContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnHelp.add(mntmContents);
		
		separator_3 = new JSeparator();
		mnHelp.add(separator_3);
		
		mntmAbout = new JMenuItem("About...");
		mntmAbout.setAction(aboutButtonClicked);
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
		rightTabbedPane.addTab("Container Reference", null, containers, null);
		
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
	
	private class NewButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public NewButtonClicked() {
			putValue(NAME, "New...");
			putValue(SHORT_DESCRIPTION, "Creates a new project");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class OpenButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public OpenButtonClicked() {
			putValue(NAME, "Open...");
			putValue(SHORT_DESCRIPTION, "Opens an existing project");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class SaveButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SaveButtonClicked() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Saves the project to disk.");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class SaveAsButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SaveAsButtonClicked() {
			putValue(NAME, "Save as...");
			putValue(SHORT_DESCRIPTION, "Creates a duplicate project and saves changes to it.");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class CloseCurrentButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public CloseCurrentButtonClicked() {
			putValue(NAME, "Close current");
			putValue(SHORT_DESCRIPTION, "Closes the current project, but leaves all others open.");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class CloseAllButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public CloseAllButtonClicked() {
			putValue(NAME, "Close all");
			putValue(SHORT_DESCRIPTION, "Closes all projects.");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class CloseAllButCurrentButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public CloseAllButCurrentButtonClicked() {
			putValue(NAME, "Close all but current");
			putValue(SHORT_DESCRIPTION, "Closes all projects, but leaves the current one open.");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class ExitApplicationButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public ExitApplicationButtonClicked() {
			putValue(NAME, "Exit Application");
			putValue(SHORT_DESCRIPTION, "Closes the Electrodia Window");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class CopyButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public CopyButtonClicked() {
			putValue(NAME, "Copy");
			putValue(SHORT_DESCRIPTION, "Copies whatever is currently selected");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class CutButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public CutButtonClicked() {
			putValue(NAME, "Cut");
			putValue(SHORT_DESCRIPTION, "Copies whatever is currently selected, and then removes it");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class PasteButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public PasteButtonClicked() {
			putValue(NAME, "Paste");
			putValue(SHORT_DESCRIPTION, "Pastes the contents of the clipboard into project");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class PreferencesButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public PreferencesButtonClicked() {
			putValue(NAME, "Preferences...");
			putValue(SHORT_DESCRIPTION, "Opens the global preferences dialog");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class HelpButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public HelpButtonClicked() {
			putValue(NAME, "Contents");
			putValue(SHORT_DESCRIPTION, "Opens the help window");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class AboutButtonClicked extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public AboutButtonClicked() {
			putValue(NAME, "About");
			putValue(SHORT_DESCRIPTION, "Opens a window with Electrodia version information");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
