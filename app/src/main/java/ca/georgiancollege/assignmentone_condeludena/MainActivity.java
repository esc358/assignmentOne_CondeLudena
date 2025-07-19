/*
* Emilio Sebastian Conde Ludena
* 200478144
* July 19, 2025
* 7:16pm
* */
package ca.georgiancollege.assignmentone_condeludena;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ca.georgiancollege.assignmentone_condeludena.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //declare binding
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assign binding and use it on create
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}