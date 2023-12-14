package com.fabred.crazy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    TextView text;

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        AutoCompleteTextView autoCompletesize = findViewById(R.id.autoCompletesize);
        ImageView clearButton = findViewById(R.id.clearButton);
        ImageView share = findViewById(R.id.share);
        ImageView share_app = findViewById(R.id.share_app);
        ImageView copy = findViewById(R.id.copy);
        TextView output = findViewById(R.id.output);
        CardView submit = findViewById(R.id.submit);
        CheckBox checkBox_re = findViewById(R.id.checkbox_re);
        CheckBox checkBox_count = findViewById(R.id.checkbox_count);

        //Toolbar

        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav = findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {




                if(item.getItemId()==R.id.menu_home){
                    Toast.makeText(MainActivity.this, "Policy", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }


                return true;
            }
        });


        //text =(TextView)findViewById(R.id.text);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

       submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String text = autoCompleteTextView.getText().toString();
        String text_size = autoCompletesize.getText().toString();



        if (TextUtils.isEmpty(text)) {
            autoCompleteTextView.setError("Enter your name");
            autoCompleteTextView.requestFocus();
            checkBox_re.setChecked(false);
            checkBox_count.setChecked(false);

            return;
        }

        if (TextUtils.isEmpty(text_size)) {
            autoCompletesize.setError("Enter Size");
            autoCompletesize.requestFocus();
            checkBox_re.setChecked(false);
            checkBox_count.setChecked(false);
            return;
        }



        StringBuilder builder = new StringBuilder();
        int size= Integer.parseInt(text_size);

        try {


            // Additional validation for size, adjust as needed
            if (size <= 0) {
                autoCompletesize.setError("Size should be greater than 0");
                autoCompletesize.requestFocus();
                checkBox_re.setChecked(false);
                checkBox_count.setChecked(false);
                return;
            }

            // Your logic for processing the text and size
            // ...

        } catch (NumberFormatException e) {
            autoCompletesize.setError("Invalid Size");
            autoCompletesize.requestFocus();
            checkBox_re.setChecked(false);
            checkBox_count.setChecked(false);
            return;
        }

        for (int i =1;i<=size;i++) {

            if(checkBox_re.isChecked() && checkBox_count.isChecked()){
                builder.append(text+" "+i + "\n");
            }else{

            if (checkBox_re.isChecked()) {
                builder.append(text + "\n");
            } else if (checkBox_count.isChecked()) {
                builder.append(text+" "+i+"," );
            } else {
                builder.append(text+",");
            }
            }

        }



            String textToPrint = builder.toString();
            output.setText(textToPrint);

    }
});



        checkBox_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = autoCompleteTextView.getText().toString();
                String text_size = autoCompletesize.getText().toString();

                if (TextUtils.isEmpty(text)) {
                    autoCompleteTextView.setError("Enter your name");
                    autoCompleteTextView.requestFocus();
                    checkBox_re.setChecked(false);
                    checkBox_count.setChecked(false);

                    return;
                }

                if (TextUtils.isEmpty(text_size)) {
                    autoCompletesize.setError("Enter Size");
                    autoCompletesize.requestFocus();
                    checkBox_re.setChecked(false);
                    checkBox_count.setChecked(false);
                    return;
                }



                StringBuilder builder = new StringBuilder();
                int size= Integer.parseInt(text_size);

                try {


                    // Additional validation for size, adjust as needed
                    if (size <= 0) {
                        autoCompletesize.setError("Size should be greater than 0");
                        autoCompletesize.requestFocus();
                        checkBox_re.setChecked(false);
                        checkBox_count.setChecked(false);
                        return;
                    }

                    // Your logic for processing the text and size
                    // ...

                } catch (NumberFormatException e) {
                    autoCompletesize.setError("Invalid Size");
                    autoCompletesize.requestFocus();
                    checkBox_re.setChecked(false);
                    checkBox_count.setChecked(false);
                    return;
                }

                for (int i =1;i<=size;i++) {

                    if(checkBox_re.isChecked() && checkBox_count.isChecked()){
                        builder.append(text+" "+i + "\n");
                    }else{



                        if (checkBox_re.isChecked()) {
                            builder.append(text + "\n");
                        } else if (checkBox_count.isChecked()) {
                            builder.append(text+" "+i+"," );
                        } else {
                            builder.append(text+",");
                        }
                    }

                }



                String textToPrint = builder.toString();
                output.setText(textToPrint);

            }
        });

        checkBox_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = autoCompleteTextView.getText().toString();
                String text_size = autoCompletesize.getText().toString();



                if (TextUtils.isEmpty(text)) {
                    autoCompleteTextView.setError("Enter your name");
                    autoCompleteTextView.requestFocus();
                    checkBox_re.setChecked(false);
                    checkBox_count.setChecked(false);

                    return;
                }

                if (TextUtils.isEmpty(text_size)) {
                    autoCompletesize.setError("Enter Size");
                    autoCompletesize.requestFocus();
                    checkBox_re.setChecked(false);
                    checkBox_count.setChecked(false);
                    return;
                }



                StringBuilder builder = new StringBuilder();
                int size= Integer.parseInt(text_size);

                try {


                    // Additional validation for size, adjust as needed
                    if (size <= 0) {
                        autoCompletesize.setError("Size should be greater than 0");
                        autoCompletesize.requestFocus();
                        checkBox_re.setChecked(false);
                        checkBox_count.setChecked(false);
                        return;
                    }

                    // Your logic for processing the text and size
                    // ...

                } catch (NumberFormatException e) {
                    autoCompletesize.setError("Invalid Size");
                    autoCompletesize.requestFocus();
                    checkBox_re.setChecked(false);
                    checkBox_count.setChecked(false);
                    return;
                }

                for (int i =1;i<=size;i++) {

                    if(checkBox_re.isChecked() && checkBox_count.isChecked()){
                        builder.append(text+" "+i + "\n");
                    }else{



                        if (checkBox_re.isChecked()) {
                            builder.append(text + "\n");
                        } else if (checkBox_count.isChecked()) {
                            builder.append(text+" "+i+"," );
                        } else {
                            builder.append(text+",");
                        }
                    }

                }



                String textToPrint = builder.toString();
                output.setText(textToPrint);

            }
        });




        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                ClipData clip = ClipData.newPlainText("label", output.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity.this, "Text copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, output.getText().toString());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });








        share_app.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id="+getPackageName());
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);

    }
});










        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // Not needed for this example
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                clearButton.setVisibility(charSequence.length() > 0 ? View.VISIBLE : View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Not needed for this example
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoCompleteTextView.setText("");
            }
        });

    }


}