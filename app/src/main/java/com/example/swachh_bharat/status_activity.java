package com.example.swachh_bharat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class status_activity extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status);


		View viewById = findViewById(R.id.button1);
		viewById.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onclick_submit(view);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onclick_submit(View v)
	{
		Intent sub_intent=new Intent(this,Working.class);
		startActivity(sub_intent);
	}
}
