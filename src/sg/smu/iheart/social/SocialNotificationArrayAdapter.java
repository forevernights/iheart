package sg.smu.iheart.social;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
			
			final View rowView = inflater.inflate(R.layout.list_social_notification, parent, false);
			TextView titleTV = (TextView)rowView.findViewById(R.id.list_social_title);
			
			if(no.type==0){
				titleTV.setText(messages.get(position).name+" has invited you to go for donation");
			}
			else if(no.type==1){
				rowView.setBackgroundColor(Color.parseColor("#d7d7d7"));
				titleTV.setText(no.name+" wants to be your friend!");
			}
						
			((ImageView)rowView.findViewById(R.id.list_social_profile_image)).setImageDrawable(context.getResources().getDrawable(messages.get(position).drawableResource));
			ImageView iconIV = (ImageView)rowView.findViewById(R.id.list_social_icon_image);
			if(no.type==0){
				iconIV.setImageResource(R.drawable.envelope);
			}else{
				iconIV.setImageResource(R.drawable.person_cross);
			}
			
			rowView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(no.type==0){
						
						AlertDialog.Builder builder = new AlertDialog.Builder(context);
						LayoutInflater inflater = ((Activity) context).getLayoutInflater();
						View view = inflater.inflate(R.layout.notification_donation_event_dialog, null);

						TextView fromTV = (TextView)view.findViewById(R.id.list_social_notification_textview_from);
						TextView locationTV = (TextView)view.findViewById(R.id.list_social_notification_textview_location);
						TextView dateTV = (TextView)view.findViewById(R.id.list_social_notification_textview_date);
						TextView timeTV = (TextView)view.findViewById(R.id.list_social_notification_textview_time);
						TextView messageTV = (TextView)view.findViewById(R.id.list_social_notification_textview_message);
						
						fromTV.setText(no.name);
						locationTV.setText(no.location);
						dateTV.setText(no.date);
						timeTV.setText(no.time);
						messageTV.setText(no.message);
						
						 
						builder.setView(view)
						 .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								StaticData.friends.add(new SocialFriend(no.email, no.name, no.mobile, no.gender, no.drawableResource,true));
								StaticData.notifications.remove(position);
								notifyDataSetChanged();
								
				
								Calendar beginTime = Calendar.getInstance();
								try {
									Date eventDate = new SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.ENGLISH).parse(no.date+" "+no.time);
									Intent intent = new Intent(Intent.ACTION_EDIT);
									intent.setType("vnd.android.cursor.item/event");
									intent.putExtra(Events.TITLE, StaticData.notifications.get(position).name+" has invited you to go for donation");
									intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
											eventDate.getTime());
									intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
											eventDate.getTime()+3600000);
									intent.putExtra(Events.ALL_DAY, false);// periodicity
									context.startActivity(intent);
								} catch (ParseException e) {
									Log.e("SocialNotification", e.getMessage());
								}

								
							}
						}).setNegativeButton("Reject", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								StaticData.notifications.remove(position);
								notifyDataSetChanged();
							}
						});
						builder.show();
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
								StaticData.friends.add(new SocialFriend(no.email, no.name, no.mobile, no.gender, no.drawableResource,true));
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
		
			

			return rowView;
	}

}
