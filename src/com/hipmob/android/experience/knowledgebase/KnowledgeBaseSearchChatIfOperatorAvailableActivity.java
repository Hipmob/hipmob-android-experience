package com.hipmob.android.experience.knowledgebase;

import java.util.Arrays;

import com.hipmob.android.HipmobHelpDeskSearchActivity;
import com.hipmob.android.experience.OptionsAdapter;
import com.hipmob.android.experience.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

public class KnowledgeBaseSearchChatIfOperatorAvailableActivity extends Activity implements View.OnClickListener
{
	private static String HIPMOB_APP_ID = "b937e4b524f84fde963da380b948c227";
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.knowledgebasesearchchatifoperator);
		setTitle("Search Only");
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// bind to the button
		Button openSearch = (Button)findViewById(R.id.action);
		openSearch.setOnClickListener(this);
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
		Intent i = new Intent(this, HipmobHelpDeskSearchActivity.class);
		
		// set the app id
		i.putExtra(HipmobHelpDeskSearchActivity.KEY_APPID, HIPMOB_APP_ID);
		
		// set the initial search term to 2 specific articles. You can pass "ids:all" to show all articles, or pass
		// a specific search term to perform a search
		i.putExtra(HipmobHelpDeskSearchActivity.KEY_DEFAULT_QUERY, "ids:d2637a75c02247c2b13237b4e309a17e,a488a80132a34926ad5dd5991224de08");

		// the chat shows by default if it is not disabled: check for an operator
		i.putExtra(HipmobHelpDeskSearchActivity.KEY_CHECK_FOR_OPERATOR , Boolean.TRUE);
		
		startActivity(i);
	}
}
