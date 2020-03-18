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

        addRooms();

    }

    void addRooms(){
        roomDatas.add(new Room(8000, "서울시 종로구", 5, "살기 좋음"));
        roomDatas.add(new Room(25000, "서울시 노원구", 6, "노원구의 투룸"));
        roomDatas.add(new Room(18000, "서울시 은평구", 7, "은평구의 투룸"));
        roomDatas.add(new Room(7000, "경기도 부천시", -1, "부천시 원룸"));
        roomDatas.add(new Room(8000, "경기도 고양시", 0, "고양시 단독주택"));

        roomAdapter.notifyDataSetChanged();
    }
}
