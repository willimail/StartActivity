package com.mac.fireflies.wgt.startactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText inputText;
    static final int REQUEST_IMAGE_CAPTURE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = ((EditText) findViewById(R.id.textView));
    }

    public void onGo(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("textInput", inputText.getText().toString());

        startActivity(i);

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences setting = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = setting.edit();
        editor.putString("Name", inputText.getText().toString());
        editor.apply();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        String nameSaved = settings.getString("Name", "No Name");
        inputText.setText(nameSaved);
    }
}
