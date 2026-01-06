package com.example.anapaula.quilombolaappv4.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.anapaula.quilombolaappv4.R;
import com.example.anapaula.quilombolaappv4.VideoPlayerActivity;

import java.util.HashMap;
import java.util.List;

//classe para lista DropDown - Legislação
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<Integer>> listHashMap;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<Integer>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i)
    {
        return listHashMap.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i)
    {
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        List<Integer> list = listHashMap.get(listDataHeader.get(i)); // i = Group Item , i1 = ChildItem
        return list.get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String)getGroup(i);

        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group,null);
        }

        TextView lblListHeader = (TextView)view.findViewById(R.id.lblListHeader);
        lblListHeader.setMinHeight(100);
        lblListHeader.setGravity(Gravity.CENTER_VERTICAL);
        lblListHeader.setTextColor(context.getResources().getColor(R.color.dark_text));
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);


        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Integer childViewId = (Integer)getChild(i, i1);

        LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(childViewId, null);

        // Lógica para os vídeos do Quilombo do Areal
        if (childViewId == R.layout.layout_quilombo_areal) {
            setupArealVideos(view);
        }

        return view;
    }

    private void setupArealVideos(View view) {
        View btn1 = view.findViewById(R.id.btnVideoAreal1);
        View btn2 = view.findViewById(R.id.btnVideoAreal2);
        View btn3 = view.findViewById(R.id.btnVideoAreal3);
        View btn4 = view.findViewById(R.id.btnVideoAreal4);

        if (btn1 != null) btn1.setOnClickListener(v -> startVideo(R.raw.videoplayback));
        if (btn2 != null) btn2.setOnClickListener(v -> startVideo(R.raw.videoplayback2));
        if (btn3 != null) btn3.setOnClickListener(v -> startVideo(R.raw.videoplayback3));
        if (btn4 != null) btn4.setOnClickListener(v -> startVideo(R.raw.videoplayback4));
    }

    private void startVideo(int resId) {
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        intent.putExtra("VIDEO_RES_ID", resId);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
