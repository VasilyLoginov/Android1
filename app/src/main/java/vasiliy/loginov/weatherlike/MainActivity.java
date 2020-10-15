package vasiliy.loginov.weatherlike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements Constants {

    protected final String[] LOC = {"Краснодар", "Москва", "Санкт-Петербург", "Улан-Удэ"};
    protected final String[] ADDR = {"krasnodar-5136/now/", "moscow-4368/now/", "sankt-peterburg-4079/now/", "ulan-ude-4804/now/"};
    protected final String[] TEMP ={" +25", " +19", " +15", " +20"};
    protected final String[] HUM ={" 95", "90", "99", "80"};
    protected final String[] PRES ={" 750", "745", "760", "735"};


    private int count;
    private String addres;
    private final String ADDRES = "https://www.gismeteo.ru/weather-";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
            count = 0;
        }
        else{
            instanceState = "Повторный запуск!";
            count = savedInstanceState.getInt("Counter");
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", instanceState + " - onCreate()");

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                if(count > 3){count = 0;}
                outPutValues(count);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findCity();
            }
        });

        Button buttonJumpToBrowser = findViewById(R.id.buttonJumpToBrowser);
        buttonJumpToBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addres = ADDRES + ADDR[count];
                Uri address = Uri.parse(addres);
                Intent linkInet = new Intent(Intent.ACTION_VIEW, address);
                startActivity(linkInet);
            }
        });

        Button buttonJumpToSecondActivity = findViewById(R.id.buttonJumpToSecondActivity);
        buttonJumpToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addres = ADDRES + ADDR[count];
                String tempTxt = TEMP[count];
                String locTxt = LOC[count];

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(CITY_TEXT, locTxt);
                intent.putExtra(TEMP_TEXT, tempTxt);
                intent.putExtra(ADDR_TEXT, addres);
                startActivity(intent);
            }
        });

        initValues(count);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "Повторный запуск!! - onRestoreInstanceState()");
        count = savedInstanceState.getInt("Counter");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "onSaveInstanceState()");
        savedInstanceState.putInt("Counter", count);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", "onDestroy()");
    }


    public void outPutValues(int count){
        TextView locationText = findViewById(R.id.locationText);
        String location = getResources().getString(R.string.location_text);
        location += LOC[count];
        locationText.setText(location);

        TextView temperatureText = findViewById(R.id.temperatureText);
        String temperature = getResources().getString(R.string.temperature_text);
        temperature += TEMP[count];
        temperatureText.setText(temperature);

        TextView humidityText = findViewById(R.id.humidityText);
        String humidity = getResources().getString(R.string.humidity_text);
        humidity += HUM[count];
        humidityText.setText(humidity);

        TextView pressureText = findViewById(R.id.pressureText);
        String pressure = getResources().getString(R.string.pressure_text);
        pressure += PRES[count];
        pressureText.setText(pressure);
    }

    public void initValues(int count){
        outPutValues(count);
    }

    public void findCity(){
        int c = 0;
        EditText editText1 = findViewById(R.id.editText1);
        String stringLine = editText1.getText().toString();
        for(String element:LOC){
            if(element.equals(stringLine)){
                outPutValues(c);
                count = c;
            }
            c++;
        }
    }

}