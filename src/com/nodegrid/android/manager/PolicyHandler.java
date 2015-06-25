package com.nodegrid.android.manager;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author mmahanama
 *
 */
public class PolicyHandler {

	 /**
	 *Extending DeviceAdminReceiver - Base class for implementing a device administration component. 
	 *This class provides a convenience for interpreting the raw intent actions that are sent by the system.
	 */
	public static class NGDeviceAdminReceiver extends DeviceAdminReceiver {
		 
		 void showToast(Context context, String message) {
	            String status =  message;
	            Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
	        }

	        @Override
	        public void onEnabled(Context context, Intent intent) {
	            showToast(context,context.getString(R.string.admin_enabled));
	        }

	        @Override
	        public void onDisabled(Context context, Intent intent) {
	            showToast(context, context.getString(R.string.admin_disabled));
	        }
		 
	 }
	
}
