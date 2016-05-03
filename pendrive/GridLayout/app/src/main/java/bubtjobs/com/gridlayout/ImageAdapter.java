package bubtjobs.com.gridlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Murtuza on 3/15/2016.
 */
public class ImageAdapter  extends BaseAdapter{
    private Context mContext;
    public Integer[] mthumb={

            R.drawable.pic_1,R.drawable.pic_2,
            R.drawable.pic_3,R.drawable.pic_4,
            R.drawable.pic_5,R.drawable.pic_6,
            R.drawable.pic_7,R.drawable.pic_8,
            R.drawable.pic_1,R.drawable.pic_2,
            R.drawable.pic_3,R.drawable.pic_4,
            R.drawable.pic_5,R.drawable.pic_6,
            R.drawable.pic_7,R.drawable.pic_8,
    };

    public ImageAdapter(Context c)
    {
       mContext=c;
    }

    @Override
    public int getCount() {
        return mthumb.length;
    }

    @Override
    public Object getItem(int position) {
        return mthumb[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView=new ImageView(mContext);
        imageView.setImageResource(mthumb[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70,70));

        return imageView;
    }
}
