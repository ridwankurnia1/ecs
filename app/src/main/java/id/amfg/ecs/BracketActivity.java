package id.amfg.ecs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BracketActivity extends AppCompatActivity {
    Calendar myCalendar;
    CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7,chk8,chk9,chk10,chk11;
    EditText txtJamStart, txtJamStartChk9, txtHasilSealant, txtTanggal, txtJamProses;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        txtTanggal = (EditText) findViewById(R.id.txtTanggal);
        txtJamProses = (EditText) findViewById(R.id.txtJamProses);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateTxtTanggal();
            }
        };

        txtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(BracketActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txtJamProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;


                mTimePicker = new TimePickerDialog(BracketActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        if (selectedMinute < 10){
                            if (selectedHour<10){
                                txtJamProses.setText("0"+selectedHour + ":0" + selectedMinute);
                            } else {
                                txtJamProses.setText(selectedHour + ":0" + selectedMinute);
                            }
                        } else if (selectedHour < 10){
                            if (selectedHour < 10){
                                if (selectedMinute < 10){
                                    txtJamProses.setText("0"+selectedHour + ":0" + selectedMinute);
                                } else {
                                    txtJamProses.setText("0"+selectedHour + ":" + selectedMinute);
                                }
                            }
                        } else {
                            txtJamProses.setText(selectedHour + ":" + selectedMinute);
                        }
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        String mp = getIntent().getStringExtra("mp");

        switch (mp){
            /*case "mp1":
                break;
            case "mp2":
                break;
            case "mp3":
                break;*/
            case "mp4":
                bracketMp4();
                break;
            case "mp5":
                bracketMp5();
                break;
            default:
                break;
        }

    }

    private void bracketMp4(){
        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);
        chk4 = (CheckBox) findViewById(R.id.chk4);
        chk6 = (CheckBox) findViewById(R.id.chk6);
        chk8 = (CheckBox) findViewById(R.id.chk8);
        chk9 = (CheckBox) findViewById(R.id.chk9);
        chk10 = (CheckBox) findViewById(R.id.chk10);
        chk11 = (CheckBox) findViewById(R.id.chk11);

        txtJamStart = (EditText) findViewById(R.id.txtJamStart);
        txtJamStartChk9 = (EditText) findViewById(R.id.txtJamStartChk9);
        txtHasilSealant = (EditText) findViewById(R.id.txtHasilSealant);

        chk1.setEnabled(false);
        chk2.setEnabled(false);
        chk3.setEnabled(false);
        chk4.setEnabled(false);
        chk6.setEnabled(false);

        chk8.setEnabled(true);
        chk9.setEnabled(true);
        chk10.setEnabled(true);
        chk11.setEnabled(true);

        txtJamStart.setEnabled(false);

        txtJamStartChk9.setEnabled(true);
        txtHasilSealant.setEnabled(true);

        txtJamStartChk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;

                mTimePicker = new TimePickerDialog(BracketActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        if (selectedMinute < 10){
                            if (selectedHour<10){
                                txtJamStartChk9.setText("0"+selectedHour + ":0" + selectedMinute);
                            } else {
                                txtJamStartChk9.setText(selectedHour + ":0" + selectedMinute);
                            }
                        } else if (selectedHour < 10){
                            if (selectedHour < 10){
                                if (selectedMinute < 10){
                                    txtJamStartChk9.setText("0"+selectedHour + ":0" + selectedMinute);
                                } else {
                                    txtJamStartChk9.setText("0"+selectedHour + ":" + selectedMinute);
                                }
                            }
                        } else {
                            txtJamStartChk9.setText(selectedHour + ":" + selectedMinute);
                        }
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }

    private void  bracketMp5(){
        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);
        chk4 = (CheckBox) findViewById(R.id.chk4);
        chk5 = (CheckBox) findViewById(R.id.chk5);
        chk6 = (CheckBox) findViewById(R.id.chk6);
        chk7 = (CheckBox) findViewById(R.id.chk7);
        chk8 = (CheckBox) findViewById(R.id.chk8);
        chk9 = (CheckBox) findViewById(R.id.chk9);
        chk10 = (CheckBox) findViewById(R.id.chk10);
        chk11 = (CheckBox) findViewById(R.id.chk11);

        txtJamStart = (EditText) findViewById(R.id.txtJamStart);
        txtJamStartChk9 = (EditText) findViewById(R.id.txtJamStartChk9);
        txtHasilSealant = (EditText) findViewById(R.id.txtHasilSealant);

        chk1.setEnabled(true);
        chk2.setEnabled(true);
        chk3.setEnabled(true);
        chk4.setEnabled(true);
        chk5.setEnabled(true);
        chk6.setEnabled(true);
        chk7.setEnabled(true);


        chk8.setEnabled(false);
        chk9.setEnabled(false);
        chk10.setEnabled(false);
        chk11.setEnabled(false);

        txtJamStart.setEnabled(true);

        txtJamStartChk9.setEnabled(false);
        txtHasilSealant.setEnabled(false);

        txtJamStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;

                mTimePicker = new TimePickerDialog(BracketActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        if (selectedMinute < 10){
                            if (selectedHour<10){
                                txtJamStart.setText("0"+selectedHour + ":0" + selectedMinute);
                            } else {
                                txtJamStart.setText(selectedHour + ":0" + selectedMinute);
                            }
                        } else if (selectedHour < 10){
                            if (selectedHour < 10){
                                if (selectedMinute < 10){
                                    txtJamStart.setText("0"+selectedHour + ":0" + selectedMinute);
                                } else {
                                    txtJamStart.setText("0"+selectedHour + ":" + selectedMinute);
                                }
                            }
                        } else {
                            txtJamStart.setText(selectedHour + ":" + selectedMinute);
                        }
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }

    private void updateTxtTanggal(){
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txtTanggal.setText(sdf.format(myCalendar.getTime()));
    }

}
