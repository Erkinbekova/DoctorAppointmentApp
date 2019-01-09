package ru.startandroid.doctorapp.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.startandroid.doctorapp.R;
import ru.startandroid.doctorapp.adapters.AilmentPagerAdapter;
import ru.startandroid.doctorapp.models.Ailment;

public class AilmentDetailActivity extends BaseActivity {
    @Bind(R.id.viewPager)
    ViewPager mViewPager;
    private AilmentPagerAdapter adapterViewPager;
    ArrayList<Ailment> mAilments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ailment_detail);
        super.onCreateDrawer();
        ButterKnife.bind(this);

        mAilments = Parcels.unwrap(getIntent().getParcelableExtra("ailments"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new AilmentPagerAdapter(getSupportFragmentManager(), mAilments);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
