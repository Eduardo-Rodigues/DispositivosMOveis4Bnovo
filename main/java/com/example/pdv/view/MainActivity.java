package com.example.pdv.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pdv.controller.LoginController;


public class MainActivity extends AppCompatActivity {

        private LoginController loginController;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            loginController = new LoginController();


        }
}





