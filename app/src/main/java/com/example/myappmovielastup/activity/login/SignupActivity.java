package com.example.myappmovielastup.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.myappmovielastup.R;
import com.example.myappmovielastup.retrofit.ApiPhim;
import com.example.myappmovielastup.retrofit.RetrofitClient;
import com.example.myappmovielastup.utils.Utils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class SignupActivity extends AppCompatActivity {
    EditText emailInput, passInput, cfPassInput;
    AppCompatButton btnSignup;
    TextView signupRedirectText;
    ApiPhim api;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
        redirect();
    }

    private void redirect() {
        btnSignup.setOnClickListener(v -> signupProcess());
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signupProcess() {
        String email = emailInput.getText().toString().trim(),
                pass = passInput.getText().toString().trim(),
                cfPass = cfPassInput.getText().toString().trim();
        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(pass) && TextUtils.isEmpty(cfPass)) {
            Toast.makeText(getApplicationContext(), "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Hãy điền email", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(getApplicationContext(), "Hãy điền mật khẩu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(cfPass)) {
            Toast.makeText(getApplicationContext(), "Hãy xác nhận mật khẩu", Toast.LENGTH_SHORT).show();

        } else {
            if (!pass.equals(cfPass)) {
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
            } else {
//Bỏ phần authentication
                compositeDisposable.add(api.signup(email, pass)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(

                                userModel -> {
                                    if (userModel.isSuccess()) {
                                        Utils.userCurrent.setEmail(email);
                                        Utils.userCurrent.setPass(pass);
                                        Toast.makeText(getApplicationContext(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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
    }


    private void initView() {
        api = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiPhim.class);
        emailInput = findViewById((R.id.emailSignup));
        passInput = findViewById((R.id.passSignup));
        cfPassInput = findViewById((R.id.cfPassSignup));
        btnSignup = findViewById((R.id.signupButton));
        signupRedirectText = findViewById(R.id.signupRedirectText);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}