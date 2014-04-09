package sg.smu.iheart.account;

import sg.smu.iheart.R;
import sg.smu.iheart.StaticData;
import sg.smu.iheart.navigation.NavigationActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AccountActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activity_account);
		
		final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater()
				.inflate(R.layout.action_bar, null);
		final ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionBarLayout);
		((TextView)findViewById(R.id.action_bar_title)).setText("Account");
		
		
		final EditText nameET = (EditText)findViewById(R.id.account_name);
		final EditText mobileET = (EditText)findViewById(R.id.account_mobile);
		final EditText dobET = (EditText)findViewById(R.id.account_dob);
		final EditText nricET = (EditText)findViewById(R.id.account_nric);
		final EditText emailET = (EditText)findViewById(R.id.account_email);
		nameET.setText(StaticData.username);
		mobileET.setText(StaticData.mobileNo);
		dobET.setText(StaticData.mobileNo);
		nricET.setText(StaticData.nric);
		emailET.setText(StaticData.email);
		((Button)findViewById(R.id.account_button)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StaticData.username = nameET.getText().toString();
				StaticData.mobileNo = mobileET.getText().toString();
				StaticData.dateOfBirth = dobET.getText().toString();
				StaticData.nric = nricET.getText().toString();
				StaticData.email = emailET.getText().toString();
			}
		});

		
		((ImageButton)findViewById(R.id.action_bar_home_button)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),NavigationActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}

}
