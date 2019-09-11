package org.tensorflow.lite.examples.classification.customview;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.examples.classification.R;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class Pokeclass extends AppCompatActivity {


    TextView Name, pokeno,type,ability,attack,height,weight,generation,speed,capture,defense,happy,transform,classif,legend;
    String pokemonn;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokeview);

        Name = findViewById(R.id.name);
        pokeno=findViewById(R.id.number);
        type=findViewById(R.id.type);
        ability=findViewById(R.id.ability);
        height=findViewById(R.id.height);
        attack=findViewById(R.id.attack);
        weight=findViewById(R.id.weight);
        generation=findViewById(R.id.generation);
        speed=findViewById(R.id.speed);
        capture=findViewById(R.id.capture);
        defense=findViewById(R.id.defense);
        happy=findViewById(R.id.happy);
        transform=findViewById(R.id.transform);
        classif=findViewById(R.id.classif);
        legend=findViewById(R.id.legend);


        pokemonn = getIntent().getStringExtra("Pokemon");
        pokemonn = pokemonn.substring(0,1).toUpperCase() + pokemonn.substring(1);
        try {
            JSONObject obj = new JSONObject(readJSONFromAsset());

            Gson gson = new Gson();
            Pokemon pok = gson.fromJson(obj.get(pokemonn).toString(), Pokemon.class);
//            Toast.makeText(getBaseContext(),""+pok.getAbilities(),Toast.LENGTH_SHORT).show();

            Name.setText(pokemonn);
            pokeno.setText(pok.getPokedex_number());
            type.setText(pok.getType1());
            ability.setText(pok.getAbilities());
            height.setText(pok.getHeight_m());
            attack.setText(pok.getAttack());
            weight.setText(pok.getWeight_kg());
            generation.setText(pok.getGeneration());
            speed.setText(pok.getSpeed());
            capture.setText(pok.getCapture_rate());
            defense.setText(pok.getDefense());
            happy.setText(pok.getBase_happiness());
            transform.setText(pok.getBase_egg_steps());
            classif.setText(pok.getClassfication());
            legend.setText(pok.getIs_legendary());


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
