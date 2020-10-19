package vasiliy.loginov.weatherlike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements Constants{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        String city_text = getIntent().getExtras().getString(CITY_TEXT);
        String temp_text = getIntent().getExtras().getString(TEMP_TEXT);
        String addr_text = getIntent().getExtras().getString(ADDR_TEXT);
        final String addres = addr_text;

        TextView textViewCity = findViewById(R.id.textCity);
        textViewCity.setText(city_text);

        TextView textViewTemp = findViewById(R.id.textTemperature);
        temp_text += " °C";
        textViewTemp.setText(temp_text);


        Button buttonJumpToBrowser = findViewById(R.id.buttonJumpToBrowser);
        buttonJumpToBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse(addres);
                Intent linkInet = new Intent(Intent.ACTION_VIEW, address);
                startActivity(linkInet);
            }
        });

        Button buttonbuttonToFirstLayout = findViewById(R.id.buttonToFirstLayout);
        buttonbuttonToFirstLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}