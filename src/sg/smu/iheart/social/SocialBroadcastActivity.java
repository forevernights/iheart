package sg.smu.iheart.social;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import sg.smu.iheart.navigation.NavigationActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

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
				new AlertDialog.Builder(SocialBroadcastActivity.this)
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
		
		/** broadcast to friends **/
		final EditText toField = (EditText)findViewById(R.id.social_broadcast_textview_to);
		final AlertDialog.Builder builder = new AlertDialog.Builder(SocialBroadcastActivity.this);
		LayoutInflater inflater = ((Activity) this).getLayoutInflater();
		View view = inflater.inflate(R.layout.broadcast_friends_dialog, null);
		builder.setView(view)
		 .setPositiveButton("Done", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String emails = "";
				for(SocialFriend f:StaticData.broadcastFriends){
					emails+=f.email+" ";
				}
				toField.setText(emails);
			}
		}).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				toField.setText("");
			}
		}).setTitle("Add friends to broadcast list");
		final Dialog broadcastFriendDialog = builder.show();
		broadcastFriendDialog.setCancelable(false);
		
		ListView broadcastFriendListView = (ListView)view.findViewById(R.id.broadcast_friend_dialog_listview);
		SocialBroadcastFriendsArrayAdapter adapter = new SocialBroadcastFriendsArrayAdapter(this, 0, StaticData.friends);
		broadcastFriendListView.setAdapter(adapter);
	
		
		toField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					StaticData.broadcastFriends.clear();
					broadcastFriendDialog.show();
				}else{
					broadcastFriendDialog.hide();
				}
			}
		});
		
		/** end **/
		
		
		final EditText locationField = (EditText)findViewById(R.id.social_broadcast_textview_location);
		final EditText dateField = (EditText)findViewById(R.id.social_broadcast_textview_date);
		final EditText startTimeField = (EditText)findViewById(R.id.social_broadcast_textview_start_time);
		final EditText endTimeField = (EditText)findViewById(R.id.social_broadcast_textview_end_time);

		final EditText messageField = (EditText)findViewById(R.id.social_broadcast_textview_message);

		final Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		final DatePickerDialog datePickerDialog = new DatePickerDialog(SocialBroadcastActivity.this, new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int selectedYear, int selectedMonth,
					int selectedDay) {
				String year = String.valueOf(selectedYear);
				selectedMonth+=1;
				String month = (selectedMonth<10?("0"+selectedMonth):(selectedMonth))+"";
	            String day = (selectedDay<10?("0"+selectedDay):(selectedDay))+"";
	            dateField.setText(day + "/" + month + "/" + year);
			}
		}, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		
		final TimePickerDialog startTimePickerDialog = new TimePickerDialog(SocialBroadcastActivity.this, new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
				String hour = (selectedHour<10?("0"+selectedHour):(selectedHour))+"";
				String minute = (selectedMinute<10?("0"+selectedMinute):(selectedMinute))+"";
				startTimeField.setText(hour+":"+minute);
			}
		}, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true);
		
		final TimePickerDialog endTimePickerDialog = new TimePickerDialog(SocialBroadcastActivity.this, new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
				String hour = (selectedHour<10?("0"+selectedHour):(selectedHour))+"";
				String minute = (selectedMinute<10?("0"+selectedMinute):(selectedMinute))+"";
				endTimeField.setText(hour+":"+minute);
			}
		}, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true);
		
		dateField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					datePickerDialog.show();
				}else{
					datePickerDialog.hide();
				}
			}
		});
		
		startTimeField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					startTimePickerDialog.show();
				}else{
					startTimePickerDialog.hide();
				}
			}
		});
		endTimeField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					endTimePickerDialog.show();
				}else{
					endTimePickerDialog.hide();
				}
			}
		});
		
		
		((Button)findViewById(R.id.social_broadcast_button_broadcast)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*SocialNotification no = new SocialNotification(StaticData.username+" has invited you to go for donation"
						, locationField.getText().toString(), dateField.getText().toString(), timeField.getText().toString()
						, messageField.getText().toString(), StaticData.profileDrawableResource,0);
				//StaticData.notifications.add(0,no);*/
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
