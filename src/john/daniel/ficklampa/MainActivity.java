package john.daniel.ficklampa;

import android.os.Bundle;
import android.app.Activity;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private SeekBar bar;
	private TextView textField;
	float screenBrightness;
	float value;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (SeekBar) findViewById(R.id.screenValue);
        bar.setProgress(0);
        bar.setMax(100);
        bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
        	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        		screenBrightness = (float)progress / 100;
        		value = screenBrightness * 100;
        		WindowManager.LayoutParams layout = getWindow().getAttributes();
        		layout.screenBrightness = screenBrightness;
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