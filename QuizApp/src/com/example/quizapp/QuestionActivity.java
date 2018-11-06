package com.example.quizapp;

import tree.LinkedBinaryTree;
import tree.Position;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionActivity extends Activity {
	private LinkedBinaryTree<String> decisionTree = new LinkedBinaryTree<String>(); 
	private Position<String> position; 
	
	private RadioGroup radioGroup; 
	private TextView textViewQuestion; 
	private Button buttonNext; 
	
	protected boolean selectedYes;
	private Position<String> questionPosition; 
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_question); 
     
	    String resultPositive = "You nailed it!"; 
	    String resultPositive2 ="passed ";
	    String resultNegative = "Failed"; 
	    
	    
	    Position<String> rootPosition = decisionTree.addRoot("25*25=625"); //true
	    
	    Position<String> q2YesPosition = decisionTree.addLeft(rootPosition, //false
	    		"85/4=30.2"); 
	    
	    decisionTree.addLeft(q2YesPosition, resultPositive2); 
	    decisionTree.addRight(q2YesPosition, resultPositive); 
	    
	    Position<String> q2NoPosition = decisionTree.addRight(rootPosition, //true
	    		"134+143=277"); 
	    
	    decisionTree.addLeft(q2NoPosition, resultPositive2);
	    decisionTree.addRight(q2NoPosition, resultNegative); 
	    
	    questionPosition = decisionTree.root(); 
	    
	    textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
	    
	    radioGroup = (RadioGroup) findViewById(R.id.radioGroup); 
	    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
	    	@Override 
	    	public void onCheckedChanged(RadioGroup group, int checkedId) { 
	    		RadioButton radioButton = (RadioButton) 
group.findViewById(checkedId);
	    		if (radioButton != null) {
	    			String stringYes = getResources().getString(R.string.yes); 
	    			if (radioButton.getText().equals(stringYes)) 
	    				selectedYes = true; 
	    			else
	    				selectedYes = false;
	    			buttonNext.setEnabled(true); 
	    		}
	    		else
	    			buttonNext.setEnabled(false); 
	    	}
	    });
	    
	    buttonNext = (Button) findViewById(R.id.buttonNext); 
	    buttonNext.setOnClickListener(new View.OnClickListener() { 
	    	@Override 
	    	public void onClick(View arg0) { 
	    		buttonNext.setEnabled(false); 
	    		if (selectedYes) 
	    			questionPosition = decisionTree.left(questionPosition); 
	    		else
	    			questionPosition = decisionTree.right(questionPosition); 
	    		
	    		if (decisionTree.isInternal(questionPosition)) {
	    		
	    			textViewQuestion.setText(questionPosition.getElement()); 
	    				
	    			QuestionActivity.this.setTitle("Question #"
	    					+ (decisionTree.depth(questionPosition) + 1)); 
	    		}
	    		else { 
	    			String result = questionPosition.getElement(); 
	    		
	    			Intent intent = ResultsActivity.newIntent(
	    					QuestionActivity.this, result,""); 
	    			
	    			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
	    			
	    			startActivity(intent); 
	    			finish(); 
	    		}
	    		
	    	}
	    });
	}
	
	@Override 
	protected void onStart() { 
		super.onStart(); 
		int questionNumber = decisionTree.depth(questionPosition) + 1; 
		this.setTitle("Question #" + questionNumber); 
		textViewQuestion.setText(questionPosition.getElement()); 
		
		
	}
}
