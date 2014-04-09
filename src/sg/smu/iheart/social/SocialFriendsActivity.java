package sg.smu.iheart.social;

import java.util.ArrayList;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import sg.smu.iheart.navigation.NavigationActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class SocialFriendsActivity extends Activity {
	ArrayList<SocialFriend> tempFriends;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social_friends);
		
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
				new AlertDialog.Builder(SocialFriendsActivity.this)
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
		
		
		((Button)findViewById(R.id.social_friends_notification_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),SocialNotificationActivity.class);
				startActivity(intent);
			}
		});
		((Button)findViewById(R.id.social_friends_friends_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),SocialFriendsActivity.class);
				startActivity(intent);
			}
		});
		((Button)findViewById(R.id.social_friends_broadcast_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),SocialBroadcastActivity.class);
				startActivity(intent);
			}
		});
		
		
		ListView listview = (ListView)findViewById(R.id.social_friends_listview_friendlist);
		tempFriends = new ArrayList<SocialFriend>(StaticData.friends);

		final SocialFriendsArrayAdapter adapter = new SocialFriendsArrayAdapter(this, 0, tempFriends);
		listview.setAdapter(adapter);
		
		final AutoCompleteTextView searchFriendTV = (AutoCompleteTextView)findViewById(R.id.social_friends_searchbox);
		final String[] friendEmails = new String[StaticData.friends.size()];
		for(int i=0;i<StaticData.friends.size();i++){
			friendEmails[i] = StaticData.friends.get(i).email;
		}
		final ArrayAdapter<String> searchFriendAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, friendEmails);
		searchFriendTV.setAdapter(searchFriendAdapter);
		searchFriendTV.setThreshold(1);

		searchFriendTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
			}
		});
		
		searchFriendTV.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				boolean isFoundMatch = false;
				for(SocialFriend f:StaticData.friends){
					if(f.email.equals(searchFriendTV.getText().toString())){
						tempFriends.clear();
						tempFriends.add(f);
						adapter.notifyDataSetChanged();
						Log.i("SocialFriendsActivity", "matched");
						isFoundMatch=true;
						break;
					}
				}
				if(isFoundMatch==false){
					tempFriends.clear();
					for(SocialFriend f:StaticData.friends){
						tempFriends.add(f);
					}
					adapter.notifyDataSetChanged();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.social_friends, menu);
		return true;
	}

}
