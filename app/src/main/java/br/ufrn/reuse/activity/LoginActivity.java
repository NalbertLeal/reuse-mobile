package br.ufrn.reuse.activity;
import br.ufrn.reuse.facade.ReuseFacade;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import br.ufrn.reuse.R;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    private ReuseFacade reuseFacade;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(view -> {
            if(new ReuseFacadeImpl().autenticar()) {
                iniciarTimeline("Apuena");
            }
        });
    }

    private void iniciarTimeline(String usuario){
        Intent intent = new Intent(this, Vitrine.class);
        //intent.putExtra("username", usuario);
        startActivity(intent);
    }
}
