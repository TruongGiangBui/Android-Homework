package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private EditText name,mssv,birthday,address,phone,email;
    private RadioButton male,female;
    private CheckBox sport,music,travel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        mssv=findViewById(R.id.mssv);
        address=findViewById(R.id.address);
        birthday=findViewById(R.id.birthday);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        sport=findViewById(R.id.sport);
        music=findViewById(R.id.music);
        travel=findViewById(R.id.travel);
    }
    public void submitform(View view){
        Form form=new Form();
        form.setName(name.getText().toString());
        form.setMssv(mssv.getText().toString());
        form.setBirthday(birthday.getText().toString());
        form.setAddress(address.getText().toString());
        form.setPhone(phone.getText().toString());
        form.setEmail(email.getText().toString());
        if(male.isChecked()) form.setGender("Male");
        else if(female.isChecked()) form.setGender("Female");
        if(sport.isChecked()) form.setSport(true);
        else form.setSport(false);
        if(music.isChecked()) form.setMusic(true);
        else form.setMusic(false);
        if(travel.isChecked()) form.setTravel(true);
        else form.setTravel(false);
        Toast toast = Toast.makeText(this, "Form was submitted: "+form.toString(),
                Toast.LENGTH_SHORT);
        toast.show();
    }

}