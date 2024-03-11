package com.jarecki;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.jarecki.TreadmillChallenge;

import java.util.Set;

public class AndroidLauncher extends AndroidApplication {
	private static final int REQUEST_ENABLE_BT = 101; // magic number

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new TreadmillChallenge(), config);


		BluetoothManager bluetoothManager = null;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
			bluetoothManager = getSystemService(BluetoothManager.class);
			BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
			if (bluetoothAdapter == null) {
				// Device doesn't support Bluetooth
			}
			if (!bluetoothAdapter.isEnabled()) {
				Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
				if (checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
					// TODO: Consider calling
					//    Activity#requestPermissions
					// here to request the missing permissions, and then overriding
					//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
					//                                          int[] grantResults)
					// to handle the case where the user grants the permission. See the documentation
					// for Activity#requestPermissions for more details.
					return;
				}
				startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
			}
			Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
			if (bondedDevices.size() > 0) {
				BluetoothDevice bluetoothDevice = bondedDevices.iterator().next();
				bluetoothDevice.
			}
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == REQUEST_ENABLE_BT) {
			if (resultCode == Activity.RESULT_OK) {

			}
		}

	}
}
