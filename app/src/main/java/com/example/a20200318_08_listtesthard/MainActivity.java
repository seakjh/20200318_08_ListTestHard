package com.example.a20200318_08_listtesthard;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

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

        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                클릭된 방의 정보를 목록에서 빼옴. position번째
                Room clickedRoom = roomDatas.get(position);
//                방 상세 화면으로 이동.
                Intent intent = new Intent(mContext, RoomDetailActivity.class);
                intent.putExtra("room", clickedRoom);
                startActivity(intent);
            }
        });

        binding.roomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

//                Room data = roomDatas.get(position);
//
//                Toast.makeText(mContext, data.getExplanation(), Toast.LENGTH_SHORT).show();

//                꾹 누르면, 해당 아이템을 목록에서 삭제
                roomDatas.remove(position);
//                어댑터에게 새로고침 시킴.
                roomAdapter.notifyDataSetChanged();

                return true; // true : 롱클릭만 , false : 그냥 클릭도 같이
            }
        });

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
