package com.example.fruitilicious;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class Grapes extends SherlockActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fruit);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		/* Changing the string and image - saves having extra XML files */
		String string_to_change = getResources().getString(R.string.grapes);
		((TextView) findViewById(R.id.textViewFruit)).setText(string_to_change);

		ImageView change_image = ((ImageView) findViewById(R.id.imageView1));
		change_image.setImageDrawable(getResources().getDrawable(
				R.drawable.grapes2));

		/* sound file */

		final MediaPlayer grapesSound = MediaPlayer.create(this,
				R.raw.g_for_grapes);

		/* FIRST LETTER BIG .. USING IMAGE SPAN */

		TextView fruitname = (TextView) findViewById(R.id.textViewFruit);

		SpannableString bigLetter = (SpannableString) fruitname.getText();

		Drawable bigA = getResources().getDrawable(R.drawable.letter_g);
		bigA.setBounds(0, 0, bigA.getIntrinsicWidth(),
				bigA.getIntrinsicHeight());
		ImageSpan span = new ImageSpan(bigA, ImageSpan.ALIGN_BASELINE);
		bigLetter.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

		fruitname.setText(bigLetter, BufferType.SPANNABLE);

		/* PLAY SOUND BY CLICKING BIG LETTER - see drawable/textviewclick.xml */

		fruitname.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				grapesSound.start();
			}

		});
		
		/* PLAY SOUND BY CLICKING IMAGE */

		change_image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				grapesSound.start();
			}

		});

	}

	/* ACTION BAR SHERLOCK MENU BELOW */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		com.actionbarsherlock.view.MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.options_each_fruit,
				(com.actionbarsherlock.view.Menu) menu);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return (true);

		case R.id.about:
			openAbout();
			return (true);
		case R.id.feedback:
			openFeedback();
			return (true);

		}
		return (super.onOptionsItemSelected(item));
	}

	/* Method to open feedback page from options menu */
	private void openFeedback() {
		Intent intent = new Intent();
		intent.setClassName("com.example.fruitilicious",
				"com.example.fruitilicious.Feedback");
		startActivity(intent);
	}

	/* Method to open about page from options menu */
	private void openAbout() {
		Intent intent = new Intent();
		intent.setClassName("com.example.fruitilicious",
				"com.example.fruitilicious.About");
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
