package bubtjobs.com.fragmentinpersonalinformation;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFrag extends Fragment {
    EditText nameEt,emailEt;
    Button submitBt,showViewBt;
    DataBaseManager manager;
    Person person;

    public InputFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_input, container, false);
        manager=new DataBaseManager(getActivity());
        person=new Person();
        nameEt=(EditText)view.findViewById(R.id.nameEt);
        emailEt=(EditText)view.findViewById(R.id.emailEt);

        submitBt=(Button)view.findViewById(R.id.submitBt);
        showViewBt=(Button)view.findViewById(R.id.showContactBt);

        showViewBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person=new Person(nameEt.getText().toString(),emailEt.getText().toString());

                String insert=manager.addContact(person);

                if(insert.equals("yes"))
                {
//                   // Toast.makeText(getActivity(),"ok",Toast.LENGTH_LONG).show();
//
//
//                    ArrayList<Person> list=new ArrayList<Person>();
//                    list=manager.getList();
//
//
//                    for(Person obj:list){
//                        Toast.makeText(getActivity(),""+obj.getEmail(),Toast.LENGTH_LONG).show();
//                    }

                    showPersonList fragment=new showPersonList();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction transaction=manager.beginTransaction();
                    transaction.replace(R.id.myFragment,fragment);
                    transaction.commit();
                }
                else{
                    Toast.makeText(getActivity(),"No",Toast.LENGTH_LONG).show();
                }
            }
        });


        return  view;
    }

}
