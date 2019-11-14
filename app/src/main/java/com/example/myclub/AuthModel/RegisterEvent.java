package com.example.myclub.AuthModel;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myclub.AuthPresenter.RegisterInterface;
import com.example.myclub.Beans.RegisterBeans;
import com.example.myclub.LoginFrag.SignUp_Fragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterEvent implements RegisterInterface {

    SignUp_Fragment signUp_fragment;
    private FirebaseAuth auth;
    FirebaseFirestore db;

    public RegisterEvent(SignUp_Fragment signUp_fragment) {
        this.signUp_fragment = signUp_fragment;
    }

    @Override
    public void register(RegisterBeans registerBeans, View v) {
        //  Sign up
        auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(registerBeans.userPassBeans.getUname(), registerBeans.userPassBeans.getPass())
                .addOnCompleteListener(signUp_fragment.getActivity(), task -> {
                    if (task.isSuccessful()) {
                        Log.w("Register Result", "Success");
                        db = FirebaseFirestore.getInstance();
                        db.collection("Users")
                                .document(auth.getUid())
                                .set(registerBeans);
                    } else {
                        Log.w("Register Result", "Failed");
                    }
                });
    }
}
