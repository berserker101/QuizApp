package com.example.quizapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends Activity {
	private static final String EXTRA_RESULT = "com.example.quizapp.extra_result"; 
	private static final String EXTRA_Question = "com.example.quizapp.extra_question";  
	private TextView textViewResult;
	private String result; 

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_results); 
	 
	 textViewResult = (TextView) findViewById(R.id.textViewResult); 
	 
	 result = getIntent().getStringExtra(EXTRA_RESULT);
	 textViewResult.setText(result); 

}
	public static Intent newIntent(Context packageContext, String result, String question) { 
		Intent intent = new Intent(packageContext, ResultsActivity.class); 
		intent.putExtra(EXTRA_RESULT, result); 
		intent.putExtra(EXTRA_RESULT, result); 
		return intent; 
	}
}


