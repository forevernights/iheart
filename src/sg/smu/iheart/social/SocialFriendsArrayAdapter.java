package sg.smu.iheart.social;

import java.util.List;

import sg.smu.iheart.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SocialFriendsArrayAdapter extends ArrayAdapter<SocialFriend>{
	final Context context;
	List<SocialFriend> friends;
	public SocialFriendsArrayAdapter(Context context, int resource, List<SocialFriend> friends) {
		super(context, R.layout.list_social_friends, friends);
		this.context = context;
		this.friends = friends;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.list_social_friends, parent, false);			
			TextView nameTV = (TextView)rowView.findViewById(R.id.list_social_friends_name);
			TextView emailTV = (TextView)rowView.findViewById(R.id.list_social_friends_email);
			TextView mobileTV = (TextView)rowView.findViewById(R.id.list_social_friends_mobile_no);
			TextView genderTV = (TextView)rowView.findViewById(R.id.list_social_friends_gender);
			ImageView profileIV = (ImageView)rowView.findViewById(R.id.list_social_friends_profile_image);
			Button unfriendBtn = (Button)rowView.findViewById(R.id.list_social_friends_unfriend_button);
			SocialFriend friend = friends.get(position);
			
			nameTV.setText(friend.name);
			emailTV.setText(friend.email);
			mobileTV.setText(friend.mobile);
			genderTV.setText(friend.gender);
			profileIV.setImageDrawable(context.getResources().getDrawable(friend.drawableResource));
			unfriendBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					friends.remove(position);
					notifyDataSetChanged();
				}
			});
			
			return rowView;
	}

}
