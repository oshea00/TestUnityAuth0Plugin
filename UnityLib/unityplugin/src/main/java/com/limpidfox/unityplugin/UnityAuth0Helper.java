package com.limpidfox.unityplugin;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.auth0.android.Auth0;
import com.auth0.android.Auth0Exception;
import com.auth0.android.authentication.AuthenticationAPIClient;
import com.auth0.android.authentication.AuthenticationException;
import com.auth0.android.callback.BaseCallback;
import com.auth0.android.provider.AuthCallback;
import com.auth0.android.provider.VoidCallback;
import com.auth0.android.provider.WebAuthProvider;
import com.auth0.android.result.Credentials;
import com.auth0.android.result.UserProfile;

public class UnityAuth0Helper {
    private static Activity activity;
    private static Auth0 auth0;
    private static String scheme;
    public static String userEmail;
    public static String userId;
    public static String userName;
    public static String returnValue;

    public static void init(String schemeName, Activity context) {
        Log.i("UnityPlugin","Helper.init() called");
        scheme = schemeName;
        activity = context;
        auth0 = new Auth0(activity);
        returnValue = "";
    }

    public static void login(String audience) {
        Log.i("UnityPlugin","Helper.login() called");
        returnValue = "";
        WebAuthProvider.login(auth0)
                .withScheme(scheme)
                .withAudience(audience)
                .withScope("openid email profile")
                .start(activity, new AuthCallback() {
                    @Override
                    public void onFailure(@NonNull final Dialog dialog) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.show();
                            }
                        });
                    }

                    @Override
                    public void onFailure(final AuthenticationException exception) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(activity, "Error: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onSuccess(@NonNull final Credentials credentials) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String tokenStr = credentials.getAccessToken();
                                returnValue = tokenStr;
                                getUser(tokenStr);

                            }
                        });
                    }
                });
    }

    public static void getUser(String accessToken) {
        Log.i("UnityPlugin","Helper.getUser() called");
        AuthenticationAPIClient auth = new AuthenticationAPIClient(auth0);
        auth.userInfo(accessToken)
                .start(new BaseCallback<UserProfile, AuthenticationException>() {
                    @Override
                    public void onSuccess(UserProfile payload) {
                        userEmail = payload.getEmail();
                        userName = payload.getName();
                        userId = payload.getId();
                        Log.i("UnityPlugin","User: "+userName+" "+userEmail+" "+userId);
                    }

                    @Override
                    public void onFailure(AuthenticationException error) {
                        Log.i("UnityPlugin", error.getDescription());
                    }
                });
    }

    public static void logout() {
        Log.i("UnityPlugin", "Helper,logout() called");
        returnValue = "";
        WebAuthProvider.logout(auth0)
                .withScheme(scheme)
                .start(activity, new VoidCallback() {
                    @Override
                    public void onSuccess(Void payload) {

                    }

                    @Override
                    public void onFailure(Auth0Exception error) {

                    }
                });
    }

    public static void DoThisInAndroid(String msg) {
        String fullMsg = String.format("Helper: %s",msg);
        Log.i("UnityPlugin",fullMsg);
        returnValue = fullMsg;
    }

}
