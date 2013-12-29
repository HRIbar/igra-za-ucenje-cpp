package si.fri.ucenjecpp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class ScoreActivity extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		EditText TextRezultati = (EditText) this.findViewById(R.id.editTextRezultati);
		String podatki = readFromFile();
		TextRezultati.setText(podatki);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		try{
		switch(v.getId()){
		case R.id.button1:
			Intent i = new Intent(this, StartActivity.class);
			startActivity(i);
			finish();
		break;
		
		case R.id.button2:
			EditText TextRezultati = (EditText) this.findViewById(R.id.editTextRezultati);
			writeToFile("");
			TextRezultati.setText("");
		
		}
		}//try
		catch(Exception e){e.printStackTrace();}
		
		
	}
	
	private String readFromFile() {

	    String ret = "";

	    try {
	        InputStream inputStream = openFileInput("rezultati.txt");

	        if ( inputStream != null ) {
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
	            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	            String receiveString = "";
	            StringBuilder stringBuilder = new StringBuilder();

	            while ( (receiveString = bufferedReader.readLine()) != null ) {
	                stringBuilder.append(receiveString+"\n");
	            }

	            inputStream.close();
	            ret = stringBuilder.toString();
	        }
	    }
	    catch (FileNotFoundException e) {
	        Log.e("login activity", "File not found: " + e.toString());
	    } catch (IOException e) {
	        Log.e("login activity", "Can not read file: " + e.toString());
	    }

	    return ret;
	}
	
	private void writeToFile(String data) {
	    try {
	        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("rezultati.txt", Context.MODE_PRIVATE));
	        outputStreamWriter.write(data);
	        outputStreamWriter.close();
	    }
	    catch (IOException e) {
	        Log.e("Exception", "File write failed: " + e.toString());
	    } 
	}

}
