package fragments;

import com.alexismorin.linguage.se.sv.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MySwedishFragment extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_swedish, container, false);
		
		return view;
	}
}
