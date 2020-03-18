package com.example.a20200318_08_listtesthard;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Adapter;

import com.example.a20200318_08_listtesthard.adapters.RoomAdapter;
import com.example.a20200318_08_listtesthard.databinding.ActivityMainBinding;
import com.example.a20200318_08_listtesthard.datas.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding = null;

    List<Room> roomDatas = new ArrayList<>();

    RoomAdapter roomAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item, roomDatas);

        binding.roomListView.setAdapter(roomAdapter);

        addRoom();

    }

    void addRoom(){
        roomDatas.add(new Room(8000, "종로구 종각", -1, "넓음"));
    }
}
