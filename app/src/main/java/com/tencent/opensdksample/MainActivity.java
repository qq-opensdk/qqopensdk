package com.tencent.opensdksample;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.tencent.qqopensdk.TencentImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TencentImpl tencentImpl = new TencentImpl(this, "com.tencent.sample.fileprovider");

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tencentImpl.login(MainActivity.this, "all");
            }
        });

        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", "17680359");
                bundle.putString("pass", "pass");
                tencentImpl.share(MainActivity.this, bundle);
            }
        });
    }
}