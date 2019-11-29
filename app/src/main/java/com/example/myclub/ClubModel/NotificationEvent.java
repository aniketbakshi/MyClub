package com.example.myclub.ClubModel;

import android.util.Log;
import android.widget.Toast;

import com.example.myclub.Activity.ui.home.HomeFragment;
import com.example.myclub.Beans.NotificationBeans;
import com.example.myclub.ClubPresenter.NotificationInterface;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class NotificationEvent implements NotificationInterface {

    private HomeFragment homeFragment;
    private List<NotificationBeans> beansList;

    public NotificationEvent (HomeFragment fragment) {
        this.homeFragment = fragment;
    }

    @Override
    public void setNotifications() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users")
                .document(auth.getUid()).get().addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()){
                        List<String> list = (List<String>)documentSnapshot.getData().get("clubs");
                        if (list.size() > 0) {
                            String club = list.get(0);
                            Log.w("Notification club", club);
                            getAlerts(club);
                        } else {
                            Toast.makeText(homeFragment.getContext(), "You are in no club", Toast.LENGTH_SHORT).show();
                        }
                    }
        });
    }

    private void getAlerts(String club) {
        FirebaseFirestore db1 = FirebaseFirestore.getInstance();
        db1.collection("Clubs")
                .document(club).collection("Notifications")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    List<DocumentSnapshot> snapshotList = null;
                    if (queryDocumentSnapshots != null) {
                        snapshotList = queryDocumentSnapshots.getDocuments();
                    }
                    if (snapshotList != null) {
                        Log.w("notifications:", "" + snapshotList.toString());
                    }
                    beansList = new ArrayList<>();
                    if (snapshotList != null) {
                        for (DocumentSnapshot s : snapshotList) {
                            NotificationBeans n = s.toObject(NotificationBeans.class);
                            if (n != null) {
                                Log.w("notifications class:", "" + n.getSubtitle() + n.getTitle());
                            }
                            beansList.add(n);
                        }
                    }
                    homeFragment.setNotificationList((ArrayList<NotificationBeans>) beansList, club);
                });
    }
}
