package com.example.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements OnClickListener
{
	EditText personsEmail, intro , personsName, stupidThings ,hatefulAction,outro;
	
	String emailAdd, beginning, name, stupidAction, hatefulAct, out;
	
	Button sendEmail;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.scroll);
	initializeVars();
	sendEmail.setOnClickListener(this);
	}
	
	private void initializeVars()
	{
		personsEmail = (EditText)findViewById(R.id.etEmails);
		intro = (EditText)findViewById(R.id.etIntro); 
		personsName = (EditText)findViewById(R.id.etName);
		stupidThings = (EditText)findViewById(R.id.etThings); 
		hatefulAction = (EditText)findViewById(R.id.etAction);
		outro = (EditText)findViewById(R.id.etOutro);
		sendEmail = (Button)findViewById(R.id.btEmail);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		convertEditText();
		String emailAddr[] = { emailAdd };
		String message ="Hello"+ name + "i wanted to say" + beginning +" i hate you when" + stupidAction +" and i go crazy when " + hatefulAct +" ok " +out ;
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddr);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "GOOD BYE");
		emailIntent.setType("plain\text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);	
        startActivity(emailIntent);
	}

	private void convertEditText() {
		// TODO Auto-generated method stub
		emailAdd = personsEmail.getText().toString(); 
		beginning = intro.getText().toString(); 
		name = personsName.getText().toString();
		stupidAction = stupidThings.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
