package id.liqu.laundry.liquid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import id.liqu.laundry.liquid.R;


public class MyOrder extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mPostReference;
    private ValueEventListener mPostListener;
    private static final String TAG = "PostDetailActivity";
    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);


        mPostReference = FirebaseDatabase.getInstance().getReference()
                .child("order").child(uid);

        mLayoutManager = new LinearLayoutManager(this);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Add value event listener to the post
        // [START post_value_event_listener]
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                if(dataSnapshot.getValue(true) != null){
                    Log.d("getData:", dataSnapshot.getValue(true).toString());

                    int c=0;
                    Iterable<DataSnapshot> orderChild = dataSnapshot.getChildren();
                    ArrayList<Order> order = new ArrayList<Order>();
                    for(DataSnapshot ds : orderChild) {
                        Order or = new Order();
                        or = ds.getValue(Order.class);
                        order.add(or);
                        c++;
                    }

                    Log.d("getData2:",order.toString());
                    for(int i=0;i<order.size();i++){
                        Log.d("Tanggal",order.get(i).dateP);
                        Log.d("Harga",order.get(i).harga+"");
                        Log.d("Status",order.get(i).status);
                    }


                    mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
                    mRecyclerView.setHasFixedSize(true);

                    // use a linear layout manager
                    mRecyclerView.setLayoutManager(mLayoutManager);

                    mAdapter = new MyAdapter(order);
                    mRecyclerView.setAdapter(mAdapter);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
                Toast.makeText(MyOrder.this, "Failed to load post.",
                        Toast.LENGTH_SHORT).show();
                // [END_EXCLUDE]
            }
        };
        mPostReference.addValueEventListener(postListener);
        // [END post_value_event_listener]

        // Keep copy of post listener so we can remove it when app stops
        mPostListener = postListener;
    }

    @Override
    public void onStop() {
        super.onStop();

        // Remove post value event listener
        if (mPostListener != null) {
            mPostReference.removeEventListener(mPostListener);
        }

    }

    @Override
    public void onClick(View v) {

    }
}
