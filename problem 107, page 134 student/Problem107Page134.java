import java.util.*;
import java.lang.Math;
/**
 * Friday the 13.
 *
 * @author  Tai-Yu Chen
 * @version (a version number or a date)
 */
public class Problem107Page134
{
/*
 *  returns an array of all months with a Friday the 13th in Calendar order
 *        Use the following Strings for each Month
 *        "Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"
 */
   public static String[] findFriday13(int year)
   {
      String[] m = {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
      int y = (year+((year-1)/4)-((year-1)/100)+((year-1)/400))% 7;
      if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){ // leap year
        if(y==0){return new String[]{"Jan", "April", "July"};}
        if(y==1){ return new String[]{"Sept","Dec"};}
        if(y==2){ return new String[]{"June"};}
        if(y==3){ return new String[]{"March","Nov"};}
        if(y==4){ return new String[]{"Feb","Aug"};}
        if(y==5){ return new String[]{"May"};}
        if(y==6){ return new String[]{"Oct"};}
    }else{
        if(y==0){return new String[]{"Jan", "Oct"};}
        if(y==1){ return new String[]{"April","July"};}
        if(y==2){ return new String[]{"Sept","Dec"};}
        if(y==3){ return new String[]{"June"};}
        if(y==4){ return new String[]{"Feb","March","Nov"};}
        if(y==5){ return new String[]{"Aug"};}
        if(y==6){ return new String[]{"May"};}
    }
    return null;
   }
}