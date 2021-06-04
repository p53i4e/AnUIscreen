package com.example.uidesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onStart() {
        super.onStart();
        AppCenter.start(getApplication(), "2ddc00ec-ba23-43a1-b91e-a64cbdfa643f", Analytics.class, Crashes.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnClickMe:
                TextView txchange = findViewById(R.id.txWelcome);
                txchange.setText("Hi Mahesh ");
                Toast.makeText(this, "Hi how are you", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnClickMe = findViewById(R.id.btnClickMe);
        btnClickMe.setOnClickListener(this);


        btnClickMe.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "long click buddy", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}