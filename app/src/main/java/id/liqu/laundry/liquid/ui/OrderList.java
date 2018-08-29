package id.liqu.laundry.liquid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;

import id.liqu.laundry.liquid.R;

public class OrderList extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        String list[] = {"Sastt", "Sastra", "Sastt", "Sastra","Sastt", "Sastra","Sastt", "Sastra","Sastt", "Sastra","Sastt", "Sastra","Sastt", "Sastra"   };


//        mAdapter = new MyAdapter(list);
//        mRecyclerView.setAdapter(mAdapter);
    }
    // ...
}

