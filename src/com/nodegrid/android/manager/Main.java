package com.nodegrid.android.manager;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Main extends ActionBarActivity {
	
	 private static final int REQUEST_CODE_ENABLE_ADMIN = 1;
	
	 DevicePolicyManager mDPM;
	 ComponentName mDeviceAdmin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    //The DeviceAdminReceiver should receive the intent below to administer the device.
		 mDeviceAdmin = new ComponentName(this, PolicyHandler.NGDeviceAdminReceiver.class);
		
		 //this intent prompts the user to allow the app to administer the device
		 //the user has the choice to accept or decline.
		Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
		intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mDeviceAdmin);
		intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, R.string.ng_admin_permission_message);
		startActivityForResult(intent, REQUEST_CODE_ENABLE_ADMIN);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
