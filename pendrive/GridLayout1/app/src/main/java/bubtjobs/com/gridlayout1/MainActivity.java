package bubtjobs.com.gridlayout1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    Address address;
    ArrayList<Address>addresslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView)findViewById(R.id.gridView1);

        addresslist=new ArrayList<>();
        address=new Address("jalilur");
        addresslist.add(address);

        address=new Address("Rahman");
        addresslist.add(address);

        address=new Address("murtuza");
        addresslist.add(address);

        Adapter adapter=new Adapter(getApplicationContext(),addresslist);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
