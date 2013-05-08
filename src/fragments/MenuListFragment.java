package fragments;

import com.alexismorin.linguage.se.sv.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuListFragment extends ListFragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.list, null);
	}
	
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		
		adapter.add(new SampleItem("Challenges", R.drawable.menu_apostrophe));
		adapter.add(new SampleItem("My Swedish", R.drawable.menu_myswedish));
		adapter.add(new SampleItem("Topics", R.drawable.menu_topics));
		
		adapter.add(new SampleItem("Dictionary", R.drawable.menu_dictionary));
		adapter.add(new SampleItem("Watch & Read", R.drawable.menu_watchread));
		adapter.add(new SampleItem("Settings", R.drawable.menu_settings));
		
		setListAdapter(adapter);
	}
	
	private class SampleItem {
		public String tag;
		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}
	
	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}
}
