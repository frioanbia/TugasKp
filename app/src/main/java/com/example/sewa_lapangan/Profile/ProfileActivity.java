package com.example.sewa_lapangan.Profile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sewa_lapangan.Booking.BookingActivity;
import com.example.sewa_lapangan.GantiPassword.GantiPasswordActivity;
import com.example.sewa_lapangan.HistoryBooking.HistoryBookingActivity;
import com.example.sewa_lapangan.Profile.EditProfile.EditProfileActivity;
import com.example.sewa_lapangan.R;

public class ProfileActivity extends AppCompatActivity {

    private TextView edit_profile, ganti_password, history_booking;
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog alertdialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        edit_profile = findViewById(R.id.edit_profile);
        ganti_password = findViewById(R.id.ganti_password);
        history_booking = findViewById(R.id.history_booking);

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });

        ganti_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        history_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HistoryBookingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showAlertDialog(){
        dialogbuilder = new AlertDialog.Builder(ProfileActivity.this);
        View layoutView = getLayoutInflater().inflate(R.layout.activity_ganti_password, null);
        Button button = layoutView.findViewById(R.id.btn_reset_pass);
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
