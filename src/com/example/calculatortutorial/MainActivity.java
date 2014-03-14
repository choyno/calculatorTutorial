package com.example.calculatortutorial;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private EditText input_holder;
	private String operator;
	private float number_bf = 0;
	private 	float number_af = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		input_holder = (EditText) findViewById(R.id.txt_input_holder);
		input_holder.setEnabled(false);
		input_holder.setText("0");
		int btnList[] = { R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3,
				R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8,
				R.id.btn_9, R.id.btn_dot, R.id.btn_c, R.id.btn_add,
				R.id.btn_equals, R.id.btn_minus, R.id.btn_times, R.id.btn_mul }; 
		for (int id : btnList) {
			View v = (View) findViewById(id);
			v.setOnClickListener(this); 
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void mExecute(String str) {
		number_bf = Float.parseFloat(input_holder.getText().toString());
		operator = str; 
		input_holder.setText("0");
	}

	public void mResult() {
		number_af = Float.parseFloat(input_holder.getText().toString());
		float result = 0;
		if (operator.equals("+")) {
			result = number_af + number_bf;
		} 
		if (operator.equals("-")) {
			result =  number_af -  number_bf;
		}
		if (operator.equals("*")) {
			result =  number_af * number_bf;
		}
		if (operator.equals("/")) {
			result =  number_af / number_bf;
		}

		input_holder.setText(String.valueOf(result));
	}

	public void getKeyClick(String str) {
		String addValue = input_holder.getText().toString();
		if (addValue.equals("0")) {
			addValue = "";
		}
		addValue += str; 
		input_holder.setText(String.valueOf(addValue));
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_c:
				input_holder.setText("0");
				operator = "";
				number_bf = 0;
				break;
			case R.id.btn_add:
				this.mExecute("+");
				break; 
			case R.id.btn_minus:
				this.mExecute("-");
				break;
			case R.id.btn_times:
				this.mExecute("*");
				break;
			case R.id.btn_mul:
				this.mExecute("/");
				break;
			case R.id.btn_equals:
				this.mResult();
				break;
			default:
				String btn_value = ((Button) v).getText().toString();
				Log.d("valueeeee", btn_value);
				this.getKeyClick(btn_value);
				break;
		}
	}
}
