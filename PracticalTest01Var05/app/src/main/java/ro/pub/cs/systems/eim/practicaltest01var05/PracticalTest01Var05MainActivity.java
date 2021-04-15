package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    private Button top_left, top_right, center, bottom_left, bottom_right, navigate_to_secondary_activity;
    private TextView number_of_buttons_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        Log.d(Constants.TAG, "onCreate() method was invoked");

        top_left = (Button)findViewById(R.id.topLeftButton);
        top_right = (Button)findViewById(R.id.topRightButton);
        center = (Button)findViewById(R.id.centerButton);
        bottom_left = (Button)findViewById(R.id.bottomLeftButton);
        bottom_right = (Button)findViewById(R.id.bottomRightButton);
        number_of_buttons_pressed = (TextView)findViewById(R.id.pressedButtons);
        navigate_to_secondary_activity = (Button)findViewById(R.id.navigateToSecondaryActivity);
    }
}