package sg.smu.iheart.faq;

import java.util.ArrayList;
import java.util.List;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import sg.smu.iheart.navigation.NavigationActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class FAQActivity extends Activity {
	
	ListView faqLV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faq);
		
		final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater()
				.inflate(R.layout.action_bar, null);
		final ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionBarLayout);
		((TextView)findViewById(R.id.action_bar_title)).setText("FAQ");
		((ImageButton)findViewById(R.id.action_bar_home_button)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),NavigationActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		
		faqLV = (ListView)findViewById(R.id.faq_list_question);
		FAQArrayAdapter adapter = new FAQArrayAdapter(this, 0, StaticData.faqQuestions);
		faqLV.setAdapter(adapter);
		
		faqLV.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				TextView faqContentTV = (TextView)view.findViewById(R.id.list_faq_content);
				if(faqContentTV.getVisibility()==View.VISIBLE){
					faqContentTV.setVisibility(View.GONE);
				}else{
					faqContentTV.setVisibility(View.VISIBLE);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.faq, menu);
		return true;
	}

}
