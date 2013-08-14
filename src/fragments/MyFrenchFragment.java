package fragments;

import com.alexismorin.linguage.se.sv.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MyFrenchFragment extends DemoFragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_my_french, container, false);
		
		commentBtn = (Button) view.findViewById(R.id.commentBtn);
		commentBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendFeedback();
			}
		});
		
		return view;
	}
}
