import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class PlayerAppGUI
{
  

	public PlayerAppGUI()
	{
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIPanel();
            }
        });
	}

	public static void main(String[] args)
	{
		new PlayerAppGUI();
	}
}

class GUIPanel
{
	private JFrame 		frame;
	private JPanel 		framePanel, dataPanel, statusPanel;
	private JTextArea 	dataTA, statusTA, resultTA;
	private JMenu       submenu, submenu2;
	private JMenuItem	printMI, exitMI, aboutMI, calcByYearMI, ecMI, wcMI; // ecMI and wcMI are for the two Conferences within the NBA, 
																			// Eastern and Western, respectively.
	private JMenuItem   aDMI, seDMI, cDMI, nwDMI, pDMI, swDMI;
	private JMenuItem   sortByNameMI, sortByYearsPlayedMI, sortByPointsMI, sortByTeamMI;
	private PlayerArray 	playerData;

	public GUIPanel()
	{
		framePanel = new JPanel();
		dataPanel = new JPanel();
		statusPanel = new JPanel();

		dataTA = new JTextArea(30, 40);
		dataTA.setBackground(new Color(255,255,255));
		dataTA.setLineWrap(true);
		dataTA.setWrapStyleWord(true);
		dataTA.setEditable(true);
		JScrollPane dataSP = new JScrollPane(dataTA,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		dataPanel.add(dataSP);

		statusTA = new JTextArea("Status Panel", 2, 40);
		statusTA.setBackground(new Color(200,200,200));
		statusTA.setLineWrap(true);
		statusTA.setWrapStyleWord(true);
		statusTA.setEditable(false);
		JScrollPane statusSP = new JScrollPane(statusTA,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		statusPanel.add(statusSP);

        framePanel.setOpaque(true);
        framePanel.setLayout(new BorderLayout());
        framePanel.add(dataPanel, BorderLayout.CENTER);
        framePanel.add(statusPanel, BorderLayout.SOUTH);

		frame = new JFrame("NBA Fantasy Statistics Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(createMenuBar());
		frame.setContentPane(framePanel);
		frame.pack();
		frame.setLocation(100, 150);
		frame.setResizable(true);
		frame.setVisible(true);

		playerData = new PlayerArray();

	} // end GUIPanel constructor

    public JMenuBar createMenuBar()
    {
		JMenuBar menuBar;
		JMenu menu;

		menuBar = new JMenuBar();

		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);

		printMI = new JMenuItem("Print...");
		printMI.addActionListener(new PrintListener());
		menu.add(printMI);

		exitMI = new JMenuItem("Exit");
		exitMI.addActionListener(new ExitListener());
		menu.add(exitMI);

		menu = new JMenu("Roster");
		menu.setMnemonic(KeyEvent.VK_C);
		menuBar.add(menu);

	
		
		submenu = new JMenu("Conference");
		menu.add(submenu);
		
		ecMI = new JMenuItem("Eastern Conference");
		ecMI.addActionListener(new SortByEastCon());
		submenu.add(ecMI);
		
		wcMI = new JMenuItem("Western Conference");
		wcMI.addActionListener(new SortByWestCon());
		submenu.add(wcMI);
		

		submenu2 = new JMenu("Division");
		menu.add(submenu2);
		
		aDMI = new JMenuItem("Atlantic Division");
		aDMI.addActionListener(new SortByAtlDiv());
		submenu2.add(aDMI);

		cDMI = new JMenuItem("Central Division");
		cDMI.addActionListener(new SortByCenDiv());
		submenu2.add(cDMI);
		
		seDMI = new JMenuItem("Southeast Division");
		seDMI.addActionListener(new SortBySEDiv());
		submenu2.add(seDMI);
		
		nwDMI = new JMenuItem("Northwest Division");
		nwDMI.addActionListener(new SortByNWDiv());
		submenu2.add(nwDMI);
		
		pDMI = new JMenuItem("Pacific Division");
		pDMI.addActionListener(new SortByPacDiv());
		submenu2.add(pDMI);
		
		swDMI = new JMenuItem("Southwest Division");
		swDMI.addActionListener(new SortBySWDiv());
		submenu2.add(swDMI);
		
		sortByTeamMI = new JMenuItem("Team");
		sortByTeamMI.addActionListener(new SortByTeamListener());
		menu.add(sortByTeamMI);
	
		
		menu = new JMenu("Sort");
		menu.setMnemonic(KeyEvent.VK_S);
		menuBar.add(menu);

		sortByNameMI = new JMenuItem("Sort By Name");
		sortByNameMI.addActionListener(new SortByNameListener());
		menu.add(sortByNameMI);

		sortByPointsMI = new JMenuItem("Sort By Points");
		sortByPointsMI.addActionListener(new SortByPointsListener());
		menu.add(sortByPointsMI);
			
		

		sortByYearsPlayedMI = new JMenuItem("Sort by Years Played");
		sortByYearsPlayedMI.addActionListener(new SortByYearProListener());
		menu.add(sortByYearsPlayedMI);

	
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menu);

		aboutMI = new JMenuItem("About");
		aboutMI.addActionListener(new AboutListener());
		menu.add(aboutMI);

		return menuBar;
    } // end createMenuBar

	class PrintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				dataTA.print();
				statusTA.setText("Print dialog finished");
			} catch (Exception pe) {
				statusTA.setText("Printer error");
			}
		}
	}

	class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	

	class SortByNameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			playerData.sortByName();

			dataTA.setText(playerData.toString());
		}
	}

	class SortByYearProListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			playerData.sortByYearsPlayed();

			dataTA.setText(playerData.yearDisplay());
		}
	}

	class SortByPointsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			playerData.sortByPoints();

			dataTA.setText(playerData.pointDisplay());
		}
	}

	class SortByTeamListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			playerData.sortByTeam();
			
			String tm = "";
			String s = (String)JOptionPane.showInputDialog(
                    frame,
                    "Enter an NBA Team by its Accronym:\n"
                    + tm);



			dataTA.setText(playerData.get1Team(s));
		}
	}

	

	class AboutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			statusTA.setText("All Systems Go");
			JOptionPane.showMessageDialog(framePanel,
				"NBA Fantasy Statistics Application by Sydney Herbert, Adam Murtland, 2012.12.1",
				"About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public class SortBySWDiv implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			dataTA.setText(playerData.getTeamDiv("Southwest Division"));

		}

	}

	public class SortByPacDiv implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			dataTA.setText(playerData.getTeamDiv("Pacific Division"));

		}

	}

	public class SortByNWDiv implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			dataTA.setText(playerData.getTeamDiv("Northwest Division"));

		}

	}

	public class SortBySEDiv implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			dataTA.setText(playerData.getTeamDiv("Southeast Division"));

		}

	}

	public class SortByCenDiv implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			dataTA.setText(playerData.getTeamDiv("Central Division"));
		}

	}

	public class SortByAtlDiv implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			dataTA.setText(playerData.getTeamDiv("Atlantic Division"));

		}

	}

	public class SortByWestCon implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			dataTA.setText(playerData.getTeamCon("Western Conference"));
			

		}

	}

	public class SortByEastCon implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			dataTA.setText(playerData.getTeamCon("Eastern Conference"));

		}

	}
	

	

} // end class GUIPanel