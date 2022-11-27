package com.example.appproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appproyecto.modelo.Swagger;
import com.example.appproyecto.modelo.Users;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        configureRegisterButton();
    }

    private void configureRegisterButton(){
        Button LoginButton = (Button) findViewById(R.id.Login_button);
        EditText mail = (EditText) findViewById(R.id.Mail);
        EditText password = (EditText) findViewById(R.id.textPassword);
        EditText surname = (EditText) findViewById(R.id.Surname);
        EditText name = (EditText) findViewById(R.id.Name);
        EditText username = (EditText) findViewById(R.id.textMail);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Swagger swagger = Swagger.retrofit.create(Swagger.class);
                Call<Users> call = swagger.getRegister(name.toString(),username.toString(),mail.toString(),surname.toString(),password.toString());
                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        Snackbar mySnackbar = Snackbar.make(view, "Registro correcto", BaseTransientBottomBar.LENGTH_SHORT);
                        mySnackbar.show();
                        startActivity(new Intent(RegisterActivity.this, PrincipalActivity.class));
                    }
                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        Snackbar mySnackbar = Snackbar.make(view, "Registro Incorrecto", BaseTransientBottomBar.LENGTH_SHORT);
                        mySnackbar.show();
                    }
                });
            }
        });
    }
}