import java.awt.*;

import javax.swing.*;


public class MainGUI {
	 private JFrame mainFrame = new JFrame();

	 //private JPanel listPanel = new JPanel();
	 

	 
	 public void init() {
	
		this.mainFrame.setLayout(new BorderLayout());
		this.mainFrame.setSize(800, 450);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.mainFrame.add(new JScrollPane(new GUI_Tab().createTabList()), BorderLayout.WEST);
		this.mainFrame.add(new JScrollPane(new GUI_MusicList().createListPanel()), BorderLayout.CENTER);
		
		//this.mainFrame.add(GUI_PlayerTab.initialize());
		
		this.mainFrame.setVisible(true);
	 }
	 
	 public MainGUI() {
		 init();
	 }
	 
	
	 
	

	 
}
