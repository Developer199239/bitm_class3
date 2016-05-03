package bubtjobs.com.fragmentinpersonalinformation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Murtuza on 3/24/2016.
 */
public class PersonAdapter extends ArrayAdapter<Person> {
    private ArrayList<Person> personList;
    private Context context;

    public PersonAdapter(Context context,  ArrayList<Person> personList) {
        super(context, R.layout.custom_row, personList);
        this.context = context;
        this.personList = personList;
    }

    static class ViewHolder {
        TextView nameTv;
        TextView emailTv;
        TextView idTv;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_row, null);

            viewHolder = new ViewHolder();
            viewHolder.nameTv = (TextView) convertView.findViewById(R.id.name);
            viewHolder.emailTv = (TextView) convertView.findViewById(R.id.email);
            viewHolder.idTv = (TextView) convertView.findViewById(R.id.id);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.nameTv.setText(personList.get(position).getName());
        viewHolder.emailTv.setText(personList.get(position).getEmail());
        viewHolder.idTv.setText(personList.get(position).getId());

        return convertView;
    }
}

