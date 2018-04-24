
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	String filename = "test.txt";
	DataHandler test = new Datahandler(filename, true);
	Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	GregorianCalendar day0, day1;
	CalDay* days = test.getApptRange(day0, day1);
	assertTrue(test.saveAppt(appt0));
	assertTrue(test.deleteAppt(appt0));
	assertTrue(test.save());
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

  }

}
