package calendar;

import java.util.Calendar;
import java.util.Random;
import calendar.Appt;
import calendar.CalDay;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	public static String RandomSelectMethod(Random random){
			String[] methodArray = new String[] {"deleteAppt", "getApptRange"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

			return methodArray[n] ; // return the method name
			}

    /**
     * Generate Random Tests that tests DataHandler Class.
     */
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

										 Appt appt2 = new Appt(startHour,
														 startMinute ,
														 startDay + 1,
														 startMonth ,
														 startYear ,
														 title,
														description,
														emailAddress);

														Appt appt3 = new Appt(startHour + 1,
			 														 startMinute ,
			 														 startDay + 2 ,
			 														 startMonth ,
			 														 startYear ,
			 														 title,
			 														description,
			 														emailAddress);

										 GregorianCalendar cal = new GregorianCalendar();
										cal.set(GregorianCalendar.YEAR, startYear);
										cal.set(GregorianCalendar.MONTH, startMonth);
										cal.set(GregorianCalendar.DATE, startDay);

										GregorianCalendar cal2 = new GregorianCalendar();
									 cal.set(GregorianCalendar.YEAR, startYear);
									 cal.set(GregorianCalendar.MONTH, startMonth);
									 cal.set(GregorianCalendar.DATE, startDay + 2);

							boolean save;
							int choice = ValuesGenerator.getRandomIntBetween(random, 1, 2);
							if (choice == 1)
								save = true;
							else
								save = false;

							DataHandler test = new DataHandler("test.txt", save);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
				String methodName = DataHandlerRandomTest.RandomSelectMethod(random);
				if (methodName.equals("deleteAppt")) {
						appt.setValid();
						appt2.setValid();

						test.saveAppt(appt);
						test.deleteAppt(appt);
						test.deleteAppt(appt2);
				}
				else if (methodName.equals("getApptRange")) {
					appt.setValid();
					appt2.setValid();
					appt3.setValid();

					int array[] = new int[]{1, 2, 3};
		      appt2.setRecurrence(array, 7, 1, 1);

					test.saveAppt(appt);
					test.saveAppt(appt2);
					test.saveAppt(appt3);

					test.getApptRange(cal, cal2);
				}


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
