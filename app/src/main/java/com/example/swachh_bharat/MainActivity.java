package com.example.swachh_bharat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

import com.parse.ParseObject;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void  onclick_complaint(View v)
	{
		Intent compliant_intent=new Intent(this,compliant_activity.class);
		startActivity(compliant_intent);
		
	}
	
	public void onclick_status(View v)
	{
		
		Intent status_intent=new Intent(this,status_activity.class);
		startActivity(status_intent);
		
		
	}
	
	
	public void onclick_help(View v)
	{
		Intent help_intent=new Intent(this,help_activity.class);
		startActivity(help_intent);
	}

}
