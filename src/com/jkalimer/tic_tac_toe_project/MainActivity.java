package com.jkalimer.tic_tac_toe_project;

import java.io.IOException;
import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends Activity {
	
	ArrayList<ImageButton> totalImages;
	ArrayList<String> values;
	ArrayList<ImageButton> winObjects;
	ArrayList<ImageButton> xImages;
	ArrayList<ImageButton> oImages;
	SharedPreferences sharedPref;
	int wins = 0;
	int ties = 0;
	int loses = 0;
	int moves = 0;
	boolean playersTurn;
	boolean endGame;
	MediaPlayer mp;
	MediaPlayer audienceApplause;
	boolean musicPref;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff6961")));
		actionBar.setIcon(R.drawable.ic_tic_tac_toe);

		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		
		sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		musicPref = sharedPref.getBoolean("music", true);
		
		mp = MediaPlayer.create(getApplicationContext(), R.raw.tick);
		audienceApplause = MediaPlayer.create(getApplicationContext(), R.raw.audience_applause);
		
		mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
		    public void onCompletion(MediaPlayer mp) {
		        mp.release();
		    }
		});
		
		audienceApplause.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
		    public void onCompletion(MediaPlayer mp) {
		        mp.release();
		    }
		});
		
		initGame();
		
		playerTurn();
		
	}
	
	private void mediaPlayerHandler(MediaPlayer mp, int i) {
		// TODO Auto-generated method stub
		if (musicPref)
		{
			mp.reset();
			mp = MediaPlayer.create(getApplicationContext(), i);
			mp.setVolume(AudioManager.STREAM_MUSIC,AudioManager.STREAM_MUSIC);
			mp.start();
		}
	}

	private void playerTurn() {
		// TODO Auto-generated method stub
		xImages = new ArrayList<ImageButton>();
		oImages = new ArrayList<ImageButton>();
		final TextView txvTurn = (TextView) findViewById(R.id.txv_turn);
		txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
		
		playersTurn = false;
		
		
		for (final ImageButton imgbtn : totalImages)
		{
			imgbtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
	            public void onClick(View v) {
					switch (imgbtn.getId()) {
			         case R.id.button1:
			        	 if (values.get(0).equalsIgnoreCase("empty"))
			        	 {
			        		 playersTurn = false;
			        		 values.set(0, "X");
			        		 imgbtn.setImageResource(R.drawable.x);
			        		 mediaPlayerHandler(mp, R.raw.tick);
				        	 checkEndGameHandler();
				        	 txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
			        	 }
			             break;
			         case R.id.button2:
			        	 if (values.get(1).equalsIgnoreCase("empty"))
			        	 {
			        		 playersTurn = false;
			        		 values.set(1, "X");
			        		 imgbtn.setImageResource(R.drawable.x);
			        		 mediaPlayerHandler(mp, R.raw.tick);
				        	 checkEndGameHandler();
				        	 txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
			        	 }
			             break;
			         case R.id.button3:
			        	 if (values.get(2).equalsIgnoreCase("empty"))
			        	 {
			        		 playersTurn = false;
			        		 values.set(2, "X");
			        		 imgbtn.setImageResource(R.drawable.x);
			        		 mediaPlayerHandler(mp, R.raw.tick);
				        	 checkEndGameHandler();
				        	 txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
			        	 }
			             break;
			         case R.id.button4:
			        	 if (values.get(3).equalsIgnoreCase("empty"))
			        	 {
			        		 playersTurn = false;
			        		 values.set(3, "X");
			        		 imgbtn.setImageResource(R.drawable.x);
			        		 mediaPlayerHandler(mp, R.raw.tick);
				        	 checkEndGameHandler();
				        	 txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
			        	 }
			             break;
			         case R.id.button5:
			        	 if (values.get(4).equalsIgnoreCase("empty"))
			        	 {
			        		 playersTurn = false;
			        		 values.set(4, "X");
			        		 imgbtn.setImageResource(R.drawable.x);
			        		 mediaPlayerHandler(mp, R.raw.tick);
				        	 checkEndGameHandler();
				        	 txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
			        	 }
			             break;
			         case R.id.button6:
			        	 if (values.get(5).equalsIgnoreCase("empty"))
			        	 {
			        		 playersTurn = false;
			        		 values.set(5, "X");
			        		 imgbtn.setImageResource(R.drawable.x);
			        		 mediaPlayerHandler(mp, R.raw.tick);
				        	 checkEndGameHandler();
				        	 txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
			        	 }
			             break;
			         case R.id.button7:
			        	 if (values.get(6).equalsIgnoreCase("empty"))
			        	 {
			        		 playersTurn = false;
			        		 values.set(6, "X");
			        		 imgbtn.setImageResource(R.drawable.x);
			        		 mediaPlayerHandler(mp, R.raw.tick);
				        	 checkEndGameHandler();
				        	 txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
			        	 }
			             break;
			         case R.id.button8:
			        	 if (values.get(7).equalsIgnoreCase("empty"))
			        	 {
			        		 playersTurn = false;
			        		 values.set(7, "X");
			        		 imgbtn.setImageResource(R.drawable.x);
			        		 mediaPlayerHandler(mp, R.raw.tick);
				        	 checkEndGameHandler();
				        	 txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
			        	 }
			             break;
			         case R.id.button9:
			        	 if (values.get(8).equalsIgnoreCase("empty"))
			        	 {
			        		 playersTurn = false;
			        		 values.set(8, "X");
			        		 imgbtn.setImageResource(R.drawable.x);
			        		 mediaPlayerHandler(mp, R.raw.tick);
				        	 checkEndGameHandler();
				        	 txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
			        	 }
			             break;
			         default:
			        	 break; 
			     }
	            }
	        });
		}
	}

	protected void checkEndGameHandler() {
		// TODO Auto-generated method stub
		for (final ImageButton imgbtn : totalImages)
		{
			imgbtn.setClickable(false);
		}
		
		Handler handler = new Handler(); 
	    handler.postDelayed(new Runnable() { 
	         public void run() { 
	        	 checkEndGame();
	         } 
	    }, 500); 
	}

	protected void checkEndGame() {
		// TODO Auto-generated method stub	
		moves++;
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putInt("moves", moves);
		editor.commit();
		
		TextView txvMo = (TextView) findViewById(R.id.txv_moves);
		txvMo.setText("moves: " + String.valueOf(moves));
		
		int count = 0;
		for (final String value : values)
		{
			if (value.equalsIgnoreCase("empty"))
				count++;
		}
		if (count == 0)
		{
			endGame("tie", winObjects);
			return;
		}
		
		//check for player win
		checkForWinHorizontally(values, "X");
		
		checkForWinVertically(values, "X");
		
		if (values.get(0).equals(values.get(4)) && values.get(4).equals(values.get(8)) && values.get(0).equalsIgnoreCase("X"))
		{
			winObjects.add(totalImages.get(0));
			winObjects.add(totalImages.get(4));
			winObjects.add(totalImages.get(8));
			endGame = true;
			endGame("win", winObjects);
		}
		
		if (values.get(2).equals(values.get(4)) && values.get(4).equals(values.get(6)) && values.get(2).equalsIgnoreCase("X"))
		{
			winObjects.add(totalImages.get(2));
			winObjects.add(totalImages.get(4));
			winObjects.add(totalImages.get(6));
			endGame = true;
			endGame("win", winObjects);
		}
		
		checkForWinHorizontally(values, "O");
		
		checkForWinVertically(values, "O");
		
		if (values.get(0).equals(values.get(4)) && values.get(4).equals(values.get(8)) && values.get(0).equalsIgnoreCase("O"))
		{
			winObjects.add(totalImages.get(0));
			winObjects.add(totalImages.get(4));
			winObjects.add(totalImages.get(8));
			endGame = true;
			endGame("lose", winObjects);
		}
		
		if (values.get(2).equals(values.get(4)) && values.get(4).equals(values.get(6)) && values.get(2).equalsIgnoreCase("O"))
		{
			winObjects.add(totalImages.get(2));
			winObjects.add(totalImages.get(4));
			winObjects.add(totalImages.get(6));
			endGame = true;
			endGame("lose", winObjects);
		}
		
		if (!endGame)
		{
			if (playersTurn)
				playerTurn();
			else if (!playersTurn)
				computersTurn();
		}
			
	}

	private void computersTurn() {
		// TODO Auto-generated method stub
		playersTurn = true;
		
		for (int i=0; i<=6; i=i+3)
		{
			if (values.get(i).equals(values.get(i+1)) && values.get(i+2).equalsIgnoreCase("empty") && values.get(i).equalsIgnoreCase("O"))
			{
				changeImageO(i+2);
				checkEndGame();
				return;
			}
			if (values.get(i).equals(values.get(i+2)) && values.get(i+1).equalsIgnoreCase("empty") && values.get(i).equalsIgnoreCase("O"))
			{
				changeImageO(i+1);
				checkEndGame();
				return;
			}
			if (values.get(i+1).equals(values.get(i+2)) && values.get(i).equalsIgnoreCase("empty") && values.get(i+1).equalsIgnoreCase("O"))
			{
				changeImageO(i);
				checkEndGame();
				return;
			}
		}
		
		for (int i=0; i<=2; i++)
		{
			if (values.get(i).equals(values.get(i+3)) && values.get(i+6).equalsIgnoreCase("empty") && values.get(i).equalsIgnoreCase("O"))
			{
				changeImageO(i+6);
				checkEndGame();
				return;
			}
			if (values.get(i).equals(values.get(i+6)) && values.get(i+3).equalsIgnoreCase("empty") && values.get(i).equalsIgnoreCase("O"))
			{
				changeImageO(i+3);
				checkEndGame();
				return;
			}
			if (values.get(i+3).equals(values.get(i+6)) && values.get(i).equalsIgnoreCase("empty") && values.get(i+3).equalsIgnoreCase("O"))
			{
				changeImageO(i);
				checkEndGame();
				return;
			}
		}
		
		if (values.get(0).equals(values.get(4)) && values.get(8).equalsIgnoreCase("empty") && values.get(0).equalsIgnoreCase("O"))
		{
			changeImageO(8);
			checkEndGame();
			return;
		}
		else if (values.get(0).equals(values.get(8)) && values.get(4).equalsIgnoreCase("empty") && values.get(0).equalsIgnoreCase("O"))
		{
			changeImageO(4);
			checkEndGame();
			return;
		}
		else if (values.get(4).equals(values.get(8)) && values.get(0).equalsIgnoreCase("empty") && values.get(4).equalsIgnoreCase("O"))
		{
			changeImageO(0);
			checkEndGame();
			return;
		}
		else if (values.get(2).equals(values.get(4)) && values.get(6).equalsIgnoreCase("empty") && values.get(2).equalsIgnoreCase("O"))
		{
			changeImageO(6);
			checkEndGame();
			return;
		}
		else if (values.get(2).equals(values.get(6)) && values.get(4).equalsIgnoreCase("empty") && values.get(2).equalsIgnoreCase("O"))
		{
			changeImageO(4);
			checkEndGame();
			return;
		}
		else if (values.get(4).equals(values.get(6)) && values.get(2).equalsIgnoreCase("empty") && values.get(2).equalsIgnoreCase("O"))
		{
			changeImageO(2);
			checkEndGame();
			return;
		}
		
		
		for (int i=0; i<=6; i=i+3)
		{
			if (values.get(i).equals(values.get(i+1)) && values.get(i+2).equalsIgnoreCase("empty") && values.get(i).equalsIgnoreCase("X"))
			{
				changeImageO(i+2);
				checkEndGame();
				return;
			}
			if (values.get(i).equals(values.get(i+2)) && values.get(i+1).equalsIgnoreCase("empty") && values.get(i).equalsIgnoreCase("X"))
			{
				changeImageO(i+1);
				checkEndGame();
				return;
			}
			if (values.get(i+1).equals(values.get(i+2)) && values.get(i).equalsIgnoreCase("empty") && values.get(i+1).equalsIgnoreCase("X"))
			{
				changeImageO(i);
				checkEndGame();
				return;
			}
		}
		
		for (int i=0; i<=2; i++)
		{
			if (values.get(i).equals(values.get(i+3)) && values.get(i+6).equalsIgnoreCase("empty") && values.get(i).equalsIgnoreCase("X"))
			{
				changeImageO(i+6);
				checkEndGame();
				return;
			}
			if (values.get(i).equals(values.get(i+6)) && values.get(i+3).equalsIgnoreCase("empty") && values.get(i).equalsIgnoreCase("X"))
			{
				changeImageO(i+3);
				checkEndGame();
				return;
			}
			if (values.get(i+3).equals(values.get(i+6)) && values.get(i).equalsIgnoreCase("empty") && values.get(i+3).equalsIgnoreCase("X"))
			{
				changeImageO(i);
				checkEndGame();
				return;
			}
		}
		
		if (values.get(0).equals(values.get(4)) && values.get(8).equalsIgnoreCase("empty") && values.get(0).equalsIgnoreCase("X"))
		{
			changeImageO(8);
			checkEndGame();
			return;
		}
		else if (values.get(0).equals(values.get(8)) && values.get(4).equalsIgnoreCase("empty") && values.get(0).equalsIgnoreCase("X"))
		{
			changeImageO(4);
			checkEndGame();
			return;
		}
		else if (values.get(4).equals(values.get(8)) && values.get(0).equalsIgnoreCase("empty") && values.get(4).equalsIgnoreCase("X"))
		{
			changeImageO(0);
			checkEndGame();
			return;
		}
		else if (values.get(2).equals(values.get(4)) && values.get(6).equalsIgnoreCase("empty") && values.get(2).equalsIgnoreCase("X"))
		{
			changeImageO(6);
			checkEndGame();
			return;
		}
		else if (values.get(2).equals(values.get(6)) && values.get(4).equalsIgnoreCase("empty") && values.get(2).equalsIgnoreCase("X"))
		{
			changeImageO(4);
			checkEndGame();
			return;
		}
		else if (values.get(4).equals(values.get(6)) && values.get(2).equalsIgnoreCase("empty") && values.get(4).equalsIgnoreCase("X"))
		{
			changeImageO(2);
			checkEndGame();
			return;
		}
		
		Random rand = new Random();
		boolean randomPosition = false;
		while (!randomPosition)
		{
			int randomNum = rand.nextInt(9);
			if (values.get(randomNum).equalsIgnoreCase("empty"))
			{
				randomPosition = true;
				changeImageO(randomNum);
			}
		}
		
		TextView txvTurn = (TextView) findViewById(R.id.txv_turn);
		txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
		
		checkEndGame();
	}

	private void changeImageO(int i) {
		// TODO Auto-generated method stub
		values.set(i, "O");
		totalImages.get(i).setImageResource(R.drawable.o);
		mediaPlayerHandler(mp, R.raw.tick);
	}

	private void endGame(String gameResult, ArrayList<ImageButton> winObjects) {
		// TODO Auto-generated method stub
		SharedPreferences.Editor editor = sharedPref.edit();
		moves = 0;
		editor.putInt("moves", moves);
		editor.commit();
		
		for (final ImageButton imgbtn : totalImages)
			imgbtn.setClickable(false);
		
		if (gameResult.equalsIgnoreCase("tie"))
		{
			ties++;
			editor.putInt("ties", ties);
			editor.commit();
			DialogFragments customDialog = new DialogFragments("It's a tie. Play again!", MainActivity.this);
			customDialog.show(getFragmentManager(), "result_win");
		}
		else
		{
			
			for (final ImageButton winObj : winObjects)
				winObj.startAnimation(flashWinningObjects());
			
			if (gameResult.equalsIgnoreCase("win"))
			{
				wins++;
				editor.putInt("wins", wins);
				editor.commit();
				mediaPlayerHandler(audienceApplause, R.raw.audience_applause);
				DialogFragments customDialog = new DialogFragments("You win!!! Play again!",  MainActivity.this);
				customDialog.show(getFragmentManager(), "result_win");
			}
			else
			{
				loses++;
				editor.putInt("loses", loses);
				editor.commit();
				DialogFragments customDialog = new DialogFragments("You lose. Play again!",  MainActivity.this);
				customDialog.show(getFragmentManager(), "result_win");
				//Toast.makeText(getApplicationContext(), "You lose. Play again", Toast.LENGTH_LONG).show();
			}
		}
		TextView txvPl = (TextView) findViewById(R.id.txv_desc_player);
		txvPl.setText("X Player: " + wins);
		TextView txvCo = (TextView) findViewById(R.id.txv_desc_computer);
		txvCo.setText("O Computer: " + loses);
	}

	private void checkForWinHorizontally(ArrayList<String> values, String symbol) {
		for (int i=0; i<=6; i=i+3)
		{
			if (values.get(i).equals(values.get(i+1)) && values.get(i+1).equals(values.get(i+2)) && values.get(i).equalsIgnoreCase(symbol))
			{
				winObjects.add(totalImages.get(i));
				winObjects.add(totalImages.get(i+1));
				winObjects.add(totalImages.get(i+2));
				endGame = true;
				if (symbol.equalsIgnoreCase("X"))
					endGame("win", winObjects);
				else
					endGame("lose", winObjects);
			}
		}
	}
	
	private void checkForWinVertically(ArrayList<String> values, String symbol) {
		for (int i=0; i<=2; i++)
		{
			if (values.get(i).equals(values.get(i+3)) && values.get(i+3).equals(values.get(i+6)) && values.get(i).equalsIgnoreCase(symbol))
			{
				winObjects.add(totalImages.get(i));
				winObjects.add(totalImages.get(i+3));
				winObjects.add(totalImages.get(i+6));
				endGame = true;
				if (symbol.equalsIgnoreCase("X"))
					endGame("win", winObjects);
				else
					endGame("lose", winObjects);
			}
		}
	}
	
	private void initGame() {
		// TODO Auto-generated method stub	
		wins = sharedPref.getInt("wins", wins);
		ties = sharedPref.getInt("ties", ties);
		loses = sharedPref.getInt("loses", loses);
		moves = 0;
		endGame = false;
		playersTurn = true;
		totalImages = new ArrayList<ImageButton>();
		values = new ArrayList<String>();
		winObjects = new ArrayList<ImageButton>();
		ImageButton imgBtn1 = (ImageButton)findViewById(R.id.button1); 
		ImageButton imgBtn2 = (ImageButton)findViewById(R.id.button2); 
		ImageButton imgBtn3 = (ImageButton)findViewById(R.id.button3);
		ImageButton imgBtn4 = (ImageButton)findViewById(R.id.button4); 
		ImageButton imgBtn5 = (ImageButton)findViewById(R.id.button5); 
		ImageButton imgBtn6 = (ImageButton)findViewById(R.id.button6); 
		ImageButton imgBtn7 = (ImageButton)findViewById(R.id.button7); 
		ImageButton imgBtn8 = (ImageButton)findViewById(R.id.button8); 
		ImageButton imgBtn9 = (ImageButton)findViewById(R.id.button9);
		totalImages.add(imgBtn1);
		totalImages.add(imgBtn2);
		totalImages.add(imgBtn3);
		totalImages.add(imgBtn4);
		totalImages.add(imgBtn5);
		totalImages.add(imgBtn6);
		totalImages.add(imgBtn7);
		totalImages.add(imgBtn8);
		totalImages.add(imgBtn9);
		values.add("empty");
		values.add("empty");
		values.add("empty");
		values.add("empty");
		values.add("empty");
		values.add("empty");
		values.add("empty");
		values.add("empty");
		values.add("empty");
		for (final ImageButton imgbtn : totalImages)
			imgbtn.clearAnimation();
		for (int i=0; i<totalImages.size(); i++)
		{
			totalImages.get(i).setImageResource(R.drawable.questionmark_hdpi);
		}
		TextView txvPl = (TextView) findViewById(R.id.txv_desc_player);
		txvPl.setText("X Player: " + wins);
		TextView txvCo = (TextView) findViewById(R.id.txv_desc_computer);
		txvCo.setText("O Computer: " + loses);
		TextView txvMo = (TextView) findViewById(R.id.txv_moves);
		txvMo.setText("moves: " + moves);
		
		TextView txvTurn = (TextView) findViewById(R.id.txv_turn);
		txvTurn.setText("Turn: " + ((playersTurn) ? "Player" : "Computer"));
		
	}
	
	private AlphaAnimation flashWinningObjects() {
		AlphaAnimation localAlphaAnimation3 = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation3.setDuration(200L);
        localAlphaAnimation3.setInterpolator(new LinearInterpolator());
        localAlphaAnimation3.setRepeatCount(-1);
        localAlphaAnimation3.setRepeatMode(2);
        return localAlphaAnimation3;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			int id = item.getItemId();
			if (id == R.id.action_clear_stats) {
				SharedPreferences.Editor editor = sharedPref.edit();
				editor.putInt("wins", 0);
				editor.putInt("loses", 0);
				editor.commit();
				TextView txvPl = (TextView) findViewById(R.id.txv_desc_player);
				txvPl.setText("X Player: " + 0);
				TextView txvCo = (TextView) findViewById(R.id.txv_desc_computer);
				txvCo.setText("O Computer: " + 0);
				return true;
			}
			else if (id == R.id.action_start_new_game)
			{
				stopMediaPlayer();
				finish();
				startActivity(getIntent());
				return true;
			}
			else if (id == R.id.action_help)
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
			      
				return true;
			}
			else if (item.getItemId() == android.R.id.home) {
		        // do something here, such as start an Intent to the parent activity.
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
			    alertDialogBuilder.setMessage("Are you sure you want to exit game?");
			      
			    alertDialogBuilder.setPositiveButton("No", new DialogInterface.OnClickListener() {
			       @Override
			       public void onClick(DialogInterface arg0, int arg1) {
			       }
			    }).setNeutralButton("Yes", new DialogInterface.OnClickListener() {
		               @Override
		               public void onClick(DialogInterface dialog, int id) {
		            	   MainActivity.this.finish();
		               }
		           }); 
			    AlertDialog alertDialog = alertDialogBuilder.create();
			    alertDialog.show();
		        return true;
		    }
			
			return super.onOptionsItemSelected(item);
		}

		public void stopMediaPlayer() {
			// TODO Auto-generated method stub
			if (audienceApplause.isPlaying())
			{
				audienceApplause.stop();
				audienceApplause.release();
			}
		}
		
		@Override
		public void onBackPressed() {
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		    alertDialogBuilder.setMessage("Are you sure you want to exit game?");
		      
		    alertDialogBuilder.setPositiveButton("No", new DialogInterface.OnClickListener() {
		       @Override
		       public void onClick(DialogInterface arg0, int arg1) {
		       }
		    }).setNeutralButton("Yes", new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   MainActivity.this.finish();
	               }
	           }); 
		    AlertDialog alertDialog = alertDialogBuilder.create();
		    alertDialog.show();
		    
		}
}
