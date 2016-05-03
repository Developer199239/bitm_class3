package bubtjobs.com.fragmentpractics;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button frag1,frag2,frag3;

    Fragment currentFrag;
    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1=(Button)findViewById(R.id.fragment1);
        frag2=(Button)findViewById(R.id.fragment2);
        frag3=(Button)findViewById(R.id.fragment3);

        frag1.setOnClickListener(this);
        frag2.setOnClickListener(this);
        frag3.setOnClickListener(this);

        currentFrag=new FragmentStart();
        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.myFragment,currentFrag);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.fragment1:
                currentFrag=new Fragment1();
                break;
            case R.id.fragment2:
                currentFrag=new Fragment2();
                break;
            case R.id.fragment3:
                currentFrag=new Fragment3();
                break;
        }

        transaction=manager.beginTransaction();
        transaction.replace(R.id.myFragment,currentFrag);
        transaction.commit();
    }
}
