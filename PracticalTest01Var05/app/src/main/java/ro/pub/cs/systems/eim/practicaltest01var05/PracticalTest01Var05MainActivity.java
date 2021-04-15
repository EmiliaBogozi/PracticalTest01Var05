package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    private Button top_left, top_right, center, bottom_left, bottom_right, navigate_to_secondary_activity;
    private TextView number_of_buttons_pressed;
    private int clicks;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String text = number_of_buttons_pressed.getText().toString();
            if(!text.isEmpty())
                text = text + ", ";
            if(v.getId() == R.id.topLeftButton) {
                clicks++;
                text = text + "Top Left";
                number_of_buttons_pressed.setText(text);
            }
            if(v.getId() == R.id.topRightButton) {
                clicks++;
                text = text + "Top Right";
                number_of_buttons_pressed.setText(text);
            }
            if(v.getId() == R.id.centerButton) {
                clicks++;
                text = text + "Center";
                number_of_buttons_pressed.setText(text);
            }
            if(v.getId() == R.id.bottomLeftButton) {
                clicks++;
                text = text + "Bottom Left";
                number_of_buttons_pressed.setText(text);
            }
            if(v.getId() == R.id.bottomRightButton) {
                clicks++;
                text = text + "Bottom Right";
                number_of_buttons_pressed.setText(text);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        Log.d(Constants.TAG, "onCreate() method was invoked");

        clicks = 0;

        top_left = (Button)findViewById(R.id.topLeftButton);
        top_left.setOnClickListener(buttonClickListener);

        top_right = (Button)findViewById(R.id.topRightButton);
        top_right.setOnClickListener(buttonClickListener);

        center = (Button)findViewById(R.id.centerButton);
        center.setOnClickListener(buttonClickListener);

        bottom_left = (Button)findViewById(R.id.bottomLeftButton);
        bottom_left.setOnClickListener(buttonClickListener);

        bottom_right = (Button)findViewById(R.id.bottomRightButton);
        bottom_right.setOnClickListener(buttonClickListener);

        number_of_buttons_pressed = (TextView)findViewById(R.id.pressedButtons);
        number_of_buttons_pressed.setOnClickListener(buttonClickListener);

        navigate_to_secondary_activity = (Button)findViewById(R.id.navigateToSecondaryActivity);
        navigate_to_secondary_activity.setOnClickListener(buttonClickListener);
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(Constants.TAG, "onSaveInstanceState() method was invoked");
        savedInstanceState.putInt(Constants.COUNT_CLICKS, clicks);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(Constants.TAG, "onRestoreInstanceState() method was invoked");
        if(savedInstanceState.containsKey(Constants.COUNT_CLICKS))
        {
            clicks = savedInstanceState.getInt(Constants.COUNT_CLICKS);
            Log.d(Constants.TAG, String.valueOf(clicks));
            Toast.makeText(getApplicationContext(), "S-au realizat " + clicks + " apasari de buton.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Constants.TAG, "onRestart() method was invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constants.TAG, "onStart() method was invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constants.TAG, "onStop() method was invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constants.TAG, "onResume() method was invoked");
        //registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        //unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
        Log.d(Constants.TAG, "onPause() method was invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constants.TAG, "onDestroy() method was invoked");
    }
}