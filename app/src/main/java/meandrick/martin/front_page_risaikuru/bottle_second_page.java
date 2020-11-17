package meandrick.martin.front_page_risaikuru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class bottle_second_page extends AppCompatActivity {
    private ImageButton image5;
    private ImageButton image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottle_second_page);
        image5 = (ImageButton) findViewById(R.id.image5);
        image2 = (ImageButton) findViewById(R.id.image2);

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMango();
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFunnel();
            }
        });
    }

    public void openMango() {
        Intent intent = new Intent(this, mango_catcher_third_page.class);
        startActivity(intent);
    }

    public void openFunnel() {
        Intent intent = new Intent(this, funnel_third_page.class);
        startActivity(intent);
    }
}