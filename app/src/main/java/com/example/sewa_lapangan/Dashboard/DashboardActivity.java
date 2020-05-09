package com.example.sewa_lapangan.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import com.example.sewa_lapangan.Booking.BookingActivity;
import com.example.sewa_lapangan.Profile.ProfileActivity;
import com.example.sewa_lapangan.R;
import com.example.sewa_lapangan.Tiket.TiketActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import de.hdodenhof.circleimageview.CircleImageView;

public class DashboardActivity extends AppCompatActivity {

//    implements AppBarLayout.OnOffsetChangedListener
//    private AppBarLayout appBarLayout;
//    public LinearLayout titleAppbar;
//    public Toolbar toolbar;
//    private boolean isHideTolbarView = false;
    private CircleImageView profile;
    private CardView menu_booking, menu_map, menu_tiket;
    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION  = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;

    private ViewFlipper v_fliiper;

    private AppBarLayout appbar;
    private CollapsingToolbarLayout collapsing;
    private ImageView coverImage;
    private FrameLayout framelayoutTitle;
    private LinearLayout linearlayoutTitle;
    private Toolbar toolbar;
    private TextView textviewTitle;
//
//    private void findViews() {
//        appbar = (AppBarLayout)findViewById( R.id.appbar );
//        collapsing = (CollapsingToolbarLayout)findViewById( R.id.collapsing );
//        coverImage = (ImageView)findViewById( R.id.imageview_placeholder );
//        framelayoutTitle = (FrameLayout)findViewById( R.id.framelayout_title );
//        linearlayoutTitle = (LinearLayout)findViewById( R.id.linearlayout_title );
//        toolbar = (Toolbar)findViewById( R.id.toolbar_app);
//        textviewTitle = (TextView)findViewById( R.id.textview_title );
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//        findViews();

        int images[] ={R.drawable.button, R.drawable.bg_spinner};

        v_fliiper = findViewById(R.id.v_flliper);

//        for (int i = 0; i < images.length; i++ ){
//            flliper(images[i]);
//        }

        for (int image : images){
            flliper(image);
        }

//        toolbar.setTitle("");
//        appbar.addOnOffsetChangedListener(this);
//
//        setSupportActionBar(toolbar);
//        startAlphaAnimation(textviewTitle, 0, View.INVISIBLE);


//        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
//        titleAppbar = findViewById(R.id.titlebar);
//
//        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("farhan");

        profile =  findViewById(R.id.profile);
        menu_booking = findViewById(R.id.menu_booking);
        menu_tiket = findViewById(R.id.menu_tiket);

//        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
//        collapsingToolbarLayout.setTitle("");
//
//        appBarLayout.addOnOffsetChangedListener(this);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        menu_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, BookingActivity.class);
                startActivity(i);
            }
        });

        menu_tiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, TiketActivity.class);
                startActivity(i);
            }
        });

    }

    public void flliper(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fliiper.addView(imageView);
        v_fliiper.setFlipInterval(4000);
        v_fliiper.setAutoStart(true);

        v_fliiper.setInAnimation(this, android.R.anim.slide_in_left);
        v_fliiper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

//    @Override
//    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
//        int maxScroll = appBarLayout.getTotalScrollRange();
//        float percentage = (float) Math.abs(offset) / (float) maxScroll;
//
//        handleAlphaOnTitle(percentage);
//        handleToolbarTitleVisibility(percentage);
//    }
//
//    private void handleToolbarTitleVisibility(float percentage) {
//        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {
//
//            if(!mIsTheTitleVisible) {
//                startAlphaAnimation(textviewTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
//                mIsTheTitleVisible = true;
//            }
//
//        } else {
//
//            if (mIsTheTitleVisible) {
//                startAlphaAnimation(textviewTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
//                mIsTheTitleVisible = false;
//            }
//        }
//    }
//
//    private void handleAlphaOnTitle(float percentage) {
//        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
//            if(mIsTheTitleContainerVisible) {
//                startAlphaAnimation(linearlayoutTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
//                mIsTheTitleContainerVisible = false;
//            }
//
//        } else {
//
//            if (!mIsTheTitleContainerVisible) {
//                startAlphaAnimation(linearlayoutTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
//                mIsTheTitleContainerVisible = true;
//            }
//        }
//    }
//
//    public static void startAlphaAnimation (View v, long duration, int visibility) {
//        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
//                ? new AlphaAnimation(0f, 1f)
//                : new AlphaAnimation(1f, 0f);
//
//        alphaAnimation.setDuration(duration);
//        alphaAnimation.setFillAfter(true);
//        v.startAnimation(alphaAnimation);
//    }
////
////    @Override
////    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
////
////        int maxScroll = appBarLayout.getTotalScrollRange();
////        float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
////
////        if (percentage == 1f && isHideTolbarView) {
//////            date_behavior.setVisibility(View.GONE);
////            titleAppbar.setVisibility(View.VISIBLE);
////            isHideTolbarView = !isHideTolbarView;
////        } else if (percentage < 1f && isHideTolbarView) {
//////            date_behavior.setVisibility(View.VISIBLE);
////            titleAppbar.setVisibility(View.GONE);
////            isHideTolbarView = !isHideTolbarView;
////        }
////    }
}