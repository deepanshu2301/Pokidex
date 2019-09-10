package org.tensorflow.lite.examples.classification.customview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.examples.classification.R;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class Pokeclass extends AppCompatActivity {

    String pokemon;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokeview);

        pokemon = getIntent().getStringExtra("Pokemon");
        pokemon = pokemon.substring(0,1).toUpperCase() + pokemon.substring(1);
        try {
            JSONObject obj = new JSONObject(readJSONFromAsset());
//            Toast.makeText(getBaseContext(),""+obj.length(),Toast.LENGTH_SHORT).show();

                Toast.makeText(getBaseContext(),""+obj.get(pokemon),Toast.LENGTH_SHORT).show();


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("information.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
