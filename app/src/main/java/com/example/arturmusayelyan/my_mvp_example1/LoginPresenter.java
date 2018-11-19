package com.example.arturmusayelyan.my_mvp_example1;

public class LoginPresenter implements ILoginPresenter {

	private ILoginView loginView;

	public LoginPresenter(ILoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void login(String userName, String password) {
		if (userName.isEmpty()) {
			loginView.showNotValidUserName();
		} else if (password.isEmpty()) {
			loginView.showNotValidPassword();
		} else {
			loginView.showSuccessLogin();
		}
	}
}
