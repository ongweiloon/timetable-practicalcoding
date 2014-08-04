package com.practicalcoding.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

	public static void testFunction(){
		
	}
	
	public static String getSingleDayTimeTable(String data,String day){
		try {
		JSONArray weekArray = new JSONArray(data);
		String weekScedule = "";
		if(day.toLowerCase().equals("monday")){
		weekScedule = weekArray.getString(0);
		}else if (day.toLowerCase().equals("tuesday")) {
		weekScedule = weekArray.getString(1);
		}else if (day.toLowerCase().equals("wednesday")) {
		weekScedule = weekArray.getString(2);
		}else if (day.toLowerCase().equals("thrusday")) {
		weekScedule = weekArray.getString(3);
		}else if (day.toLowerCase().equals("friday")) {
		weekScedule = weekArray.getString(4);
		}else if (day.toLowerCase().equals("saturday")) {
		weekScedule = weekArray.getString(5);
		}else if (day.toLowerCase().equals("sunday")) {
		weekScedule = weekArray.getString(6);
		}
		JSONArray dayTimeTableArray = new JSONArray(weekScedule);
		if(dayTimeTableArray != null && dayTimeTableArray.length()>0){
		String timetable = "";
		for (int i = 0; i < dayTimeTableArray.length(); i++) {
		JSONObject time = new JSONObject(dayTimeTableArray.getString(i));
		timetable = timetable.concat("  "+time.getString("time").toString() + " " + time.getString("sub").toString() + "\n");
		}
		return timetable;
		}else{
		return "No class today";
		}
		} catch (JSONException e) {
		return null;
		}catch (Exception e) {
		return null;
		}
		}
		

		public static String getTodaysDay(){
		SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);

		Calendar calendar = Calendar.getInstance();
		return dayFormat.format(calendar.getTime());
		}
		
		
		
		

}


