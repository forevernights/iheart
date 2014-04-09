package sg.smu.iheart.eform;

import java.util.Arrays;

import sg.smu.iheart.R;
import sg.smu.iheart.navigation.NavigationActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class EFormActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eform);

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
		
		final Button fillButton = (Button)findViewById(R.id.eform_button_fill_eform);
		((Button)findViewById(R.id.eform_button_fill_eform)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),EFormSurveyActivity.class);
				startActivity(intent);
			}
		});
		
		final String[] validCountries = {"Malaysia","Indonesia","Vietnam"};
		final String[] invalidCountries = {"India","South Africa"};
		final String[] countries = {"Malaysia","Indonesia","Vietnam","India","South Africa"};
		final TextView messageTV = (TextView)findViewById(R.id.eform_message);
		
		
		final AutoCompleteTextView searchBox = (AutoCompleteTextView)findViewById(R.id.eform_search_box);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, countries);
		searchBox.setAdapter(adapter);
		searchBox.setThreshold(1);
		searchBox.addTextChangedListener(new TextWatcher(){
	        public void afterTextChanged(Editable s) {
	            if(Arrays.asList(validCountries).contains(searchBox.getText().toString())){
	            	messageTV.setVisibility(View.VISIBLE);
	            	messageTV.setText("The area is safe! Please proceed to fill in the e-form.");
	            }
	            if(Arrays.asList(invalidCountries).contains(searchBox.getText().toString())){
	            	messageTV.setVisibility(View.VISIBLE);
	            	messageTV.setText("You can't donate! This is an effected area.");
	            	fillButton.setEnabled(false);
	            }
	        }
	        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
	        public void onTextChanged(CharSequence s, int start, int before, int count){}
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eform, menu);
		return true;
	}

}
