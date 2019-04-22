package com.example.administrator.demos.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.demos.R;
import com.example.administrator.demos.interfaces.UserLoginView;
import com.example.administrator.demos.interfaces.UserLoginViewPresenter;

public class MVCTestActivity extends AppCompatActivity implements UserLoginView{

    private EditText et1;
    private EditText et2;
    private Button btn1;
    private Button btn2;
    private Button login;

    UserLoginViewPresenter presenter = new UserLoginViewPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvctest);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        login = findViewById(R.id.login);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clear();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clear();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login();
            }
        });

    }

    @Override
    public String getUsername() {
        return et1.getText().toString();
    }

    @Override
    public String getUserpwd() {
        return et2.getText().toString();
    }

    @Override
    public void clearUsername() {
        et1.setText("");
    }

    @Override
    public void clearPwd() {
        et2.setText("");
    }
}
