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
    TextView bug,dark,dragon,electric,fairy,fight,fire,flying,ghost,grass,ground,ice,normal,poison,psychic,rock,steel,water;
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

        bug = findViewById(R.id.bugval);
        dark=findViewById(R.id.darkval);
        dragon=findViewById(R.id.dragon);
        electric=findViewById(R.id.electric);
        fairy=findViewById(R.id.fairyval);
        fight=findViewById(R.id.fightval);
        fire=findViewById(R.id.fireval);
        flying=findViewById(R.id.flyingval);
        ghost=findViewById(R.id.ghostval);
        grass=findViewById(R.id.grassval);
        ground=findViewById(R.id.groundval);
        ice=findViewById(R.id.iceval);
        normal=findViewById(R.id.normal);
        poison=findViewById(R.id.poisonval);
        psychic=findViewById(R.id.psychicval);
        rock=findViewById(R.id.rockval);
        steel=findViewById(R.id.steelval);
        water=findViewById(R.id.waterval);


        pokemonn = getIntent().getStringExtra("Pokemon");
        pokemonn = pokemonn.substring(0,1).toUpperCase() + pokemonn.substring(1);
        try {
            JSONObject obj = new JSONObject(readJSONFromAsset());

            Gson gson = new Gson();
            Pokemon pok = gson.fromJson(obj.get(pokemonn).toString(), Pokemon.class);
//            Toast.makeText(getBaseContext(),""+pok.getAbilities(),Toast.LENGTH_SHORT).show();

            String ab = pok.getAbilities();
            String ab1=ab.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\\'", "").replaceAll("\\,", "\n");
            Name.setText(pokemonn);
            pokeno.setText(pok.getPokedex_number());
            type.setText(pok.getType1());
            ability.setText(ab1);
            height.setText(pok.getHeight_m() + " m");
            attack.setText(pok.getAttack());
            weight.setText(pok.getWeight_kg() + " kg");
            generation.setText(pok.getGeneration());
            speed.setText(pok.getSpeed() + " kmps");
            capture.setText(pok.getCapture_rate());
            defense.setText(pok.getDefense());
            happy.setText(pok.getBase_happiness());
            transform.setText(pok.getBase_egg_steps());
            classif.setText(pok.getClassfication());
            legend.setText(pok.getIs_legendary());
            bug.setText(pok.getAgainst_bug());
            dark.setText(pok.getAgainst_dark());
            dragon.setText(pok.getAgainst_dragon());
            electric.setText(pok.getAgainst_electric());
            fairy.setText(pok.getAgainst_fairy());
            fight.setText(pok.getAgainst_fight());
            fire.setText(pok.getAgainst_fire());
            flying.setText(pok.getAgainst_flying());
            ghost.setText(pok.getAgainst_ghost());
            ground.setText(pok.getAgainst_ground());
            ice.setText(pok.getAgainst_ice());
            normal.setText(pok.getAgainst_normal());
            poison.setText(pok.getAgainst_poison());
            psychic.setText(pok.getAgainst_psychic());
            rock.setText(pok.getAgainst_rock());
            steel.setText(pok.getAgainst_steel());
            water.setText(pok.getAgainst_water());


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
