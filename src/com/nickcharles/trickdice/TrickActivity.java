package com.nickcharles.trickdice;

import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class TrickActivity extends Activity {
	private TextView trickDisplay;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trick);
	        
		trickDisplay = (TextView) findViewById(R.id.trick_display_box);

		Spinner levelSpinner = (Spinner) findViewById(R.id.level);
		ArrayAdapter<CharSequence> levelAdapter = ArrayAdapter.createFromResource(this,
				R.array.levels, android.R.layout.simple_spinner_item);
		levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		levelSpinner.setAdapter(levelAdapter);
		
		
		Button jibRollButton = (Button) findViewById(R.id.jib_roll_button);
		Button jumpRollButton = (Button) findViewById(R.id.jump_roll_button);
		
		jibRollButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				jibRoll();
			}
		});
		
		jumpRollButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				jumpRoll();
			}
		});
	}

	private void jibRoll() {
		Resources res = getResources();
		String[] approach = res.getStringArray(R.array.approach);
		String[] slide = res.getStringArray(R.array.slide);
		Random r = new Random();
		int i = r.nextInt(approach.length);
		int j = r.nextInt(slide.length);
		trickDisplay.setText(approach[i] + " " + slide[j]);
	}
	
	private void jumpRoll() {
		Resources res = getResources();
		String[] spinDirection = res.getStringArray(R.array.spinDirection);
		String[] degree = res.getStringArray(R.array.degree);
		String[] grab = res.getStringArray(R.array.grab);
		Random r = new Random();
		int i = r.nextInt(spinDirection.length);
		int j = r.nextInt(degree.length);
		int k = r.nextInt(grab.length);
		trickDisplay.setText(spinDirection[i] + " " + degree[j] + " " + grab[k]);
	}
}