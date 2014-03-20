package sg.smu.iheart.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import sg.smu.iheart.R;
import sg.smu.iheart.R.layout;
import sg.smu.iheart.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.widget.Toast;

public class ScheduleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_schedule);
		Calendar cal = new GregorianCalendar(); 
		cal.setTime(new Date()); 
		long time = cal.getTime().getTime(); 
		Uri.Builder builder = 
		      CalendarContract.CONTENT_URI.buildUpon(); 
		builder.appendPath("time"); 
		builder.appendPath(Long.toString(time)); 
		Intent intent = new Intent(Intent.ACTION_VIEW, builder.build()); 
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent); 
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.schedule, menu);
		return true;
	}

}
