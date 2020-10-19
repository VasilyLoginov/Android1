package vasiliy.loginov.weatherlike;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected String LOC =" Краснодар";
    protected String TEMP =" 25";
    protected String HUM =" 80";
    protected String PRES =" 750";

    protected String locationValue = LOC;
    protected String temperatureValue = TEMP;
    protected String humidityValue = HUM;
    protected String pressureValue = PRES;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView locationText = findViewById(R.id.locationText);
        String location = getResources().getString(R.string.location_text);
        location += locationValue;
        locationText.setText(location);
        //locationText.setTextSize(24);

        TextView temperatureText = findViewById(R.id.temperatureText);
        String temperature = getResources().getString(R.string.temperature_text);
        temperature += temperatureValue;
        temperatureText.setText(temperature);

        TextView humidityText = findViewById(R.id.humidityText);
        String humidity = getResources().getString(R.string.humidity_text);
        humidity += humidityValue;
        humidityText.setText(humidity);

        TextView pressureText = findViewById(R.id.pressureText);
        String pressure = getResources().getString(R.string.pressure_text);
        pressure += pressureValue;
        pressureText.setText(pressure);
    }

}