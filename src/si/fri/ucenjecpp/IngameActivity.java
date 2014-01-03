package si.fri.ucenjecpp;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		try{
		switch(v.getId()){
		
		case R.id.buttonA :
			if(pravilen.equals("a")){
				
				stopService(new Intent(getBaseContext(), PredvajajCounter.class));
				startService(new Intent(getBaseContext(), PredvajajPrav.class));
				
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezultat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.pravilno);
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
				String rezultatiText = readFromFile();
				writeToFile(rezultatiText +"\n"+nickname+" je dosegel: "+Integer.toString(tocke)+" tock");//shranimo tocke
				
				stopService(new Intent(getBaseContext(), PredvajajCounter.class));
				startService(new Intent(getBaseContext(), PredvajajNarobe.class));
				
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezultat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.narobe);
				adb.show();
				
				
				Intent i = new Intent(this, ScoreActivity.class);
				startActivity(i);
				finish();
			
			}
			
			
			break;
		case R.id.buttonB :
			if(pravilen.equals("b")){
				
				stopService(new Intent(getBaseContext(), PredvajajCounter.class));
				startService(new Intent(getBaseContext(), PredvajajPrav.class));
				
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezultat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.pravilno);
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
				String rezultatiText = readFromFile();
				writeToFile(rezultatiText +"\n"+nickname+" je dosegel: "+Integer.toString(tocke)+" tock");//shranimo tocke
				
				stopService(new Intent(getBaseContext(), PredvajajCounter.class));
				startService(new Intent(getBaseContext(), PredvajajNarobe.class));
				
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezultat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.narobe);
				adb.show();
				Intent i = new Intent(this, ScoreActivity.class);
				startActivity(i);
				finish();
			//nastavi score TODO
			}
			
			break;
			
		case R.id.buttonC :
			if(pravilen.equals("c")){
				
				stopService(new Intent(getBaseContext(), PredvajajCounter.class));
				startService(new Intent(getBaseContext(), PredvajajPrav.class));
				
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezultat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.pravilno);
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
				String rezultatiText = readFromFile();
				writeToFile(rezultatiText +"\n"+nickname+" je dosegel: "+Integer.toString(tocke)+" tock");//shranimo tocke
				
				stopService(new Intent(getBaseContext(), PredvajajCounter.class));
				startService(new Intent(getBaseContext(), PredvajajNarobe.class));
				
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezultat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.narobe);
				adb.show();
				
				Intent i = new Intent(this, ScoreActivity.class);
				startActivity(i);
				finish();
			//nastavi score TODO
			}
			
			break;
			
		case R.id.buttonD:
if(pravilen.equals("d")){
				
				stopService(new Intent(getBaseContext(), PredvajajCounter.class));
				startService(new Intent(getBaseContext(), PredvajajPrav.class));
				
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezultat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.pravilno);
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
				String rezultatiText = readFromFile();
				writeToFile(rezultatiText +"\n"+nickname+" je dosegel: "+Integer.toString(tocke)+" tock");//shranimo tocke
				
				stopService(new Intent(getBaseContext(), PredvajajCounter.class));
				startService(new Intent(getBaseContext(), PredvajajNarobe.class));
				
				AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
				adb.setTitle("Rezultat").setCancelable(false).setPositiveButton("V redu", null).setMessage(R.string.narobe);
				adb.show();
				
				Intent i = new Intent(this, ScoreActivity.class);
				startActivity(i);
				finish();
			//nastavi score TODO
			}
			
			
			break;
			
		
		
		} //konec switch
		}
		catch(Exception e){e.printStackTrace();}
		
	} //konec onClick
	
	
	public void NastaviSliko(){
		try{
		ImageView img=(ImageView)findViewById(R.id.imageView1);
		int index = rnd.nextInt(imageArray.length);
		pravilen = Character.toString(imageArray[index].charAt(imageArray[index].length()-1)); //nastavi pravilen odgovr
		int resID = getResources().getIdentifier(imageArray[index], "drawable",  getPackageName());
		img.setImageResource(resID);
		
		startService(new Intent(getBaseContext(), PredvajajCounter.class)); //predvajaj mp3 counter
		}
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
	
	public void NovaAktivnost(Class cls){
		try{
		Intent i = new Intent(this, cls);
		startActivity(i);
		}
		catch(Exception e){e.printStackTrace();}
		}
	
	public void AlertDialog(String obvestilo){
		try{
		AlertDialog.Builder adb = new AlertDialog.Builder(this, 3);
		adb.setTitle("Obvestilo").setCancelable(false).setPositiveButton("V redu", null).setMessage(obvestilo);
		adb.show();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}//try
		catch(Exception e){e.printStackTrace();}
		
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
			    		
			    		
			    		
			    		stopService(new Intent(getBaseContext(), PredvajajCounter.class));
						startService(new Intent(getBaseContext(), PredvajajTimeout.class));
						
			    		AlertDialog("Vas cas je potekel\nGame Over :)"); //mogoce se komu to zdi primitivno?
			    		String rezultatiText = readFromFile();
						writeToFile(rezultatiText +"\n"+nickname+" je dosegel: "+Integer.toString(tocke)+" tock");//shranimo tocke
						NovaAktivnost(ScoreActivity.class);
						finish();
			    	}
			    	timeLeft--;
			    }
			});
			
        }
    }

   

}
