package com.practicalcoding.timetable;
import com.parse.ParseObject;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;


 
public class StudentReg extends Activity {
	 private Spinner spinner1, spinner2, spinner3,spinner4;
	  private Button btnSubmit;
	  @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stu_reg);
		
		addListenerOnButton();
		addListenerOnSpinnerItemSelection();	
		
	}
     public void addListenerOnSpinnerItemSelection() {
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
			spinner2 = (Spinner) findViewById(R.id.spinner2);
			spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
			spinner3 = (Spinner) findViewById(R.id.spinner3);
			spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());
			spinner4 = (Spinner) findViewById(R.id.spinner4);
			spinner4.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		  }
     // get the selected dropdown list value
     public void addListenerOnButton() {
    
   	spinner1 = (Spinner) findViewById(R.id.spinner1);
   	spinner2 = (Spinner) findViewById(R.id.spinner2);
   	spinner3 = (Spinner) findViewById(R.id.spinner3);
   	spinner4 = (Spinner) findViewById(R.id.spinner4);
   	btnSubmit = (Button) findViewById(R.id.btnSubmit);
    
   	btnSubmit.setOnClickListener(new OnClickListener() {
    
   	  public void onClick(View v) {
    
   	    Toast.makeText(StudentReg.this,
   		"OnClickListener : " + 
                   "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) + 
                   "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem())+
                   "\nSpinner3 : "+ String.valueOf(spinner3.getSelectedItem())+
                   "\nSpinner4 : "+ String.valueOf(spinner4.getSelectedItem()),
   			Toast.LENGTH_SHORT).show();
   	    ParseObject Student = new ParseObject("student");
   	 //   String name = new String();
   	    String spinner[] = new String[4];
   	    
   	    	spinner[0]=String.valueOf(spinner1.getSelectedItem());
   	    	spinner[1]=String.valueOf(spinner2.getSelectedItem());
   	    	spinner[2]=String.valueOf(spinner3.getSelectedItem());
   	    	spinner[3]=String.valueOf(spinner4.getSelectedItem());
   	   
		Student.put("college", spinner[0]);
		Student.put("branch", spinner[1]);
		Student.put("semester", String.valueOf(spinner3.getSelectedItem()));
		Student.put("division", String.valueOf(spinner4.getSelectedItem()));
		Student.put("name",spinner[0]+"_"+spinner[1]+"_"+spinner[2]+"_"+spinner[3]);
		
		Student.saveInBackground();
		
		final Intent intent = new Intent(getApplicationContext(),TimeTable.class);
		intent.putExtra("unique",spinner[0]+"_"+spinner[1]+"_"+spinner[2]+"_"+spinner[3] );
		startActivity(intent);
		
   	  }
    
   	});
     }
}
