package com.practicalcoding.timetable;

import java.util.List;



import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.practicalcoding.utility.SharedPreferenceConnector;
import com.practicalcoding.utility.Utility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
public class TimeTable extends Activity {
	 private Spinner spin;
	  private Button button1;
	
	String uniqueName= new String();
	TextView timeTable_TV;
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
			
		
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();//bundle contains data (sends from one place to other)
		if (extras != null) {
			uniqueName= extras.getString("unique");
		}
		
		setContentView(R.layout.time_table);
		timeTable_TV = (TextView) findViewById(R.id.textView1);
		
		Utility.getTodaysDay();
		String localData = SharedPreferenceConnector.readString(TimeTable.this, SharedPreferenceConnector.TIME_TABLE_LIST, "");
		if(localData == null || localData.equals("")){
			Toast.makeText(TimeTable.this, "local blank", 10).show();
			getTimeTable();
		}else{
			Toast.makeText(TimeTable.this, "local data is there", 10).show();
			String todysTimeTable =  Utility.getSingleDayTimeTable(localData, Utility.getTodaysDay());
			
            timeTable_TV.setText(todysTimeTable);
		}
		addListenerOnButton();
		addListenerOnSpinnerItemSelection();
	//	ParseAnalytics.trackAppOpened(getIntent());
	}

	private void addListenerOnSpinnerItemSelection() {
		spin = (Spinner) findViewById (R.id.spinner1);
		//spin.setOnItemSelectedListener(new CustomOnItemSelectedListener());			
		
	}

	private void addListenerOnButton() {
		button1 = (Button) findViewById(R.id.button1);
		spin = (Spinner) findViewById (R.id.spinner1);
	   	button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String localData1 = SharedPreferenceConnector.readString(TimeTable.this, SharedPreferenceConnector.TIME_TABLE_LIST, "");
				String todaysTimeTable = Utility.getSingleDayTimeTable(localData1, String.valueOf(spin.getSelectedItem()));
				 timeTable_TV.setText(todaysTimeTable);
				
			}
	   		
	   	});
	    
	}

	private void getTimeTable() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("timetable");
		/*ParseObject timeTable = new ParseObject("timetable");
		public String timetb = new String();
		 timetb = timeTable.getString("name").toString();*/
		 
		 
		 
		
		query.whereEqualTo("name",uniqueName);
		query.findInBackground(new FindCallback<ParseObject>() {
		    

			
			public void done(List<ParseObject> objects, ParseException e) {
				// TODO Auto-generated method stub
				if (e == null) {
					
					
		            Log.d("score", "Retrieved " + objects.get(0).getString("timetable").toString() + " scores");
					//Toast.makeText(TimeTable.this, objects.get(0).getString("timetable").toString(), 10).show();
		            SharedPreferenceConnector.writeString(TimeTable.this, SharedPreferenceConnector.TIME_TABLE_LIST, objects.get(0).getString("timetable").toString());

		            String todysTimeTable =  Utility.getSingleDayTimeTable(objects.get(0).getString("timetable").toString(), Utility.getTodaysDay());
					
		            timeTable_TV.setText(todysTimeTable);
					
		        } else {
		            Log.d("score", "Error: " + e.getMessage());
		        }
			}
		});
		
	}
	
	

	
}