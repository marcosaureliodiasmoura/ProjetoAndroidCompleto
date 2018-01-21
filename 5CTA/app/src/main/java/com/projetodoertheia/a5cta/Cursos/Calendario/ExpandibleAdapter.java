package com.projetodoertheia.a5cta.Cursos.Calendario;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projetodoertheia.a5cta.R;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Marcos on 03/08/2016.
 */
public class ExpandibleAdapter extends BaseExpandableListAdapter {

    private List<String> listGroup;
    private HashMap<String, List<String>> listData;
    private LayoutInflater inflater;

    //Cria um construtor pra poder preencher os dados
    public ExpandibleAdapter(Context context, List<String> listGroup, HashMap<String, List<String>> listData)
    {

        this.listGroup = listGroup;
        this.listData = listData;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //quantidade de itens no grupo
        return listData.get(listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
//        return null;
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
//        return null;
        return listData.get(listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup holderx;
//        ViewHolderGroupImage holderImage;
        //pra receber layout
        if (convertView == null)
        {

            convertView = inflater.inflate(R.layout.header_expandir_listview, null);
            holderx = new ViewHolderGroup();
//            holderImage = new ViewHolderGroup();
            convertView.setTag(holderx);
//            convertView.setTag(holderImage);

            holderx.tvGroup = (TextView)convertView.findViewById(R.id.tv_group);
//            holderImage.tvImageView = (TextView)convertView.findViewById(R.id.tvImageView);

        }else {

            holderx = (ViewHolderGroup) convertView.getTag();
//            holderImage = (ViewHolderGroup)convertView.getTag();


        }

        holderx.tvGroup.setText(listGroup.get(groupPosition));
//        holderImage.tvImageView.setText(listGroup.get(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
      ViewHolderItem holderx;
        String valor = (String) getChild(groupPosition, childPosition);
        //pra receber layout
        if (convertView == null)
        {

            convertView = inflater.inflate(R.layout.item_expandir_listview, null);
            holderx = new ViewHolderItem();
            convertView.setTag(holderx);

            holderx.tvItem = (TextView)convertView.findViewById(R.id.tvItem);

        }else {

            holderx = (ViewHolderItem) convertView.getTag();


        }

        holderx.tvItem.setText(valor);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    class ViewHolderGroup{

        TextView tvGroup;
//        TextView tvImageView;
    }

    class ViewHolderItem{
        TextView tvItem;
    }





}
