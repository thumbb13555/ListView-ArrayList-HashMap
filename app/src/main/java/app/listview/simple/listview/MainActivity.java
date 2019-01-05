package app.listview.simple.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String[] fruitNames = {"Apple", "Banana", "Grapes", "Cherry", "Blackberry", "Blueberry", "Coconut", "Orange", "Pineapple", "Peach", "Strawberry"};
    int[] fruitImages = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10, R.drawable.pic11};
    ListView SimpleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleListView = findViewById(R.id.SimpleArrayAdapter);

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>(); //HashMap add data to Arraylist

        for (int i = 0; i<fruitNames.length; i++) {

            HashMap<String, String> hashMap = new HashMap<>(); //Hashmap to put items in the list
            hashMap.put("name", fruitNames[i]);
            hashMap.put("Image", fruitImages[i]+"");
            arrayList.add(hashMap);
        }

        String[] from = {"name", "Image"};
        int[] to = {R.id.Fruit_Names, R.id.Fruit_Images};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.list_items, from, to);

        SimpleListView.setAdapter(simpleAdapter);

        SimpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, fruitNames[i], Toast.LENGTH_LONG).show();
            }
        });
    }
}
