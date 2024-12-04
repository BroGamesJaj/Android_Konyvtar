package hu.petrik.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button hozzaadButton;
    private Button torlesButton;
    private static ArrayList<Konyv> konyvek;
    private TextInputLayout cimTextInputLayout;
    private TextInputLayout szerzoTextInputLayout;
    private TextInputLayout oldalTextInputLayout;
    private KonyvAdapter adapter;
    private ListView listView;
    private Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        hozzaadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String cim = cimTextInputLayout.getEditText().getText().toString();
                String szerzo = szerzoTextInputLayout.getEditText().getText().toString();
                Integer oldal = Integer.parseInt(oldalTextInputLayout.getEditText().getText().toString().isEmpty() ? "0" : oldalTextInputLayout.getEditText().getText().toString());
                if(cim.isEmpty()){
                    Toast.makeText(MainActivity.this, "Nincs cím megadva", Toast.LENGTH_SHORT).show();
                }else if(szerzo.isEmpty()){
                    Toast.makeText(MainActivity.this, "Nics szerző megadva", Toast.LENGTH_SHORT).show();
                }else if(oldal < 50){
                    Toast.makeText(MainActivity.this, "Az oldalak száma nem lehet 50 alatt", Toast.LENGTH_SHORT).show();
                }else{
                    Konyv user = new Konyv(cim, szerzo, oldal,rnd.nextInt(2024));
                    konyvek.add(user);
                    Toast.makeText(MainActivity.this, "Sikeres hozzáadás", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("onItemClick");
                Konyv item = konyvek.get(i);
                Intent intent = new Intent(MainActivity.this, list_of_booksActivity.class);
                intent.putExtra("cim",item.getCim());
                intent.putExtra("szerzo",item.getSzerzo());
                intent.putExtra("oldal",item.getOldalak());
                intent.putExtra("ev",item.getEv());
                startActivity(intent);
                finish();
            }
        });



    }
    public void init(){
        hozzaadButton = findViewById(R.id.hozzaadas);
        cimTextInputLayout = findViewById(R.id.cimTIL);
        szerzoTextInputLayout = findViewById(R.id.szerzoTIL);
        oldalTextInputLayout = findViewById(R.id.oldalakTIL);
        konyvek = new ArrayList<>();
        listView = findViewById(R.id.listView);
        adapter = new KonyvAdapter(konyvek, MainActivity.this);
        listView.setAdapter(adapter);
        rnd = new Random();
    }

    public static ArrayList<Konyv> getKonyvek(){
        return konyvek;
    }
}