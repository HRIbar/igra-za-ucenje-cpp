package si.fri.ucenjecpp;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity{
	
	Button gumbStart, gumbScore, gumbNavodila, gumbExit;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		// User code - Add buttons etc. here
		
		
		gumbStart = (Button) findViewById(R.id.buZacni);
		gumbScore = (Button) findViewById(R.id.buRezultati);
		gumbNavodila = (Button) findViewById(R.id.buNavodila);
		gumbExit = (Button) findViewById(R.id.buIzhod);
		
		gumbStart.setOnClickListener(new View.OnClickListener() {

		    @Override
		    public void onClick(View v) {
		    	
		    	try{
		         gumbStart.setBackgroundColor(color.white);
		         Intent userActivity = new Intent(getApplicationContext(), InputUserActivity.class);
		         startActivity(userActivity);
		         finish();
		    	}//try
		    	catch(Exception e){e.printStackTrace();}
		    }
		});
		
		gumbExit.setOnClickListener(new View.OnClickListener() {

		    @Override
		    public void onClick(View v) {
		    	try{
		    	// Fix the coloring of the button when pressed
		         //gumbExit.setBackgroundColor(color.white);
		         StartActivity.this.finish();
		    	}
		    	catch(Exception e){e.printStackTrace();}
		    	
		    }
		});
		
		gumbScore.setOnClickListener(new View.OnClickListener() {

		    @Override
		    public void onClick(View v) {
		    	try{
		         //gumbScore.setBackgroundColor(color.white);
		         Intent scoreActivity = new Intent(getApplicationContext(), ScoreActivity.class);
		         startActivity(scoreActivity);
		         finish();
		    	}
		    	catch(Exception e){e.printStackTrace();}
		    }
		});
		
		gumbNavodila.setOnClickListener(new View.OnClickListener() {

		    @Override
		    public void onClick(View v) {
		    	try{
		         //gumbScore.setBackgroundColor(color.white);
		         Intent instruActivity = new Intent(getApplicationContext(),InstructionsActivity.class);
		         startActivity(instruActivity);
		         finish();
		    	}
		    	catch(Exception e){e.printStackTrace();}
		    }
		});
		}
		catch(Exception e){e.printStackTrace();}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		try{
		getMenuInflater().inflate(R.menu.start, menu);
		}
		catch(Exception e){e.printStackTrace();}
		return true;
		
		
	}
	

}

