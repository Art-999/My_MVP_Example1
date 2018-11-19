package com.example.arturmusayelyan.my_mvp_example1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {
	private EditText userNameEt;
	private EditText passwordEt;
	private Button loginBtn;

	private LoginPresenter loginPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		userNameEt = findViewById(R.id.username_et);
		passwordEt = findViewById(R.id.password_et);
		loginBtn = findViewById(R.id.login_btn);
		loginBtn.setOnClickListener(this);

		if (loginPresenter == null) {
			loginPresenter = new LoginPresenter(this);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.login_btn:
				String userName = userNameEt.getText().toString();
				String password = passwordEt.getText().toString();
				loginPresenter.login(userName, password);
				break;
		}
	}

	@Override
	public void showNotValidUserName() {
		Toast.makeText(this, "Username is not valid", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showNotValidPassword() {
		Toast.makeText(this, "Password is not valid", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showSuccessLogin() {
		Toast.makeText(this, "Login has been successful", Toast.LENGTH_SHORT).show();
	}
}
