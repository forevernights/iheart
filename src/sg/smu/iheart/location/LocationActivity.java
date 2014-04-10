package sg.smu.iheart.location;

import sg.smu.iheart.R;
import sg.smu.iheart.navigation.NavigationActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);
		final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater()
				.inflate(R.layout.action_bar, null);
		final ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionBarLayout);
		((TextView) findViewById(R.id.action_bar_title)).setText("Location");
		((ImageButton) findViewById(R.id.action_bar_home_button)).setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(getApplicationContext(),
								NavigationActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent);
					}
				});
		final ImageView mapView = (ImageView)findViewById(R.id.mapView);
		mapView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mapView.setImageResource(R.drawable.map);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location, menu);
		return true;
	}

}
