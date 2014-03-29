package com.hipmob.android.experience.chat;

import java.util.Arrays;
import java.util.UUID;

import com.hipmob.android.HipmobCore;
import com.hipmob.android.experience.OptionsAdapter;
import com.hipmob.android.experience.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.Button;

public class CustomMessageLayoutLiveChatActivity extends Activity implements View.OnClickListener
{
	private static String HIPMOB_APP_ID = "b937e4b524f84fde963da380b948c227";

	private SharedPreferences prefs;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.custommessagelayoutlivechat);
		setTitle("Custom Message Layout Chat");
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// bind to the button
		Button openChat = (Button)findViewById(R.id.action);
		openChat.setOnClickListener(this);
		
		prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case android.R.id.home:
	    	finish();
	    	return true;
	    default:
            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	public void onClick(View arg0)
	{
		// launch the article view
		Intent i = new Intent(this, HipmobCore.class);
		
		// set the app id
		i.putExtra(HipmobCore.KEY_APPID, HIPMOB_APP_ID);
		
		// pass a user identifier: we create one if we need to
		String userid = prefs.getString("userid", UUID.randomUUID().toString());
		if(!prefs.contains("userid")){
			SharedPreferences.Editor editor = prefs.edit();
			editor.putString("userid", userid);
			editor.commit();
		}

		// tell us the user
		i.putExtra(HipmobCore.KEY_USERID, userid);
		
		// and then overwrite the row layout so we have custom layout
		i.putExtra(HipmobCore.KEY_MESSAGE_LAYOUT, R.layout.custom_message_layout);

		// finally, always show the message timestamps
		i.putExtra(HipmobCore.KEY_SHOW_TIMESTAMPS, HipmobCore.SHOW_TIMESTAMPS_ALWAYS);

		startActivity(i);
	}
}
