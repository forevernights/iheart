package sg.smu.iheart.myrecord;

import java.util.List;

import sg.smu.iheart.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyRecordArrayAdapter extends ArrayAdapter<MyRecord> {
	Context context;
	List<MyRecord> records;
	public MyRecordArrayAdapter(Context context, int resource, List<MyRecord> records) {
		super(context, R.layout.list_my_record, records);
		this.context = context;
		this.records = records;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.list_my_record, parent, false);
			TextView location = (TextView)rowView.findViewById(R.id.list_my_record_location);
			TextView date = (TextView)rowView.findViewById(R.id.list_my_record_date);
			TextView time = (TextView)rowView.findViewById(R.id.list_my_record_time);
			
			MyRecord record = records.get(position);
			location.setText(record.location);
			date.setText(record.date);
			time.setText(record.time);
			return rowView;
	}
}
