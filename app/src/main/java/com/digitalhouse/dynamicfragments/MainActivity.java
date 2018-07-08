package com.digitalhouse.dynamicfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bRemoveFrag;
    FragmentManager fragManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bRemoveFrag = (Button) findViewById(R.id.removeFrag);

        fragManager = getSupportFragmentManager();

        fragManager.beginTransaction().add(R.id.frame1, new Fragment1()).commit();

        fragManager.beginTransaction().add(R.id.frame2, new Fragment2()).commit();

        fragManager.beginTransaction().replace(R.id.frame1, new Fragment2()).addToBackStack(null).commit();

        bRemoveFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame1);
                if (fragment != null)
                    fragManager.beginTransaction().remove(fragment).commit();
                Toast.makeText(view.getContext(), "You removed the fragment from frame1", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
