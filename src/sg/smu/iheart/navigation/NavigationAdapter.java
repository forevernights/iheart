package sg.smu.iheart.navigation;

import java.util.ArrayList;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import sg.smu.iheart.account.AccountActivity;
import sg.smu.iheart.eform.EFormActivity;
import sg.smu.iheart.faq.FAQActivity;
import sg.smu.iheart.location.LocationActivity;
import sg.smu.iheart.login.LoginActivity;
import sg.smu.iheart.myrecord.MyRecordActivity;
import sg.smu.iheart.schedule.ScheduleActivity;
import sg.smu.iheart.social.SocialNotificationActivity;
import sg.smu.iheart.supply.SupplyActivity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class NavigationAdapter extends BaseAdapter {
	private Context mContext;
	
	public NavigationAdapter(Context context){
		this.mContext = context;
	}

	@Override
	public int getCount() {
		return navigationButtons.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		Button navButton;
		if (convertView == null) {  // if it's not recycled, initialize some attributes
           navButton = new Button(mContext);
           GridView.LayoutParams params = new GridView.LayoutParams(200, 70);
           navButton.setLayoutParams(params);
           navButton.setBackgroundResource(R.drawable.navigation_button);
        } else {
            navButton = (Button) convertView;
        }
		navButton.setText(navigationButtons.get(position).title);
		if(position==6){
			navButton.setText("Social ("+StaticData.notifications.size()+")");
		}
		navButton.setTextSize(14);
		if(navigationButtons.get(position).iconResId!=0)
			navButton.setCompoundDrawablesWithIntrinsicBounds(navigationButtons.get(position).iconResId, 0, 0, 0);
        if(navigationButtons.get(position).targetActivityClass!=null){
            navButton.setOnClickListener(new View.OnClickListener() {
    			@Override
    			public void onClick(View v) {
    				Intent intent = new Intent(mContext,navigationButtons.get(position).targetActivityClass);
    				mContext.startActivity(intent);
    			}
    		});
        }
		return navButton;
	}

	// references to all buttons
	private static ArrayList<NavigationButton> navigationButtons;
	static {
		navigationButtons = new ArrayList<NavigationButton>();
		navigationButtons.add(new NavigationButton("Account",R.drawable.navigation_account,AccountActivity.class));
		navigationButtons.add(new NavigationButton("Calendar", R.drawable.navigation_calendar,ScheduleActivity.class));
		navigationButtons.add(new NavigationButton("My Records", 0,MyRecordActivity.class));
		navigationButtons.add(new NavigationButton("E-Form", R.drawable.navigation_eform,EFormActivity.class));
		navigationButtons.add(new NavigationButton("Location", R.drawable.navigation_location,LocationActivity.class));
		navigationButtons.add(new NavigationButton("Supply", R.drawable.navigation_supply,SupplyActivity.class));
		navigationButtons.add(new NavigationButton("Social", R.drawable.navigation_social,SocialNotificationActivity.class));
		navigationButtons.add(new NavigationButton("F.A.Q", R.drawable.navigation_information,FAQActivity.class));
		navigationButtons.add(new NavigationButton("Log out", 0,LoginActivity.class));

	}

}
