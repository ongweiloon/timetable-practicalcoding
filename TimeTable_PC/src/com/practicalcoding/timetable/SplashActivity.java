package com.practicalcoding.timetable;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import com.parse.ParseAnalytics;
import com.practicalcoding.utility.SharedPreferenceConnector;

public class SplashActivity extends Activity {
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_splash);

	//	ParseAnalytics.trackAppOpened(getIntent());
	}
	
	public void startOnClick(View V){
		String localData= SharedPreferenceConnector.readString(SplashActivity.this, SharedPreferenceConnector.TIME_TABLE_LIST, "");
		if(localData==null || localData.equals("")){
			final Intent intent = new Intent(getApplicationContext(),ChooseActivity.class);
			startActivity(intent);
		}
		else{
			final Intent intent = new Intent(getApplicationContext(),TimeTable.class);
			startActivity(intent);
		}
		
	}
	
}
