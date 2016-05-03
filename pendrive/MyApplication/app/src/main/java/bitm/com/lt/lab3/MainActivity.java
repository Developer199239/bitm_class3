package bitm.com.lt.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Contact contact;
    ArrayList<Contact>contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);

        contactList=new ArrayList<>();

        contact=new Contact();
        contact=new Contact("Jalilur","22244455");
        contactList.add(contact);

        contact=new Contact("Rahman","33344455");
        contactList.add(contact);

        contact=new Contact("Tarikul","66644455");
        contactList.add(contact);

        if(contactList!=null)
        {
            AdapterForContact adapter=new AdapterForContact(getApplicationContext(),contactList);
            listView.setAdapter(adapter);
        }

    }

}
