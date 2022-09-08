/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

public class Clock {
      
   //variable to store hours
   private int hours;
  
   //variable to store minutes
   private int minutes;
  
   //variable to store seconds
   private int seconds;

   //Constructor to initialize instance variables
   public Clock(int hours, int minutes, int seconds) {
       super();
       this.hours = hours;
       this.minutes = minutes;
       this.seconds = seconds;
   }

   //hours getters and setter
   public int getHours() {
       return hours;
   }

   public void setHours(int h) {
       hours = ((h>=0&&h<24)?h:0);
   }

   //minutes getters and setters
   public int getMinutes() {
       return minutes;
   }

   public void setMinutes(int m) {
       minutes = ((m>=0&&m<24)?m:0);
   }

   //seconds getters and setters
   public int getSeconds() {
       return seconds;
   }

   public void setSeconds(int s) {
       seconds = ((s>=0&&s<24)?s:0);
   }

  
   //overrding toString method to display in the format as given in file
   @Override
   public String toString() {
       return String.format("%02d:%02d:%02d", getHours(),getMinutes(),getSeconds());
   }

}