package sg.smu.iheart.navigation;

import sg.smu.iheart.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.GridView;

public class NavigationActivity extends Activity {
	private GridView navigationContainerGV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_navigation);
        navigationContainerGV = (GridView)findViewById(R.id.activity_navigation_grid_view_navigation_container);
        navigationContainerGV.setAdapter(new NavigationAdapter(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }
}
