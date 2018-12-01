package com.example.jhams.loginbonito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_USUARIO = "usuario";
    public static final String EXTRA_DEFAULT_USER = "UserDefault";
    public static final int RESULT_CODE_LOGUEADO_EXITOSO = 2000;
    public static final int RESULT_CODE_CANCELADO = 2001;
    EditText txtUsuario;
    EditText txtPassword;
    Button btnLogin;
    Button btnSingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userdefault = this.getIntent().getStringExtra(EXTRA_DEFAULT_USER);
        txtUsuario = findViewById(R.id.txtUsuario );
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSingIn = findViewById(R.id.btnSingIn);

        txtUsuario.setText(userdefault);
        btnLogin.setOnClickListener(this);
        btnSingIn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnSingIn:
                SingIn();
                break;
        }

    }
    public  void SingIn(){
        Intent intent = new Intent(this,Registrar.class);
        startActivityForResult(intent, 0);

    }
    public void login(){
        if(txtUsuario.getText().toString().equals("admin")
                && txtPassword.getText().toString().equals("admin")){
            Toast.makeText(this, "Admin logueado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Loggeado.class);
            startActivityForResult(intent, 0);
            setResult(RESULT_CODE_LOGUEADO_EXITOSO, intent);
            finish();
        }else {
            Toast.makeText(this, "DATOS INCORRECTOS", Toast.LENGTH_SHORT).show();
        }
    }
}
