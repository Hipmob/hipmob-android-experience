package com.hipmob.android.experience.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hipmob.android.ChatMessage;
import com.hipmob.android.HipmobChatView;

import com.hipmob.android.experience.R;
import com.hipmob.android.experience.R.layout;

public class CustomHipmobChatView extends HipmobChatView
{

	private String user;
	
	public CustomHipmobChatView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * Creates the view.
	 * 
	 * @exclude
	 */
	public CustomHipmobChatView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * Creates the view.
	 * 
	 * @exclude
	 */
	public CustomHipmobChatView(Context context) {
		super(context);
	}
	
	protected View buildMessageLayout()
	{
		LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		return inflater.inflate(R.layout.chatrow, this, false);
	}
	
	protected boolean renderMessage(View row, ChatMessage message)
	{
		if(message.isLocal()){
			ImageView iv = (ImageView)row.findViewById(R.id.profile_pic_local);
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.man2);
			iv = (ImageView)row.findViewById(R.id.profile_pic_remote);
			iv.setVisibility(View.GONE);
			((TextView)row.findViewById(R.id.hipmob_content)).setGravity(Gravity.LEFT);
		}else{
			ImageView iv = (ImageView)row.findViewById(R.id.profile_pic_remote);
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(R.drawable.man1);
			iv = (ImageView)row.findViewById(R.id.profile_pic_local);
			iv.setVisibility(View.GONE);
			((TextView)row.findViewById(R.id.hipmob_content)).setGravity(Gravity.RIGHT);
		}
		
		return false;
	}
	
	protected boolean willRenderMessage()
	{
		return true;
	}
}
