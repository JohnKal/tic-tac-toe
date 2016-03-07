package com.jkalimer.tic_tac_toe_project;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogFragments extends DialogFragment {
	
	String _message;
	View view;
	LayoutInflater inflater;
	Activity _activity;
	
	public DialogFragments(String message, Activity activity)
	{
		_activity = activity;
		_message = message;
		inflater = _activity.getLayoutInflater();
		view = inflater.inflate(R.layout.end_game_dialog, null);
		TextView txv = (TextView) view.findViewById(R.id.message_dialog);
		txv.setText(message);
		ImageView imView = (ImageView) view.findViewById(R.id.img_view1);
		if (message.equalsIgnoreCase("It's a tie. Play again!"))
			imView.setImageResource(R.drawable.worried_emoticon);
			//System.out.println("");
		else if (message.equalsIgnoreCase("You lose. Play again!"))
			imView.setImageResource(R.drawable.crying_emoticon);
			
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

	    // Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    builder.setView(view)
	    // Add action buttons
	           .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   ((MainActivity) getActivity()).stopMediaPlayer();
	            	   _activity.finish();
	            	   startActivity(_activity.getIntent());
	               }
	           }).setNeutralButton(R.string.string_ok, new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	               }
	           });
	    return builder.create();
	}
}
