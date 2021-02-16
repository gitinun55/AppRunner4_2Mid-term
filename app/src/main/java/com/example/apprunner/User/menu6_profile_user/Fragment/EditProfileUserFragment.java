package com.example.apprunner.User.menu6_profile_user.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apprunner.Organizer.menu1_home.Activity.MainActivity;
import com.example.apprunner.OrganizerAPI;
import com.example.apprunner.DB.ProfileUserDB;
import com.example.apprunner.R;
import com.example.apprunner.ResultQuery;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditProfileUserFragment extends Fragment {

    EditText FNameEdt,LNameEdt,TelEdt,IdEdt;
    TextView text_date;
    RadioButton selectedRadioButton;
    RadioGroup rd_gender;
    Button btn_bd,btn_submit;
    String gender,first_name,last_name,type,email,password,name_event;
    int id_user;

    public EditProfileUserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentHandle = inflater.inflate(R.layout.fragment_edit_profile_user, container, false);
        FNameEdt = fragmentHandle.findViewById(R.id.FNameEdt);
        LNameEdt = fragmentHandle.findViewById(R.id.LNameEdt);
        TelEdt = fragmentHandle.findViewById(R.id.telEdt);
        IdEdt = fragmentHandle.findViewById(R.id.idEdt);
        text_date = fragmentHandle.findViewById(R.id.text_date);
        rd_gender = fragmentHandle.findViewById(R.id.rd_gender );
        btn_bd = fragmentHandle.findViewById(R.id.btn_date);
        btn_submit = fragmentHandle.findViewById(R.id.btn_edit_profile);

        Bundle bundle = this.getArguments();
        if(bundle != null){
            id_user = getArguments().getInt("id_user");
            first_name = getArguments().getString("first_name");
            last_name = getArguments().getString("last_name");
            type = getArguments().getString("type");
        }

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
                        requireContext(), new DatePickerDialog.OnDateSetListener() {
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
                selectedRadioButton  = (RadioButton)getView().findViewById(rd_gender.getCheckedRadioButtonId());
                gender = selectedRadioButton.getText().toString();
                Toast.makeText(requireContext(), gender , Toast.LENGTH_LONG).show();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrganizerAPI service = retrofit.create(OrganizerAPI.class);
                Call<ResultQuery> call = service.edit_ProfileUser(id_user,new ProfileUserDB(FNameEdt.getText().toString(),
                        LNameEdt.getText().toString(),
                        TelEdt.getText().toString(),
                        IdEdt.getText().toString(),
                        gender,
                        text_date.getText().toString()));

                call.enqueue(new Callback<ResultQuery>() {
                    @Override
                    public void onResponse(Call<ResultQuery> call, Response<ResultQuery> response) {
                        Toast.makeText(requireContext(),"แก้ไขข้อมูลสำเร็จ",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ResultQuery> call, Throwable t) {
                        Toast.makeText(requireContext(),"แก้ไขข้อมูลไม่สำเร็จ",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return fragmentHandle;
    }
}