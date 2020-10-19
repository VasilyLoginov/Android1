package vasiliy.loginov.weatherlike;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected final String[] LOC = {"Краснодар", "Москва", "Санкт-Петербург", "Улан-Удэ"};
    protected final String[] TEMP ={" +25", " +19", " +15", " +20"};
    protected final String[] HUM ={" 95", "90", "99", "80"};
    protected final String[] PRES ={" 750", "745", "760", "735"};

    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outPutValues(count);
                count ++;
                if(count > 3){
                    count = 0;
                }
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findCity();
            }
        });

        initValues();
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

    public void initValues(){
        TextView locationText = findViewById(R.id.locationText);
        String location = getResources().getString(R.string.location_text);
        location += LOC[0];
        locationText.setText(location);

        TextView temperatureText = findViewById(R.id.temperatureText);
        String temperature = getResources().getString(R.string.temperature_text);
        temperature += TEMP[0];
        temperatureText.setText(temperature);

        TextView humidityText = findViewById(R.id.humidityText);
        String humidity = getResources().getString(R.string.humidity_text);
        humidity += HUM[0];
        humidityText.setText(humidity);

        TextView pressureText = findViewById(R.id.pressureText);
        String pressure = getResources().getString(R.string.pressure_text);
        pressure += PRES[0];
        pressureText.setText(pressure);
    }

    public void findCity(){
        int c = 0;
        EditText editText1 = findViewById(R.id.editText1);
        String stringLine = editText1.getText().toString();
        for(String element:LOC){
            if(element.equals(stringLine)){
                outPutValues(c);;
            }
            c++;
        }
    }

}