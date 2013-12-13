package gky.aspera.lotteryrand;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
	
	MediaPlayer splashSFX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		splashSFX = MediaPlayer.create(Splash.this, R.raw.splash_fx);
		splashSFX.start();
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openMenu = new Intent("gky.aspera.lotteryrand.MENU");
					startActivity(openMenu);
				}	
			}
		};
		
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		splashSFX.release();
		finish();
	}
	
}
