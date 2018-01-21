package com.projetodoertheia.a5cta.FirebaseMessaging;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Marcos on 09/09/2016.
 */
public class FirebaseInstacia extends FirebaseInstanceIdService {

    public static final String TAG = "NOTICIAS";

    @Override
    public void onTokenRefresh() {
//        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Token: " + token);

        sendRegistrationToServer(token);

    }

    private void sendRegistrationToServer(String token) {


    }
}


