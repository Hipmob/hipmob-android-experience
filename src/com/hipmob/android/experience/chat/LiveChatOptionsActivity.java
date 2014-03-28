package com.hipmob.android.experience.chat;

import java.util.Arrays;

import com.hipmob.android.experience.OptionsAdapter;
import com.hipmob.android.experience.R;
import com.hipmob.android.experience.R.layout;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class LiveChatOptionsActivity extends ListActivity 
{
private String[][] options;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setTitle("Live Chat Options");
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		options = new String[][]{ new String[]{ "Default Chat", "" } };
		
		setListAdapter(new OptionsAdapter(this, Arrays.asList(options), R.layout.twoline));
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
}