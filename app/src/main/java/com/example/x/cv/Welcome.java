package com.example.x.cv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.example.x.cv.memories.MemoriesActivity;
import com.example.x.cv.previous_work.PreviousWorkActivity;

public class Welcome extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView welcome;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        calling();
        handling();
    }

    void calling() {

        welcome = findViewById(R.id.welcome_textView);
        webView = findViewById(R.id.webView);
    }

    void handling() {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Welcome.this);

        String fullName = "";

        fullName = sharedPreferences.getString(LoginActivity.KEY_FIRST_NAME, "") + " " + sharedPreferences.getString(LoginActivity.KEY_SECOND_NAME, "");

        welcome.append(fullName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_facebook) {

            Uri facebook = Uri.parse("https://www.facebook.com");
            Intent faceIntent = new Intent(Intent.ACTION_VIEW, facebook);
            startActivity(faceIntent);
            return true;
        } else if (item.getItemId() == R.id.action_google) {

            webView.setWebViewClient(new webView());
            webView.loadUrl("https://www.google.com");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            return true;
        } else if (item.getItemId() == R.id.action_linkedIn) {


            webView.setWebViewClient(new webView());
            webView.loadUrl("https://www.linkedIn.com");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);


            return true;

        } else if (item.getItemId() == R.id.action_previous_education) {

            startActivity(new Intent(Welcome.this, EducationActivity.class));
            return true;

        } else if (item.getItemId() == R.id.action_previous_work) {

            startActivity(new Intent(Welcome.this, PreviousWorkActivity.class));
            return true;

        } else if (item.getItemId() == R.id.action_memories) {

            startActivity(new Intent(Welcome.this, MemoriesActivity.class));
            return true;

        } else if (item.getItemId() == R.id.action_logout) {
            toast();
            sharedPreferences.edit().clear().commit();
            startActivity(new Intent(Welcome.this, LoginActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void toast() {
        LayoutInflater inflater = getLayoutInflater();
        View toastView = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast));
        TextView toastTextView = toastView.findViewById(R.id.toastMsg);
        toastTextView.append(" " + sharedPreferences.getString(LoginActivity.KEY_FIRST_NAME, ""));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 80);
        toast.setView(toastView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
