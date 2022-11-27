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

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        configureLoginButton();
    }

    private void configureLoginButton(){
        Button LoginButton = (Button) findViewById(R.id.Login_button);
        EditText mail = (EditText) findViewById(R.id.textMail);
        EditText password = (EditText) findViewById(R.id.textPassword);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Swagger swagger = Swagger.retrofit.create(Swagger.class);
                //String mail = mail.getText().toString();
                //String password = password.getText().toString();
                Call<Users> call = swagger.getPosts(password.toString(),mail.toString());
                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        Snackbar mySnackbar = Snackbar.make(view, "Inicio de Sesion correcto", BaseTransientBottomBar.LENGTH_SHORT);
                        mySnackbar.show();
                        startActivity(new Intent(LoginActivity.this, PrincipalActivity.class));
                    }
                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        Snackbar mySnackbar = Snackbar.make(view, "No se ha podido Iniciar Sesion", BaseTransientBottomBar.LENGTH_SHORT);
                        mySnackbar.show();
                    }
                });
            }
        });
    }
}