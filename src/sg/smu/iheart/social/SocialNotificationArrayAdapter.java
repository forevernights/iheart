package sg.smu.iheart.social;

import java.util.Calendar;
import java.util.List;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import sg.smu.iheart.eform.EFormSurveyActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SocialNotificationArrayAdapter extends ArrayAdapter<SocialNotification>{
	final Context context;
	List<SocialNotification> messages;
	public SocialNotificationArrayAdapter(Context context, int resource, List<SocialNotification> messages) {
		super(context, R.layout.list_social_notification, messages);
		this.context = context;
		this.messages = messages;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			final SocialNotification no = messages.get(position);
			
			View rowView = inflater.inflate(R.layout.list_social_notification, parent, false);
			final LinearLayout messageContainer = (LinearLayout)rowView.findViewById(R.id.list_social_container_message);
			TextView titleTV = (TextView)rowView.findViewById(R.id.list_social_title);
			
			if(no.type==0)
				titleTV.setText(messages.get(position).title);
			else if(no.type==1)
				titleTV.setText(no.name+" wants to be your friend!");
			
			
			messageContainer.setVisibility(View.GONE);
			
			((ImageView)rowView.findViewById(R.id.list_social_profile_image)).setImageDrawable(context.getResources().getDrawable(messages.get(position).drawableResource));
			
			rowView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(no.type==0){
						if(messageContainer.getVisibility()==View.VISIBLE){
							messageContainer.setVisibility(View.GONE);	
						}else{
							messageContainer.setVisibility(View.VISIBLE);
						}
					}else if(no.type==1){
						 AlertDialog.Builder builder = new AlertDialog.Builder(context);
						 LayoutInflater inflater = ((Activity) context).getLayoutInflater();
						 
						 View view = inflater.inflate(R.layout.notification_friend_request_dialog, null);
						 ((TextView)view.findViewById(R.id.friend_request_dialog_message)).setText(no.message);
						 ((TextView)view.findViewById(R.id.friend_request_dialog_name)).setText(no.name);
						 ((TextView)view.findViewById(R.id.friend_request_dialog_email)).setText(no.email);
						 ((TextView)view.findViewById(R.id.friend_request_dialog_mobile)).setText(no.mobile);
						 ((TextView)view.findViewById(R.id.friend_request_dialog_gender)).setText(no.gender);
						 
						 builder.setView(view)
						 .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								StaticData.friends.add(new SocialFriend(no.email, no.name, no.mobile, no.gender, no.drawableResource));
								StaticData.notifications.remove(position);
								notifyDataSetChanged();
							}
						}).setNegativeButton("Reject", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								StaticData.notifications.remove(position);
								notifyDataSetChanged();
							}
						});
						 builder.show();
					}
				}
			});
			
			TextView locationTV = (TextView)rowView.findViewById(R.id.list_social_notification_textview_location);
			TextView dateTV = (TextView)rowView.findViewById(R.id.list_social_notification_textview_date);
			TextView timeTV = (TextView)rowView.findViewById(R.id.list_social_notification_textview_time);
			TextView messageTV = (TextView)rowView.findViewById(R.id.list_social_notification_textview_message);
			
			locationTV.setText(no.location);
			dateTV.setText(no.date);
			timeTV.setText(no.time);
			messageTV.setText(no.message);
			
			
			
			Button acceptButton = (Button)rowView.findViewById(R.id.list_social_button_accept);
			acceptButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					StaticData.notifications.remove(position);
					notifyDataSetChanged();
					
					Calendar beginTime = Calendar.getInstance();
					Intent intent = new Intent(Intent.ACTION_EDIT);
					intent.setType("vnd.android.cursor.item/event");
					intent.putExtra(Events.TITLE, "Social Donation");
					intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
							beginTime.getTimeInMillis());
					intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
							Calendar.getInstance().getTimeInMillis()+600000);
					intent.putExtra(Events.ALL_DAY, false);// periodicity
					            intent.putExtra(Events.DESCRIPTION,"Blood Donation with "+StaticData.username);
					context.startActivity(intent);

				}
			});
			
			Button rejectButton = (Button)rowView.findViewById(R.id.list_social_button_reject);
			rejectButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					StaticData.notifications.remove(position);
					notifyDataSetChanged();
				}
			});
			

			return rowView;
	}

}
