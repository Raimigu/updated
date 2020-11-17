package meandrick.martin.front_page_risaikuru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class front_page extends AppCompatActivity {
    //the Image buttons.
    private ImageButton i4;
    private ImageButton i6;
    private ImageButton i5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);
i4 =(ImageButton) findViewById(R.id.imageButton);
i6 =(ImageButton) findViewById(R.id.imageButton2);
i5 = (ImageButton) findViewById(R.id.imageButton3);

i4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openActivity2();
    }
});
i6.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openActivity3();
    }
});
i5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openActivity4();
    }
});
    }
    //this will call the file
    public void openActivity2(){
        Intent intent = new Intent(this, bottle_second_page.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this, paper_second_page.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, cans_second_page.class);
        startActivity(intent);
    }
}