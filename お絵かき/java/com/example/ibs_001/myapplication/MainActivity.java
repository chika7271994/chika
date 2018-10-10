package com.example.ibs_001.myapplication;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CanvasView cv = (CanvasView) findViewById(R.id.canvas_view);

        //Button
        Button bt = (Button) findViewById(R.id.clear_button);
        //動作設定
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.allDelete();
            }
        });
    }
}
