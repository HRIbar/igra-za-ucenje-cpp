package si.fri.ucenjecpp;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class IngameActivity extends Activity implements OnClickListener  {
	TextView editNickname, editTocke, editSekunde;
	int timeLeft = 30;
	int tocke;
	String nickname = User.nickname;
	Timer timerOne = new Timer();
	String[] imageArray = {"vprasanje1b", "vprasanje2a","vprasanje3a","vprasanje4b","vprasanje5a",
			"vprasanje6a","vprasanje7b","vprasanje8b","vprasanje9a","vprasanje10c"}; //zadna crka predstavlja pravilen odgovor
	//ker se mi neda delat sezam terk ali kaj podobnega
	Random rnd = new Random();
	String pravilen;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingame);
		
		editNickname = (TextView) findViewById(R.id.uporabnik);
		editTocke = (TextView) findViewById(R.id.tocke);
		editSekunde = (TextView) findViewById(R.id.sekunde);
		
		// Set the nickname at the beginning and points
		editNickname.setText(User.nickname);
		editTocke.setText(Integer.toString(User.points));
		
		/* Calling the inside class which calls run() 
		 * function every 1000ms.
		 */
		
		timerOne.schedule(new ProcessOne(), 0L, 1000L);
		NastaviSliko();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.ingame, menu);
		return true;
	}
	
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.buttonA :
			if(pravilen.equals("a")){
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezltat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.pravilno);
				adb.show();
				
				tocke = User.points;
				tocke = tocke + 15;
				User.points = tocke;
				editTocke.setText(Integer.toString(User.points));
				timeLeft = 30;
				timerOne.schedule(new ProcessOne(), 0L, 1000L);
				NastaviSliko();
				}
			else{
				writeToFile(nickname+" je dosegel: "+Integer.toString(tocke)+" tock");//shranimo tocke
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
			adb.setTitle("Rezltat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.narobe);
			adb.show();
			Intent i = new Intent(this, ScoreActivity.class);
			startActivity(i);
			finish();
			
			}
			
			
			break;
		case R.id.buttonB :
			if(pravilen.equals("b")){
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezltat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.pravilno);
				adb.show();
				
				tocke = User.points;
				tocke = tocke + 15;
				User.points = tocke;
				editTocke.setText(Integer.toString(User.points));
				timeLeft = 30;
				timerOne.schedule(new ProcessOne(), 0L, 1000L);
				NastaviSliko();
				}
			else{
				writeToFile(nickname+" je dosegel: "+Integer.toString(tocke)+" tock");//shranimo tocke
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
			adb.setTitle("Rezltat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.narobe);
			adb.show();
			Intent i = new Intent(this, ScoreActivity.class);
			startActivity(i);
			finish();
			//nastavi score TODO
			}
			
			break;
			
		case R.id.buttonC :
			if(pravilen.equals("c")){
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezltat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.pravilno);
				adb.show();
				
				tocke = User.points;
				tocke = tocke + 15;
				User.points = tocke;
				editTocke.setText(Integer.toString(User.points));
				timeLeft = 30;
				timerOne.schedule(new ProcessOne(), 0L, 1000L);
				NastaviSliko();
				}
			else{
				writeToFile(nickname+" je dosegel: "+Integer.toString(tocke)+" tock");//shranimo tocke
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
			adb.setTitle("Rezltat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.narobe);
			adb.show();
			Intent i = new Intent(this, ScoreActivity.class);
			startActivity(i);
			finish();
			//nastavi score TODO
			}
			
			break;
		
		} //konec switch
		
		
	} //konec onClick
	
	public void NastaviSliko(){
		ImageView img=(ImageView)findViewById(R.id.imageView1);
		int index = rnd.nextInt(imageArray.length);
		pravilen = Character.toString(imageArray[index].charAt(imageArray[index].length()-1)); //nastavi pravilen odgovr
		int resID = getResources().getIdentifier(imageArray[index], "drawable",  getPackageName());
		img.setImageResource(resID);
	}
	
	public void NovaAktivnost(Class cls){
		Intent i = new Intent(this, cls);
		startActivity(i);
		}
	
	public void AlertDialog(String obvestilo){
		AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
		adb.setTitle("Obvestilo").setCancelable(false).setPositiveButton("V redu", null).setMessage(obvestilo);
		adb.show();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	
	
	
	
	
	
	
	private class ProcessOne extends TimerTask {
		public void run() {
			runOnUiThread(new Runnable() {
			    public void run() {
			    	editSekunde.setText(Integer.toString(timeLeft) + "s");
			    	if (timeLeft == 0){
			    		timerOne.cancel();
			    		/* Here you add to switch to new activity
			    		 * because the game is over - timeleft = 0!
			    		 */
			    		AlertDialog("Vas cas je potekel\nGame Over :)"); //mogoce se komu to zdi primitivno?
						
						NovaAktivnost(ScoreActivity.class);
						finish();
			    	}
			    	timeLeft--;
			    }
			});
			
        }
    }

   

}
