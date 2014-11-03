package ctec.lighthouse;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends Activity
{
	private ToggleButton toggle;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		toggle = (ToggleButton) findViewById(R.id.toggleButton1);
		
		setupListeners();
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
				
			}
		});
		
	}
}
