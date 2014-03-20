package sg.smu.iheart.faq;

import java.util.List;

import sg.smu.iheart.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FAQArrayAdapter extends ArrayAdapter<FAQQuestion> {
	Context context;
	List<FAQQuestion> questions;
	public FAQArrayAdapter(Context context, int resource, List<FAQQuestion> questions) {
		super(context, R.layout.list_eform, questions);
		this.context = context;
		this.questions = questions;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.list_faq, parent, false);
			TextView questionTV = (TextView) rowView.findViewById(R.id.list_faq_title);
			questionTV.setText(questions.get(position).title);
			
			return rowView;
	}
}
