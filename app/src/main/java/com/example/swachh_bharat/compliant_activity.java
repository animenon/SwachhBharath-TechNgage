package com.example.swachh_bharat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.io.InputStream;

public class compliant_activity extends Activity {


	int compliant_no;
	String comp_loc, Name, comp_cause, Number, location, pin;
	String[] selectionargs = {"compliant_no", "comp_loc", "Name", "comp_cause", "Number", "location", "pin"};
	double longitude;
	double latitude;
	int Request_code = 2;


	static final String select_last_row = "select  * from compliant_info;";
	Bitmap image;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compliant);

		Spinner dropdown = (Spinner) findViewById(R.id.spinner1);
		String[] items = new String[]{"Sarjapur Road", "Whitefield", "Bannerghatta Road", "Electronic City", "HSR Layout", "Jayanagar", "JP Nagar", "Hosur Road", "Indira Nagar", "Koramangala", "Yelahanka", "Hesaraghatta Main Road", "Devanahalli", "Marathahalli", "Hebbal", "Kanakapura Road", "Anekal", "Hennur Road", "C V Raman Nagar", "Kalyan Nagar", "RT Nagar", "Jalahalli", "HRBR Layout", "BTM Layout", "Ramamurthy Nagar", "Brooke Field", "Jakkur", "Dollars Colony", "Abbigere", "Rajanukunte", "G M Palya", "Kundalahalli", "Madiwala", "Fraser Town", "Chandapur", "Gottigere", "Basavanagar", "Nagarbhavi", "Belandur", "Hoskote", "Chamarajpet", "Richards Town", "Lavelle Road", "Kodigehalli", "Chikkajala", "Hanumanth Nagar", "Akshaya Nagar", "Thanisandra", "Sarjapur", "Hegde Nagar", "Jigani Industrial Area", "Mathikere", "Rest House Road", "Begur Road", "Rajajinagar", "MG Road", "HBR Layout", "Banaswadi", "Uttarahalli", "Airport Road", "Thippasandra", "Banashankari", "Bagalur", "Horamavu", "KR Puram", "Bommanahalli", "OMBR Layout", "Mysore Road", "Silkboard", "RMV Extension Stage", "Old Madras Road", "Kasturi Nagar", "Tumkur Road", "Richmond Road", "Vidyaranyapura", "Mahadevapura", "Rajarajeshwari Nagar", "Malleshwaram", "AECS Layout", "Chikkaballapur", "Defence Colony", "Kanaka Nagar", "Hulimavu", "Thyagaraj Nagar", "Basaveshwaranagar", "Airport Area", "Kumaraswamy Layout", "Sanjay Nagar", "Hoskote", "Kudlu Gate", "RBI Layout", "Palace Road", "Hoodi Village", "Millers Road", "Huskur", "Vijaya Bank Layout", "Shanti Nagar", "Hebbal Kempapura", "Tippasandra", "Naganathapura", "Yeshwantpur", "Jeevan Bima Nagar", "Cox Town", "Ulsoor", "Benson Town", "ITPL", "Doddaballapur", "Kaggadaspura", "Nagwar", "Attibele", "Padmanabhanagar", "Vijayanagar", "Kengeri", "Peenya", "Magadi Road", "NelaMangala", "Sahakar Nagar", "Dodballapur Road", "Outer Ring Road", "Vigyan Nagar", "Basavanagudi", "Mallesh Palaya", "Domlur", "Cookes Town", "Old Airport Road", "Bellary Road", "Sadaramangala", "Anjanapura", "Majestic", "Vasanth Nagar", "Wilson Garden", "ISRO Layout", "HMT Layout", "Nagawara", "Doddaballapur Road", "Central Silk Board", "Nandi Hills", "Ganganagar", "Bommasandra", "Pai Layout", "Sadaramangala", "Prashanth Nagar", "Hennur", "Raj Bhavan", "Vidyanagar", "Bilekahalli", "Manek Chowk", "Chambal River", "Indraprastha"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
		dropdown.setAdapter(adapter);

		Spinner dropdown1 = (Spinner) findViewById(R.id.spinner2);
		String[] items1 = new String[]{"waste disposal", "waste segregation", "Dustbin needed"};
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items1);
		dropdown1.setAdapter(adapter1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public void onclick_submit(View v) {

		Spinner comp_location1 = (Spinner) findViewById(R.id.spinner1);
		Spinner cause1 = (Spinner) findViewById(R.id.spinner2);
		EditText Name1 = (EditText) findViewById(R.id.name);
		EditText phone1 = (EditText) findViewById(R.id.phone);
		EditText user_location1 = (EditText) findViewById(R.id.address1);
		EditText pin_code1 = (EditText) findViewById(R.id.pin1);


		String comp_location = comp_location1.getItemAtPosition(comp_location1.getSelectedItemPosition()).toString();
		String cause = cause1.getItemAtPosition(cause1.getSelectedItemPosition()).toString();
		String Name = Name1.getText().toString();
		String phone = phone1.getText().toString();
		String user_location = user_location1.getText().toString();
		String pin_code = pin_code1.getText().toString();


		final ParseObject testObject = new ParseObject("Complaints");

		testObject.put("com_area", comp_location);
		testObject.put("problem", cause);
		testObject.put("filedby", Name);
		testObject.put("mob_number", phone);
		testObject.put("address", user_location);
		testObject.put("pin_code", pin_code);

		ParseGeoPoint point = new ParseGeoPoint(latitude,longitude);
		//ParseObject object = new ParseObject("PlaceObject");
		testObject.put("geo_point", point);

		byte[] braveData = (image.toString()).getBytes();
		ParseFile imgFile = new ParseFile("image.png", braveData);
		imgFile.saveInBackground();

		testObject.put("image", imgFile);


		testObject.saveInBackground(new SaveCallback() {
			@Override
			public void done(ParseException e) {
				if (e != null) {
					Toast.makeText(getApplicationContext(), "Failed dude" + e.getCode(), Toast.LENGTH_LONG).show();
					e.printStackTrace();

				} else {

					Toast.makeText(getApplicationContext(), "Success" + testObject.getObjectId(), Toast.LENGTH_LONG).show();

				}
			}
		});


	}

	public void onclick_sub(View v) {
		Intent sub_intent = new Intent(this, Working.class);
		startActivity(sub_intent);
	}

	public void add_location(View v) {

		Intent new_intent = new Intent(this, MapsActivity.class);
		startActivityForResult(new_intent, Request_code);


	}


	public void add_image(View v)

	{

		Intent galleryIntent = new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
// Start the Intent
		startActivityForResult(galleryIntent, 3);

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		try {
			// When an Image is picked
			if (requestCode == 3 && resultCode == RESULT_OK
					&& null != data) {
				// Get the Image from data

				Uri selectedImage = data.getData();
				String[] filePathColumn = {MediaStore.Images.Media.DATA};

				// Get the cursor
				Cursor cursor = getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				// Move to first row
				cursor.moveToFirst();

				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				String imgDecodableString = cursor.getString(columnIndex);
				cursor.close();
				//ImageView imgView = (ImageView) findViewById(R.id.imgView);
				// Set the Image in ImageView after decoding the String
				//imgView.setImageBitmap(BitmapFactory
				//		.decodeFile(imgDecodableString));

				image = BitmapFactory
						.decodeFile(imgDecodableString);

			} else {
				Toast.makeText(this, "You haven't picked Image",
						Toast.LENGTH_LONG).show();
			}
		} catch (Exception e) {
			Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
					.show();
		}


		if(requestCode==Request_code && resultCode==RESULT_OK)
		{
			latitude=data.getDoubleExtra("latitude",2);
			longitude=data.getDoubleExtra("longitude",3);
		}

	}




}