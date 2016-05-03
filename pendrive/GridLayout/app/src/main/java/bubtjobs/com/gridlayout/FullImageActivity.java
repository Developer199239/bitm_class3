package bubtjobs.com.gridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        Intent i = getIntent();

        int positon=i.getExtras().getInt("id");

        ImageAdapter imageAdapter=new ImageAdapter(this);

        ImageView imageView=(ImageView)findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mthumb[positon]);
    }
}
