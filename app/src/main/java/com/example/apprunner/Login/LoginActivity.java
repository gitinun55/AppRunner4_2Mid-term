package com.example.apprunner.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apprunner.Organizer.menu1_home.Activity.MainActivity;
import com.example.apprunner.OrganizerAPI;
import com.example.apprunner.R;
import com.example.apprunner.ResultQuery;
import com.example.apprunner.User.menu1_home.Activity.SecondActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

  EditText edtemail;
  EditText edtPassword;
  Button btnLogin,btnReg;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    edtemail = (EditText) findViewById(R.id.bt_email);
    edtPassword = (EditText) findViewById(R.id.bt_password);
    btnLogin = (Button) findViewById(R.id.bt_login);
    btnReg = (Button) findViewById(R.id.bt_reg);

    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String username = edtemail.getText().toString();
        String password = edtPassword.getText().toString();
        //validate form
        if(validateLogin(username, password)){
          //do login
          doLogin(username, password);
        }
      }

      private boolean validateLogin(String email, String password) {
        if(email==null || email.trim().length() == 0){
          Toast.makeText(LoginActivity.this,"email is required",Toast.LENGTH_SHORT).show();
          return false;
        }
        if(password == null || password.trim().length() == 0){
          Toast.makeText(LoginActivity.this, "Password is required", Toast.LENGTH_SHORT).show();
          return false;
        }
        return true;
      }

      private void doLogin(String email, String password) {
        MainActivity mainActivity = new MainActivity();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mainActivity.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OrganizerAPI service = retrofit.create(OrganizerAPI.class);
        Call call = service.login(email,password);
        call.enqueue(new Callback() {
          @Override
          public void onResponse(Call call, Response response) {
            if(response.isSuccessful()){
              //.makeText(LoginActivity.this, "Response", Toast.LENGTH_SHORT).show();
              ResultQuery resultQuery = (ResultQuery) response.body();
              if(resultQuery.getType().equals("นักวิ่ง")){
                Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
                intent.putExtra("id_user", resultQuery.getId());
                intent.putExtra("first_name", resultQuery.getFirst_name());
                intent.putExtra("last_name", resultQuery.getLast_name());
                intent.putExtra("type", resultQuery.getType());
                intent.putExtra("email", resultQuery.getEmail());
                intent.putExtra("password", resultQuery.getPassword());
                startActivity(intent);
              }
              if(resultQuery.getType().equals("ผู้จัดกิจกรรม")){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("id_user", resultQuery.getId());
                intent.putExtra("first_name", resultQuery.getFirst_name());
                intent.putExtra("last_name", resultQuery.getLast_name());
                intent.putExtra("type", resultQuery.getType());
                intent.putExtra("email", resultQuery.getEmail());
                intent.putExtra("password", resultQuery.getPassword());
                startActivity(intent);
              }
              Toast.makeText(LoginActivity.this, "เข้าสู่ระบบสำเร็จ", Toast.LENGTH_SHORT).show();                        }
          }

          @Override
          public void onFailure(Call call, Throwable t) {
            Toast.makeText(LoginActivity.this, "เข้าสู่ระบบไม่สำเร็จ", Toast.LENGTH_SHORT).show();
          }
        });

      }
    });

    btnReg.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        openRegisterappActivity();
      }
    });
  }

  private void openRegisterappActivity() {
    Intent intent = new Intent(this, RegisterappActivity.class);
    startActivity(intent);
  }

}
