package com.campusmate.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;

import com.campusmate.AppContext;

public class DeviceInfo {

	public static String getMac() {
		String macSerial = null;
		String str = "";
		try {
			Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ");
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (; str != null;) {
				str = input.readLine();
				if (str != null) {
					macSerial = str.trim();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return macSerial;
	}

	public static String getDeviceId() {
		TelephonyManager telephonemanage = (TelephonyManager) AppContext.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
		return telephonemanage.getDeviceId();
	}

	@SuppressLint("NewApi")
	public static String getResolution() {
		WindowManager wm = (WindowManager) AppContext.getInstance().getSystemService(Context.WINDOW_SERVICE);
		Point size = new Point();
		Display display = wm.getDefaultDisplay();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		return width + "*" + height;
	}

	/**
	 * 获取应用当前版本号
	 * 
	 * @param context
	 * 
	 * @return
	 */
	public static int getVersionCode(Context context) {
		String packageName = context.getPackageName();
		int versionCode = 0;
		try {
			versionCode = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return versionCode;
	}
	
	/**
	 * 获取应用当前版本名称
	 * 
	 * @param context
	 * 
	 * @return
	 */
	public static String getVersionName(Context context) {
		String packageName = context.getPackageName();
		String versionName = null;
		try {
			versionName = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return versionName;
	}
}
