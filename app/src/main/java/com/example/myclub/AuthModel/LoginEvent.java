package com.example.myclub.AuthModel;

import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.myclub.AuthPresenter.UserPassInterface;
import com.example.myclub.Beans.AdminBeans;
import com.example.myclub.Beans.UserPassBeans;
import com.example.myclub.LoginFrag.Login_Fragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class LoginEvent implements UserPassInterface {

    private Login_Fragment loginFragment;
    private FirebaseAuth auth;
    private boolean check;

    public LoginEvent(Login_Fragment login_fragment) {
        this.loginFragment = login_fragment;
    }

    @Override
    public void loginWithEmail(UserPassBeans beans, View v) {
        auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(beans.getUname(), beans.getPass())
                .addOnCompleteListener(loginFragment.getActivity(), task -> {
                    if (task.isSuccessful()) {
                        Log.w("LoginEvent Result", "Success");
                        Toast.makeText(loginFragment.getActivity(), "Success", Toast.LENGTH_SHORT).show();
                        loginFragment.onConnectionResult();
                    } else {
                        Log.w("LoginEvent Result", "Failed");
                        Toast.makeText(loginFragment.getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean checkAdmin() {
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        String uid = auth.getUid();
        assert uid != null;
        firestore.collection("Admins").document(uid).get()
                .addOnSuccessListener(task -> {
                    AdminBeans beans = task.toObject(AdminBeans.class);
                    Log.w("LoginEvent Admin", "" + beans.isAdmin + " " + beans.Club);
                });

        return check;
    }
}
