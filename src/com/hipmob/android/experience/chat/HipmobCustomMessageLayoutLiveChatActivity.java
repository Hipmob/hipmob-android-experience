package com.hipmob.android.experience.chat;

import java.util.UUID;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

import com.hipmob.android.HipmobChatView;

import com.hipmob.android.experience.R;
import com.hipmob.android.experience.R.layout;

public class HipmobCustomMessageLayoutLiveChatActivity extends Activity 
{
	private static String HIPMOB_APP_ID = "b937e4b524f84fde963da380b948c227";
	
	private CustomHipmobChatView chatView;

	private SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		chatView = (CustomHipmobChatView)findViewById(R.id.chat);
		
		// set up the chat
		chatView.setAppId(HIPMOB_APP_ID);

		prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		chatView.setUser(getUserId());
		
		Object obj = getLastNonConfigurationInstance();
		if(obj == null) chatView.start();
		else chatView.resume(obj);
	}
	
	private String getUserId()
	{
		String userid = prefs.getString("userid", UUID.randomUUID().toString());
		if(!prefs.contains("userid")){
			SharedPreferences.Editor editor = prefs.edit();
			editor.putString("userid", userid);
			editor.commit();
		}
		return userid;
	}
	
	@Override
	public Object onRetainNonConfigurationInstance()
	{
		return chatView.pause();
	}
	
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		chatView.destroy();
	}
}
