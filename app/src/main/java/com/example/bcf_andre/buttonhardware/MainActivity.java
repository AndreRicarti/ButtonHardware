package com.example.bcf_andre.buttonhardware;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean flag = false;
    boolean flag2 = false;
    Context context;

    int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getBaseContext();
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {

            Intent in=new Intent(Intent.ACTION_CALL);
            try {
                in.setData(Uri.parse("tel:" + "+55 11 97202-3780"));
                startActivity(in);
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
            }

            Log.d("Test", "Long press!");
            flag = false;
            flag2 = true;
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            event.startTracking();

            if (flag2 == true) {
                flag = false;
            } else {
                flag = true;
                flag2 = false;
            }

            if (cont == 4){
                Intent in=new Intent(Intent.ACTION_CALL);
                try {
                    in.setData(Uri.parse("tel:" + "+55 11 97202-3780"));
                    startActivity(in);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
                }
                cont = 0;
            }

            cont ++;

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            event.startTracking();
            if (flag) {
                Intent in=new Intent(Intent.ACTION_CALL);
                try {
                    in.setData(Uri.parse("tel:" + "+55 11 97202-3780"));
                    startActivity(in);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
                }
                Log.d("Test", "Short");
            }
            flag = true;
            flag2 = false;
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
