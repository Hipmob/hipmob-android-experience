package com.hipmob.android.experience;

import com.hipmob.android.HipmobPlayPushService;
import com.hipmob.android.HipmobPushService;
import com.hipmob.android.experience.articleview.ArticleViewOptionsActivity;
import com.hipmob.android.experience.chat.LiveChatOptionsActivity;
import com.hipmob.android.experience.knowledgebase.KnowledgeBaseOptionsActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class TopLevelOptionsActivity extends ListActivity implements OnItemClickListener 
{
	private String[] topOptions; 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		topOptions = new String[]{ "Knowledge Base Search", "Quick Article View", "Live Chat" };
		
		// set the options
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, topOptions));
		
		// handle list item clicks
		getListView().setOnItemClickListener(this);
		
		// and fire up the play service for push
		HipmobPlayPushService.setup(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id)
	{
		switch(position){
		case 0:
			// knowledge base
			startActivity(new Intent(this, KnowledgeBaseOptionsActivity.class));
			break;
		case 1:
			// article view
			startActivity(new Intent(this, ArticleViewOptionsActivity.class));
			break;
		case 2:
			// live chat
			startActivity(new Intent(this, LiveChatOptionsActivity.class));
			break;
		}
	}
}
