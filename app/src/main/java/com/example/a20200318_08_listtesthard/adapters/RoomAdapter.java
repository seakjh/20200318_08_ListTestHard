package com.example.a20200318_08_listtesthard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a20200318_08_listtesthard.R;
import com.example.a20200318_08_listtesthard.datas.Room;

import java.util.List;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;
    List<Room> mList;
    LayoutInflater inf;


//    Context mContext;   // 화면과의 연결고리
//    List<Store> mList;  // 뿌려줄 데이터목록 담는 변수
//    LayoutInflater inf; // xml -> 객체화 시켜주는 역할 클래스

    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null){
            row = inf.inflate(R.layout.room_list_item, null);
        }

        Room data = mList.get(position);

        TextView priceTxt = row.findViewById(R.id.priceTxt);
        TextView addressAndFloorTxt = row.findViewById(R.id.priceTxt);
        TextView explanTxt = row.findViewById(R.id.priceTxt);

//        가격 설정 => setText에는 int값을 넣지말자
//        1만 이상이면 억단위 아니면 그냥 숫자만 표시 , 찍어서
        if (data.getPrice() >= 10000){
//            ?억 %,d
            int billion = data.getPrice() / 10000;
            int thousand = data.getPrice() % 10000;

            priceTxt.setText(String.format("%d억 %,d", billion, thousand));

        }
        else{
            priceTxt.setText(String.format("%,d", data.getPrice()));
        }


        return row;

    }
}
