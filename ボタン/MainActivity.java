package jp.mixi.practice.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        Button button = (Button) findViewById(R.id.button);

        //textview
        textView = (TextView) findViewById(R.id.text_view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //flag=true
                if(flag){
                    textView.setText("Hello");
                    flag=false;
                }
                else {
                    textView.setText("World!");
                    flag=true;
                }
            }
        });
    }
}
