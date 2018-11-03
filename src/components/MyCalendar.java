package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyCalendar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int year;
	private int month;
	private int  dayOfFirstWeek;
	private int numberOfDaysInMonth;
	private ZoneId zone;
	private ZonedDateTime zonedDateAndTime;
	private JComboBox<String> monthList;
	private JComboBox<String> yearList;
	private String months[] = new String[]{"জানুয়ারী","ফেব্রুয়ারী","মার্চ","এপ্রিল","মে","জুন","জুলাই","আগস্ট","সেপ্টেম্বর","অক্টোবর","নবেম্বর","ডিসেম্বর"};
	public MyCalendar() {
		super();
		setProperties();
		intialiseTime();
		makeTitleLabel();
		makeComboboxOfYear();
		makeComboboxofMonth();
		drawNameOfWeekDays();
		createOkButton();
		creatNextPageButton();
		createPreousPageButton();
	}

	private void createPreousPageButton() {
		JButton  previousButton = new JButton("পূর্বের পাতা");
		JLabel messageLabel = new JLabel("পাওয়া যায়নি");
		previousButton.setBackground(Color.MAGENTA);
		previousButton.setBounds(1150, 200, 150, 50);
		previousButton.setFont(new Font("Vrinda",Font.PLAIN,30));
		previousButton.setFocusPainted(false);
		previousButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				messageLabel.setFont(new Font("Vrinda", Font.PLAIN, 30));
				messageLabel.setSize(200,60);
				if(year==1 && month==1)JOptionPane.showMessageDialog(null,messageLabel ,"error",JOptionPane.ERROR_MESSAGE);
				else if(month==1){year--;month=12;}
				else month--;
				setChangedDate(year, month);
				repaint();
			}
		});
		add(previousButton);

	}

	private void creatNextPageButton() {
		JButton  nextButton = new JButton("পরের পাতা");
		nextButton.setBackground(Color.MAGENTA);
		nextButton.setBounds(950, 200, 150, 50);
		nextButton.setFont(new Font("Vrinda",Font.PLAIN,30));
		nextButton.setFocusPainted(false);
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(month==12){year++;month=1;}
				else month++;
				setChangedDate(year, month);
				repaint();
			}
		});
		add(nextButton);
	}

	private void createOkButton() {
		JButton okButton = new JButton("ঠিক");
		okButton.setFont(new Font("Vrinda",Font.PLAIN,30));
		okButton.setBounds(1250,100,100,40);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int changedYear=-1,changedMonth=-1;
				JLabel errorMessage = new JLabel("সঠিক তথ্য দিন");
				errorMessage.setFont(new Font("Vrinda", Font.PLAIN, 30));
				
					changedYear = yearList.getSelectedIndex()+1;
					changedMonth = monthList.getSelectedIndex()+1;
					
				if(changedYear==0 || changedMonth==0)JOptionPane.showMessageDialog(null,errorMessage,"ভুল",JOptionPane.ERROR_MESSAGE);
				else setChangedDate(changedYear,changedMonth);	
				repaint();
			}
		});
		add(okButton);
	}
	
	
	
	private void setChangedDate(int changedYear, int changedMonth) {
		year = changedYear;
		month = changedMonth;
		zonedDateAndTime = zonedDateAndTime.withYear(year);
		zonedDateAndTime = zonedDateAndTime.withMonth(month);
		setNumberOfDaysInMonth();
		setDayOfFirstWeek();
	}

	private void setNumberOfDaysInMonth() {
		if(month == 2){
			if(isLeapYear())numberOfDaysInMonth = 29;
			else numberOfDaysInMonth =28;
		}
		
		else if(month<8){
			if(month %2 ==0 )numberOfDaysInMonth = 30;
			else numberOfDaysInMonth = 31;
		}
		
		else {
			if(month % 2 ==0) numberOfDaysInMonth=31;
			else numberOfDaysInMonth=30;
		}
	}

	private boolean isLeapYear(){
	 	   
	   if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0))
		   return true;
	   else
	       return false;  
	  
	}
	

	private void drawNameOfWeekDays() {
		JLabel mondayLabel = new JLabel("সোম");
		mondayLabel.setBounds(300,250,60,50);
		mondayLabel.setFont(new Font("Vrinda", Font.BOLD, 30));
		add(mondayLabel);
		JLabel tuedayLabel = new JLabel("মঙ্গল");
		tuedayLabel.setBounds(400,250,150,50);
		tuedayLabel.setFont(new Font("Vrinda", Font.BOLD, 30));
		add(tuedayLabel);
		
		JLabel wednesdayLabel = new JLabel("বোধ");
		wednesdayLabel.setBounds(500,250,150,50);
		wednesdayLabel.setFont(new Font("Vrinda", Font.BOLD, 30));
		add(wednesdayLabel);
		
		JLabel thirstdayLabel = new JLabel("বৃহ:");
		thirstdayLabel.setBounds(600,250,150,50);
		thirstdayLabel.setFont(new Font("Vrinda", Font.BOLD, 30));
		add(thirstdayLabel);
		
		JLabel fridayLabel = new JLabel("শুক্র");
		fridayLabel.setBounds(700,250,150,50);
		fridayLabel.setFont(new Font("Vrinda", Font.BOLD, 30));
		add(fridayLabel);
		
		JLabel saterdayLabel = new JLabel("শনি");
		saterdayLabel.setBounds(800,250,150,50);
		saterdayLabel.setFont(new Font("Vrinda", Font.BOLD, 30));
		saterdayLabel.setForeground(Color.BLUE);
		add(saterdayLabel);
		
		JLabel sundayLabel = new JLabel("রবি");
		sundayLabel.setBounds(200,250,150,50);
		sundayLabel.setFont(new Font("Vrinda", Font.BOLD, 30));
		sundayLabel.setForeground(Color.RED);
		add(sundayLabel);
		
	}

	private void makeComboboxofMonth() {
		JLabel textLabel = new JLabel("মাস:");
		textLabel.setFont(new Font("Vrinda",Font.PLAIN,30));
		textLabel.setBounds(1070,100,100,40);
		add(textLabel);
		
		monthList = new JComboBox<String>(months);
		monthList.setSelectedIndex(month-1);
		monthList.setEditable(true);
		monthList.setFont(new Font("Vrinda",Font.PLAIN,30));
		monthList.setBounds(1120,100,100,40);
		
		add(monthList);

	}

	private void makeComboboxOfYear() {
		JLabel textLabel = new JLabel("সাল:");
		textLabel.setFont(new Font("Vrinda",Font.PLAIN,30));
		textLabel.setBounds(900,100,80,40);
		add(textLabel);
		
		
		String []years = new String[6000];
		for(int i=0;i<6000;i++){
			years[i]=getStringOfBengaliNumber(i+1);
		}
		
		yearList = new JComboBox<String>(years);
		yearList.setSelectedIndex(2016);
		yearList.setEditable(true);
		yearList.setFont(new Font("Vrinda",Font.PLAIN,30));
		yearList.setBounds(950,100,100,40);

		
		add(yearList);
		
	}

	private void intialiseTime() {
		zone = ZoneId.of( "Asia/Dhaka" );
		zonedDateAndTime = ZonedDateTime.now(zone);
		year = zonedDateAndTime.getYear();
		month = zonedDateAndTime.getMonthValue();
		setNumberOfDaysInMonth();
		setDayOfFirstWeek();
		
	}

	private void setDayOfFirstWeek() {
		
		int weekDay = zonedDateAndTime.getDayOfWeek().getValue();
		int day = zonedDateAndTime.getDayOfMonth();
		int remainder = day % 7 ;
		if(remainder==0)remainder =7;
		dayOfFirstWeek =  weekDay - (remainder-1);
		if(dayOfFirstWeek<=0) dayOfFirstWeek=dayOfFirstWeek+7;
		
	}

	private void makeTitleLabel(){
		JLabel titleLabel = new JLabel("ক্যালেন্ডার");
		titleLabel.setFont(new Font("Vrinda",Font.BOLD,50));
		titleLabel.setBounds(600,10,500,40);
		add(titleLabel);
	}

	private String getStringOfBengaliNumber(int year2) {
		String year="";
		int remainder;
		while(true){
			remainder = year2 % 10;
			year2-=remainder;
			year2/=10;
			year = String.valueOf((char)(remainder+'০')) + year;
			if(year2==0)break;
		}
		return year;
	}

	private void setProperties() {
		setLayout(null);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int currentDate = ZonedDateTime.now(zone).getDayOfMonth();
		int currentMonth = ZonedDateTime.now(zone).getMonthValue();
		int currentYear = ZonedDateTime.now(zone).getYear();
		
		g.setFont(new Font("Vrinda",Font.BOLD,40));
		g.drawString(months[month-1]+", "+getStringOfBengaliNumber(year), 450, 200);
		int x,y;
		char firstDigitOfDate='০',secondDigitOfDate='১';
		if(dayOfFirstWeek ==7)x=203;
		else x=203+dayOfFirstWeek*100;
		y=350;
		
		
		for(int i=0;i<numberOfDaysInMonth;i++){
			
			if(x==803)g.setColor(Color.BLUE);
			else if(x==203)g.setColor(Color.RED);
			else g.setColor(Color.BLACK);
			g.drawString(String.valueOf(firstDigitOfDate)+String.valueOf(secondDigitOfDate), x, y);
			secondDigitOfDate++;
			if(secondDigitOfDate=='১'+9){secondDigitOfDate='০';firstDigitOfDate++;}
			if((this.month == currentMonth) && (i+1 == currentDate) && (this.year == currentYear) ){
				g.drawRect(x-4, y-25, 50, 40);
			}
			if(x==803){x=203;y+=50;}
			else x+= 100;
		}
		
	}
	
}
