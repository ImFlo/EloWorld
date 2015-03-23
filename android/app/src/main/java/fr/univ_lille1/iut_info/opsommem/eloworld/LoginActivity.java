package fr.univ_lille1.iut_info.opsommem.eloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginActivity extends ActionBarActivity {

    boolean create = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        EditText email = (EditText) findViewById(R.id.email);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toggleLoginOrCreate(View view) {

        TextView loginOrCreateText = (TextView) findViewById(R.id.create);
        Button loginOrCreate = (Button) findViewById(R.id.sign_in_or_create);
        EditText repeatPassword = (EditText) findViewById(R.id.repeat_password);
        EditText firstName = (EditText) findViewById(R.id.first_name);
        EditText lastName = (EditText) findViewById(R.id.last_name);
        EditText email = (EditText) findViewById(R.id.email);

        if(!create) {

            repeatPassword.setVisibility(View.VISIBLE);
            firstName.setVisibility(View.VISIBLE);
            lastName.setVisibility(View.VISIBLE);
            email.setVisibility(View.VISIBLE);
            loginOrCreateText.setText("I already have an account");
            loginOrCreate.setText("Create");
            create = true;

        }

        else {

            repeatPassword.setVisibility(View.GONE);
            firstName.setVisibility(View.GONE);
            lastName.setVisibility(View.GONE);
            email.setVisibility(View.GONE);
            loginOrCreateText.setText("No account ? Create one now !");
            loginOrCreate.setText("Sign in");
            create = false;

        }

    }

    public void LoginOrCreate(View view) {
        if(create)
            CreateAccount(view);
        else
            Login(view);
    }

    public void CreateAccount(View view) {


        /*Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);*/
    }

    public void Login(View view) {

    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
