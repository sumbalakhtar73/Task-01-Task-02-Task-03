package com.example.task010203;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertBox extends AppCompatActivity {

    EditText name,rollno,email;
    Button save,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_box);
        name=(EditText)findViewById(R.id.edname);
        rollno=(EditText)findViewById(R.id.edrollno);
        email=(EditText)findViewById(R.id.email);
        cancel=(Button)findViewById(R.id.btncancel);
        save=(Button)findViewById(R.id.btnsave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                LayoutInflater li = LayoutInflater.from(AlertBox.this);

                View promptsView = li.inflate(R.layout.alertboxdesign, null);

                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(AlertBox.this);
                alertDialogBuilder.setView(promptsView);

//                fourth = (TextView)findViewById(R.id.qty1);
//                final EditText userInput = (EditText)promptsView.findViewById(R.id.editTextDialogUserInput);
             //   fourth.setText(userInput.getText().toString());

                TextView txtnam,txtrollno,txtemail;
                txtnam=(TextView)promptsView.findViewById(R.id.alertdesignname);
                txtrollno=(TextView)promptsView.findViewById(R.id.alertdesignrollno);
                txtemail=(TextView)promptsView.findViewById(R.id.alertdesignemail);

                txtnam.setText(name.getText().toString());
                txtrollno.setText(rollno.getText().toString());
                txtemail.setText(email.getText().toString());

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // editText.getText().clear();
                name.getText().clear();
                rollno.getText().clear();
                email.getText().clear();
            }
        });



    }
}
