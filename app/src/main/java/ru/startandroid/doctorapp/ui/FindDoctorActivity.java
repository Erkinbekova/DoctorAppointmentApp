package ru.startandroid.doctorapp.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.startandroid.doctorapp.Constants;
import ru.startandroid.doctorapp.R;

public class FindDoctorActivity extends BaseActivity implements View.OnClickListener {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mCityPreference;
    private int mStateSelectedPosition;
    private int mSpecialistSelectedPosition;
    private int mPracticeSelectedPosition;
    private String mBetterDoctorURL = "http://www.betterdoctor.com";

    @Bind(R.id.specialtySearchButton)
    Button mSpecialtySearchButton;
    @Bind(R.id.cityEditText)
    TextView mCityEditText;
    @Bind(R.id.stateSpinner)
    Spinner mStateSpinner;
    @Bind(R.id.specialistSpinner)
    Spinner mSpecialistSpinner;
    @Bind(R.id.practiceSpinner)
    Spinner mPracticeSpinner;
//    @Bind(R.id.betterDoctorCreditTextView)
//    TextView mBetterDoctorCreditTextView;
    @Bind(R.id.findDoctorTitle)
    TextView mFindDoctorTitle;
    @Bind(R.id.chooseSpecialistTextView)
    TextView mChooseSpecialistTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        super.onCreateDrawer();
        ButterKnife.bind(this);
        mSpecialtySearchButton.setOnClickListener(this);
      //  mBetterDoctorCreditTextView.setOnClickListener(this);


//        Typeface questrialFont = Typeface.createFromAsset(getAssets(), "fonts/Questrial-Regular.otf");
//        mFindDoctorTitle.setTypeface(questrialFont);
//        mChooseSpecialistTextView.setTypeface(questrialFont);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mCityPreference = mSharedPreferences.getString(Constants.PREFERENCES_CITY_KEY, null);

        if (mCityPreference != null) {
            mCityEditText.setText(mCityPreference);
            mStateSpinner.setSelection(mSharedPreferences.getInt(Constants.PREFERENCES_STATE_KEY, 0));
            mSpecialistSpinner.setSelection(mSharedPreferences.getInt(Constants.PREFERENCES_SPECIALTY_KEY, 0));
            mPracticeSpinner.setSelection(mSharedPreferences.getInt(Constants.PREFERENCES_PRACTICE_KEY, 0));
        }
    }

    @Override
    public void onClick(View v) {
        if(v == mSpecialtySearchButton) {
            String specialty = mSpecialistSpinner.getSelectedItem().toString().toLowerCase().replace(" ", "-");
            String city = mCityEditText.getText().toString().toLowerCase();
            String state = mStateSpinner.getSelectedItem().toString().toLowerCase();
            String condition = mPracticeSpinner.getSelectedItem().toString().toLowerCase();
            mStateSelectedPosition = mStateSpinner.getSelectedItemPosition();
            mSpecialistSelectedPosition = mSpecialistSpinner.getSelectedItemPosition();
            mPracticeSelectedPosition=mPracticeSpinner.getSelectedItemPosition();

            if (!(city).equals("")) {
                addToSharedPreferences(mSpecialistSelectedPosition, city, mStateSelectedPosition,mPracticeSelectedPosition);
            }

            Intent intent = new Intent(FindDoctorActivity.this, DoctorListActivity.class);
            intent.putExtra("specialty", specialty);
            intent.putExtra("city", city);
            intent.putExtra("state", state);
            intent.putExtra("condition", condition);


            startActivity(intent);
        }

//        if(v == mBetterDoctorCreditTextView) {
//            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mBetterDoctorURL ));
//            startActivity(webIntent);
//        }
    }

    private void addToSharedPreferences(int specialty, String city, int state, int condition) {
        mEditor.putInt(Constants.PREFERENCES_SPECIALTY_KEY, specialty);
        mEditor.putString(Constants.PREFERENCES_CITY_KEY, city).apply();
        mEditor.putInt(Constants.PREFERENCES_STATE_KEY, state);
        mEditor.putInt(Constants.PREFERENCES_PRACTICE_KEY, condition);
        mEditor.commit();
    }
}
