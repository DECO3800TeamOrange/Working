package com.example.studentsaleapp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
	
	public final static String PHOTO = "com.example.StudentSaleApp.PHOTO";
	public final static String OBJECT_ID = "com.example.StudentSaleApp.OBJECTID";
	public final static String ITEM_NAME = "com.example.StudentSaleApp.ITEM_NAME";
	public final static String ITEM_DESC = "com.example.StudentSaleApp.ITEM_DESC";
	public final static String USER_ID = "com.example.StudentSaleApp.USER_ID";
	final static int cameraData = 0;
	
	ImageButton ib;
	ImageView iv;
	Intent i;
	EditText location;

	Bitmap itemPhoto;
	Bitmap defaultPhoto;
	byte[] photoByteStream;
	byte[] defaultByteStream;
	String itemName;
	String itemDescription;
	String itemID;
	String userID;
	ParseGeoPoint geoPoint;
	String longitude;
	String latitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Parse.initialize(this, "oSVz4UWfUShEgXckKkqA2G4gESIle3GL0egGqEQI","BU5O1f2A26nLwQOzTB4WEucrKGH7JU7tSyC1d7GW"); 
		setContentView(R.layout.activity_main);
		initialize();
		
		//make photo a default picture then write over byte[] later with real photo
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		defaultPhoto = BitmapFactory.decodeStream(is);
		defaultByteStream = convertBmpToBytes(defaultPhoto);
		
		try {
			geoPoint = getPhoneGeoPoint();
			longitude = String.valueOf(geoPoint.getLongitude());
			latitude = String.valueOf(geoPoint.getLatitude());
			location.setText(longitude + ", "  + latitude);
		} catch (Exception e) {
			location.setText("Can't find you!");
		}
	
	}

	private void initialize() {
		// TODO Auto-generated method stub
		iv = (ImageView) findViewById (R.id.ivReturnedPic);
		ib = (ImageButton)findViewById(R.id.ibTakePhoto);
		ib.setOnClickListener(this);
		location = (EditText) findViewById (R.id.location);
	
	}
	
	public void search(View view){
		Intent newIntent = new Intent(this, Search.class);
		startActivity(newIntent);
	}
	
	public void sellerPosts(View view){
		Intent newIntent = new Intent(this, SellerPosts.class);
		startActivity(newIntent);
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ibTakePhoto :
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);
		break;
			
		}
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			itemPhoto = (Bitmap)extras.get("data");
			photoByteStream = convertBmpToBytes(itemPhoto);
			
			iv.setImageBitmap(itemPhoto);
		}
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void postItem(View v) {
		EditText editName = (EditText) findViewById(R.id.itemName);
		EditText editDesc = (EditText) findViewById(R.id.itemDescription);
		itemName = editName.getText().toString();
		itemDescription = editDesc.getText().toString();
		userID = getUserID();
		
		if (areValuesValid()) {
		
			final ParseObject itemPost = new ParseObject("ItemPost");
			try{
				itemPost.put("Location", geoPoint);
				}
			catch(Exception e){
				ParseGeoPoint point = new ParseGeoPoint(-27.49,153.01);
				itemPost.put("Location", point);
			}
			
			itemPost.put("ItemName", itemName);
			itemPost.put("ItemDescription", itemDescription);
			itemPost.put("ItemNameLowerCase", itemName.toLowerCase());
			itemPost.put("ItemDescriptionLowerCase", itemDescription.toLowerCase());
			itemPost.put("UserID", userID);
			if (photoByteStream != null)
				itemPost.put("ItemPhoto", photoByteStream);
			else 
				itemPost.put("ItemPhoto", defaultByteStream);
			itemPost.saveInBackground(new SaveCallback() {
				  public void done(ParseException e) {
					    //  Access the object id here
					  if (e != null) {
						  	itemID = e.toString();}
					  else {
						  	itemID = itemPost.getObjectId().toString();
						  	}
					  }
					});
			
	
	
			Intent newIntent = new Intent(this, SellerPosts.class);
			startActivity(newIntent);
			
		} else 
			Toast.makeText(MainActivity.this, "Please make sure your item has a name and a description!",
					Toast.LENGTH_LONG).show();

	}
	
	public byte[] convertBmpToBytes(Bitmap bitmap) {
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		return stream.toByteArray();
	}
	
	public ParseGeoPoint getPhoneGeoPoint() throws Exception{
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
		Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		ParseGeoPoint geoPoint = new ParseGeoPoint(location.getLatitude(), location.getLongitude());
		return geoPoint;
		
	}
	
	public String getUserID() {
		TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getDeviceId();
	}
	public String getSuburbByGeoPoint(ParseGeoPoint location) {
		String suburb = "";
		return suburb;
	}
	public Boolean areValuesValid() {
		EditText editName = (EditText) findViewById(R.id.itemName);
		EditText editDesc = (EditText) findViewById(R.id.itemDescription);
		
		if (	editName.getText().toString() == null || 
				editName.getText().toString().equals("") ||
				editDesc.getText().toString().equals("") ||
				editDesc.getText().toString() == null)
			return false;
		else
			return true;
	}

}
