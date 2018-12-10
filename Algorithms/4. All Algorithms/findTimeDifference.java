import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	public static int ONEHOURINMINS = 60;
	public static int ONEDAYINHOURS = 24;

	public static long findTimeDiff(long timeOfEvent, long timeBuffer) {
		String time = String.valueOf(timeOfEvent);
		
		int len = time.length();
		if(len < 4) {
			int diff = 4 - len;
			String a = "";
			for(int i = 1; i <= diff; i++) 
				a += 0;
			time = a + time;
		}
		
		long timeInHours = Long.parseLong(time.substring(0, 2));
		long timeInMins = Long.parseLong(time.substring(2, 4));
		
		long bufferTimeInMins = timeBuffer % ONEHOURINMINS;
		long bufferTimeInHours = timeBuffer / ONEHOURINMINS;
		
		if(timeInMins >= bufferTimeInMins) {
			timeInMins = timeInMins - bufferTimeInMins;
		} else {
			timeInMins = (ONEHOURINMINS - (bufferTimeInMins - timeInMins));
			bufferTimeInHours++;
		}

		int day = 0;
		if(timeInHours >= bufferTimeInHours) {
			timeInHours = timeInHours - bufferTimeInHours;
		} else {
			timeInHours = (ONEDAYINHOURS - (bufferTimeInHours - timeInHours));
			day++;
		}
		
		String hoursTime = String.valueOf(timeInHours);
		String minsTime = String.valueOf(timeInMins);
		String appendZero = "0";
		
		if(hoursTime.length() == 1)
			hoursTime = appendZero + hoursTime; 
		if(minsTime.length() == 1)
			minsTime = appendZero + minsTime; 
		
		System.out.println("Change in days " + day);
		System.out.println("New Time : " + (hoursTime + " " + minsTime));
		
		return 0;
	}

	public static void main(String[] args) {
		long timeOfEvent = 25; /* Get time using API */
		long timeBuffer = 35; /* Get time using API */
		long result = findTimeDiff(timeOfEvent, timeBuffer);

	}
}