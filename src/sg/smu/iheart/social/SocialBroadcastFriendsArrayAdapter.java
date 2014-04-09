package sg.smu.iheart.social;

import java.util.List;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SocialBroadcastFriendsArrayAdapter extends ArrayAdapter<SocialFriend>{
	final Context context;
	List<SocialFriend> friends;
	public SocialBroadcastFriendsArrayAdapter(Context context, int resource, List<SocialFriend> friends) {
		super(context, R.layout.list_social_friends, friends);
		this.context = context;
		this.friends = friends;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final SocialFriend friend = friends.get(position);

			View rowView = inflater.inflate(R.layout.list_broadcast_friends, parent, false);			
			TextView nameTV = (TextView)rowView.findViewById(R.id.list_broadcast_friends_profile_name);
			TextView emailTV = (TextView)rowView.findViewById(R.id.list_broadcast_friends_profile_email);
			TextView mobileTV = (TextView)rowView.findViewById(R.id.list_broadcast_friends_mobile_no);
			TextView genderTV = (TextView)rowView.findViewById(R.id.list_broadcast_friends_gender);
			ImageView profileIV = (ImageView)rowView.findViewById(R.id.list_broadcast_friends_profile_image);
			final CheckBox checkbox = (CheckBox)rowView.findViewById(R.id.list_broadcast_friends_checkbox);
			checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(checkbox.isChecked()){
						StaticData.broadcastFriends.add(friend);
					}else{
						StaticData.broadcastFriends.remove(friend);
					}
				}
			});
			
			nameTV.setText(friend.name);
			emailTV.setText(friend.email);
			mobileTV.setText(friend.mobile);
			genderTV.setText(friend.gender);
			profileIV.setImageDrawable(context.getResources().getDrawable(friend.drawableResource));			
			return rowView;
	}

}
