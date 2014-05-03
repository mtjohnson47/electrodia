package org.electrodia.help.display;

import java.awt.BorderLayout;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class ElectrodiaHelpWindow extends JFrame{
	private static final long serialVersionUID = 9121498390374976143L;
	private JTextField searchBar;
	
	public ElectrodiaHelpWindow(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Electrodia Help");
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		searchBar = new JTextField();
		searchBar.setText("");
		panel.add(searchBar, BorderLayout.NORTH);
		searchBar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JTree tree = new JTree();
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);
		tree.setModel(new DefaultTreeModel(generateTree(FileSystems.getDefault().getPath(".", "doc").toAbsolutePath().normalize())));
		scrollPane.setViewportView(tree);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane_1.setViewportView(editorPane);
		
		splitPane.setDividerLocation(150);
		
		setSize(400, 600);
		setVisible(true);
		
	}
	private TreeNode generateTree(Path file){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileNameSimple(file));
		DirectoryStream<Path> stream = null;
		try {
			stream = Files.newDirectoryStream(file);
		    for (Path name: stream) {
		    	if (name.getFileName() != null && !name.getFileName().toString().equals("index.html")){
		    		if (name.toFile().isDirectory()){
		    			root.add((MutableTreeNode) generateTree(name));
		    		}
		    		else {
		    			root.add(new DefaultMutableTreeNode(fileNameSimple(name)));
		    		}
		    	}
		    }
			if (stream != null){
				stream.close();
			}
		}
		catch (DirectoryIteratorException x){
			System.err.println("Unable to open documentation directory.");
		    x.printStackTrace();
			if (stream != null){
				try {
					stream.close();
				} catch (IOException e) {
					System.err.println("Megan: Your computer is literally haunted.");
					e.printStackTrace();
				}
			}
			System.exit(1);
		}
		catch (IOException x) {
			file.toFile().mkdir();
			return generateTree(file);
		}
		return root;
	}
	private String fileNameSimple(Path file){
		return file.getFileName().toString().substring(
				0, file.getFileName().toString().lastIndexOf('.') > 0 ? 
				file.getFileName().toString().lastIndexOf('.') :
				file.getFileName().toString().length());
	}
}
