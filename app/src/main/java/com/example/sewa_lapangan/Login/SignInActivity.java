package com.example.sewa_lapangan.Login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sewa_lapangan.Dashboard.DashboardActivity;
import com.example.sewa_lapangan.LupaKataSandi.LupaKataSandiActivity;
import com.example.sewa_lapangan.Profile.ProfileActivity;
import com.example.sewa_lapangan.R;
import com.example.sewa_lapangan.Register.RegisterActivity;

public class SignInActivity extends AppCompatActivity {

    private EditText email;
    private TextView regis, lupa;
    private Button login;
    public AlertDialog.Builder dialogBuilder;
    public AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        email = (EditText) findViewById(R.id.edt_email);
        regis = (TextView) findViewById(R.id.txt_sign_in);
        login = (Button) findViewById(R.id.btn_login);
        lupa = (TextView) findViewById(R.id.edt_forget);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });

        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this, LupaKataSandiActivity.class);
                startActivity(i);
            }
        });

        showAlertDialog();
    }

    private void showAlertDialog(){
        dialogBuilder = new AlertDialog.Builder(SignInActivity.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_splash, null);
        Button button = layoutView.findViewById(R.id.btn_dialog_sign);
        dialogBuilder.setView(layoutView);
        dialogBuilder.setCancelable(false);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}