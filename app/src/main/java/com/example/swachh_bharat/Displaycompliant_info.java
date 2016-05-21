package com.example.swachh_bharat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class Displaycompliant_info  extends Activity{
	
	TextView compliant_no,compliant_location,user_name,user_phonenumber,user_location,user_pincode;
	
	String compliant_no1,compliant_location1,user_name1,user_phonenumber1,user_location1,user_pincode1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compliantifo);
		
		
		/*
		compliant_no=(TextView)findViewById(compliant_no);
		compliant_location=(TextView)findViewById(compliant_location);
		user_name=(TextView)findViewById(user_name);
		user_phonenumber=(TextView)findViewById(user_phonenumber);
		user_location=(TextView)findViewById(user_location);
		user_pincode=(TextView)findViewById(user_pincode);
		
		
		compliant_no1= getIntent().getExtras().getString("compliant_no");
		compliant_location1=getIntent().getExtras().getString("comp_loc");
		user_name1=getIntent().getExtras().getString("Name");
		user_phonenumber1=getIntent().getExtras().getString("Number");
		user_location1=getIntent().getExtras().getString("location");
		user_pincode1=getIntent().getExtras().getString("pin");
		
		
		compliant_no.setText(compliant_no1);
		compliant_location.setText(compliant_location1);
		user_name.setText(user_name1);
		user_phonenumber.setText(user_phonenumber1);
		user_location.setText(user_location1);
		user_pincode.setText(user_pincode1);
		
		*/
	}

	private TextView findViewById(TextView compliant_no2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
