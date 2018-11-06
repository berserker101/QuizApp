package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        Button buttonnormal_quiz = (Button) findViewById(R.id.buttonnormal_quiz); 
    

        buttonnormal_quiz.setOnClickListener(new View.OnClickListener() { 
        
        	@Override 
        	public void onClick(View arg0) { 
        		Intent intent = new Intent(MainActivity.this, 
        				QuestionActivity.class); 
        		startActivity(intent); 
        	}
        });
        Button buttonhard_quiz = (Button) findViewById(R.id.buttonhard_quiz); 
        

        buttonhard_quiz.setOnClickListener(new View.OnClickListener() { 
        
        	@Override 
        	public void onClick(View arg0) { 
        		Intent intent = new Intent(MainActivity.this, 
        				Question2Activity.class); 
        		startActivity(intent); 
        	}
        });
    }   
}  
        
        
        
        