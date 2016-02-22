package com.campusmate;

import android.app.Application;

public class AppContext extends Application{

	private static AppContext app;

	/* (non-Javadoc)
	 * @see android.app.Application#onCreate()
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		app=this;
	}
	
	public static AppContext getInstance(){
		return app;
	}
	
}
