package ru.startandroid.doctorapp;
public class Constants {
    public static final String BETTER_DOCTOR_CONSUMER_KEY = BuildConfig.BETTER_DOCTOR_CONSUMER_KEY;
    public static final String BETTER_DOCTOR_BASE_URL = "https://api.betterdoctor.com/2016-03-01/doctors?";
    //https://api.betterdoctor.com/2016-03-01/practices/0/doctors?skip=0&limit=10&user_key=aa831b87f1b3f332e84b57ef1b0b3f0a
   // https://api.betterdoctor.com/2016-03-01/conditions?user_key=aa831b87f1b3f332e84b57ef1b0b3f0a
    public static final String BETTER_DOCTOR_SPECIALTY_QUERY_PARAMETER = "specialty_uid";
    public static final String BETTER_DOCTOR_PRACTICE_QUERY_PARAMETER = "practice_uid";
    public static final String BETTER_DOCTOR_LOCATION_QUERY_PARAMETER = "location";
    public static final String API_KEY_QUERY_PARAMETER = "user_key";
    public static final String FIREBASE_CHILD_DOCTORS = "doctors";
    public static final String FIREBASE_CHILD_AILMENTS = "ailments";
    public static final String PREFERENCES_SPECIALTY_KEY = "specialtySpinnerSelection";
    public static final String PREFERENCES_PRACTICE_KEY = "practiceSpinnerSelection";
    public static final String PREFERENCES_CITY_KEY = "city";
    public static final String PREFERENCES_STATE_KEY = "stateSpinnerSelection";
}
