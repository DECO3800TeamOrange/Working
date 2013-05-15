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

public class MainActivity extends Activity implements View.OnClickListener{
	
	public final static String PHOTO = "com.example.StudentSaleApp.PHOTO";
	public final static String OBJECT_ID = "com.example.StudentSaleApp.OBJECTID";
	public final static String ITEM_NAME = "com.example.StudentSaleApp.ITEM_NAME";
	public final static String ITEM_DESC = "com.example.StudentSaleApp.ITEM_DESC";
	public final static String USER_ID = "com.example.StudentSaleApp.USER_ID";
	
	ImageButton ib;
	ImageView iv;
	Intent i;
	final static int cameraData = 0;
	Bitmap itemPhoto;
	Bitmap defaultPhoto;
	byte[] photoByteStream;
	byte[] defaultByteStream;
	WallpaperManager wallpaperManager;
	String itemName;
	String itemDescription;
	String itemID;
	String userID;
	String longitude;
	String latitude;
	
	@Override
	/*
	 * onCreate(Bundle)
	 * 
	 * Input:	Bundle object
	 * Return:	None
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Parse.initialize(this, "oSVz4UWfUShEgXckKkqA2G4gESIle3GL0egGqEQI","BU5O1f2A26nLwQOzTB4WEucrKGH7JU7tSyC1d7GW"); 
		setContentView(R.layout.activity_main);
		initialize();
		
		// Make photo a default picture, then write over byte[] later with real photo
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		defaultPhoto = BitmapFactory.decodeStream(is);
		defaultByteStream = convertBmpToBytes(defaultPhoto);
	}

	/*
	 * initialize()
	 * 	Set up some global variables and listeners.
	 * Input:	None
	 * Return:	None
	 */
	private void initialize() {
		iv = (ImageView) findViewById (R.id.ivReturnedPic);
		ib = (ImageButton)findViewById(R.id.ibTakePhoto);
		ib.setOnClickListener(this);
	}
	
	/*
	 * onClick(View)
	 * 
	 * Input:	View object representing ???
	 * Return:	None
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ibTakePhoto :
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);
		break;
			
		}
		
	}
	
	@Override
	/*
	 * onActivityResult(int, int, Intent)
	 * 	
	 * Input:	int object representing ???
	 * 			int object representing ???
	 * 			Intent object holding data of ???
	 * Return:	None
	 * 
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			itemPhoto = (Bitmap)extras.get("data");
			photoByteStream = convertBmpToBytes(itemPhoto);
			iv.setImageBitmap(itemPhoto);
		}
	}

	@Override
	/*
	 * onCreateOptionsMenu(Menu)
	 * 	Sets up the options menu for this 'page'. Adds items to action bar if it is present.
	 * Input:	Menu object
	 * Return:	True if successful
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	/*
	 * postItem(View)
	 * 	
	 * Input:	View object representing ???
	 * Method:	Runs another class (PostedActivity)
	 * Return:	None
	 */
	public void postItem(View view) {
		EditText editName = (EditText) findViewById(R.id.itemName);
		EditText editDesc = (EditText) findViewById(R.id.itemDescription);
		itemName = editName.getText().toString();
		itemDescription = editDesc.getText().toString();
		userID = getUserID();

		ParseGeoPoint point = getPhoneGeoPoint();
		latitude = String.valueOf(point.getLatitude());
	    longitude = String.valueOf(point.getLongitude()); 
		
		final ParseObject itemPost = new ParseObject("ItemPost");
		itemPost.put("ItemName", itemName);
		itemPost.put("ItemDescription", itemDescription);
		itemPost.put("ItemNameLowerCase", itemName.toLowerCase());
		itemPost.put("ItemDescriptionLowerCase", itemDescription.toLowerCase());
		itemPost.put("UserID", userID);
		
		//itemPost.put("location", point);
		itemPost.put("Longitude",longitude);
		itemPost.put("Latitude",latitude);
		
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
		
		Intent newIntent = new Intent(this, PostedActivity.class);
		Intent searchResults = new Intent(this, PostedActivity.class);
		newIntent.putExtra(OBJECT_ID, itemID);
		
		if(photoByteStream != null) newIntent.putExtra(PHOTO, photoByteStream);
		
		newIntent.putExtra(ITEM_NAME, itemName);
		newIntent.putExtra(ITEM_DESC, itemDescription);
		newIntent.putExtra(USER_ID, userID);
		startActivity(newIntent);
	}
	
	/*
	 * convertBmpToBytes(Bitmap)
	 * 	Takes a bitmap and converts to a byte array.
	 * Input:	Bitmap object
	 * Return:	Byte array representing a bitmap image
	 */
	public byte[] convertBmpToBytes(Bitmap bitmap) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
		return stream.toByteArray();
	}
	
	/*
	 * getPhoneGeoPoint()
	 * 	Gets a location representation from the phone OS service.
	 * Input:	None
	 * Return:	ParseGeoPoint representing current location of device
	 */
	public ParseGeoPoint getPhoneGeoPoint() {
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
		Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		ParseGeoPoint geoPoint = new ParseGeoPoint(location.getLatitude(), location.getLongitude());
		return geoPoint;
	}
	
	/*
	 * getUserID()
	 * 	Gets an ID representing the user.
	 * Input:	None
	 * Return:	String of Device ID, representing unique user code
	 */
	public String getUserID() {
		TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getDeviceId();
	}
}
