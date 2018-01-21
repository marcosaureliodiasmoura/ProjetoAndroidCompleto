package com.projetodoertheia.a5cta.Cursos;


import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.projetodoertheia.a5cta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideosFragment extends Fragment {


    public VideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_videos, container, false);
       ;

        if(container == null)
        {
            return null;
        }

        VideoView video = (VideoView) rootview.findViewById(R.id.videoView);

        Uri src = Uri.parse("https://firebasestorage.googleapis.com/v0/b/cta-4f03b.appspot.com/o/Videos%20CTA%2FTop%205%20Material%20Design%20Apps%20(2015).mp4?alt=media&token=1f5ae8ed-71d7-401a-9b0f-a36dc74dfda6");


        video.setVideoURI(src);

        video.setMediaController(new MediaController(this.getActivity()));

        return rootview;
    }

}
