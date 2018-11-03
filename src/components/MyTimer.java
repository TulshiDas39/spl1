package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class MyTimer extends JPanel {
	private Timer timer;
	private int firstDigit=0;
	private int secondDigit=0;
	private int thirdDigit=0;
	private int fourthDigit=0;
	private int fifthDigit=0;
	private int sixthDigit=0;
	private String digits = "০১২৩৪৫৬৭৮৯";
	private int totalSecond;
	private int totalMinute;
	private int totalHour;
	JComboBox<?>secondList;
	JComboBox<?>minuteList;
	JComboBox<?>hourList;

	public MyTimer(){
	 super();
	 setLayout(null);
	 makeStartButton();
	 makeResetButton();
	 makeTileLabel();
	 makeTimeTexts();
	 makeInputCombobox();
	  timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			sixthDigit--;
			if(sixthDigit == -1){sixthDigit=9; fifthDigit--;}
			if(fifthDigit==-1){fifthDigit=5;fourthDigit--;}
			if(fourthDigit==-1){thirdDigit--;fourthDigit=9;}
			if(thirdDigit==-1){secondDigit--;thirdDigit=5;}
			if(secondDigit==-1){firstDigit--;secondDigit=9;}
			if(firstDigit+secondDigit+thirdDigit+fourthDigit+fifthDigit+sixthDigit ==0){timer.stop();showTimeUpMessageWindow();}
			repaint();			
						
		}
 
	});
	
}
	
	private void showTimeUpMessageWindow() {
		JFrame timeUpFrame = new JFrame("সময় শেষ");
		timeUpFrame.setFont(new Font("Vrinda",Font.PLAIN,40));
		JLabel messageLabel = new JLabel("সময় শেষ!",SwingConstants.CENTER);
		messageLabel.setFont(new Font("Vrinda",Font.BOLD,80));
		messageLabel.setForeground(Color.MAGENTA);
		timeUpFrame.setLayout(new BorderLayout());
		timeUpFrame.add(messageLabel,BorderLayout.CENTER);
		timeUpFrame.setSize(500, 400);
		timeUpFrame.setLocation(300, 100);
		timeUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		timeUpFrame.setVisible(true);
		
	}
	
	private void makeInputCombobox() {
		
		JLabel textLabel = new JLabel("মোট সময়:");
		textLabel.setFont(new Font("Vrinda",Font.PLAIN,30));
		textLabel.setBounds(900,40,100,40);
		add(textLabel);
		
		
		String []seconds = new String[61];
		seconds[0]="সেকেন্ড";
		for(int i=0;i<6;i++){
			for(int j=0;j<10;j++){
				seconds[i*10+j+1] = String.valueOf((char)((int)'০'+i)) + String.valueOf((char)((int)'০'+j));
			}
		}
		
		secondList = new JComboBox<String>(seconds);
		secondList.setSelectedIndex(0);
		secondList.getEditor().getEditorComponent().setBackground(Color.GRAY);
		secondList.setFont(new Font("Vrinda",Font.PLAIN,30));
		secondList.setBounds(1012,40,100,40);
		
		add(secondList);
		
		
		String []minutes = new String[61];
		minutes[0]="মিনিট";
		for(int i=0;i<6;i++){
			for(int j=0;j<10;j++){
				minutes[i*10+j+1] = String.valueOf((char)((int)'০'+i)) + String.valueOf((char)((int)'০'+j));
			}
			
		}
		
		minuteList = new JComboBox<String>(minutes);
		minuteList.setSelectedIndex(0);
		minuteList.getEditor().getEditorComponent().setBackground(Color.GRAY);
		minuteList.setFont(new Font("Vrinda",Font.PLAIN,30));
		minuteList.setBounds(1112,40,100,40);
		
		add(minuteList);
		
		
		

		
		String []hours = new String[101];
		hours[0]="ঘন্টা";
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				hours[i*10+j+1] = String.valueOf((char)((int)'০'+i)) + String.valueOf((char)((int)'০'+j));
			}
			
		}
		
		hourList = new JComboBox<String>(hours);
		hourList.setSelectedIndex(0);
		hourList.getEditor().getEditorComponent().setBackground(Color.GRAY);
		hourList.setFont(new Font("Vrinda",Font.PLAIN,30));
		hourList.setBounds(1212,40,100,40);
		
		add(hourList);
		
		
	}

	private void makeTimeTexts() {
		JLabel hourLabel = new JLabel();
		hourLabel.setFont(new Font("Vrinda",Font.PLAIN,90));
		String text = new String("ঘন্টা");
		hourLabel.setText(text);
		hourLabel.setBounds(410,300,110,120);
		add(hourLabel);
		
		JLabel minuteLabel = new JLabel();
		minuteLabel.setFont(new Font("Vrinda",Font.PLAIN,90));
		String text1 = new String("মিনিট");
		minuteLabel.setText(text1);
		minuteLabel.setBounds(1080,300,145,120);
		add(minuteLabel);
		
		JLabel secondLabel = new JLabel();
		secondLabel.setFont(new Font("Vrinda",Font.PLAIN,90));
		String text2 = new String("সেকেন্ড");
		secondLabel.setText(text2);
		secondLabel.setBounds(780,500,175,120);
		add(secondLabel);

	}

	private void makeTileLabel() {
		JLabel label = new JLabel();
		label.setFont(new Font("Vrinda",Font.PLAIN,70));
		String text = new String("অবশিষ্ট সময়");
		label.setText(text);
		label.setBounds(500,150,300,70);
		add(label);
		
	}


	private void makeResetButton() {
		JButton stopButton = new JButton("বাতিল");
		String tooltipText = "<html><p><font color=\"red\" " +  
	            "size=\"6\" face=\"Vrinda\">পুনরায় শুরু করুন" +
	            "</font></p></html>";
		
		stopButton.setToolTipText(tooltipText);
		stopButton.setFont(new Font("Vrinda",Font.PLAIN,30));
		
		stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				
			}
		});
		stopButton.setBounds(340,40,110,40);
		stopButton.setFocusPainted(false);
		
		add(stopButton);
				
	}

	private void reset() {
		timer.stop();
		sixthDigit=0;
		fifthDigit=0;
		thirdDigit=0;
		fourthDigit=0;
		firstDigit=0;
		secondDigit=0;
		repaint();
	}

	
	private boolean initialise(){
		JLabel tLabel = new JLabel("মোট সময় নির্ধারন করুন");
		tLabel.setFont(new Font("Vrinda",Font.PLAIN,40));
		totalSecond = secondList.getSelectedIndex();
		if(totalSecond ==0) {JOptionPane.showMessageDialog(null, tLabel,"error",JOptionPane.ERROR_MESSAGE);return false;}
		totalMinute = minuteList.getSelectedIndex();
		if(totalMinute ==0){JOptionPane.showMessageDialog(null, tLabel,"error",JOptionPane.ERROR_MESSAGE);return false;}
		totalHour = hourList.getSelectedIndex();
		if(totalHour ==0){JOptionPane.showMessageDialog(null, tLabel,"error",JOptionPane.ERROR_MESSAGE);return false;}
		
		totalSecond--;
		totalMinute--;
		totalHour--;
		sixthDigit = totalSecond % 10 ;
		fifthDigit = (int) totalSecond/10;
		fourthDigit =totalMinute %10 ;
		thirdDigit = (int) totalMinute /10;
		secondDigit = totalHour % 10;
		firstDigit = totalHour /10 ;
		return true;
	}

	private void makeStartButton(){
		JButton startButton = new JButton("শুরু");
		startButton.setFont(new Font("Vrinda",Font.PLAIN,30));
		startButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(initialise() &&  (!timer.isRunning())){repaint(); timer.start();}
				 
			}
		});
		startButton.setBounds(200,40,100,40);
		startButton.setFocusPainted(false);
		
		add(startButton);
		
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.MAGENTA);
		g.drawLine(50, 250, 1290,250);
		g.drawLine(50, 630, 1290,630);
		g.drawLine(50, 250, 50,630);
		g.drawLine(1290, 250, 1290,630);

		
		if(firstDigit+secondDigit ==0)g.setColor(Color.BLUE);
		else g.setColor(Color.RED);
		
		g.setFont(new Font("Vrinda",Font.PLAIN,300));
		g.drawChars(digits.toCharArray(), firstDigit, 1, 100, 400);
		g.drawChars(digits.toCharArray(), secondDigit, 1, 250, 400);
			
	
		if(firstDigit+secondDigit+thirdDigit+fourthDigit ==0)g.setColor(Color.BLUE);
		else g.setColor(Color.RED);
		g.drawChars(digits.toCharArray(), thirdDigit, 1, 780, 400);
		g.drawChars(digits.toCharArray(), fourthDigit, 1, 930, 400);
		
		
		if(firstDigit+secondDigit+thirdDigit+fourthDigit+fifthDigit+sixthDigit==0)g.setColor(Color.BLUE);
		else g.setColor(Color.RED);
		g.drawChars(digits.toCharArray(), fifthDigit, 1, 470, 600);
		g.drawChars(digits.toCharArray(), sixthDigit, 1, 620, 600);

	}

}
