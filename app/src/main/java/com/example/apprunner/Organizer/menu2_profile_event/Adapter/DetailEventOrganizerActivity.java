package com.example.apprunner.Organizer.menu2_profile_event.Adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apprunner.Organizer.menu2_profile_event.Activity.ListNameRegEventActivity;
import com.example.apprunner.R;
import com.squareup.picasso.Picasso;

public class DetailEventOrganizerActivity extends AppCompatActivity {

    TextView tv_event_name_organizer,tv_date_start_organizer,tv_date_end_organizer,tv_detail_organizer;
    String name_event,detail,type,name_producer,date_reg_start,date_reg_end,first_name,last_name,pic_event;
    Button btn_list_name;
    int id_user,id_add;
    ImageView imageView_organizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event_organizer);

        tv_event_name_organizer = (TextView) findViewById(R.id.tv_event_name_organizer);
        tv_date_start_organizer = (TextView) findViewById(R.id.tv_date_start_organizer);
        tv_date_end_organizer = (TextView) findViewById(R.id.tv_date_end_organizer);
        tv_detail_organizer = (TextView) findViewById(R.id.tv_detail_organizer);
        btn_list_name = (Button) findViewById(R.id.btn_list_name);
        imageView_organizer = (ImageView)findViewById(R.id.imageView_organizer);

        pic_event = getIntent().getExtras().getString("pic_event");
        name_event = getIntent().getExtras().getString("name_event");
        date_reg_start = getIntent().getExtras().getString("date_reg_start");
        date_reg_end = getIntent().getExtras().getString("date_reg_end");
        detail = getIntent().getExtras().getString("detail");
        type = getIntent().getExtras().getString("type");
        name_producer = getIntent().getExtras().getString("name_producer");
        id_add = getIntent().getExtras().getInt("id_add");
        id_user = getIntent().getExtras().getInt("id_user");
        first_name = getIntent().getExtras().getString("first_name");
        last_name = getIntent().getExtras().getString("last_name");

        Picasso.with(DetailEventOrganizerActivity.this).load(pic_event).into(imageView_organizer);
        tv_event_name_organizer.setText(name_event);
        tv_date_start_organizer.setText(date_reg_start);
        tv_date_end_organizer.setText(date_reg_end);
        tv_detail_organizer.setText(detail);

        btn_list_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type != null && type.equals("ผู้จัดกิจกรรม")) {
                    Intent intent = new Intent(DetailEventOrganizerActivity.this, ListNameRegEventActivity.class);
                    intent.putExtra("id_user", id_user);
                    intent.putExtra("first_name",first_name);
                    intent.putExtra("last_name",last_name);
                    intent.putExtra("type", type);
                    intent.putExtra("id_add", id_add);
                    intent.putExtra("name_event", name_event);
                    intent.putExtra("name_producer", name_producer);
                    startActivity(intent);
                }
                if (type != null && type.equals("นักวิ่ง")) {

                }
            }
        });
    }
}