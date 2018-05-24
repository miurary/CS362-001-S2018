package calendar;

import java.util.Calendar;
import java.util.Random;
import calendar.Appt;

import org.junit.Test;

import java.util.GregorianCalendar;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	 @Test
	  public void radnomtest()  throws Throwable  {

			long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random, -10, 30);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -10, 70);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -10, 40);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -10, 20);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -10, 10);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data
				 //Construct a new Appointment object with the initial data
						 Appt appt = new Appt(startHour,
											startMinute ,
											startDay ,
											startMonth ,
											startYear ,
											title,
										 description,
										 emailAddress);

										 Appt appt2 = new Appt(startHour - 1,
										 				 startMinute ,
										 				 startDay ,
										 				 startMonth ,
										 				 startYear ,
										 				 title,
										 				description,
										 				emailAddress);

										 GregorianCalendar cal = new GregorianCalendar();
					 			    cal.set(GregorianCalendar.YEAR, startYear);
					 			    cal.set(GregorianCalendar.MONTH, startMonth);
					 			    cal.set(GregorianCalendar.DATE, startDay);

							CalDay test1 = new CalDay(cal);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
						appt.setValid();
						appt2.setValid();
						test1.addAppt(appt);
						test1.addAppt(appt2);
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
							if((iteration%10000)==0 && iteration!=0 )
										System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");

	 }



}
