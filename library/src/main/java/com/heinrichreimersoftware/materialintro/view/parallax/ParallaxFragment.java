package com.heinrichreimersoftware.materialintro.view.parallax;

import android.os.Bundle;
import android.view.View;

import com.heinrichreimersoftware.materialintro.view.parallax.util.ParallaxUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ParallaxFragment extends Fragment implements Parallaxable {

    private final List<Parallaxable> parallaxableChildren = new ArrayList<>();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        parallaxableChildren.addAll(ParallaxUtil.findParallaxableChildren(view));
    }

    @Override
    public void setOffset(@FloatRange(from = -1.0, to = 1.0) float offset) {
        ParallaxUtil.setOffsetToParallaxableList(parallaxableChildren, offset);
    }
}
