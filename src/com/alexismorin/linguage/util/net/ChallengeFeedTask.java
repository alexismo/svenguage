package com.alexismorin.linguage.util.net;

import java.net.MalformedURLException;
import java.util.ArrayList;

import model.LinguageChallengeStub;

import com.alexismorin.linguage.DrawerActivity;
import com.alexismorin.linguage.util.InternetStatus;
import com.alexismorin.linguage.util.net.LinguageWebServiceHelper;
import com.google.gson.JsonSyntaxException;

import fragments.FeedFragment;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;


public class ChallengeFeedTask extends AsyncTask<String, Void, FeedResponse> {
	private FeedFragment feedFragment;
	private ProgressDialog progressD;
	private LinguageWebServiceHelper lwsH = new LinguageWebServiceHelper("http://alexismorin.com/svenguage/");
	
	public ChallengeFeedTask(FeedFragment feedFragment, ProgressDialog progressDialog){
		this.feedFragment = feedFragment;
		this.progressD = progressDialog;
	}
	
	@Override
    protected void onPreExecute(){
		progressD.show();
		/*
        if(InternetStatus.getInstance(drawerAct).isOnline(drawerAct)){
        	
        }else{
        	//drawerAct.toastError(R.string.no_connection);
        	Log.e("no internet","no connection");
            cancel(true);
        }
        */
    }
	
	@Override
	protected FeedResponse doInBackground(String... arg0) {
		try {
			FeedResponse fr = lwsH.getChallengesFeed();
			
			if(fr == null){
				fr = new FeedResponse();
				fr.status = "error";
                fr.reasonCode = "NoReponse";
			}
			
			System.out.println("Feed size: "+fr.feed.size());
			
			return fr;
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
	protected void onPostExecute(FeedResponse fr){
		if(progressD.isShowing()){
            progressD.dismiss();
        }
		if(fr.feed.size() > 0){
			Log.i("feed errors", "no errors "+fr.feed.size());
			feedFragment.setCardsList((ArrayList<LinguageChallengeStub>) fr.feed);
		}
	}
}
