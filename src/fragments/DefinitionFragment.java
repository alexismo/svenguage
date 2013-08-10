package fragments;

import model.Word;

import com.alexismorin.linguage.se.sv.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;

public class DefinitionFragment extends DialogFragment {
	
	OnSoundButtonClicked mListener;	
	Word word;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        
        View v = inflater.inflate(R.layout.fragment_definition, container);
        
        TextView sourceWord = (TextView) v.findViewById(R.id.source_lang_title);
        TextView targetWord = (TextView) v.findViewById(R.id.target_lang_title);
        ImageButton soundButton = (ImageButton) v.findViewById(R.id.speak_button);
        
		if(word != null){
	        sourceWord.setText(word.getWord_source());
	        targetWord.setText(word.getWord_target());
		}
		if(word.getSounds().size() == 0){
			soundButton.setVisibility(View.INVISIBLE);
		}
        
		soundButton.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {						
						switch (v.getId()) {
						case R.id.speak_button:
							mListener.onSoundButtonClicked("stockholmska");
							break;
						default:
							break;
						}
					}
				});
		
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		return v;
	}
	
	public void setWord(Word newWord){
		word = newWord;
	}
	
	public interface OnSoundButtonClicked{
		public void onSoundButtonClicked(String accent);
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try {
			mListener = (OnSoundButtonClicked) activity;
		} catch (Exception e) {
			throw new ClassCastException(activity.toString() + " must implement OnSoundButtonClicked");
		}
	}
}
