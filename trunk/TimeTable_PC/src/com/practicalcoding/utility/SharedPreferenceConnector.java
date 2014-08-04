package com.practicalcoding.utility;

import java.io.OptionalDataException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferenceConnector{
	public static final String PREF_NAME = "TIMETABLE_PRACTICALCODING";
	public static final int MODE = Context.MODE_PRIVATE;

	/**
	 * <br>  <strong> DataType: {@link String}. This is used to save timetable data in Json format [
[
     [
{ "time": "07:00-10:00", "sub": "CS260(oops)" },
     { "time": "10:30-11:30", "sub": "CS269(ADA)" }
     ],[{ "time": "09:30-10:00", "sub": "CS269(ADA)" },
     { "time": "10:30-11:30", "sub": "CS260(oops)" }
     ],[{ "time": "08:00-10:00", "sub": "CS359(ADA)" },
     { "time": "10:30-11:30", "sub": "CS260(oops)" }
     ],[{ "time": "09:00-11:00", "sub": "CS259(ADAA)" },
     { "time": "10:30-11:30", "sub": "CS260(oops)" }
     ],[{ "time": "09:00-10:00", "sub": "CS259(ADA)" },
     { "time": "10:30-11:30", "sub": "CS260(oops)" }
     ],[{ "time": "09:00-10:00", "sub": "CS259(ADA)" },
     { "time": "10:30-11:30", "sub": "CS260(oops)" }
     ]

 ]
	
	 [
		     [{ "time": "7-10", "sub": "CS260(oops)" },
		     { "time": "10.30-11.30", "sub": "CS269(ADA)" }
		     ], 
		[{ "time": "9.30-10", "sub": "CS269(ADA)" },
		     { "time": "10.30-11.30", "sub": "CS260(oops)" }
		     ],
		[{ "time": "8-10", "sub": "CS359(ADA)" },
		     { "time": "10.30-11.30", "sub": "CS260(oops)" }
		     ],
		[{ "time": "9-11", "sub": "CS259(ADAA)" },
		     { "time": "10.30-11.30", "sub": "CS260(oops)" },
		     { "time": "3.30-5.30", "sub": "CS268(JAVA)" }
		     ],
		[{ "time": "9-10", "sub": "CS259(ADA)" },
		     { "time": "10.30-11.30", "sub": "CS260(oops)" }
		     ],
		[{ "time": "9-10", "sub": "CS259(ADA)" },
		     { "time": "10.30-11.30", "sub": "CS260(oops)" }
		     ],
		[{ "time": "9-10", "sub": "CS259(ADA)" },
		     { "time": "10.30-11.30", "sub": "CS260(oops)" }
		     ]

		 ]
	 */
	public static final String TIME_TABLE_LIST = "TimeTableList";
	
	public static SharedPreferences getPreferences(Context context) {
		return context.getSharedPreferences(PREF_NAME, MODE);
	}

	public static Editor getEditor(Context context) {
		return getPreferences(context).edit();
	}

	public static void writeBoolean(Context context, String key, boolean value) {
		getEditor(context).putBoolean(key, value).commit();
	}

	public static boolean readBoolean(Context context, String key, boolean defValue) {
		return getPreferences(context).getBoolean(key, defValue);
	}

	public static void writeInteger(Context context, String key, int value) {
		getEditor(context).putInt(key, value).commit();

	}

	public static int readInteger(Context context, String key, int defValue) {
		return getPreferences(context).getInt(key, defValue);
	}

	public static void writeString(Context context, String key, String value) {
		getEditor(context).putString(key, value).commit();
	}

	public static String readString(Context context, String key, String defValue) {
		return getPreferences(context).getString(key, defValue);
	}

	public static void writeFloat(Context context, String key, float value) {
		getEditor(context).putFloat(key, value).commit();
	}

	public static float readFloat(Context context, String key, float defValue) {
		return getPreferences(context).getFloat(key, defValue);
	}

	public static void writeLong(Context context, String key, long value) {
		getEditor(context).putLong(key, value).commit();
	}

	public static long readLong(Context context, String key, long defValue) {
		return getPreferences(context).getLong(key, defValue);
	}

}
