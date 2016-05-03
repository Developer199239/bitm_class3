package bitm.com.lt.lab3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mobile App Develop on 16-3-16.
 */
public class AdapterForContact extends ArrayAdapter<Contact> {

    private ArrayList<Contact> contactList;
    private Context context;

    public AdapterForContact(Context context, ArrayList<Contact> contactList) {
        super(context, R.layout.custom_row,contactList);
        this.context=context;
        this.contactList=contactList;
    }

    static class ViewHolder{
        TextView nameTv;
        TextView phoneTv;
        ImageButton smsButton,callButton;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.custom_row,null);

            viewHolder=new ViewHolder();
            viewHolder.nameTv=(TextView)convertView.findViewById(R.id.nameTv);
            viewHolder.phoneTv=(TextView)convertView.findViewById(R.id.phoneTv);
            viewHolder.smsButton=(ImageButton)convertView.findViewById(R.id.smsButton);
            viewHolder.callButton=(ImageButton)convertView.findViewById(R.id.callButton);



            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTv.setText(contactList.get(position).getName());
        viewHolder.phoneTv.setText(contactList.get(position).getNumber());


        viewHolder.smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "sms", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("smsto:" + viewHolder.phoneTv.getText().toString());
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                smsIntent.putExtra("sms_body","I am Jalilur Rahman");


                context.startActivity(smsIntent);
            }
        });
        viewHolder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context,"call",Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                callIntent.setData(Uri.parse("tel:" +viewHolder.phoneTv.getText().toString()));
                context.startActivity(callIntent);
            }
        });



        return convertView;
    }
}
