package com.hipmob.android.experience.chat;

import android.view.View;
import android.widget.Toast;

import com.hipmob.android.ChatMessage;
import com.hipmob.android.HipmobCore;

public class CustomHipmobCore extends HipmobCore 
{
	/**
	 * Callback method to be invoked when the connection is established.
	 */
	protected void onConnected()
	{
		Toast.makeText(this, "Connected!", Toast.LENGTH_LONG).show();
	}

	/**
	 * Callback method to be invoked when operators have become available.
	 */
	protected void onOperatorOnline()
	{
		
	}

	/**
	 * Callback method to be invoked when operators are no longer available.
	 */
	protected void onOperatorOffline()
	{
		
	}

	/**
	 * Callback method to be invoked when the connection is closed.
	 */
	protected void onDisconnected()
	{
		
	}

	/**
	 * Callback method to be invoked when an operator accepts the chat
	 * session.
	 * 
	 * @param operator
	 *            The operator that accepted the chat session.
	 */
	protected void onOperatorAccepted(String operator)
	{
		
	}

	/**
	 * Callback method to be invoked when a specific user is now available.
	 * 
	 * @param userId
	 *            The user identifier for the user that is now available.
	 */
	protected void onUserOnline(String userId)
	{
		
	}

	/**
	 * Callback method to be invoked when a specific user is no longer
	 * available.
	 * 
	 * @param userId
	 *            The user identifier for the user that is no longer
	 *            available.
	 */
	protected void onUserOffline(String userId)
	{
		
	}

	/**
	 * Callback method to be invoked when a message is received.
	 * 
	 * @param message
	 *            The message that was received.
	 */
	protected void onMessageReceived(ChatMessage message)
	{
		
	}

	/**
	 * Callback method to be invoked when a message is sent.
	 * 
	 * @param message
	 *            The message that was sent.
	 */
	protected void onMessageSent(ChatMessage message)
	{
		
	}
	
	/**
	 * Override in subclasses to customize the ListView row displayed for a specific chat message.
	 * The default implementation returns false.
	 * 
	 * @param row The View to be used for the message. This is returned from buildMessageLayout().
	 * @param message The actual chat message to be rendered.
	 * 
	 * @return true if the implementation completely handles rendering the message, false otherwise.
	 */
	protected boolean renderMessage(View v, ChatMessage m)
	{
		android.util.Log.v("CustomHipmobCore", "Rendering");
		return false;
	}
}
