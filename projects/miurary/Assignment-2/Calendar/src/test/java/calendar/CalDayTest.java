** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	GregorianCalendar cal;
	Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	CalDay calday0 = new CalDay(cal);
	String string0 = calday0.toString();
	string0 = calday0.getFullInformationApp(calday0);
	calday0.addAppt(appt0);
	assertTrue(calday0.isValid());

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

  }

}
