package com.example.myclub.Activity.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myclub.Beans.NotificationBeans;
import com.example.myclub.ClubModel.NotificationEvent;
import com.example.myclub.ClubView.NotificationView;
import com.example.myclub.R;
import com.example.myclub.Utils.CustomAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements NotificationView {

    private RecyclerView recyclerView;
    private TextView textView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        NotificationEvent event = new NotificationEvent(this);
        event.setNotifications();

        textView = root.findViewById(R.id.text_home);
        recyclerView = root.findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(manager);
        return root;
    }

    @Override
    public void setNotificationList(ArrayList<NotificationBeans> beans, String club) {
        textView.setText(club);
        CustomAdapter adapter = new CustomAdapter(beans);
        recyclerView.setAdapter(adapter);
    }
}