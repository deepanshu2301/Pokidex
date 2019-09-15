package org.tensorflow.lite.examples.classification.customview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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


    TextView Name, pokeno,type,ability,attack,height,weight,generation,speed,capture,defense,happy,transform,classif,legend,ability1a,ability2a;
    TextView bug,dark,dragon,electric,fairy,fight,fire,flying,ghost,grass,ground,ice,normal,poison,psychic,rock,steel,water,total1,type2,type1,permale;
    LinearLayout vgenere,vspeed,vcapture,vdefense,vhappy,vtransform,vclass,vlegendary,vmale;
    String pokemonn;
    ScrollView sview;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokeview);
        type1=findViewById(R.id.utype1);
        permale=findViewById(R.id.male);
        type2=findViewById(R.id.utype2);
        ability1a=findViewById(R.id.ability1);
        ability2a=findViewById(R.id.ability2);
        vgenere=findViewById(R.id.lvgenere);
        vspeed=findViewById(R.id.lvspeed);
        vcapture=findViewById(R.id.lvcapture);
        vdefense=findViewById(R.id.lvdefense);
        vhappy=findViewById(R.id.lvhappy);
        vtransform=findViewById(R.id.lvtrans);
        vclass=findViewById(R.id.lvclass);
        vlegendary=findViewById(R.id.lvlegend);
        vmale=findViewById(R.id.lvmale);
        total1=findViewById(R.id.total);
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
        sview=findViewById(R.id.ssview);

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
//        normal=findViewById(R.id.normal);
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
            String ab1=ab.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\\'", "");
            String[] ab2 = ab1.split(",");

            String col=pok.getType1();
            if(col.contains("bug")){
                sview.setBackgroundColor(getResources().getColor(R.color.bug));

            }
            if(col.contains("dark")){
                sview.setBackgroundColor(getResources().getColor(R.color.dark));
            }
            if(col.contains("dragon")){
                sview.setBackgroundColor(getResources().getColor(R.color.dragon));
            }
            if(col.contains("electric")){
                sview.setBackgroundColor(getResources().getColor(R.color.electric));
            }
            if(col.contains("fairy")){
                sview.setBackgroundColor(getResources().getColor(R.color.fairy));
            }
            if(col.contains("flight")){
                sview.setBackgroundColor(getResources().getColor(R.color.flight));
            }
            if(col.contains("fire")){
                sview.setBackgroundColor(getResources().getColor(R.color.fire));
            }
            if(col.contains("flying")){
                sview.setBackgroundColor(getResources().getColor(R.color.flying));
            }
            if(col.contains("ghost")){
                sview.setBackgroundColor(getResources().getColor(R.color.ghost));
            }
            if(col.contains("grass")){
                sview.setBackgroundColor(getResources().getColor(R.color.grass));
            }
            if(col.contains("ground")){
                sview.setBackgroundColor(getResources().getColor(R.color.ground));
            }
            if(col.contains("ice")){
                sview.setBackgroundColor(getResources().getColor(R.color.ice));
            }
            if(col.contains("poison")){
                sview.setBackgroundColor(getResources().getColor(R.color.poison));
            }
            if(col.contains("psychic")){
                sview.setBackgroundColor(getResources().getColor(R.color.psychic));
            }
            if(col.contains("rock")){
                sview.setBackgroundColor(getResources().getColor(R.color.rock));
            }
            if(col.contains("steel")){
                sview.setBackgroundColor(getResources().getColor(R.color.steel));
            }
            if(col.contains("water")){
                sview.setBackgroundColor(getResources().getColor(R.color.water));
            }

            int color = Color.TRANSPARENT;
            Drawable background = sview.getBackground();
            if (background instanceof ColorDrawable)
                color = ((ColorDrawable) background).getColor();

            GradientDrawable drawable1 = (GradientDrawable) vgenere.getBackground();
            drawable1.setColor(color);
            GradientDrawable drawable2 = (GradientDrawable) vspeed.getBackground();
            drawable2.setColor(color);
            GradientDrawable drawable3 = (GradientDrawable) vcapture.getBackground();
            drawable3.setColor(color);
            GradientDrawable drawable4 = (GradientDrawable) vdefense.getBackground();
            drawable4.setColor(color);
            GradientDrawable drawable5 = (GradientDrawable) vhappy.getBackground();
            drawable5.setColor(color);
            GradientDrawable drawable6 = (GradientDrawable) vtransform.getBackground();
            drawable6.setColor(color);
            GradientDrawable drawable7 = (GradientDrawable) vclass.getBackground();
            drawable7.setColor(color);
            GradientDrawable drawable8 = (GradientDrawable) vlegendary.getBackground();
            drawable8.setColor(color);
            GradientDrawable drawable9 = (GradientDrawable) vmale.getBackground();
            drawable9.setColor(color);


            Name.setText(pokemonn);
            pokeno.setText("#0"+pok.getPokedex_number());
            type.setText(pok.getType1());
            type1.setText(pok.getType1());
            type2.setText(pok.getType2());
            permale.setText(pok.getPercentage_male());
            ability.setText(" "+ab2[0]);
            ability1a.setText(ab2[1]);
            ability2a.setText(" "+pok.getType1().toUpperCase() + " Attack");
            height.setText(pok.getHeight_m() + " m");
            attack.setText(pok.getAttack());
            weight.setText(pok.getWeight_kg() + " kg");
            generation.setText(pok.getGeneration());
            speed.setText(pok.getSpeed());
            capture.setText(pok.getCapture_rate());
            defense.setText(pok.getDefense());
            happy.setText(pok.getBase_happiness());
            transform.setText(pok.getBase_egg_steps());
            classif.setText(pok.getClassfication());

            String le="";
            if(pok.getIs_legendary().equals("0")){
                le="No";
            }
            else{
                le="Yes";
            }
            legend.setText(le);
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
//            normal.setText(pok.getAgainst_normal());
            poison.setText(pok.getAgainst_poison());
            psychic.setText(pok.getAgainst_psychic());
            rock.setText(pok.getAgainst_rock());
            steel.setText(pok.getAgainst_steel());
            water.setText(pok.getAgainst_water());
            int total = Integer.parseInt(pok.getSpeed()) + Integer.parseInt(pok.getDefense()) + Integer.parseInt(pok.getCapture_rate()) + Integer.parseInt(pok.base_happiness);
            total1.setText("TOTAL  "+total);

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
