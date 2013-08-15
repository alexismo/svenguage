package fragments;

import com.alexismorin.linguage.se.sv.R;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class LinguagePrefsFragment extends PreferenceFragment {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//Load preferences from XML resource
		addPreferencesFromResource(R.xml.preferences);
	}
}
