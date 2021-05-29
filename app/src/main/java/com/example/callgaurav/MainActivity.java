package com.example.callgaurav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivCall, ivMail, ivWeb, ivLocate;
    private static final int REQUEST =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivCall = findViewById(R.id.ivCall);
        ivMail = findViewById(R.id.ivMail);
        ivWeb = findViewById(R.id.ivWeb);
        ivLocate = findViewById(R.id.ivLocate);
        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });
        ivMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto: gaurav7275kr@gmail.com"));
                startActivity(intent);
            }
        });
        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.hackerrank.com/gaurav7275kr"));
                startActivity(intent);
            }
        });
        ivLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=Ghatotand"));
                startActivity(intent);
            }
        });
    }
    private void call()
    {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:6299026321"));
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST);
        }
        else
        {
            startActivity(intent);
        }
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions,int[] grantResults)
    {
        if(requestCode==REQUEST)
        {
            if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                call();
            }
        }
    }
}
