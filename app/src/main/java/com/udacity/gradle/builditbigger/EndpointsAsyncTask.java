package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;


import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

import andreas.androidlibraryjoke.DisplayJokeActivity;


/**
 * Created by Andreas on 18-Mar-18.
 */


class EndpointsAsyncTask extends AsyncTask<Context,Void,String> {
    private static MyApi mJokeApi = null;
    private Context mContext;
    private String mResult;
    public EndpointsAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(Context... contexts) {
        if (mJokeApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(mContext.getString(R.string.rooUrl));
            mJokeApi = builder.build();
        }
        try {
            return mJokeApi.getJokes().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mResult = result;
        startJokeDisplayActivity();
    }

    private void startJokeDisplayActivity() {
        Intent intent = new Intent(mContext, DisplayJokeActivity.class);
        intent.putExtra(DisplayJokeActivity.Tag, mResult);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

}
