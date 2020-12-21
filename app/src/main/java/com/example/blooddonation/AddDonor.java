package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDonor extends AppCompatActivity {

    EditText eName;
    EditText eGroup;
    EditText eLocation;
    EditText eNumber;
    Button addbtn;
    Button cancelbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donor);

         Init_Views();


        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String Name = eName.getText().toString().trim();
                String Group = eGroup.getText().toString().trim();
                String Location = eLocation.getText().toString().trim();
                String Number = eNumber.getText().toString().trim();

                if(Name.isEmpty() || Group.isEmpty() || Location.isEmpty() || Number.isEmpty() )
                {
                    Toast.makeText(AddDonor.this, "Please ! Enter all data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.putExtra("name",Name);
                    intent.putExtra("group",Group);
                    intent.putExtra("location",Location);
                    intent.putExtra("number",Number);
                    setResult(RESULT_OK,intent);
                    AddDonor.this.finish();
                }

            }
        });



        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setResult(RESULT_CANCELED);
                AddDonor.this.finish();
            }
        });
    }

    public void Init_Views()
    {

        eName = findViewById(R.id.eName);
        eGroup = findViewById(R.id.eGroup);
        eLocation = findViewById(R.id.eLocation);
        eNumber = findViewById(R.id.eNumber);
        addbtn = findViewById(R.id.addbtn);
        cancelbtn = findViewById(R.id.cancelbtn);
    }

}