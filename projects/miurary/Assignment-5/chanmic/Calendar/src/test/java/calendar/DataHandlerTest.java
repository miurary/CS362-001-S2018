
/* A JUnit test class to test the class DataHandler. */


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
     DataHandler test1 = new DataHandler();
     assertNotNull(test1);

     DataHandler test2 = new DataHandler(filename);
     assertNotNull(test2);

	   DataHandler test = new DataHandler(filename, true);
     assertNotNull(test);

     DataHandler testNoSave = new DataHandler(filename, false);
     assertNotNull(testNoSave);

	   Appt appt0 = new Appt(15, 30, 5, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     Appt badAppt = new Appt(15, 30, 14, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     badAppt.setValid();
     assertFalse(badAppt.getValid());

     GregorianCalendar cal = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 5);
    cal.set(GregorianCalendar.DATE, 10);

    GregorianCalendar cal2 = new GregorianCalendar();
    cal.set(GregorianCalendar.YEAR, 2018);
    cal.set(GregorianCalendar.MONTH, 5);
    cal.set(GregorianCalendar.DATE, 11);

	   assertTrue(test.saveAppt(appt0));
	   assertTrue(test.deleteAppt(appt0));
     assertFalse(test.deleteAppt(appt0));
	   assertTrue(test.save());

     assertFalse(test.saveAppt(badAppt));
     assertFalse(test.deleteAppt(badAppt));

     assertTrue(testNoSave.saveAppt(appt0));
     assertTrue(testNoSave.deleteAppt(appt0));

     assertNotNull(test.getApptRange(cal2, cal));
     //assertEquals("Second date specified is not before the first date specified.", test.getApptRange(cal, cal2));
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

      String filename = "test.txt";
      DataHandler test = new DataHandler(filename, true);

      Appt appt0 = new Appt(15, 30, 10, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      int array[] = new int[]{1, 2, 3};
      appt0.setRecurrence(array, 1, 1, 1);

      GregorianCalendar cal = new GregorianCalendar();
     cal.set(GregorianCalendar.YEAR, 2018);
     cal.set(GregorianCalendar.MONTH, 5);
     cal.set(GregorianCalendar.DATE, 10);

     GregorianCalendar cal2 = new GregorianCalendar();
     cal.set(GregorianCalendar.YEAR, 2018);
     cal.set(GregorianCalendar.MONTH, 5);
     cal.set(GregorianCalendar.DATE, 11);

     assertTrue(test.saveAppt(appt0));
     assertNotNull(test.getApptRange(cal2, cal));

  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {

      String filename = "test.txt";
      DataHandler test = new DataHandler(filename, true);

      Appt appt0 = new Appt(15, 30, 10, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      int array[] = new int[]{};
      appt0.setRecurrence(array, 7, 1, 1);

      GregorianCalendar cal = new GregorianCalendar();
     cal.set(GregorianCalendar.YEAR, 2018);
     cal.set(GregorianCalendar.MONTH, 5);
     cal.set(GregorianCalendar.DATE, 10);

     GregorianCalendar cal2 = new GregorianCalendar();
     cal.set(GregorianCalendar.YEAR, 2018);
     cal.set(GregorianCalendar.MONTH, 5);
     cal.set(GregorianCalendar.DATE, 11);

     assertTrue(test.saveAppt(appt0));
     assertNotNull(test.getApptRange(cal2, cal));

  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {

      String filename = "test.txt";
      DataHandler test = new DataHandler(filename, true);

      Appt appt0 = new Appt(15, 30, 9, 5, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      int array[] = new int[]{};
      appt0.setRecurrence(array, 7, 1, 1);

      GregorianCalendar cal = new GregorianCalendar();
     cal.set(GregorianCalendar.YEAR, 2018);
     cal.set(GregorianCalendar.MONTH, 5);
     cal.set(GregorianCalendar.DATE, 10);

     GregorianCalendar cal2 = new GregorianCalendar();
     cal.set(GregorianCalendar.YEAR, 2018);
     cal.set(GregorianCalendar.MONTH, 5);
     cal.set(GregorianCalendar.DATE, 11);

     assertTrue(test.saveAppt(appt0));
     assertNotNull(test.getApptRange(cal2, cal));

  }

}
