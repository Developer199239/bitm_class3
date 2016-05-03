package bubtjobs.com.fragmentinpersonalinformation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


/**
 * Created by Murtuza on 3/15/2016.
 */
public class DataBaseManager {
    private DataBaseHelper helper;
    private SQLiteDatabase database;
    Context context;


    public DataBaseManager(Context context){
        helper=new DataBaseHelper(context);
        this.context=context;
    }

    private void open(){
        database=helper.getWritableDatabase();
    }

    private void close(){
        helper.close();
    }

    public String addContact(Person person){
        try {
            this.open();
            ContentValues contentValues=new ContentValues();
            contentValues.put(DataBaseHelper.NAME,person.getName());
            contentValues.put(DataBaseHelper.EMAIL, person.getEmail());

            long insert=database.insert(DataBaseHelper.TABLE_STUDENTINFO,null,contentValues);
            this.close();
            if(insert>0)
            return  "yes";
            else
                return "no";
        }
        catch (Exception e){
            this.close();
            return  e.toString();
        }


    }

    public ArrayList<Person> getList(){
        ArrayList<Person>list=new ArrayList<>();
        try{
           this.open();

            String sql="select * from "+DataBaseHelper.TABLE_STUDENTINFO;
            Cursor cursor=database.rawQuery(sql,null);
            cursor.moveToFirst();
            if(cursor!=null && cursor.getCount()>0){

                for(int i=0;i<cursor.getCount();i++)
                {
                    String id=cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_ID));
                    String name=cursor.getString(cursor.getColumnIndex(DataBaseHelper.NAME));
                    String email=cursor.getString(cursor.getColumnIndex(DataBaseHelper.EMAIL));
                    Person person=new Person(name,email,id);
                    list.add(person);
                    cursor.moveToNext();
                }
            }

            this.close();
            return list;
        }
        catch (Exception e){
            this.close();
            return  list;
        }
    }

}
