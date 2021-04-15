package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    private Button verify_button, cancel_button;
    private EditText directions;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.verifyButton:
                    setResult(RESULT_OK, intent);
                    break;
                case R.id.cancelButton:
                    setResult(RESULT_CANCELED, intent);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        directions = (EditText) findViewById(R.id.textDirections);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.DIRECTIONS)) {
            String dir = intent.getExtras().getString(Constants.DIRECTIONS);
            directions.setText(dir);
        }

        verify_button = (Button)findViewById(R.id.verifyButton);
        verify_button.setOnClickListener(buttonClickListener);

        cancel_button = (Button)findViewById(R.id.cancelButton);
        cancel_button.setOnClickListener(buttonClickListener);
    }
}