package com.projetodoertheia.a5cta.RssNoticias;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Marcos on 15/08/2016.
 */
public class VerticalSpace extends RecyclerView.ItemDecoration {

    int Space;
    public VerticalSpace(int Space)
    {
        this.Space=Space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left=Space;
        outRect.bottom=Space;
        outRect.right=Space;

        if(parent.getChildLayoutPosition(view)==0)
        {
            outRect.top=Space;
        }

        //Depois dessa ação é feito no ReadRSS->OnPostExecute, uma nova ação com recyclerview
    }
}
