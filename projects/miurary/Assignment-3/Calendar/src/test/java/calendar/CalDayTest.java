/* A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;

import java.util.GregorianCalendar;

public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    CalDay test = new CalDay();
    assertFalse(test.isValid());
    assertNull(test.iterator());

    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 5);
    cal.set(GregorianCalendar.DATE, 9);

    CalDay test1 = new CalDay(cal);
    assertTrue(test1.isValid());

    Appt appt0 = new Appt(15, 30, 9, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt1 = new Appt(9, 30, 9, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    Appt appt2 = new Appt(9, 30, 40, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt2.setValid();

    test1.addAppt(appt0);
    test1.addAppt(appt1);
    test1.addAppt(appt2);
    assertNotNull(test.toString());

    assertNotNull(test1.getFullInfomrationApp(test1));

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 5);
    cal.set(GregorianCalendar.DATE, 9);

    CalDay test1 = new CalDay(cal);
    assertTrue(test1.isValid());

    Appt appt0 = new Appt(0, 5, 9, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

    test1.addAppt(appt0);

    assertNotNull(test1.getFullInfomrationApp(test1));

    assertNotNull(test1.toString());

  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {

    GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 5);
    cal.set(GregorianCalendar.DATE, 9);

    CalDay test1 = new CalDay(cal);
    assertTrue(test1.isValid());

    Appt appt0 = new Appt(0, 5, 9, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

    test1.addAppt(appt0);

    assertEquals(1, test1.getSizeAppts());
    assertEquals(9, test1.getDay());
    assertEquals(6, test1.getMonth());
    assertEquals(2018, test1.getYear());

  }

}
