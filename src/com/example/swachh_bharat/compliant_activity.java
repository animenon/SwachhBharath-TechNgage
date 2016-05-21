package com.example.swachh_bharat;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class compliant_activity extends Activity {
	
	
	SQLiteDatabase db; 
	Cursor cus;
	int  compliant_no;
	String comp_loc,Name,comp_cause,Number,location,pin;
	String[]  selectionargs={"compliant_no","comp_loc","Name","comp_cause","Number","location","pin" };
    
	
	
	 static final String select_last_row = "select  * from compliant_info;" ;
     
	 
	 
	 
	 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compliant);
		
		Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
		String[] items = new String[]{ "Sarjapur Road","Whitefield","Bannerghatta Road","Electronic City","HSR Layout","Jayanagar","JP Nagar","Hosur Road","Indira Nagar","Koramangala","Yelahanka","Hesaraghatta Main Road","Devanahalli","Marathahalli","Hebbal","Kanakapura Road","Anekal","Hennur Road","C V Raman Nagar","Kalyan Nagar","RT Nagar","Jalahalli","HRBR Layout","BTM Layout","Ramamurthy Nagar","Brooke Field","Jakkur","Dollars Colony","Abbigere","Rajanukunte","G M Palya","Kundalahalli","Madiwala","Fraser Town","Chandapur","Gottigere","Basavanagar","Nagarbhavi","Belandur","Hoskote","Chamarajpet","Richards Town","Lavelle Road","Kodigehalli","Chikkajala","Hanumanth Nagar","Akshaya Nagar","Thanisandra","Sarjapur","Hegde Nagar","Jigani Industrial Area","Mathikere","Rest House Road","Begur Road","Rajajinagar","MG Road","HBR Layout","Banaswadi","Uttarahalli","Airport Road","Thippasandra","Banashankari","Bagalur","Horamavu","KR Puram","Bommanahalli","OMBR Layout","Mysore Road","Silkboard","RMV Extension Stage","Old Madras Road","Kasturi Nagar","Tumkur Road","Richmond Road","Vidyaranyapura","Mahadevapura","Rajarajeshwari Nagar","Malleshwaram","AECS Layout","Chikkaballapur","Defence Colony","Kanaka Nagar","Hulimavu","Thyagaraj Nagar","Basaveshwaranagar","Airport Area","Kumaraswamy Layout","Sanjay Nagar","Hoskote","Kudlu Gate","RBI Layout","Palace Road","Hoodi Village","Millers Road","Huskur","Vijaya Bank Layout","Shanti Nagar","Hebbal Kempapura","Tippasandra","Naganathapura","Yeshwantpur","Jeevan Bima Nagar","Cox Town","Ulsoor","Benson Town","ITPL","Doddaballapur","Kaggadaspura","Nagwar","Attibele","Padmanabhanagar","Vijayanagar","Kengeri","Peenya","Magadi Road","NelaMangala","Sahakar Nagar","Dodballapur Road","Outer Ring Road","Vigyan Nagar","Basavanagudi","Mallesh Palaya","Domlur","Cookes Town","Old Airport Road","Bellary Road","Sadaramangala","Anjanapura","Majestic","Vasanth Nagar","Wilson Garden","ISRO Layout","HMT Layout","Nagawara","Doddaballapur Road","Central Silk Board","Nandi Hills","Ganganagar","Bommasandra","Pai Layout","Sadaramangala","Prashanth Nagar","Hennur","Raj Bhavan","Vidyanagar","Bilekahalli","Manek Chowk","Chambal River","Indraprastha"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
		dropdown.setAdapter(adapter);
		
		Spinner dropdown1 = (Spinner)findViewById(R.id.spinner2);
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
	
 
	public void onclick_submit(View v)
	{
		// LoginDataBaseAdapter loginDataBaseAdapter=new LoginDataBaseAdapter(this);
      //   loginDataBaseAdapter=loginDataBaseAdapter.open();
         
            Spinner comp_location1=(Spinner)findViewById(R.id.spinner1);
            Spinner cause1=(Spinner)findViewById(R.id.spinner2);
            EditText  Name1=(EditText)findViewById(R.id.name);
            EditText  phone1=(EditText)findViewById(R.id.phone);
            EditText  user_location1=(EditText)findViewById(R.id.address1);
            EditText  pin_code1=(EditText) findViewById(R.id.pin1);
		    //Button    btnCreateAccount1=(Button)findViewById(R.id.button1);
        
		 String comp_location=comp_location1.getItemAtPosition(comp_location1.getSelectedItemPosition()).toString();
		 String cause=cause1.getItemAtPosition(cause1.getSelectedItemPosition()).toString();
		 String Name=Name1.getText().toString();
		 String phone=phone1.getText().toString();
		 String user_location=user_location1.getText().toString();
		 String pin_code=pin_code1.getText().toString();
		 
		 /* 
		 if(comp_location.equals("")||cause.equals("")||Name.equals("") || phone.equals("") || user_location.equals("") || pin_code.equals(""))
         {
                 Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                 return;
         }
		 
		 
		 else
         {
                 // Save the Data in Database
                loginDataBaseAdapter.insertEntry(comp_location,cause,Name,phone,user_location,pin_code);
                 Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                 
                 db=loginDataBaseAdapter.getDatabaseInstance();
                cus=db.rawQuery(select_last_row, selectionargs);
                
                
                compliant_no=cus.getInt(cus.getColumnIndex("complaint_no"));
                comp_loc=cus.getString(cus.getColumnIndex("comp_loc"));
                Name  =cus.getString(cus.getColumnIndex("Name"));
                comp_cause=cus.getString(cus.getColumnIndex("comp_cause"));
                Number=cus.getString(cus.getColumnIndex("Number"));
                location=cus.getString(cus.getColumnIndex("location"));
                pin=cus.getString(cus.getColumnIndex("pin"));
                
                compliant_no=(int)Math.random();
                
                Intent display_compliant=new Intent(this, Displaycompliant_info.class);
                
                display_compliant.putExtra("compliant_no", compliant_no);
                display_compliant.putExtra("comp_loc", comp_loc);
                display_compliant.putExtra("Name", Name);
                display_compliant.putExtra("comp_cause", comp_cause);
                display_compliant.putExtra("Number", Number);
                display_compliant.putExtra("location", location);
                display_compliant.putExtra("pin", pin);
                
                startActivity(display_compliant);
                
                
         }*/
		 
	}
	public void onclick_sub(View v)
	{
		Intent sub_intent=new Intent(this,Working.class);
		startActivity(sub_intent);
	}
}
