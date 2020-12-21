package com.example.blooddonation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements donorAdapter.ItemSelected {

    TextView BName;
    TextView BGroup;
    TextView BLocation;
    TextView BNumber;
    Button add_donor;
    Button search_btn;
    ImageView location_id;
    ImageView call_id;
    final int addDonor_key=3;

    ListFrag listFrag;
    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init_Views();
        manager = this.getSupportFragmentManager();
        listFrag = (ListFrag) manager.findFragmentById(R.id.list_frag);
        OnItemClicked(0);



        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this ,SearchBGroup.class);
                //intent.putExtra(" array ",myApplication.people);
                startActivity(intent);
            }
        });

        add_donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                startActivityForResult(new Intent(MainActivity.this,AddDonor.class),addDonor_key);
            }
        });


        location_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + BLocation.getText().toString().trim()) );
                startActivity(intent);

            }
        });

        call_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + BNumber.getText().toString().trim()));
                startActivity(intent);

            }
        });
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == addDonor_key)
        {
            if(resultCode == RESULT_OK)
            {
               BName.setText(data.getStringExtra("name"));
               BGroup.setText(data.getStringExtra("group"));
               BLocation.setText(data.getStringExtra("location"));
               BNumber.setText(data.getStringExtra("number"));
               myApplication.people.add(new Person(BName.getText().toString().trim(),BGroup.getText().toString().trim(),BLocation.getText().toString().trim(),BNumber.getText().toString().trim()));
                listFrag.dataChanged();
                OnItemClicked(0);
            }
            else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(MainActivity.this, "User Pressed the Cancel button", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void OnItemClicked(int index)
    {
             BName.setText(myApplication.people.get(index).getdName());
             BGroup.setText(myApplication.people.get(index).getdBloodGroup());
             BLocation.setText(myApplication.people.get(index).getdLocation());
             BNumber.setText(myApplication.people.get(index).getPhone());

    }

    public void Init_Views()
    {
        location_id = findViewById(R.id.locationid);
        call_id = findViewById(R.id.callid);
        add_donor = findViewById(R.id.adddonor);
        search_btn = findViewById(R.id.searchbtn);
        BName = (TextView) findViewById(R.id.dName);
        BGroup = (TextView) findViewById(R.id.dGroup);
        BLocation = (TextView) findViewById(R.id.dLocation);
        BNumber = (TextView) findViewById(R.id.dNumber);
    }
}