package sg.smu.iheart.social;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import sg.smu.iheart.eform.EFormSurveyActivity;
import sg.smu.iheart.navigation.NavigationActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class SocialNotificationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_social_notification);
		
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
		
		final Button actionButton = (Button)findViewById(R.id.action_bar_action_button);
		actionButton.setVisibility(View.VISIBLE);
		actionButton.setBackgroundResource(R.drawable.supply_info);
		RelativeLayout.LayoutParams params = (LayoutParams) actionButton.getLayoutParams();
		params.width=50;
		params.height=50;
		actionButton.setLayoutParams(params);
		

		actionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new AlertDialog.Builder(SocialNotificationActivity.this)
				.setTitle("System Information")
			    .setMessage("The 'Notification' tab displays your notifications for event invitation and friend request. " +
			    		"You can accept/reject the invitation or friend request by tapping on the notification. " +
			    		"The 'Friends' tab displays your friend list. You can also delete your friend.")
			    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) { 
			            // continue with delete
			        }
			     }).show();
			}
		});

		((Button)findViewById(R.id.social_notification_friends_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),SocialFriendsActivity.class);
				startActivity(intent);
			}
		});
		((Button)findViewById(R.id.social_notification_broadcast_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),SocialBroadcastActivity.class);
				startActivity(intent);
			}
		});
		
		
		ListView listview = (ListView)findViewById(R.id.social_listview_message);
		SocialNotificationArrayAdapter adapter = new SocialNotificationArrayAdapter(this, 0, StaticData.notifications);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.social, menu);
		return true;
	}

}
