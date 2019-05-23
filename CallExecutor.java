package com.apps.muthoka.retailer.Api;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import com.apps.muthoka.retailer.CallBacks.CallInterface;
import com.apps.muthoka.retailer.Models.ServerResponse;

import java.io.IOException;

import retrofit2.Call;

/**
 * Created by NE on 18/02/2019.
 */

public class CallExecutor extends AsyncTask<Call, Void, ServerResponse> {

    CallInterface callInterface = null;
    Activity activity;
    private String TAG = CallExecutor.class.getSimpleName();

    public CallExecutor(Activity activity, CallInterface callInterface) {
        this.callInterface = callInterface;
        this.activity = activity;
        TAG = activity.getLocalClassName();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute() called");
        callInterface.onStart();
    }

    @Override
    protected ServerResponse doInBackground(Call[] calls) {
        ServerResponse serverResponse;
        try {
            Call<ServerResponse> call = calls[0];
            serverResponse = call.execute().body();
            if (serverResponse != null) {
                Log.d(TAG, "doInBackground() called with: calls = [" + calls + "] and response = [" + serverResponse.toString() + "]");
            } else {
                Log.d(TAG, "doInBackground: " + call.request().toString());
            }
        } catch (final Exception e) {
            Log.e(TAG, "doInBackground Error Occurred: ", e);
            serverResponse = new ServerResponse();
            serverResponse.setMessage(e.getMessage());
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    callInterface.onError(e);
                    //progressDialog.setMessage(e.getMessage());
                }
            });

            return serverResponse;
        }
        return serverResponse;
    }

    @Override
    protected void onPostExecute(ServerResponse serverResponse) {
        super.onPostExecute(serverResponse);
        if (serverResponse == null) {
            serverResponse = new ServerResponse();
        }
        if (!serverResponse.isNull()) {
            Log.d(TAG, "onPostExecute: :" + serverResponse);
        }
        callInterface.onComplete(serverResponse);

    }
}
