package com.dinaro.activities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dinaro.R;

public class HomeActivity extends AppCompatActivity {

    TextView txtSettings, txtActivity;
    ImageView imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        initiateView();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        activityClicked();
        txtActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityClicked();

                if (navController.getCurrentDestination().getId() == R.id.activityFragment) {


                } else if (navController.getCurrentDestination().getId() == R.id.homeFragment) {

                    navController.navigate(R.id.action_homeFragment_to_activityFragment);


                } else if (navController.getCurrentDestination().getId() == R.id.settingsFragment) {

                    navController.navigate(R.id.action_settingsFragment_to_activityFragment);

                }else if (navController.getCurrentDestination().getId() == R.id.searchCalendarFragment) {

                    navController.navigate(R.id.action_searchCalendarFragment_to_activityFragment);

                }
            }
        });


        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                homeClicked();

                if (navController.getCurrentDestination().getId() == R.id.activityFragment) {


                    navController.navigate(R.id.action_activityFragment_to_homeFragment);

                } else if (navController.getCurrentDestination().getId() == R.id.homeFragment) {


                } else if (navController.getCurrentDestination().getId() == R.id.settingsFragment) {

                    navController.navigate(R.id.action_settingsFragment_to_homeFragment);

                }else if (navController.getCurrentDestination().getId() == R.id.searchCalendarFragment) {

                    navController.navigate(R.id.action_searchCalendarFragment_to_homeFragment);

                }
            }
        });


        txtSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingsClicked();
                if (navController.getCurrentDestination().getId() == R.id.activityFragment) {
                    navController.navigate(R.id.action_activityFragment_to_settingsFragment);

                } else if (navController.getCurrentDestination().getId() == R.id.homeFragment) {
                    navController.navigate(R.id.action_homeFragment_to_settingsFragment);


                } else if (navController.getCurrentDestination().getId() == R.id.settingsFragment) {

                }else if (navController.getCurrentDestination().getId() == R.id.searchCalendarFragment) {

                    navController.navigate(R.id.action_searchCalendarFragment_to_settingsFragment);

                }
            }
        });


    }




    private void homeClicked(){
        int colorPrimary = getResources().getColor(R.color.colorAccent);
        int colorDefault = getResources().getColor(R.color.colorGreyPrimary);

        imageViewHome.setImageResource(R.drawable.ic_clicked_home);
        txtActivity.setTextColor(colorDefault);
        txtSettings.setTextColor(colorDefault);

        txtSettings.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColorBack(this,R.drawable.ic_settings) , null, null);
        txtActivity.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColorBack(this,R.drawable.ic_activity) , null, null);




    }

    private void activityClicked(){
        int colorPrimary = getResources().getColor(R.color.colorAccent);
        int colorDefault = getResources().getColor(R.color.colorGreyPrimary);

        imageViewHome.setImageResource(R.drawable.ic_non_clicked);


        txtActivity.setTextColor(colorPrimary);
        txtActivity.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColor(this,R.drawable.ic_activity) , null, null);


        txtSettings.setTextColor(colorDefault);
        txtSettings.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColorBack(this,R.drawable.ic_setting) , null, null);


    }

    private void settingsClicked(){
        int colorPrimary = getResources().getColor(R.color.colorAccent);
        int colorDefault = getResources().getColor(R.color.colorGreyPrimary);

        imageViewHome.setImageResource(R.drawable.ic_non_clicked);


        txtSettings.setTextColor(colorPrimary);
        txtSettings.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColor(this,R.drawable.ic_setting) , null, null);


        txtActivity.setTextColor(colorDefault);
        txtActivity.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColorBack(this,R.drawable.ic_activity) , null, null);


    }
    private Drawable changeIconColor(Context context , int drawable){
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, drawable);
        assert unwrappedDrawable != null;
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.colorAccent));

        return wrappedDrawable;

    }
    private Drawable changeIconColorBack(Context context , int drawable){
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, drawable);
        assert unwrappedDrawable != null;
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.grey));

        return wrappedDrawable;

    }



    private void initiateView() {

        txtSettings = findViewById(R.id.txtSettings);
        txtActivity = findViewById(R.id.txtActivity);
        imageViewHome = findViewById(R.id.imageViewHome);


    }

}
