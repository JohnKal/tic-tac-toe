package com.jkalimer.tic_tac_toe_project;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainMenuListAdapter extends BaseAdapter {

	Context context;
	Activity _activity;
	List<MenuItem> menuItems;
	
	public MainMenuListAdapter(Context context, Activity activity, List<MenuItem> items) {
		this.context = context;
		_activity = activity;
		this.menuItems = items;
	}
	
	/*private view holder class*/
	private class ViewHolder {
		ImageView imageView;
		TextView title;
		TextView desc;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menuItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return menuItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return menuItems.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.menu_item, null);
			holder = new ViewHolder();
			holder.desc = (TextView) convertView.findViewById(R.id.description);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.imageView = (ImageView) convertView.findViewById(R.id.menu_item_imgv);
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		MenuItem menuItem = (MenuItem) getItem(position);
		
		holder.desc.setText(menuItem.getDesc());
		holder.title.setText(menuItem.getTitle());		
		holder.imageView.setImageResource(menuItem.getImageId());
		
		return convertView;
	}
	
}
