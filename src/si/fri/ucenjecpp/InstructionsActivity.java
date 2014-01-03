package si.fri.ucenjecpp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class InstructionsActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions);
		TextView TextNavodila = (TextView) this.findViewById(R.id.TextViewNavodila);
		TextNavodila.setText("Crke ob sliki se navezujejo na crke na gumbih\n"+
				"ce mislite da je pravilen odgovor ob keterem je crka A pritisnite gumb s crko A "+
				"ce mislite da je pravilen odgovor ob keterem je crka B pritisnite gumb s crko B "+
				"ce mislite da je pravilen odgovor ob keterem je crka C pritisnite gumb s crko C ");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.instructions, menu);
		return true;
	}
	public void onClick(View v) {
		Intent i = new Intent(this, StartActivity.class);
		startActivity(i);
		finish();
		
	}
	

}
