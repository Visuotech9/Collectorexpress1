package com.example.collectorexpress.UtilClass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONObject;

/*import com.facebook.AccessToken;
import com.facebook.login.LoginManager;*/


public class SessionParam {
    public String signupStage = "0", loginSession = "n";
    public String userId = "", name = "", mobile = "", email = "", login = "", unqId = "", status = "", profileImg = "",noti_count="0";
    String PREF_NAME = "MyPref";
    Context _context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefsEditor;

    public static String USER_ID;




    public SessionParam(Context context, String signupStage) {
        this.signupStage = signupStage;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("signupStage", signupStage);
        prefsEditor.commit();
    }

    @SuppressLint("LongLogTag")
    public SessionParam(Context context, JSONObject jsonObject) {
        if (jsonObject != null) {
            userId = (jsonObject.optString("user_id"));
            unqId = (jsonObject.optString("kon_unq_id"));
            name = (jsonObject.optString("kon_name"));
            mobile = jsonObject.optString("kon_mobile");
            email = jsonObject.optString("kon_email");
            mobile = jsonObject.optString("kon_mobile");
            status = jsonObject.optString("kon_status");

            USER_ID = userId;

            userId(context, userId);
            unqueId(context, unqId);
            userName(context, name);
            userEmail(context, email);
            userMobile(context, mobile);
            statusKon(context, mobile);
        }
    }


    public SessionParam(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.userId = sharedPreferences.getString("userId", "");
        this.unqId = sharedPreferences.getString("unqId", "");
        this.name = sharedPreferences.getString("name", "");
        this.mobile = sharedPreferences.getString("mob", "");
        this.email = sharedPreferences.getString("email", "");
        this.login = sharedPreferences.getString("login", "");
        this.status = sharedPreferences.getString("status", "");
        this.profileImg = sharedPreferences.getString("Pimage", "");
        this.noti_count = sharedPreferences.getString("COUNT","");

    }


    public void userId(Context context, String userId) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("userId", userId);
        prefsEditor.commit();
    }

    public void profileImage(Context context, String profileImage) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("Pimage", profileImage);
        prefsEditor.commit();
    }

    public void unqueId(Context context, String unqId) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("unqId", unqId);
        prefsEditor.commit();
    }

    public void userName(Context context, String name) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("name", name);
        prefsEditor.commit();
    }

    public void userEmail(Context context, String email) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("email", email);
        prefsEditor.commit();
    }

    public void userMobile(Context context, String mobile) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("mob", mobile);
        prefsEditor.commit();
    }

    public void statusKon(Context context, String status) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("status", status);
        prefsEditor.commit();
    }

    public void notificatioCount(Context context, String count) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("COUNT", count);
        prefsEditor.commit();
    }


    public void deviceId(Context context, String device_id) {
        Log.d("DeviceId Session", device_id);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("deviceId", device_id);
        prefsEditor.commit();
    }


    public void clearPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        /*AccessToken.setCurrentAccessToken(null);
        LoginManager.getInstance().logOut();*/
        prefsEditor.clear();
        prefsEditor.commit();
    }


    @Override
    public String toString() {
        return "SessionParam [name=" + "]";
    }


    public void loginSession(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString("login", "yes");
        prefsEditor.commit();
    }

    public void editPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        /*AccessToken.setCurrentAccessToken(null);
        LoginManager.getInstance().logOut();*/
        prefsEditor.clear();
        prefsEditor.commit();
    }


}
