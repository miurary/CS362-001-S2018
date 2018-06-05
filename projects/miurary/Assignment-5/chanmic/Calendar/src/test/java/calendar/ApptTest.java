/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {

   Appt appt0 = new Appt(9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   assertNotNull(appt0);
 }

 @Test(timeout = 4000)
  public void test02()  throws Throwable  {

    Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt0.setValid();
    assertFalse(appt0.getValid());

    Appt appt2 = new Appt(15, 30, 9, 0, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt2.setValid();
    assertFalse(appt2.getValid());

    Appt appt1 = new Appt(24, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt1.setValid();
    assertFalse(appt1.getValid());

    Appt appt3 = new Appt(-1, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt3.setValid();
    assertFalse(appt3.getValid());

    Appt appt4 = new Appt(15, -1, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt4.setValid();
    assertFalse(appt4.getValid());

    Appt appt5 = new Appt(15, 60, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt5.setValid();
    assertFalse(appt5.getValid());

    Appt appt6 = new Appt(15, 30, 9, 10, 0, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt6.setValid();
    assertFalse(appt6.getValid());

    Appt appt7 = new Appt(15, 30, 0, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt7.setValid();
    assertFalse(appt7.getValid());

    Appt appt8 = new Appt(15, 30, 40, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt8.setValid();
    assertFalse(appt8.getValid());

    Appt appt9 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    appt9.setValid();
    assertTrue(appt9.getValid());
  }

  @Test(timeout = 4000)
   public void test03()  throws Throwable  {

     Appt appt0 = new Appt(9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
     assertNotNull(appt0);

     String description = null;
     appt0.setDescription(description);

     String x = "hi";
     appt0.setDescription(x);
   }

   @Test(timeout = 4000)
    public void test04()  throws Throwable  {

      Appt appt0 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      Appt appt1 = new Appt(9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

      assertTrue(appt0.isOn(9, 10, 2018));
      assertFalse(appt0.isOn(10, 10, 2018));

      assertTrue(appt0.hasTimeSet());
      assertFalse(appt1.hasTimeSet());

      //assertSame("\tThis appointment is not valid", appt0.toString());

    }

    @Test(timeout = 4000)
     public void test05()  throws Throwable  {

       Appt appt0 = new Appt(-1, 30, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
       appt0.setValid();
       assertFalse(appt0.getValid());

       Appt appt1 = new Appt(0, 30, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
       appt1.setValid();
       assertTrue(appt1.getValid());

       Appt appt2 = new Appt(23, 30, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
       appt2.setValid();
       assertTrue(appt2.getValid());

       Appt appt3 = new Appt(24, 30, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
       appt3.setValid();
       assertFalse(appt3.getValid());

     }

     @Test(timeout = 4000)
      public void test06()  throws Throwable  {

        Appt appt0 = new Appt(10, -1, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
        appt0.setValid();
        assertFalse(appt0.getValid());

        Appt appt1 = new Appt(10, 0, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
        appt1.setValid();
        assertTrue(appt1.getValid());

        Appt appt2 = new Appt(10, 59, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
        appt2.setValid();
        assertTrue(appt2.getValid());

        Appt appt3 = new Appt(10, 60, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
        appt3.setValid();
        assertFalse(appt3.getValid());

      }

      @Test(timeout = 4000)
       public void test07()  throws Throwable  {

         Appt appt0 = new Appt(10, 30, 0, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
         appt0.setValid();
         assertFalse(appt0.getValid());

         Appt appt1 = new Appt(10, 30, 1, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
         appt1.setValid();
         assertTrue(appt1.getValid());

         Appt appt2 = new Appt(10, 30, 30, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
         appt2.setValid();
         assertTrue(appt2.getValid());

         Appt appt3 = new Appt(10, 30, 31, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
         appt3.setValid();
         assertFalse(appt3.getValid());

       }

}
