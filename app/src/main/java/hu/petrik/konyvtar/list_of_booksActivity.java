package hu.petrik.konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class list_of_booksActivity extends AppCompatActivity {

    private Button backButton;
    private TextView cimTV;
    private TextView szerzoTV;
    private TextView oldalTV;
    private TextView evTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_of_books);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        Bundle bundle = getIntent().getExtras();
        Integer oldalak = bundle.getInt("oldal");
        Integer ev = bundle.getInt("ev");
        cimTV.setText(bundle.getString("cim"));
        szerzoTV.setText(bundle.getString("szerzo"));
        oldalTV.setText(oldalak.toString());
        evTV.setText(ev.toString());
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(list_of_booksActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void init(){
        backButton = findViewById(R.id.backButton);
        cimTV = findViewById(R.id.cimTextView);
        szerzoTV = findViewById(R.id.szerzoTextView);
        oldalTV = findViewById(R.id.oldalTextView);
        evTV = findViewById(R.id.evTextView);
    }
}