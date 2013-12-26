package com.nickcharles.trickdice;

import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TrickActivity extends Activity {
	private TextView trickDisplay;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trick);
	        
		trickDisplay = (TextView) findViewById(R.id.trick_display_box);
		Button rollButton = (Button) findViewById(R.id.rollbutton);
		
		rollButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				roll();
			}
		});
	}

	private void roll() {
		Resources res = getResources();
		String[] spinDirection = res.getStringArray(R.array.spinDirection);
		String[] degree = res.getStringArray(R.array.degree);
		Random r = new Random();
		int i = r.nextInt(spinDirection.length);
		int j = r.nextInt(degree.length);
		trickDisplay.setText(spinDirection[i] + " " + degree[j]);
	}
}