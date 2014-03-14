package com.example.calculatortutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText input_holder; 
	private String operator;
	private float number_bf;
	private ButtonOnClickListener btnOnClick;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		input_holder = (EditText) findViewById(R.id.txt_input_holder);
		input_holder.setText("0");
		int btnList[] = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6
				, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_dot, R.id.btn_c, R.id.btn_add, R.id.btn_equals
				, R.id.btn_minus, R.id.btn_times, R.id.btn_mul};
		
		for(int id:btnList){
			View v =(View) findViewById(id);
			v.setOnClickListener(btnOnClick);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void mExecute(String str){	 
		number_bf = Float.parseFloat(input_holder.getText().toString());
		operator = str;
		input_holder.setText("0");
	} 
	public void mResult(){ 
		float number_af = Float.parseFloat(input_holder.getText().toString());
		float result = 0;
		if(operator == "+"){
			result = number_bf + number_af; 
		}else if(operator == "-"){
			result = number_bf - number_af; 
		}else if(operator == "*"){
			result = number_bf * number_af; 
		}else if(operator == "/"){
			result = number_bf / number_af; 
		}
		
		input_holder.setText(String.valueOf(result));
	}  
	public void getKeyClick(String str){
		String addValue = input_holder.getText().toString();
		addValue += str;
		input_holder.setText("0");
	}
	
	private class ButtonOnClickListener implements OnClickListener{
		
		public void onClick(View view){ 
			switch(view.getId()){
			case(R.id.btn_c):
				input_holder.setText("0");
				operator = "";
				number_bf = 0;
				break; 
			case(R.id.btn_add): 
				mExecute("+");
				break;  
			case(R.id.btn_minus): 
				mExecute("-");
				break;  
			case(R.id.btn_times): 
				mExecute("*");
				break;  
			case(R.id.btn_mul): 
				mExecute("/");
				break;  
			case(R.id.btn_equals):
				mResult();
				break;
			default:
				String btn_value = ((Button) view).getText().toString();
				getKeyClick(btn_value);
				break;
			}
		} 
	}

}
