package com.example.apprunner.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apprunner.Organizer.menu1_home.Activity.MainActivity;
import com.example.apprunner.OrganizerAPI;
import com.example.apprunner.R;
import com.example.apprunner.ResultQuery;
import com.example.apprunner.DB.userDB;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class
RegisterappActivity extends AppCompatActivity {

    Button btn_submit_reg,btn_cancel,btn_bd;
    EditText text_FName,text_LName,text_Email,text_Password,text_weight,text_height;
    TextView text_date;
    RadioGroup rd_gender,rd_type;
    RadioButton selectedRadioButton;
    String type,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerapp);

        btn_bd = findViewById(R.id.bt_date);
        text_date = findViewById(R.id.text_date);
        btn_submit_reg = findViewById(R.id.btn_register);
        text_FName = findViewById(R.id.id_FName);
        text_LName = findViewById(R.id.id_LName);
        text_Email = findViewById(R.id.id_email);
        text_Password = findViewById(R.id.id_password);
        rd_gender = findViewById(R.id.rd_gender);
        rd_type = findViewById(R.id.rd_type);
        text_weight = findViewById(R.id.id_weight);
        text_height = findViewById(R.id.id_height);
        btn_cancel = findViewById(R.id.btn_cancel);


        MainActivity mainActivity = new MainActivity();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mainActivity.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Calendar calendar_bd = Calendar.getInstance();
        final int year = calendar_bd.get(Calendar.YEAR);
        final int month = calendar_bd.get(Calendar.MONTH);
        final int day = calendar_bd.get(Calendar.DAY_OF_MONTH);

        btn_bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegisterappActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day + "/" + month + "/" + year;
                        text_date.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        rd_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedRadioButton  = (RadioButton)findViewById(rd_gender.getCheckedRadioButtonId());
                gender = selectedRadioButton.getText().toString();
                Toast.makeText(RegisterappActivity.this, gender , Toast.LENGTH_LONG).show();
            }
        });


        rd_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedRadioButton  = (RadioButton)findViewById(rd_type.getCheckedRadioButtonId());
                type = selectedRadioButton.getText().toString();
                Toast.makeText(RegisterappActivity.this, type , Toast.LENGTH_LONG).show();
            }
        });


        btn_submit_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrganizerAPI service = retrofit.create(OrganizerAPI.class);
                Call<ResultQuery> call = service.insertRegister(new userDB(text_FName.getText().toString(),
                        text_LName.getText().toString(),
                        text_Email.getText().toString(),
                        text_Password.getText().toString(),
                        gender,
                        text_date.getText().toString(),
                        text_weight.getText().toString(),
                        text_height.getText().toString(),
                        type));

                call.enqueue(new Callback<ResultQuery>() {
                    @Override
                    public void onResponse(Call<ResultQuery> call, Response<ResultQuery> response) {
                        Toast.makeText(RegisterappActivity.this,"ลงทะเบียนเสร็จสิ้นโปรดรอแอดมินอนุมัติ",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ResultQuery> call, Throwable t) {
                        Toast.makeText(RegisterappActivity.this,"ข้อมูลของท่านยังกรอกไม่ครบกรุณาลองใหม่อีกครั้ง",Toast.LENGTH_LONG).show();
                    }
                });
                openLoginActivity();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backLoginActivity();
            }
        });

    }

    private void backLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}