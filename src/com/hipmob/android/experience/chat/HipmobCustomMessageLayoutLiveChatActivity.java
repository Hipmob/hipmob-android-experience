package com.hipmob.android.experience.chat;

import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.hipmob.android.HipmobChatView;
import com.hipmob.android.experience.R;

public class HipmobCustomMessageLayoutLiveChatActivity extends Activity 
{
	private static String HIPMOB_APP_ID = "b937e4b524f84fde963da380b948c227";
	
	private CustomHipmobChatView chatView;

	private SharedPreferences prefs;
	
	private static final int MENU_ATTACHMENT = Menu.FIRST + 1;
	
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
	
		chatView.setExtendedStatusListener(esl);;
		
		Object obj = getLastNonConfigurationInstance();
		if(obj == null) chatView.start();
		else chatView.resume(obj);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		super.onCreateOptionsMenu(menu);

		// create a menu item
		MenuItem item = menu.add(Menu.NONE, MENU_ATTACHMENT, Menu.NONE, "Send Picture");
		item.setIcon(R.drawable.attach);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}
	
	private static final int REQUEST_IMAGE_CONTENT = 1;
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getItemId() == MENU_ATTACHMENT){
			// start the gallery picker
			Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
			intent.setType("image/*");
			startActivityForResult(intent, REQUEST_IMAGE_CONTENT);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		switch (requestCode) {
		case REQUEST_IMAGE_CONTENT:
			// Result was cancelled by the user or there was an error
			if (resultCode != RESULT_OK) return;

			chatView.sendMessage(data.getData());
			break;
		}
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
	
	private HipmobChatView.ExtendedStatusListener esl = new HipmobChatView.ExtendedStatusListener() {
		@Override
		public void onReconnecting() {
		}
		
		@Override
		public void onTypingIndicator(boolean isTyping, String operator)
		{
			Toast.makeText(HipmobCustomMessageLayoutLiveChatActivity.this, operator+" is typing...", Toast.LENGTH_LONG).show();
		}
	};

}
