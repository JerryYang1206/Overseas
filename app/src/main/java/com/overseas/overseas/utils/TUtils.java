package com.overseas.overseas.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.overseas.overseas.R;


/**
 * Toast统一管理类
 * 
 * @author power
 * 
 */
public class TUtils {

	private TUtils() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	public static boolean isShow = true;

	/**
	 * 短时间显示Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void showShort(Context context, CharSequence message) {
		if (isShow)
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 短时间显示Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void showShort(Context context, int message) {
		if (isShow)
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 长时间显示Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void showLong(Context context, CharSequence message) {
		if (isShow)
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}

	/**
	 * 长时间显示Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void showLong(Context context, int message) {
		if (isShow)
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}

	/**
	 * 自定义显示Toast时间
	 * 
	 * @param context
	 * @param message
	 * @param duration
	 */
	public static void show(Context context, CharSequence message, int duration) {
		if (isShow)
			Toast.makeText(context, message, duration).show();
	}

	/**
	 * 自定义显示Toast时间
	 * 
	 * @param context
	 * @param message
	 * @param duration
	 */
	public static void show(Context context, int message, int duration) {
		if (isShow)
			Toast.makeText(context, message, duration).show();
	}

	public static void showFail(Context context, String msg){
		Toast toast = new Toast(context);
		toast.setGravity(Gravity.BOTTOM, 0, 80);
		LinearLayout ll = new LinearLayout(context);
		ll.setOrientation(LinearLayout.VERTICAL);
		ll.setBackground(context.getResources().getDrawable(R.drawable.toast_bg));
		TextView myTextView = new TextView(context);
		myTextView.setText(msg);
		myTextView.setTextColor(Color.WHITE);
		myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
		int lHeight = LinearLayout.LayoutParams.WRAP_CONTENT;
		int lWidth = LinearLayout.LayoutParams.WRAP_CONTENT;
		ll.setPadding(15, 8, 15, 8);
		ll.addView(myTextView, new LinearLayout.LayoutParams(lHeight, lWidth));

		toast.setView(ll);
		toast.show();
	}
}