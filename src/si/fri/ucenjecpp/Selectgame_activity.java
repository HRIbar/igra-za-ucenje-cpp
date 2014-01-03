package si.fri.ucenjecpp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class Selectgame_activity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selectgame_activity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selectgame_activity, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		try{
			switch(v.getId()){
			
			case R.id.button1:
				Intent i = new Intent(this, IngameActivity.class);
				startActivity(i);
				finish();
				
				break;
			
			case R.id.button2:
				Intent i2 = new Intent(this, Znaki_activity.class);
				startActivity(i2);
				finish();
				
				break;
			
			case R.id.button3:
				Intent i3 = new Intent(this, Krizisca_activity.class);
				startActivity(i3);
				finish();
				
				break;
				
			case R.id.button4:
				Intent i4 = new Intent(this, Avtocesta_activity.class);
				startActivity(i4);
				finish();
				
				break;
			
			
			
			}
			
			
			
			
			
			
		}
		catch(Exception e){e.printStackTrace();}
		
	}
	
	

}
