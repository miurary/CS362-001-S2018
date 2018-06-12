
package finalprojectB;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import java.util.Random;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }



   public void testManualTest()
   {
     UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     String val1 = null;
     String val2 = "http://255.com/test1/file";
     String val3 = "//:65a/test1//file";
     String val4 = "http//255.com/test1/file";
     String val5 = "//255.com/test1/file";
     String val6 = "://255.com/test1/file";
     String val7 = "/255.com/test1/file";
     String val8 = "http:";
     String val9 = "http://google.com/";
     String val10 = "http:google.com/";
     String val11 = "file://google.com/";
     String val12 = "://google.com";
     String val13 = "http//google.com/";
     String val14 = "http://google/";
     String val15 = "http://googlecom/";
     String val16 = "http://facebook.com/";
     String val17 = "https://www.youtube.com/watch?v=lbeILUhuxDE";
     String val18 = "www.youtube.com";
     String val19 = "https://oregonstate.edu/";
     String val20 = "http://web.engr.oregonstate.edu/~erwig/cs381/#slides";
     String val21 = "a";
     String val22 = "?";
     String val23 = "http://google.com:";
     String val24 = "http://goo:gle.com/";

     assertFalse(validator.isValid(val1)); //doesnt make it
     //assertTrue(validator.isValid(val2));
     assertFalse(validator.isValid(val3)); //null
     assertFalse(validator.isValid(val4)); //null
     assertFalse(validator.isValid(val5)); //null
     assertFalse(validator.isValid(val6)); //null
     assertFalse(validator.isValid(val7)); //null
     //assertFalse(validator.isValid(val8));
     assertTrue(validator.isValid(val9)); //http
     assertFalse(validator.isValid(val10)); //http
     //assertFalse(validator.isValid(val11));
     assertFalse(validator.isValid(val12)); //null
     //assertFalse(validator.isValid(val13));
     //assertFalse(validator.isValid(val14));
     //assertFalse(validator.isValid(val15));
     assertTrue(validator.isValid(val16)); //http
     //assertTrue(validator.isValid(val17));
     assertFalse(validator.isValid(val18)); //null
     //assertTrue(validator.isValid(val19));
     //assertTrue(validator.isValid(val20));
     assertFalse(validator.isValid(val21)); //null
     assertFalse(validator.isValid(val22)); //null
     assertFalse(validator.isValid(val23));
     assertFalse(validator.isValid(val24));
//You can use this function to implement your manual testing

}


public void testNoProtocolPartition()
{
   UrlValidator urlVal = new UrlValidator();
   urlVal = urlVal.getInstance();
   String[] url = {
     "www.money.com",
     "www.money.com/ilovemoney",
     "127.0.0.1",
     "127.0.0.1:0",
     "money.com",
     ".com.thiswontwork"
   };

   System.out.println("\nFirst partition test: URLs with no protocols");
   for(int i = 0; i < url.length; i++) {
     System.out.print("Testing URL " + (i + 1) + ": " +url[i] + " = ");
     if(urlVal.isValid(url[i])) {
       System.out.println("Valid");
     }
     else {
       System.out.println("Invalid");
     }
   }
   if(urlVal.isValid(null)) {
     System.out.println("Nice.");
   }


}

public void testHttpProtocolPartition(){
  String[] schemes = {
    "http",
    "https"
  };
  UrlValidator urlVals = new UrlValidator(schemes);
  UrlValidator urlVal = new UrlValidator(schemes, null, 1);
  String[] url = {
    "http://www.money.com",
    "http://www.money.com/ilovemoney",
    "http://127.0.0.1",
    "http://127.0.0.1:0",
    "http://money.com/",
    "http://",
    "http:\\thiswontwork.com",
    "https://www.money.com",
    "https://www.money.com/ilovemoney",
    "https://127.0.0.1",
    "https://127.0.0.1:0",
    "https://money.com/",

  };

  System.out.println("\nSecond partition test: URLs with HTTP protocols");
  for(int i = 0; i < url.length; i++) {
    System.out.print("Testing URL " + (i + 1) + ": " + url[i] + " = ");
    if(urlVal.isValid(url[i])) {
      System.out.println("Valid");
    }
    else {
      System.out.println("Invalid");
    }
  }

}

public void testFtpProtocolPartition(){
  String[] schemes = {
    "ftp"
  };
  UrlValidator urlVal = new UrlValidator(schemes, null, 0);
  String[] url = {
    "ftp://www.money.com",
    "ftp://www.money.com/ilovemoney",
    "ftp://127.0.0.1",
    "ftp://127.0.0.1:0",
    "ftp://money.com/"
  };

  System.out.println("\nThird partition test: URLs with FTP protocols");
  for(int i = 0; i < url.length; i++) {
    System.out.print("Testing URL " + (i + 1) + ": " + url[i] + " = ");
    if(urlVal.isValid(url[i])) {
      System.out.println("Valid");
    }
    else {
      System.out.println("Invalid");
    }
  }

}

public void testFileProtocolPartition(){
  String[] schemes = {
    "file"
  };
  UrlValidator urlVal = new UrlValidator(schemes, null, 0);
  String[] url = {
    "file://www.money.com",
    "file://www.money.com/ilovemoney",
    "file://127.0.0.1",
    "file://127.0.0.1:0",
    "file://money.com/"
  };

  System.out.println("\nFourth partition test: URLs with file protocols");
  for(int i = 0; i < url.length; i++) {
    System.out.print("Testing URL " + (i + 1) + ": " + url[i] + " = ");
    if(urlVal.isValid(url[i])) {
      System.out.println("Valid");
    }
    else {
      System.out.println("Invalid");
    }
  }

}

