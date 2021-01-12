package com.mkp246.hostspotmanager;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView arp = (TextView) findViewById(R.id.arp);
        FileReader arpReader = null;
        try {
            arpReader = new FileReader("/proc/net/arp");
            BufferedReader reader = new BufferedReader(arpReader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            reader.close();
            arp.setText(sb.toString());
        } catch (IOException e) {
            arp.setText(e.getMessage());
        }
    }
}