package bubtjobs.com.fragmentinpersonalinformation;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetatilsFragment extends Fragment {


    public DetatilsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_detatils, container, false);

        String retriveId=getArguments().getString("id","");
        Toast.makeText(getActivity(),retriveId,Toast.LENGTH_LONG).show();

        return view;
    }

}
