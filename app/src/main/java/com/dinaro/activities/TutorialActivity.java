package com.dinaro.activities;

import android.content.Intent;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.dinaro.R;
import com.dinaro.adapters.TutorialAdapter;
import com.dinaro.databinding.ActivityTutorialBinding;
import com.dinaro.utils.PrefManager;

import java.util.Timer;
import java.util.TimerTask;

public class TutorialActivity extends AppCompatActivity implements View.OnClickListener {


    private static int num = 2;
    private static int currentpage = 0;
    private static ActivityTutorialBinding mBinding;

    @BindingAdapter({"bind:handler"})
    public static void bindViewPagerAdapter(final ViewPager pager, final TutorialActivity activity) {

        final TutorialAdapter adapter = new TutorialAdapter(pager.getContext(), activity.getSupportFragmentManager(), num);
        pager.setAdapter(adapter);

        mBinding.circleIndicator.setViewPager(pager);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentpage == num) {
                    currentpage = 0;
                }
                pager.setCurrentItem(currentpage++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 10000, 10000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_tutorial);
        TutorialActivity mContext = this;
        PrefManager.savePref(mContext,"IsFirstLogin","1");
        mBinding.setHandler(this);
        mBinding.btnSkip.setOnClickListener(this);
        mBinding.setManager(getSupportFragmentManager());
        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {


            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (mBinding.viewPager.getCurrentItem() == 1) {
                    mBinding.btnSkip.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(TutorialActivity.this, LoginActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("2", "xyz");
                            i.putExtras(bundle);
                            startActivity(i);
                            finishAffinity();
                        }
                    });

                    mBinding.btnSkip.setText("Get started");

                    mBinding.btnGetStarted.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(TutorialActivity.this, LoginActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("2", "xyz");
                            i.putExtras(bundle);
                            startActivity(i);
                            finishAffinity();



                        }
                    });

                } else {
                    mBinding.btnSkip.setText("Skip ");

                    mBinding.btnSkip.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mBinding.viewPager.setCurrentItem(currentpage++, true);
                        }
                    });
                    mBinding.btnGetStarted.setVisibility(View.GONE);


                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(TutorialActivity.this, LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("2", "xyz");
        i.putExtras(bundle);
        startActivity(i);
        finishAffinity();
    }
}
