package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dayofweek {

	
	public static void main(String args[]) throws Exception{
		String	date = "08/08/2015";
        String dayOfWeek = null; 
        Date inputDate = null;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
if (date == null)
   inputDate = cal.getTime();
 else 
  {
   try{
      inputDate = format.parse(date);
      }
  catch(Exception nfe)
       {
     System.out.println("[CCSITTools.date:dayOfWeek] Input date " + date + " is not a correct date format (dd/MM/yyyy)..");
       } 
   }
System.out.println("asdsad"+inputDate.getDay()+"  "+inputDate.getMonth()+"  "+inputDate.getYear());

	}
}
