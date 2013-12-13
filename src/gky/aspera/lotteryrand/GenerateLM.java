package gky.aspera.lotteryrand;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GenerateLM extends Activity implements View.OnClickListener {

	Button num1, num2, num3, num4, num5, num6, num7;
	Button[] ba = { num1, num2, num3, num4, num5, num6, num7 };
	Button generate;
	
	int[] results = new int[7];
	boolean[] locked = {false, false, false, false, false, false, false};
	boolean first = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.randomgen_lottomax);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		ba[0] = (Button) findViewById(R.id.blmNum1);
		ba[1] = (Button) findViewById(R.id.blmNum2);
		ba[2] = (Button) findViewById(R.id.blmNum3);
		ba[3] = (Button) findViewById(R.id.blmNum4);
		ba[4] = (Button) findViewById(R.id.blmNum5);
		ba[5] = (Button) findViewById(R.id.blmNum6);
		ba[6] = (Button) findViewById(R.id.blmNum7);
		generate = (Button) findViewById(R.id.blmGenerate);
		for (int i = 0; i < ba.length; i++) {
			ba[i].setEnabled(false);
			ba[i].setOnClickListener(this);
		}
		generate.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()) {
		case R.id.blmNum1:
			if (locked[0]) {
				locked[0] = false;
				ba[0].setBackgroundResource(R.drawable.button_enabled);
			}else{
				locked[0] = true;
				ba[0].setBackgroundResource(R.drawable.button_locked);
			}
			break;	
		case R.id.blmNum2:
			if (locked[1]) {
				locked[1] = false;
				ba[1].setBackgroundResource(R.drawable.button_enabled);
			}else{
				locked[1] = true;
				ba[1].setBackgroundResource(R.drawable.button_locked);
			}
			break;			
		case R.id.blmNum3:
			if (locked[2]) {
				locked[2] = false;
				ba[2].setBackgroundResource(R.drawable.button_enabled);
			}else{
				locked[2] = true;
				ba[2].setBackgroundResource(R.drawable.button_locked);
			}
			break;			
		case R.id.blmNum4:
			if (locked[3]) {
				locked[3] = false;
				ba[3].setBackgroundResource(R.drawable.button_enabled);
			}else{
				locked[3] = true;
				ba[3].setBackgroundResource(R.drawable.button_locked);
			}
			break;			
		case R.id.blmNum5:
			if (locked[4]) {
				locked[4] = false;
				ba[4].setBackgroundResource(R.drawable.button_enabled);
			}else{
				locked[4] = true;
				ba[4].setBackgroundResource(R.drawable.button_locked);
			}
			break;			
		case R.id.blmNum6:
			if (locked[5]) {
				locked[5] = false;
				ba[5].setBackgroundResource(R.drawable.button_enabled);
			}else{
				locked[5] = true;
				ba[5].setBackgroundResource(R.drawable.button_locked);
			}
			break;
		case R.id.blmNum7:
			if (locked[6]) {
				locked[6] = false;
				ba[6].setBackgroundResource(R.drawable.button_enabled);
			}else{
				locked[6] = true;
				ba[6].setBackgroundResource(R.drawable.button_locked);
			}
			break;
			
		case R.id.blmGenerate:
			if (first) {
				for (int i = 0; i < ba.length; i++) {
					ba[i].setEnabled(true);
					ba[i].setBackgroundResource(R.drawable.button_enabled);
				}
				first = false;
			}
			
			generateNumbers();
			for (int i = 0; i < ba.length; i++) 
				ba[i].setText(Integer.toString(results[i]));
			break;
		}
	}

	private void generateNumbers() {
		// TODO Auto-generated method stub
		Random rng = new Random();
		ArrayList<Integer> generated = new ArrayList<Integer>();
		ArrayList<Integer> lockedNums = new ArrayList<Integer>();
		
		for (int i = 0; i < locked.length; i++) {
			if (locked[i])
				lockedNums.add(results[i]);
		}
		
		for (int i = 0; i < results.length; i++) {
			if (locked[i]) {
				generated.add(results[i]);
			}else{
				while(true){
					int next = rng.nextInt(49) + 1;
					if (!generated.contains(next) && !lockedNums.contains(next)) {
						generated.add(next);
						break;
					}
				}
			}
		}
		
		Object ia[] = generated.toArray();
		
		for (int i = 0; i < results.length; i++) {
			results[i] = ((Integer) ia[i]).intValue();
		}
	}
	
}
