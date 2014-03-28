package com.hipmob.android.experience;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OptionsAdapter extends ArrayAdapter<String[]> 
{
		Context c;
	    private ArrayList<String[]> entries;
	    
		public OptionsAdapter(Context c, List<String[]> entries, int layout)
		{
			super(c, layout);
			this.c = c;
			this.entries = new ArrayList(entries);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View v = convertView;
			if (v == null){
				if (convertView == null) {
		            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		            v = inflater.inflate(R.layout.twoline, null);
		        } else {
		        	v = convertView;
		        }
			}
			
	        TextView text1 = (TextView)v.findViewById(android.R.id.text1);
	        TextView text2 = (TextView)v.findViewById(android.R.id.text2);

	        text1.setText(entries.get(position)[0]);
	        text2.setText(entries.get(position)[1]);

			return v;
		}

	    @Override
	    public int getCount() {
	        return entries.size();
	    }

	    @Override
	    public String[] getItem(int position) {
	        return entries.get(position);
	    }

	    @Override
	    public long getItemId(int position) {
	        return 0;
	    }
}
