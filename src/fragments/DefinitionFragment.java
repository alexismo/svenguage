package fragments;

import com.alexismorin.linguage.se.sv.R;
import com.alexismorin.linguage.util.VocabWord;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;

public class DefinitionFragment extends DialogFragment {
	
	OnSoundButtonClicked mListener;	
	VocabWord word;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        
        View v = inflater.inflate(R.layout.fragment_definition, container);
        
        TextView sourceWord = (TextView) v.findViewById(R.id.source_language_title);
        TextView translationWord = (TextView) v.findViewById(R.id.translation_language_title);
        
		if(word != null){
	        sourceWord.setText(word.getWord());
	        translationWord.setText(word.getTranslation());
		}
        
		v.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						switch (v.getId()) {
						case R.id.speak_skanska:
							mListener.onSoundButtonClicked("skanska");
							break;
						case R.id.speak_stockholmska:
							mListener.onSoundButtonClicked("stockholmska");
							break;
						case R.id.speak_norrlandska:
							mListener.onSoundButtonClicked("norrlandska");
							break;
		
						default:
							break;
						}
					}
				});
		
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		return v;
	}
	
	/*
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        
        View v = inflater.inflate(R.layout.fragment_definition, getDialog().);
        
        TextView sourceWord = (TextView) v.findViewById(R.id.source_language_title);
        TextView translationWord = (TextView) v.findViewById(R.id.translation_language_title);
        
		if(word != null){
	        sourceWord.setText(word.getWord());
	        translationWord.setText(word.getTranslation());
		}
        
		v.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						switch (v.getId()) {
						case R.id.speak_skanska:
							mListener.onSoundButtonClicked("skanska");
							break;
						case R.id.speak_stockholmska:
							mListener.onSoundButtonClicked("stockholmska");
							break;
						case R.id.speak_norrlandska:
							mListener.onSoundButtonClicked("norrlandska");
							break;
		
						default:
							break;
						}
					}
				});
        
        builder.setView(v);
        
        // Create the AlertDialog object and return it
        return builder.create();
    }*/
	
	public void setWord(VocabWord newWord){
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
