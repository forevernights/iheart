package sg.smu.iheart.eform;

import java.util.List;

import sg.smu.iheart.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

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
			final EFormQuestion question = questions.get(position);

			View rowView = inflater.inflate(R.layout.list_eform, parent, false);
			TextView questionTV = (TextView) rowView.findViewById(R.id.list_eform_question);
			questionTV.setText(questions.get(position).question);
			
			RadioButton yesBtn = (RadioButton)rowView.findViewById(R.id.list_eform_yes);
			RadioButton noBtn = (RadioButton)rowView.findViewById(R.id.list_eform_no);
			
			if(question.choice==1){
				yesBtn.setChecked(true);
			}else if(question.choice==2){
				noBtn.setChecked(true);
			}
			
			RadioGroup radio = (RadioGroup)rowView.findViewById(R.id.list_eform_radio);
			radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					question.isAnswered = true;
				}
			});
			yesBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					question.isAnswered = true;
					question.choice = 1;
				}
			});
			noBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					question.isAnswered = true;
					question.choice = 2;
				}
			});
			
			

			return rowView;
	}

}
