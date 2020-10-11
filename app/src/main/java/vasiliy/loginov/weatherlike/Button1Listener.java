package vasiliy.loginov.weatherlike;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Button1Listener implements View.OnClickListener {
    protected int count = 0;

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "button1 Click event"+ " " + count, Toast.LENGTH_LONG).show();
        count ++;
    }
}
