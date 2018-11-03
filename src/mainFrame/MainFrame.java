package mainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import components.MyCalendar;
import components.MyTimer;
import components.StopWatch;
import components.Watch;

public class MainFrame {
	private JFrame mainFrame;
	private JTabbedPane tabbedPane;
	
	public MainFrame() {
		makeFrame();
		makeTabbedPane();
		mainFrame.setVisible(true);
	}

	private void makeTabbedPane() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setFont(new Font("Vrinda",Font.PLAIN,40));
		tabbedPane.addTab("  ঘড়ি    ", new Watch());
		tabbedPane.add("স্টপওয়াচ", new StopWatch());
		tabbedPane.add("সময় নির্নায়ক",new MyTimer());
		tabbedPane.add("ক্যালেন্ডার",new MyCalendar());
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		mainFrame.pack();
	}

	private void makeFrame() {
		mainFrame = new JFrame("সময়");
		mainFrame.setFont(new Font("Vrinda",Font.PLAIN,40));
		mainFrame.setLayout(null);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setMinimumSize(new Dimension(700, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
