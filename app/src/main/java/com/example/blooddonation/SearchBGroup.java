package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchBGroup extends AppCompatActivity
{

     EditText search_id;
     Button btn_submit;
     TextView list_names;
     myApplication obj1 = new myApplication();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_b_group);
        Init_Views();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String search_data = search_id.getText().toString().trim();
                int size = obj1.people.size();
                String find=null;
                for(int i=0; i<size; i++)
                {

                    if(search_data.equals(obj1.people.get(i).getdName()))
                    {

                         find = "  Donor Name              :  "+obj1.people.get(i).getdName()
                                + "\n  Donor BloodGroup   :  "+ obj1.people.get(i).getdBloodGroup()
                                + "\n  Donor Location         :  "+ obj1.people.get(i).getdLocation()
                                + "\n  Donor Cell No.          :  "+obj1.people.get(i).getPhone();
                        list_names.setText(find);
                    }



                }
                if(find == null)
                {
                    Toast.makeText(SearchBGroup.this, "No Record Found !!", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }

    public void Init_Views()
    {
        search_id = findViewById(R.id.searchid);
        btn_submit = findViewById(R.id.btn_submit);
        list_names = findViewById(R.id.list_ofname);

    }
}