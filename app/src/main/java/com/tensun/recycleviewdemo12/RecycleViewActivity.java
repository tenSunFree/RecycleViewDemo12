package com.tensun.recycleviewdemo12;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.Orientation;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class RecycleViewActivity extends AppCompatActivity {

    private List<RecycleViewItem> data;                                       // RecycleView的Item容器

    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter infiniteAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        data = getData();

        itemPicker = (DiscreteScrollView) findViewById(R.id.item_picker);
        itemPicker.setOrientation(Orientation.HORIZONTAL);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new RecycleViewAdapter(data));
        // itemPicker.addItemDecoration(new RecyclerViewItemDecoration();
        itemPicker.addItemDecoration(new DividerItemDecoration(this));
        itemPicker.setAdapter(infiniteAdapter);

        /** 實現當前圖片放大的效果 */
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.75f)
                .build());
    }

    /** 因為最後要放入的是List<Item> data, 因此每個一個子物件的型態, 都必須是Item */
    public List<RecycleViewItem> getData() {
        return Arrays.asList(
                new RecycleViewItem(R.drawable.a_01),
                new RecycleViewItem(R.drawable.a_02),
                new RecycleViewItem(R.drawable.a_03),
                new RecycleViewItem(R.drawable.a_04),
                new RecycleViewItem(R.drawable.a_05),
                new RecycleViewItem(R.drawable.a_06),
                new RecycleViewItem(R.drawable.a_07));
    }
}
