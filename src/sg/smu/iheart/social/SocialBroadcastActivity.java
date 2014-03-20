package sg.smu.iheart.social;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import sg.smu.iheart.R.id;
import sg.smu.iheart.R.layout;
import sg.smu.iheart.R.menu;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SocialBroadcastActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social_broadcast);
		
		final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater()
				.inflate(R.layout.action_bar, null);
		final ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionBarLayout);
		((TextView)findViewById(R.id.action_bar_title)).setText("Social");
		((ImageButton)findViewById(R.id.action_bar_home_button)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),NavigationActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		((Button)findViewById(R.id.social_broadcast_notification_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),SocialNotificationActivity.class);
				startActivity(intent);
			}
		});
		((Button)findViewById(R.id.social_broadcast_friends_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),SocialFriendsActivity.class);
				startActivity(intent);
			}
		});
		
		final EditText toField = (EditText)findViewById(R.id.social_broadcast_textview_to);
		final EditText locationField = (EditText)findViewById(R.id.social_broadcast_textview_location);
		final EditText dateField = (EditText)findViewById(R.id.social_broadcast_textview_date);
		final EditText timeField = (EditText)findViewById(R.id.social_broadcast_textview_time);
		final EditText messageField = (EditText)findViewById(R.id.social_broadcast_textview_message);

		
		((Button)findViewById(R.id.social_broadcast_button_broadcast)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SocialNotification no = new SocialNotification(StaticData.username+" has invited you to go for donation"
						, locationField.getText().toString(), dateField.getText().toString(), timeField.getText().toString()
						, messageField.getText().toString(), StaticData.profileDrawableResource,0);
				StaticData.notifications.add(0,no);
				Toast.makeText(getApplicationContext(), "Your blood donation event has been succesfully broadcasted", Toast.LENGTH_LONG).show();
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.social_broadcast, menu);
		return true;
	}

}
