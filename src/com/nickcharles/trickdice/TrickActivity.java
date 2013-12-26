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
				roll();
			}
		});
		
		jumpRollButton.setOnClickListener(new View.OnClickListener() {
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