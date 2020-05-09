package com.example.sewa_lapangan.Booking;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sewa_lapangan.Login.SignInActivity;
import com.example.sewa_lapangan.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BookingActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog alertdialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
        fab = findViewById(R.id.floating);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

    }

    private void showAlertDialog(){
        dialogbuilder = new AlertDialog.Builder(BookingActivity.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_booking, null);
        Button button = layoutView.findViewById(R.id.btn_booking);
        dialogbuilder.setView(layoutView);
        dialogbuilder.setCancelable(true);
        alertdialog = dialogbuilder.create();
        alertdialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertdialog.show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertdialog.dismiss();
            }
        });
    }
}