public void testInvalidProtocolsPartition(){
  String[] schemes = {
    "http",
    "https",
    "ftp",
    "file"
  };
  RegexValidator reg = null;
  UrlValidator urlVals = new UrlValidator(reg, 1);
  UrlValidator urlVal = new UrlValidator(schemes, null, 0);
  String[] url = {
    "HTTP://thiswontwork.com",
    "asdf://thiswontwork.com",
    "123://127.0.0.1"
  };

  System.out.println("\nFifth partition test: URLs with invalid protocols");
  for(int i = 0; i < url.length; i++) {
    System.out.print("Testing URL " + (i + 1) + ": " + url[i] + " = ");
    if(urlVal.isValid(url[i])) {
      System.out.println("Valid");
    }
    else {
      System.out.println("Invalid");
    }
  }

}

public void testAuthorityPartition(){
  String[] schemes = {
    "http",
    "https",
    "ftp",
    "file"
  };
  UrlValidator urlVal = new UrlValidator(schemes, null, 1);
  String[] url = {
    "http"
  };

  System.out.println("\nSixth partition test: URL authority tests");
  for(int i = 0; i < url.length; i++) {
    System.out.print("Testing URL " + (i + 1) + ": " + url[i] + " = ");
    if(urlVal.isValid(url[i])) {
      System.out.println("Valid");
    }
    else {
      System.out.println("Invalid");
    }
  }

}
   //You need to create more test cases for your Partitions if you need to

   /*public void testIsValid()
   {
	   //You can use this function for programming based testing

     UrlValidator validator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     long randomseed =System.currentTimeMillis();
		 Random random = new Random(randomseed);

     String[] BASE_CHARACTERS =
   		{" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
   		"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
   		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
   		"~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "=", "|", ":", ";",
   		"?", "/", ".", ">", ",", "<"
   	};
     String [] prefix = new String[]{"http://", "https://", "://", ":", "//", "/", ":/"};
     String [] urlFront = new String[]{"www.", "www", "."};
     String [] urlEnd = new String[]{".com", ".org", ".gov", ".edu", "com", "org", "gov", "edu"};
     String postfix = "/";

     int select;

     for (int x = 0; x < 100; x++) {

    String url = "";
     select = random.nextInt(11);

     switch (select) {
       case 0: url += prefix[0];
       break;
       case 1: url += prefix[1];
       break;
       case 2: url += prefix[2];
       break;
       case 3: url += prefix[3];
       break;
       case 4: url += prefix[4];
       break;
       case 5: url += prefix[5];
       break;
       case 6: url += prefix[6];
       break;
       case 7:
          for (int i = 0; i < 4; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          String endPre = "://";
          url += endPre;
          break;
       case 8:
          for (int i = 0; i < 7; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 9:
          for (int i = 0; i < 7; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          String endPre2 = "://";
          url += endPre2;
          break;
      case 10:
          for (int i = 0; i < 10; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 11:
          break;
     }

     select = random.nextInt(7);

     switch (select) {
       case 0: url += urlFront[0];
       break;
       case 1: url += urlFront[1];
       break;
       case 2: url += urlFront[2];
       break;
       case 3:
          for (int i = 0; i < 3; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 4:
          for (int i = 0; i < 6; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 5:
          for (int i = 0; i < 3; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          String dot = ".";
          url += dot;
          break;
      case 6:
          for (int i = 0; i < 6; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          String dot2 = ".";
          url += dot2;
          break;
      case 7:
      break;
     }

     select = random.nextInt(10);

     for (int i = 0; i < select; i++) {
       String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
       url += temp;
     }

     select = random.nextInt(12);

     switch (select) {
       case 0: url += urlEnd[0];
       break;
       case 1: url += urlEnd[1];
       break;
       case 2: url += urlEnd[2];
       break;
       case 3: url += urlEnd[3];
       break;
       case 4: url += urlEnd[4];
       break;
       case 5: url += urlEnd[5];
       break;
       case 6: url += urlEnd[6];
       break;
       case 7: url += urlEnd[7];
       break;
       case 8:
          for (int i = 0; i < 3; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 9:
          String dot3 = ".";
          url += dot3;
          for (int i = 0; i < 3; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 10:
          for (int i = 0; i < 5; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 11:
          String dot4 = ".";
          url += dot4;
          for (int i = 0; i < 5; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 12:
      break;
     }

     select = random.nextInt(3);
     int selectSize = random.nextInt(10) + 1;

     switch (select) {
       case 0: url += postfix;
       break;
       case 1: url += postfix;
          for (int i = 0; i < selectSize; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 2:
          for (int i = 0; i < selectSize; i++) {
            String temp = BASE_CHARACTERS[random.nextInt(BASE_CHARACTERS.length)];
            url += temp;
          }
          break;
      case 3: break;
      }

      boolean valid = validator.isValid(url);

      System.out.print(url);
      if (valid) {
        System.out.print("-o");
      }
      else {
        System.out.print("-x");
      }

      System.out.println();
     }

   }*/

   /*public static void main(String[] argv) {

    UrlValidatorTest fct = new UrlValidatorTest("url test");
      fct.testManualTest();
   }*/



}
