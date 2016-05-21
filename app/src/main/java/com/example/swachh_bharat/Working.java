package com.example.swachh_bharat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class Working extends Activity{
	String queryString="";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_working);

		ParseQuery<ParseObject> query = ParseQuery.getQuery("Complaints");
		query.findInBackground(new FindCallback<ParseObject>() {
			@Override
			public void done(List<ParseObject> objects, ParseException e) {

				if (e!=null) {
					e.printStackTrace();
					Toast.makeText(Working.this,"Failed to fetxh",Toast.LENGTH_SHORT).show();
					TextView tv = (TextView) findViewById(R.id.textView1);http://news.google.com/
					tv.setText("Failed to fetch");

					return;
				}
				else {
					queryString = "";
					for (int i = 0; i < objects.size(); i++) {

						ParseObject parseObject = objects.get(i);
						queryString += parseObject.getString("filedby") + "\n ";

					}


					TextView tv = (TextView) findViewById(R.id.textView1);
					tv.setText(queryString);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
