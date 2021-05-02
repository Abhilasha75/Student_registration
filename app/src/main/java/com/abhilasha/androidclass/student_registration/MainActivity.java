package com.abhilasha.androidclass.student_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{

    EditText first_name, mid_name, last_name, mail, num,day,month,yr,id,year,grade;
    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox Check;
    Spinner spinner, spinner_sem;

    String[] stringList1 = {"Select ", "Hindi", "Marathi", "Urdu", "Telugu", "Gujarati", "Bengali", "Kannada"};
    String[] stringList2 = {"Select ", "First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth"};

    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        first_name = findViewById(R.id.firstname);
        mid_name = findViewById(R.id.middlename);
        last_name = findViewById(R.id.lastname);
        mail = findViewById(R.id.email);
        num = findViewById(R.id.phnumber);
        day = findViewById(R.id.day_id);
        month = findViewById(R.id.month_id);
        yr = findViewById(R.id.year_id);
        id = findViewById(R.id.studentid);
        year = findViewById(R.id.entryid);
        grade = findViewById(R.id.grade_id);

        Check = findViewById(R.id.next);

        spinner = findViewById(R.id.spin_ethnicity);
        spinner_sem = findViewById(R.id.spin_semister);

        radioGroup = findViewById(R.id.gender);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                radioButton = radioGroup.findViewById(checkedId);

                //Toast.makeText(MainActivity.this, "" + radioButton.getText(), Toast.LENGTH_SHORT).show();


            }
        });

        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList1);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList2);

        spinner.setAdapter(adapter1);
        spinner_sem.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(MainActivity.this, " " + stringList1[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(MainActivity.this, " " + stringList2[i], Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
 /*************************************************************************************************************************************/
         //Radio group
         public void submitRadioButton(View view)
         {
            // int selectedid = radioGroup.getCheckedRadioButtonId();

         }




    /**********************************************************************************************************************************/
        /* data send*/
    public void Send_Data (View view) {

        int selectedid = radioGroup.getCheckedRadioButtonId();
        if (selectedid == -1)
        {

            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();

        }
        else
            {
                if (Check.isChecked())
                {
                    String first = first_name.getText().toString().trim();
                    String mid = mid_name.getText().toString().trim();
                    String last = last_name.getText().toString().trim();

                    String Email = mail.getText().toString().trim();
                    String phn = num.getText().toString().trim();

                    String Day = day.getText().toString().trim();
                    String Month = month.getText().toString().trim();
                    String Yr = yr.getText().toString().trim();

                    String Gender = radioButton.getText().toString().trim();

                    String stud_yr = year.getText().toString().trim();
                    String stud_id = id.getText().toString().trim();
                    String stud_grade = grade.getText().toString().trim();

                    String ethin = spinner.getSelectedItem().toString();
                    String sem = spinner_sem.getSelectedItem().toString();


                    DbHelper dbHelper = new DbHelper(this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();


                    ContentValues values = new ContentValues();

                    values.put("firstname", first);
                    values.put("middlename", mid);
                    values.put("lastname", last);
                    values.put("email", Email);
                    values.put("phnumber", phn);

                    values.put("day_id", Day);
                    values.put("month_id", Month);
                    values.put("year_id", Yr);

                    values.put("gender_id", Gender);

                    values.put("spin_ethnicity", ethin);
                    //values.put("gender_id",);
                    values.put("studentid", stud_id);
                    values.put("entryid", stud_yr);
                    values.put("grade_id", stud_grade);
                    values.put("spin_semester", sem);


                    long RowId = db.insert("user_login", null, values);

                    //Toast.makeText(this, " "+ RowId, Toast.LENGTH_SHORT).show();

                    Toast.makeText(this, "DATA inserted \n" + "Name :" + first + " " + mid + " " + last + "\nEmail : " + Email + "\n Phone number : " + phn + "\n Ethnicity :" + ethin + "\nGender : " + Gender + "\n Semester : " + sem + "\n Student Id : " + stud_id + "\n Entry Year : " + stud_yr + "\n Grade : " + stud_grade + "\n" + "Birth Date: " + Day + "/" + Month + "/" + Yr + "\n" + RowId, Toast.LENGTH_LONG).show();
                 }
                else
                    {
                        Toast.makeText(this, "\n Please Agree Term and Condition", Toast.LENGTH_SHORT).show();

                    }
            }

         }
}