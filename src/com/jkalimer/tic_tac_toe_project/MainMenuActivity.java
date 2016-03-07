package com.jkalimer.tic_tac_toe_project;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainMenuActivity extends Activity implements OnItemClickListener {
	
	ArrayList<MenuItem> menuItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
	    getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff6961")));
	    getActionBar().setIcon(R.drawable.ic_tic_tac_toe);
		
	    final String[] titles = new String[] { "Play",
				"Settings", "Help", "Send Feedback", "Share", "About"};

		final String[] descriptions = new String[] {
				"Play Tic Tac Toe",
				"Settings of app", "Rules for tic-tac-toe", "Send your review about tic-tac-toe app",
				"Share the app to social media", "Information about the app and the software licence"};

		final Integer[] images = { R.drawable.play,
				R.drawable.settings, R.drawable.help, R.drawable.feedback, R.drawable.share, R.drawable.about};
		
		menuItems = new ArrayList<MenuItem>();
		for (int i = 0; i < titles.length; i++) {
			MenuItem item = new MenuItem(images[i], titles[i], descriptions[i]);
			menuItems.add(item);
		}
		
	    ListView listView = (ListView) findViewById(R.id.list);
		MainMenuListAdapter adapter = new MainMenuListAdapter(this, MainMenuActivity.this, menuItems);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		/*Toast toast = Toast.makeText(getApplicationContext(),
				"Item " + (position + 1) + ": " + menuItems.get(position),
				Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();*/
		if (position == 0)
		{
			Intent i = new Intent(MainMenuActivity.this, MainActivity.class);
            startActivity(i);
		}
		if (position == 1)
		{
			Intent i = new Intent(MainMenuActivity.this, Settings.class);
            startActivity(i);
		}
		if (position == 2)
		{
			StringBuilder builder = new StringBuilder();
			
			SpannableStringBuilder title = new SpannableStringBuilder("Tic Tac Toe");

		    //Right align the text
		    AlignmentSpan alignmentSpan = new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);
		    title.setSpan(alignmentSpan, 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		    
			builder.append("<h1 align='center'>"
					+ "<b>"
                    + title
					+ "</b>"
                    + "</h1>"
                    + "<pre> The object of Tic Tac Toe is to get three in a row. You play on a three by three game board."
		      		+ "The first player is known as X and the second is O. Players alternate placing Xs and Os on the game board until "
		      		+ "either oppent has three in a row or all nine squares are filled. X always goes first, and in the event that no one "
		      		+ "has three in a row, the stalemate is called a cat game. <br><br> Developer: John Kalimeris </pre>");
			
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		      alertDialogBuilder.setMessage(Html.fromHtml(builder.toString()));
		      
		      alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
		         @Override
		         public void onClick(DialogInterface arg0, int arg1) {
		         }
		      }); 
		      AlertDialog alertDialog = alertDialogBuilder.create();
		      alertDialog.show();
		}
		else if (position == 3)
		{
			Intent email = new Intent(Intent.ACTION_SEND);
			email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jkalimer13@gmail.com"});		  
			email.putExtra(Intent.EXTRA_SUBJECT, "App review");
			email.putExtra(Intent.EXTRA_TEXT, "message");
			//email.setType("message/rfc822");
			email.setType("vnd.android.cursor.dir/email");
			startActivity(Intent.createChooser(email, "Choose an Email client :"));
		}
		else if (position == 4)
		{
			Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Check out this App \n\n http://play.google.com/store/apps/details?id=com.jkalimer.tic_tac_toe_project");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "New Tic-Tac-Toe App");
            startActivity(Intent.createChooser(intent, "Share"));
		}
		else if (position == 5)
		{
			LicensesDialogFragment dialog = LicensesDialogFragment.newInstance();
		    dialog.show(getFragmentManager(), "LicensesDialog");
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main_menu_action, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		if (id == R.id.action_exit) {
			System.exit(0);
			return false;
		}
		
		return super.onOptionsItemSelected(item);
	}


}
