package john.daniel.ficklampa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	SeekBar bar;
	TextView textField;
	Button launchFlash;
	float setBrightness;
	float value;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        //Set up button to launch new activity to drive the Flash
        launchFlash = (Button) findViewById(R.id.launchFlashButton);
        launchFlash.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, CameraFlash.class); 
				startActivity(intent);
			}
		});
        
        //Setting up seekbar
        bar = (SeekBar) findViewById(R.id.screenValue);
        bar.setProgress(0);
        bar.setMax(100);
        bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
        	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        		//screenBrightness has float value between 0 and 1. Progress/100 will make a 0.x value to screenBrightness
        		setBrightness = (float)progress / 100;
        		value = setBrightness * 100;
        		WindowManager.LayoutParams layout = getWindow().getAttributes();
        		layout.screenBrightness = setBrightness;
        		getWindow().setAttributes(layout);
        		
        		textField = (TextView) findViewById(R.id.textField);
				textField.setText("Ljusstyrka: " + (int)value + "%");
        	}
        

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			};
    });
        
}
}