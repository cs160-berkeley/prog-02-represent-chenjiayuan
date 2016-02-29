package chenjiayuan.represent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    TextView location;
    EditText zipcode;
    ImageView icon;
    String mode = "zipcode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //prevent keyboard appear automatically
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location = (TextView) findViewById(R.id.location_option);
        zipcode = (EditText) findViewById(R.id.zip_option);
        zipcode.setVisibility(View.VISIBLE);
        location.setVisibility(View.GONE);
    }

    public void searchClickHandler(View view) {
        if (view.getId() == R.id.searchButton) {
            Intent intent;
            intent = new Intent(this, CongressionalActivity.class);
            intent.putExtra("mode", mode);
            intent.putExtra("location", location.getText().toString());
            intent.putExtra("zipcode", zipcode.getText().toString());
            startActivity(intent);

            Intent watchIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
            watchIntent.putExtra("info", "Fred");
            startService(watchIntent);
        }
    }

    public void locationOptionClicked(View view) {
        if (view.getId() == R.id.use_location) {
            location = (TextView) findViewById(R.id.location_option);
            zipcode = (EditText) findViewById(R.id.zip_option);
            icon = (ImageView) findViewById(R.id.imageView);
            location.setVisibility(View.VISIBLE);
            zipcode.setVisibility(View.GONE);
            icon.setImageResource(R.drawable.ic_location_on_black_48dp);
            mode = "currentLocation";
        }
    }
    public void zipcodeOptionClicked(View view) {
        if (view.getId() == R.id.use_zipcode) {
            location = (TextView) findViewById(R.id.location_option);
            zipcode = (EditText) findViewById(R.id.zip_option);
            icon = (ImageView) findViewById(R.id.imageView);
            location.setVisibility(View.GONE);
            zipcode.setVisibility(View.VISIBLE);
            icon.setImageResource(R.drawable.ic_location_city_black_48dp);
            mode = "zipcode";
        }
    }
}