package bubtjobs.com.fragmentinpersonalinformation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    Fragment currentFrag;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentFrag=new InputFrag();

        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.myFragment,currentFrag);
        transaction.commit();
    }
}
