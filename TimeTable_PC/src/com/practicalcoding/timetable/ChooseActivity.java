package com.practicalcoding.timetable;

import com.practicalcoding.timetable.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChooseActivity extends Activity {
	  private RadioGroup radioGroup;
	  private RadioButton radioButton;
	  private Button btnNext;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_1);
		addListenerOnButton();
		
	}
		
		 public void addListenerOnButton() {
			 
				radioGroup = (RadioGroup) findViewById(R.id.radioChoose);
				btnNext = (Button) findViewById(R.id.btnNext);
				 
				btnNext.setOnClickListener(new OnClickListener() {
			 
					public void onClick(View v) {
			 
					        // get selected radio button from radioGroup
						int selectedId = radioGroup.getCheckedRadioButtonId();
			 
						// find the radiobutton by returned id
					        radioButton = (RadioButton) findViewById(selectedId);
					        if(radioButton.getText().equals("Professor")){
					        	Toast.makeText(ChooseActivity.this,
										"Still not Programmed", Toast.LENGTH_SHORT).show();
					        }
					        else{
					        final Intent intent = new Intent(getApplicationContext(),StudentReg.class);
							startActivity(intent);
					        }
			 
						//Toast.makeText(ChooseActivity.this,
							//radioButton.getText(), Toast.LENGTH_SHORT).show();
			 
					}
			 
				});
				
			 
			
			  
			
	}
	
}