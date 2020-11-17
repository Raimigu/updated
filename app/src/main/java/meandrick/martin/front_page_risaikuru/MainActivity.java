package meandrick.martin.front_page_risaikuru;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<RecItems> recItems;
    private RecyclerView mRecyclerView;
    private ProgramAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int[] likesCount = {200, 34, 50, 150, 170, 100};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createRecItems();
        buildRecyclerView();
    }
    private void createRecItems() {
        recItems = new ArrayList<>();
        recItems.add(new RecItems("Title1", "Desc1", "200"));
        recItems.add(new RecItems("Title2", "Desc2", "34"));
        recItems.add(new RecItems("Title3", "Desc3", "50"));
        recItems.add(new RecItems("Title4", "Desc4", "150"));
        recItems.add(new RecItems("Title5", "Desc5", "170"));
        recItems.add(new RecItems("Title6", "Desc6", "100"));
    }
    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ProgramAdapter(recItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ProgramAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position) {
                instructions(position, likesCount);
            }
        });
    }

    public void instructions(int position, int[] arr){
        if (arr[position] == 200){
            Intent intent = new Intent(this, diy_paper_third_page.class);
            startActivity(intent);
        }else if (arr[position] == 34){

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sort1) {
            increasingSort(likesCount, recItems);
        } else if (id == R.id.sort2) {
            decreasingSort(likesCount, recItems);
        }
        return true;
    }

    private void increasingSort(int[] arr, ArrayList<RecItems> items) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            Object m = items.get(i);
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                items.set(j+1, items.get(j));
                j--;
            }
            arr[j + 1] = key;
            items.set(j + 1, (RecItems) m);
        }
        mAdapter.notifyDataSetChanged();
    }
    private void decreasingSort(int[] arr, ArrayList<RecItems> items) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            Object m = items.get(i);
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                items.set(j+1, items.get(j));
                j--;
            }
            arr[j + 1] = key;
            items.set(j + 1, (RecItems) m);
        }
        mAdapter.notifyDataSetChanged();
    }
}
