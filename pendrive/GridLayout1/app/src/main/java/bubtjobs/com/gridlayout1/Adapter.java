package bubtjobs.com.gridlayout1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Murtuza on 3/15/2016.
 */
public class Adapter extends ArrayAdapter<Address>{

    private ArrayList<Address> contactList;
    private Context context;

    public Adapter(Context context, ArrayList<Address> contactList) {
        super(context, R.layout.row,contactList);
        this.context=context;
        this.contactList=contactList;
    }

    static class ViewHolder{
        TextView text;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.row,null);

            viewHolder=new ViewHolder();
            viewHolder.text=(TextView)convertView.findViewById(R.id.text);
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.image);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.text.setText(contactList.get(position).getName());
        viewHolder.imageView.setImageResource(R.drawable.pic_10);

//        viewHolder.item1.setText(contactList.get(position).getOp1());
//        viewHolder.item2.setText(contactList.get(position).getOp2());
//        viewHolder.item3.setText(contactList.get(position).getOp3());
//        viewHolder.item4.setText(contactList.get(position).getOp4());
        // viewHolder.idTv.setText(""+contactList.get(position).getId());


        return convertView;
    }
}
