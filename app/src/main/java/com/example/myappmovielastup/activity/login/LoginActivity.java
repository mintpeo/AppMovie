package com.example.myappmovielastup.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.myappmovielastup.R;
import com.example.myappmovielastup.activity.MainActivity;
import com.example.myappmovielastup.retrofit.ApiPhim;
import com.example.myappmovielastup.retrofit.RetrofitClient;
import com.example.myappmovielastup.utils.Utils;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {
    TextView textViewSignup;
    EditText emailInput, passInput;
    AppCompatButton btnLogin;
    ApiPhim api;
    CompositeDisposable com = new CompositeDisposable();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        redirect();
    }

    private void redirect() {
        textViewSignup.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(intent);
        });
        btnLogin.setOnClickListener((v) -> {
                    String email = emailInput.getText().toString().trim(),
                            pass = passInput.getText().toString().trim();
                    if (TextUtils.isEmpty(email) && TextUtils.isEmpty(pass)) {
                        Toast.makeText(getApplicationContext(), "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(email)) {
                        Toast.makeText(getApplicationContext(), "Hãy điền email", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(pass)) {
                        Toast.makeText(getApplicationContext(), "Hãy điền mật khẩu", Toast.LENGTH_SHORT).show();
                    } else {
                        //Bỏ phần authentication
                        com.add(api.login(email, pass)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(

                                        userModel -> {
                                            if (userModel.isSuccess()) {
                                                Paper.book().write("email", email);
                                                Paper.book().write("pass", pass);
                                                Utils.userCurrent = userModel.getResult().get(0);
                                                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                Toast.makeText(getApplicationContext(), userModel.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }, throwable -> Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show()
                                )
                        );
                    }
                }
        );
    }

    private void initView() {
        Paper.init(this);
        api = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiPhim.class);
        textViewSignup = findViewById(R.id.signupRedirectText);
        emailInput = findViewById(R.id.emailLogin);
        passInput = findViewById(R.id.passLogin);
        btnLogin = findViewById(R.id.loginButton);
//Read data
        if (Paper.book().read("email") != null && Paper.book().read("pass") != null) {
            emailInput.setText(Paper.book().read("email"));
            passInput.setText(Paper.book().read("pass"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


        if (Utils.userCurrent.getEmail() != null && Utils.userCurrent.getPass() != null) {
            emailInput.setText(Utils.userCurrent.getEmail());
            passInput.setText(Utils.userCurrent.getPass());
        }
    }

    @Override
    protected void onDestroy() {
        com.clear();
        super.onDestroy();
    }
}
