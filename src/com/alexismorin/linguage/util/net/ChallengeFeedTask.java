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
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;


public class ChallengeFeedTask extends AsyncTask<String, Void, FeedResponse> {
	private FeedFragment feedFragment;
	private Context ctx;
	private ProgressDialog progressD;
	private LinguageWebServiceHelper lwsH = new LinguageWebServiceHelper("http://alexismorin.com/svenguage/");
	
	public ChallengeFeedTask(FeedFragment feedFragment, ProgressDialog progressDialog, Context ctx){
		this.feedFragment = feedFragment;
		this.progressD = progressDialog;
		this.ctx = ctx;
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
		
        if(InternetStatus.getInstance(ctx).isOnline(ctx)){
        	
        }else{
        	//drawerAct.toastError(R.string.no_connection);
        	progressD.cancel();
        	cancel(true);
        	Log.e("no internet","no connection");
        }
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
