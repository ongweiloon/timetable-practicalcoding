package com.practicalcoding.constants;



import com.practicalcoding.timetable.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MySplash extends Activity {
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		onCreate(savedInstanceState);
		setContentView(R.layout.my_splash);
	}
	
public void startOnClick(View V){
	final Intent intent = new Intent(getApplicationContext(),RegActivity.class);
	//intent.putExtra("ticket", 0);
	startActivity(intent);
}
}