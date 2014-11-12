package ctec.lighthouse;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.content.Context;

public class MainActivity extends Activity
{
	private ToggleButton toggle;
	private Context context;
	private TextView textView;
	private boolean hasLight;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		toggle = (ToggleButton) findViewById(R.id.toggleButton1);
		textView = (TextView) findViewById(R.id.textView1);
		
		setupListeners();
		checkFlashlight();
	}

	private void checkFlashlight()
	{
		Boolean haslight = context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
		if (!haslight)
		{
			textView.setText("Sorry, your device does not have a flashlight.");
			//Should the app automatically close itslef here?
		}
	}

	private void setupListeners()
	{
		toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				Camera cam = Camera.open();
				Parameters p = cam.getParameters();
				p.setFlashMode(Parameters.FLASH_MODE_TORCH);
				cam.setParameters(p);
				cam.startPreview();
				//if(isChecked)
				//{
					//Turn Flashlight off
					//Toast Flashlight off
				//}
				//else if (!isChecked)
				//{
					//Turn Flashlight on
					//Toast Flashlight on
				//}
			}
		});
		
	}
}
