package com.overseas.overseas.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtils {
	
	private static SharedPreferencesUtils sp ;
	private SharedPreferences mPrefs;
	private Context m_Context;
	
	private static final String PREFERENCE_NAME = "config.xml";
	
	private SharedPreferencesUtils(Context context) {
		m_Context = context;
	}
	
	public static synchronized SharedPreferencesUtils getInstace(Context context){
		if(sp==null){
			sp = new SharedPreferencesUtils(context);
		}
		return sp;
	}
	
	
	@SuppressLint("InlinedApi")
	public SharedPreferences getmPrefs() {
		if (mPrefs == null) {
			mPrefs = m_Context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_MULTI_PROCESS);
		}
		return mPrefs;
	}

	public int getIntPreference(String name, int defaultValue) {
		return getmPrefs().getInt(name, defaultValue);
	}

	public void setIntPreference(String name, int value) {

		Editor editor = getmPrefs().edit();
		editor.putInt(name, value);
		editor.commit();
	}

	public long getLongPreference(String name, long defaultValue) {
		return getmPrefs().getLong(name, defaultValue);
	}

	public void setLongPreference(String name, long value) {
		Editor editor = getmPrefs().edit();
		editor.putLong(name, value);
		editor.commit();
	}

	public boolean getBooleanPreference(String name, boolean defaultValue) {
		return getmPrefs().getBoolean(name, defaultValue);
	}

	public void setBooleanPreference(String name, boolean value) {
		Editor editor = getmPrefs().edit();
		editor.putBoolean(name, value);
		editor.commit();
	}

	public void setStringPreference(String name, String value) {
		Editor editor = getmPrefs().edit();
		editor.putString(name, value);
		editor.commit();
	}

	public String getStringPreference(String name, String defaultValue) {
		return getmPrefs().getString(name, defaultValue);
	}

}
