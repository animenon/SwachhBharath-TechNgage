package com.example.swachh_bharat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class help_activity extends Activity {
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		
		Spinner dropdown = (Spinner)findViewById(R.id.spinner_help);
		String[] items = new String[]{"Sarjapur Road","Whitefield","Bannerghatta Road","Electronic City","HSR Layout","Jayanagar","JP Nagar","Hosur Road","Indira Nagar","Koramangala","Yelahanka","Hesaraghatta Main Road","Devanahalli","Marathahalli","Hebbal","Kanakapura Road","Anekal","Hennur Road","C V Raman Nagar","Kalyan Nagar","RT Nagar","Jalahalli","HRBR Layout","BTM Layout","Ramamurthy Nagar","Brooke Field","Jakkur","Dollars Colony","Abbigere","Rajanukunte","G M Palya","Kundalahalli","Madiwala","Fraser Town","Chandapur","Gottigere","Basavanagar","Nagarbhavi","Belandur","Hoskote","Chamarajpet","Richards Town","Lavelle Road","Kodigehalli","Chikkajala","Hanumanth Nagar","Akshaya Nagar","Thanisandra","Sarjapur","Hegde Nagar","Jigani Industrial Area","Mathikere","Rest House Road","Begur Road","Rajajinagar","MG Road","HBR Layout","Banaswadi","Uttarahalli","Airport Road","Thippasandra","Banashankari","Bagalur","Horamavu","KR Puram","Bommanahalli","OMBR Layout","Mysore Road","Silkboard","RMV Extension Stage","Old Madras Road","Kasturi Nagar","Tumkur Road","Richmond Road","Vidyaranyapura","Mahadevapura","Rajarajeshwari Nagar","Malleshwaram","AECS Layout","Chikkaballapur","Defence Colony","Kanaka Nagar","Hulimavu","Thyagaraj Nagar","Basaveshwaranagar","Airport Area","Kumaraswamy Layout","Sanjay Nagar","Hoskote","Kudlu Gate","RBI Layout","Palace Road","Hoodi Village","Millers Road","Huskur","Vijaya Bank Layout","Shanti Nagar","Hebbal Kempapura","Tippasandra","Naganathapura","Yeshwantpur","Jeevan Bima Nagar","Cox Town","Ulsoor","Benson Town","ITPL","Doddaballapur","Kaggadaspura","Nagwar","Attibele","Padmanabhanagar","Vijayanagar","Kengeri","Peenya","Magadi Road","NelaMangala","Sahakar Nagar","Dodballapur Road","Outer Ring Road","Vigyan Nagar","Basavanagudi","Mallesh Palaya","Domlur","Cookes Town","Old Airport Road","Bellary Road","Sadaramangala","Anjanapura","Majestic","Vasanth Nagar","Wilson Garden","ISRO Layout","HMT Layout","Nagawara","Doddaballapur Road","Central Silk Board","Nandi Hills","Ganganagar","Bommasandra","Pai Layout","Sadaramangala","Prashanth Nagar","Hennur","Raj Bhavan","Vidyanagar","Bilekahalli","Manek Chowk","Chambal River","Indraprastha"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
		dropdown.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
