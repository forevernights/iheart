package sg.smu.iheart.eform;

import java.util.List;

import sg.smu.iheart.R;
import sg.smu.iheart.navigation.NavigationActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class EFormArrayAdapter extends ArrayAdapter<EFormQuestion>{
	Context context;
	List<EFormQuestion> questions;
	public EFormArrayAdapter(Context context, int resource, List<EFormQuestion> questions) {
		super(context, R.layout.list_eform, questions);
		this.context = context;
		this.questions = questions;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.list_eform, parent, false);
			TextView questionTV = (TextView) rowView.findViewById(R.id.list_eform_question);
			questionTV.setText(questions.get(position).question);
			
			RadioButton yesBtn = (RadioButton)rowView.findViewById(R.id.list_eform_yes);
			RadioButton noBtn = (RadioButton)rowView.findViewById(R.id.list_eform_no);
			RadioGroup radio = (RadioGroup)rowView.findViewById(R.id.list_eform_radio);
			
			
			final EFormQuestion question = questions.get(position);
			radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					
				}
			});

			return rowView;
	}

}
