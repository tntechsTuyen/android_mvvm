package com.vietko.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.vietko.mvvm.R;
import com.vietko.mvvm.data.model.User;
import com.vietko.mvvm.viewmodel.MainViewModel;

import java.util.ArrayList;

import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<User> lstUser = new ArrayList<>();
    private MainViewModel mainViewModel;

    private WebView wvMain;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        wvMain = findViewById(R.id.wv_main);
        wvMain.getSettings().setJavaScriptEnabled(true);
        wvMain.setWebChromeClient(new WebChromeClient());
        wvMain.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                String acc = "f1facc610";
                String js = "javascript:(function() { $('#sso_register_form_account').val('"+acc+"'); $('#sso_register_form_email').val('"+acc+"@v.vn');  $('#sso_register_form_password').val('acc111333'); $('#confirm-btn').click(); })()";
                wvMain.loadUrl(js);
            }
        });
        wvMain.loadUrl("https://connect.garena.com/ui/register");
    }

    private void getUser(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        mainViewModel.getUserRepositoryLiveData().observe(this, data -> {
            if(data != null){
                System.out.println("--------------------------------------------------------------: "+data.size());
            }
        });
    }
}