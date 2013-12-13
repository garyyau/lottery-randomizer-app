package gky.aspera.lotteryrand;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity implements View.OnClickListener {

	Button start;
	Button instruct;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		
		AdView ad = (AdView) findViewById(R.id.adView);

		// REMMOVE THESE LINES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		AdRequest request = new AdRequest();
		request.addTestDevice(AdRequest.TEST_EMULATOR);
		request.setTesting(true);
		// REMMOVE THESE LINES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				
		ad.loadAd(new AdRequest());
		//ad.loadAd(new AdRequest());
		
		initalize();
	}

	private void initalize() {
		// TODO Auto-generated method stub
		start = (Button) findViewById(R.id.bStart);
		instruct = (Button) findViewById(R.id.bInstruct);
		start.setOnClickListener(this);
		instruct.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bStart:
			Intent openGenerator = new Intent("gky.aspera.lotteryrand.TYPEMENU");
			startActivity(openGenerator);
			break;
		
		case R.id.bInstruct:
			Intent openInstruct = new Intent("gky.aspera.lotteryrand.INSTRUCT");
			startActivity(openInstruct);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.mainmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) {
		case R.id.menuAbout:
			Intent openAbout = new Intent("gky.aspera.lotteryrand.ABOUT");
			startActivity(openAbout);
			break;
			
		case R.id.menuInstructions:
			Intent openInstruct = new Intent("gky.aspera.lotteryrand.INSTRUCT");
			startActivity(openInstruct);
			break;
			
		case R.id.menuPreferences:
			Intent openTM = new Intent("gky.aspera.lotteryrand.TYPEMENU");
			startActivity(openTM);
			break;
		}
		return false;
	}

}
