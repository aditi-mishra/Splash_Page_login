package com.example.croma.navigation_draw;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Croma on 14-02-2018.
 */

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> mExpandableListTitle;
    private Map<String,List<String>> mExpandableListDetail;
    private LayoutInflater mLayoutInflater;

    public CustomExpandableListAdapter(Context context,List<String> expandableListTitle,Map<String,List<String>> expandableListDetail){
        mContext = context;
        mExpandableListTitle = expandableListTitle;
        mExpandableListDetail = expandableListDetail;
        mLayoutInflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getGroupCount() {
        return mExpandableListTitle.size();
    }

    @Override
    public int getChildrenCount(int listPos) {
        return mExpandableListDetail.get(mExpandableListTitle.get(listPos)).size();

    }

    @Override
    public Object getGroup(int listPos) {
        return mExpandableListTitle.get(listPos);
     }

    @Override
    public Object getChild(int listPos, int expandedListpos) {
        return mExpandableListDetail.get(mExpandableListTitle.get(listPos)).get(expandedListpos);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int listPos, int expandedListpos) {
        return expandedListpos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int listPos, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String)getGroup(listPos);
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.list_group,null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public View getChildView(int listPos, int expandedListPos, boolean b, View view, ViewGroup viewGroup) {
       final String expandedListtext = (String)getChild(listPos,expandedListPos);
       if(view == null){
           view = mLayoutInflater.inflate(R.layout.list_item,null);
       }
        TextView expandedListViewText = (TextView)view.findViewById(R.id.expandedListItem);
        expandedListViewText.setText(expandedListtext);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
