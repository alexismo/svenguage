package com.alexismorin.linguage.util.net;

import java.net.MalformedURLException;
import java.util.ArrayList;

import model.LinguageChallengeStub;
import model.TopicChallenge;

import com.alexismorin.linguage.DrawerActivity;
import com.alexismorin.linguage.VocabularyActivity;
import com.alexismorin.linguage.util.InternetStatus;
import com.alexismorin.linguage.util.net.LinguageWebServiceHelper;
import com.google.gson.JsonSyntaxException;

import fragments.FeedFragment;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;


public class TopicChallengeTask extends AsyncTask<String, Void, TopicChallengeResponse> {
	private VocabularyActivity vocabAct;
	private int challengeId;
	private ProgressDialog progressD;
	private LinguageWebServiceHelper lwsH = new LinguageWebServiceHelper("http://alexismorin.com/svenguage/");
	
	public TopicChallengeTask(VocabularyActivity vocabAct, int challengeId, ProgressDialog progressDialog){
		this.vocabAct = vocabAct;
		this.challengeId = challengeId;
		this.progressD = progressDialog;
	}
	
	@Override
    protected void onPreExecute(){
		progressD.setOnCancelListener(new DialogInterface.OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				 cancel(true);
			}
		});
		progressD.show();
		
        if(InternetStatus.getInstance(vocabAct).isOnline(vocabAct)){
        	
        }else{
        	//drawerAct.toastError(R.string.no_connection);
        	Log.e("no internet","no connection");
            progressD.cancel();
        	cancel(true);
        }
    }
	
	@Override
	protected TopicChallengeResponse doInBackground(String... arg0) {
		try {
			Log.i("tcr", "getting topic challenge "+challengeId);
			TopicChallengeResponse tcr = lwsH.getTopicChallenge(challengeId);
			
			if(tcr == null){
				tcr = new TopicChallengeResponse();
				tcr.status = "error";
                tcr.reasonCode = "NoReponse";
			}
			
			return tcr;
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(TopicChallengeResponse tcr){
		if(progressD.isShowing()){
            progressD.dismiss();
        }
		if(tcr!= null){
			TopicChallenge tc = tcr.challenge.get(0);
			if(tc.columns.size() > 0){
				vocabAct.attachAdapter(tc);
			}
		}
	}
}
