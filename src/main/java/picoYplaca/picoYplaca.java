package picoYplaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class picoYplaca {
	private int plate_number;
	private String date;
	private String time;
	// constructor of the class
	/**
	* constructor of the class
	* @author  Cristian
	* @param a plate number, date and time
	*/
	public picoYplaca(int plate_number, String date, String time) {
		// update the private fields
		this.plate_number= plate_number;
		this.date= date;
		this.time = time;
	}
	
	
	/**
	* Function to check if a car can drive or not during picoYplaca hour
	* A car is restricted by the last number of the plate in the following schedule:
	* MONDAY LAST DIGITS 1 and 2
	* TUESDAY LAST DIGITS 3 and 4
	* WEDNESDAY LAST DIGITS 5 and 6
	* THURSDAY LAST DIGITS 7 and 8
	* FRIDAY LAST DIGITS 9 and 0
	* PICO Y PLACA TIME IN QUITO
	* 07:00 to 09:30  MORNING
	* 16:00. to 19:30  AFTERNOON
	* @author  Cristian
	* @return  TRUE if the car can drive, False if not, this includes invalid data
	* @requires valid object
	*/
	
	public boolean Should_ride () {
		// check for corner cases
		if(date == null || time == null || date.isEmpty() || date.isBlank() || time.isBlank() || time.isEmpty() || plate_number < 0 )
			return false;
		//create a calendar object 
		Calendar calendar;
		calendar =Calendar.getInstance();
		//parse the date given to  a java date object
		SimpleDateFormat  test = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date dateParsed = null;
		try {
			dateParsed = test.parse(this.date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("error in the parsing");
		}
		// set the calendar to the date parsed and get the day from the object
		calendar.setTime(dateParsed);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		// helper function to check if the 
		return legal_drive(dayOfWeek);
	}
	

	/**
	* Helper function to compare the week day, time and plate number
	* @author  Cristian
	* @return boolean variable
	* @requires valid object
	*/
	
	private boolean legal_drive (int day) {
		int last_digit= this.plate_number%10;
		// get instances of time objects to relate time intervals
		LocalTime morning_lower =LocalTime.of(6, 59);
		LocalTime morning_upper =LocalTime.of(9, 31);
		LocalTime night_lower =LocalTime.of(15, 59);
		LocalTime night_upper =LocalTime.of(19, 31);
		LocalTime car_time = LocalTime.parse(this.time, DateTimeFormatter.ofPattern("HH:mm"));
		
		// check if the time is inside pico y placa if not then its legal to drive with any car. Otherwise, check the day and digit
		
		if((car_time.isAfter(morning_lower) && car_time.isBefore(morning_upper)) || ( car_time.isAfter(night_lower) && car_time.isBefore(night_upper))) 
			return checkDayDigit(day,last_digit);
		else 
			return true; 				
	}
	/**
	* Helper function to compare the week day and last digit of the plate number
	* @author  Cristian
	* @return boolean variable
	* @requires valid object
	*/
	private boolean checkDayDigit(int day, int digit)  {
		if(day==Calendar.MONDAY && (digit==1 || digit==2))
			return false;
		else if(day==Calendar.TUESDAY && (digit==3 || digit==4))
			return false;
		else if(day==Calendar.WEDNESDAY && (digit==5 || digit==6))
			return false;
		else if(day==Calendar.THURSDAY && (digit==7 || digit==8))
			return false;
		else if(day==Calendar.FRIDAY && (digit==9|| digit==0))
			return false;
		else
			return true;							
	}
}
