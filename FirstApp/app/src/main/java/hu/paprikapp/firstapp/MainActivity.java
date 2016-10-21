package hu.paprikapp.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_NUMBER = "NUMBER";
    public static final int REQ_DIAL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dialButton = (Button) findViewById(R.id.dial_button);
        dialButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "OnClick", Toast.LENGTH_LONG).show();
        EditText numberEdit = (EditText) findViewById(R.id.editText);
        String number = numberEdit.getText().toString();

        Intent intent = new Intent(this, DialerActivity.class);
        intent.putExtra(KEY_NUMBER, number);
        startActivityForResult(intent, REQ_DIAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_DIAL) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Result OK", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Result Canceled", Toast.LENGTH_LONG).show();
            }
        }
    }
}
