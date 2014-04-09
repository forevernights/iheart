package sg.smu.iheart.eform;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import sg.smu.iheart.navigation.NavigationActivity;
import sg.smu.iheart.supply.SupplyInfoActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class EFormSurveyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eform_survey);
		
		for(EFormQuestion q:StaticData.eformQuestions){
			q.isAnswered = false;
		}
		
		final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater()
				.inflate(R.layout.action_bar, null);
		final ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionBarLayout);
		((TextView)findViewById(R.id.action_bar_title)).setText("E-Form");
		
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
				new AlertDialog.Builder(EFormSurveyActivity.this)
				.setTitle("System Information")
			    .setMessage("All the questions are to be answered truthfully. Every donor is required to fill up the form prior to the donation process. Please keep in mind that information is time-sensitive.")
			    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) { 
			            // continue with delete
			        }
			     }).show();
			}
		});
		

		
		final TextView pageTV = (TextView)findViewById(R.id.eform_survey_page);

		final ListView questionListView = (ListView)findViewById(R.id.eform_survey_list_questions);
		EFormArrayAdapter adapter = new EFormArrayAdapter(this, 0, StaticData.eformQuestions);
		questionListView.setAdapter(adapter);
		questionListView.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
			
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				final int pos = questionListView.getLastVisiblePosition();
				Log.i("EFormSurveyActivity", "position: "+pos);
				if(pos>5){
					pageTV.setText("Page 2/2");
				}else {
					pageTV.setText("Page 1/2");
				}
				if(pos==StaticData.eformQuestions.size()-1){
					actionButton.setText("Submit");
					actionButton.setTextSize(12);
					actionButton.setBackgroundResource(R.drawable.navigation_button);
					RelativeLayout.LayoutParams submitParams = (LayoutParams) actionButton.getLayoutParams();
					submitParams.width=100;
					submitParams.height=60;
					actionButton.setLayoutParams(submitParams);
					actionButton.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							boolean isAllAnswered = true;
							for(EFormQuestion q:StaticData.eformQuestions){
								if(q.isAnswered==false){
									Toast.makeText(getApplicationContext(), "Please fill in all the required fields before submitting!", Toast.LENGTH_LONG).show();
									isAllAnswered = false;
									break;
								}
							}
							if(isAllAnswered==true){
								Toast.makeText(getApplicationContext(), "The e-form has been successfully submitted!", Toast.LENGTH_LONG).show();
								Intent intent = new Intent(getApplicationContext(),NavigationActivity.class);
								intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(intent);
							}
						}
					});
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eform_survey, menu);
		return true;
	}

}
