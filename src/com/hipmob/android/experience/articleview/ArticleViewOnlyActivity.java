package com.hipmob.android.experience.articleview;

import java.util.Arrays;

import com.hipmob.android.HipmobHelpDeskArticleViewActivity;
import com.hipmob.android.experience.OptionsAdapter;
import com.hipmob.android.experience.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

public class ArticleViewOnlyActivity extends Activity implements View.OnClickListener
{
	private static String HIPMOB_APP_ID = "b937e4b524f84fde963da380b948c227";
	private static String HIPMOB_ARTICLE_ID = "d2637a75c02247c2b13237b4e309a17e";
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.articleview);
		setTitle("Article Only");
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// bind to the button
		Button openArticle = (Button)findViewById(R.id.action);
		openArticle.setOnClickListener(this);
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
		Intent i = new Intent(this, HipmobHelpDeskArticleViewActivity.class);
		
		// set the app id
		i.putExtra(HipmobHelpDeskArticleViewActivity.KEY_APPID, HIPMOB_APP_ID);
		
		// set the specific article to show
		i.putExtra(HipmobHelpDeskArticleViewActivity.KEY_ARTICLEID, HIPMOB_ARTICLE_ID);
		
		// disable the chat
		i.putExtra(HipmobHelpDeskArticleViewActivity.KEY_DISABLE_CHAT, Boolean.TRUE);
		startActivity(i);
	}
}
