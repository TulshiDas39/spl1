package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class StopWatch extends JPanel {
	private Timer timer;
	private int firstDigit=0;
	private int secondDigit=0;
	private int thirdDigit=0;
	private int fourthDigit=0;
	private int fifthDigit=0;
	private int sixthDigit=0;
	private int seventhDigit=0;
	private String digits= "০১২৩৪৫৬৭৮৯";
	
	public StopWatch(){
	 super();
	 setLayout(null);
	 makeStartButton();
	 makeStopButton();
	 makeResetButton();
	  timer = new Timer(100, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
			seventhDigit++;
			if(seventhDigit==10){seventhDigit=0;sixthDigit++;}
			if(sixthDigit == 10){sixthDigit=0; fifthDigit++;}
			if(fifthDigit==6){fifthDigit=0;fourthDigit++;}
			if(fourthDigit==10){thirdDigit++;fourthDigit=0;}
			if(thirdDigit==6){secondDigit++;thirdDigit=0;}
			if(secondDigit==10){firstDigit++;secondDigit=0;}
			if(firstDigit==10){firstDigit=0;}
						
		}
		

	});
	  
	  makeFormateTextLabel();
	
		
	}
	
	public void makeFormateTextLabel(){
		JLabel formateLabel = new JLabel();
		formateLabel.setFont(new Font("Vrinda",Font.PLAIN,40));
		String formateText = new String("ঘন্টা:মিনিট:সেকেন্ড:সেকেন্ড/১০");
		formateLabel.setText(formateText);
		formateLabel.setBounds(500,420,400,200);
		add(formateLabel);
		
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
		stopButton.setBounds(740,40,110,40);
		stopButton.setFocusPainted(false);
		
		add(stopButton);
				
	}

	private void reset() {
		timer.stop();
		sixthDigit=0;
		fifthDigit=0;
		seventhDigit=0;
		thirdDigit=0;
		fourthDigit=0;
		firstDigit=0;
		secondDigit=0;
		repaint();
	}

	private void makeStopButton() {
		JButton stopButton = new JButton("বন্ধ");
		stopButton.setFont(new Font("Vrinda",Font.PLAIN,30));
		stopButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});
		stopButton.setBounds(620,40,100,40);
		stopButton.setFocusPainted(false);
		
		add(stopButton);
		
	}

	private void makeStartButton() {
		JButton startButton = new JButton("শুরু");
		startButton.setFont(new Font("Vrinda",Font.PLAIN,30));
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
			}
		});
		startButton.setBounds(500,40,100,40);
		startButton.setFocusPainted(false);
		
		add(startButton);
		
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Vrinda",Font.PLAIN,300));
		
		g.drawChars(digits.toCharArray(), firstDigit, 1, 0, 400);
		g.drawChars(digits.toCharArray(), secondDigit, 1, 150, 400);
			
		g.fillOval(300, 370, 20, 20);
		g.fillOval(300, 310, 20, 20);
		
		g.drawChars(digits.toCharArray(), thirdDigit, 1, 350, 400);
		g.drawChars(digits.toCharArray(), fourthDigit, 1, 500, 400);
		
		
		g.fillOval(700, 370, 20, 20);
		g.fillOval(700, 310, 20, 20);
		
		g.drawChars(digits.toCharArray(), fifthDigit, 1, 750, 400);
		g.drawChars(digits.toCharArray(), sixthDigit, 1, 900, 400);
		g.fillOval(1100, 370, 20, 20);
		g.fillOval(1100, 310, 20, 20);

		g.drawChars(digits.toCharArray(), seventhDigit, 1, 1150, 400);
	}
	
}
