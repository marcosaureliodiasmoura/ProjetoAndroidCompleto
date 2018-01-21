package com.projetodoertheia.a5cta.Outros;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Places;
import com.projetodoertheia.a5cta.R;

public class AplicativosActivity extends AppCompatActivity {
//    private GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicativos);


//        // [START build_api_client]
//        // Build GoogleApiClient with AppInvite API for receiving deep links
//        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .enableAutoManage(this, (GoogleApiClient.OnConnectionFailedListener) this)
//                .addApi(AppInvite.API)
//                .build();
//
//
//        mGoogleApiClient = new GoogleApiClient
//                .Builder(this)
//                .addApi(Places.GEO_DATA_API)
//                .addApi(Places.PLACE_DETECTION_API)
//                .addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) this)
//                .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this)
//                .build();
//        // [END build_api_client]
//
//        // [START get_deep_link]
//        // Check if this app was launched from a deep link. Setting autoLaunchDeepLink to true
//        // would automatically launch the deep link if one is found.
//        boolean autoLaunchDeepLink = false;
//        AppInvite.AppInviteApi.getInvitation(mGoogleApiClient, this, autoLaunchDeepLink)
//                .setResultCallback(
//                        new ResultCallback<AppInviteInvitationResult>() {
//                            @Override
//                            public void onResult(@NonNull AppInviteInvitationResult result) {
//                                if (result.getStatus().isSuccess()) {
//                                    // Extract deep link from Intent
//                                    Intent intent = result.getInvitationIntent();
//                                    String deepLink = AppInviteReferral.getDeepLink(intent);
//
//                                    // Handle the deep link. For example, open the linked
//                                    // content, or apply promotional credit to the user's
//                                    // account.
//
//                                    // [START_EXCLUDE]
//                                    // Display deep link in the UI
//                                    ((TextView) findViewById(R.id.txtLINK)).setText(deepLink);
//                                    Toast.makeText(getApplicationContext(), deepLink, Toast.LENGTH_LONG).show();
//                                    // [END_EXCLUDE]
//                                } else {
////                                    Log.d("getInvitation: no deep link found.");
//                                }
//                            }
//                        });
//        // [END get_deep_link]


    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        mGoogleApiClient.connect();
//    }
//
//    @Override
//    protected void onStop() {
//        mGoogleApiClient.disconnect();
//        super.onStop();
//    }

}
