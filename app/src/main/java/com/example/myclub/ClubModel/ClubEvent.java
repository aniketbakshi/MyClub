package com.example.myclub.ClubModel;

import android.util.Log;

import com.example.myclub.Activity.ClubActivity;
import com.example.myclub.Beans.RegisterBeans;
import com.example.myclub.ClubPresenter.ClubUserInterface;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class ClubEvent implements ClubUserInterface {

    private ClubActivity clubActivity;
    public ClubEvent(ClubActivity clubActivity) {
        this.clubActivity = clubActivity;
    }

    @Override
    public void getClubUserDetail() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("Users")
                .document(uid).get()
                .addOnSuccessListener(clubActivity, task -> {
                    RegisterBeans beans = task.toObject(RegisterBeans.class);
                    Log.w("ClubEvent GetData", "got all the beans" + beans.fullName);
                    clubActivity.onGetDataResult(beans);
                });
    }
}
