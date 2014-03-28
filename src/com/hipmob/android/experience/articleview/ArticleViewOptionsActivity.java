package com.hipmob.android.experience.articleview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.Arrays;

import com.hipmob.android.experience.OptionsAdapter;
import com.hipmob.android.experience.R;
import com.hipmob.android.experience.R.layout;
import com.hipmob.android.experience.chat.LiveChatOptionsActivity;
import com.hipmob.android.experience.knowledgebase.KnowledgeBaseOptionsActivity;

public class ArticleViewOptionsActivity extends ListActivity implements OnItemClickListener
{
	private String[][] options;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setTitle("Article View Options");
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		options = new String[][]{ new String[]{ "Article View Only", "Never show Chat Button" } };
		
		setListAdapter(new OptionsAdapter(this, Arrays.asList(options), R.layout.twoline));
		
		// handle list item clicks
		getListView().setOnItemClickListener(this);
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
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id)
	{
		switch(position){
		case 0:
			// knowledge base
			startActivity(new Intent(this, ArticleViewOnlyActivity.class));
			break;
		}
	}
}
