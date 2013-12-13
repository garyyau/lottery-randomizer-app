package gky.aspera.lotteryrand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TypeMenu extends Activity implements OnClickListener {

	Button launch649;
	Button launchMax;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.typemenu);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		launch649 = (Button) findViewById(R.id.bLaunch649);
		launchMax = (Button) findViewById(R.id.bLaunchMax);
		launch649.setOnClickListener(this);
		launchMax.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.bLaunch649:
			Intent launcher649 = new Intent("gky.aspera.lotteryrand.GEN");
			startActivity(launcher649);
			break;
			
		case R.id.bLaunchMax:
			Intent launcherLM = new Intent("gky.aspera.lotteryrand.GENLM");
			startActivity(launcherLM);
			break;
		}
	}
}
