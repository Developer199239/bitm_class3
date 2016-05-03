package bubtjobs.com.fragmentinpersonalinformation;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class showPersonList extends Fragment {

    ListView listView;
    DataBaseManager manager;
    ArrayList<Person>arrayList;
    Person person;
    public showPersonList() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_show_person_list, container, false);
        listView=(ListView)view.findViewById(R.id.listView);


        manager=new DataBaseManager(getActivity());
        person=new Person();
        arrayList=new ArrayList<>();

        arrayList=manager.getList();
        if (arrayList!=null)
        {

            PersonAdapter adapter=new PersonAdapter(view.getContext(),arrayList);
            listView.setAdapter(adapter);

        }
        else{
            Toast.makeText(getActivity(),"empty",Toast.LENGTH_LONG).show();
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(),position+" "+arrayList.get(position).getEmail(),Toast.LENGTH_LONG).show();

                DetatilsFragment fragment=new DetatilsFragment();
                FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();

                Bundle bundle=new Bundle();
                bundle.putString("id",arrayList.get(position).getId());

                fragment.setArguments(bundle);

                transaction.replace(R.id.myFragment,fragment);
                transaction.commit();
            }
        });

        return view;
    }

}
