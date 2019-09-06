package com.example.task010203;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;
    int result;
    EditText editText;
    String text;
    Button search,form;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.edtext);
        search=(Button)findViewById(R.id.gotposearch);
        form=(Button)findViewById(R.id.goroform);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, Searchbar.class);
                startActivity(i);
            }
        });
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, AlertBox.class);
                startActivity(i);
            }
        });

        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i == TextToSpeech.SUCCESS)
                {
                    result=textToSpeech.setLanguage(Locale.US);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Feature not supported in your device", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public void ITS(View view)
    {
        switch (view.getId())
        {
            case R.id.read:
                if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(this, "Feature not supported in your device", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    text=editText.getText().toString();
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null);

                }
                break;

            case R.id.stop:
                if(textToSpeech!=null)
                {
                    textToSpeech.stop();
                }
                break;
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if(textToSpeech!=null)
        {
            textToSpeech.stop();
        }

    }




    }

