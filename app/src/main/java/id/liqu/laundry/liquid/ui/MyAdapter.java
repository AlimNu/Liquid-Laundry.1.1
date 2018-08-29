package id.liqu.laundry.liquid.ui;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import id.liqu.laundry.liquid.R;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Order> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextview1, mTextview2, mTextview3;
        public ViewHolder(ConstraintLayout v) {
            super(v);
            mTextview1 = v.findViewById(R.id.textView);
            mTextview2 = v.findViewById(R.id.textView2);
            mTextview3 = v.findViewById(R.id.textView4);
        }
}

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Order> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_text_view, parent, false);


        ViewHolder vh = new ViewHolder(v);

//        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
//        viewHolder = new ViewHolder(convertView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        for(int i=0;i < mDataset.length;i++){
            holder.mTextview1.setText(mDataset.get(position).getDateD());
            holder.mTextview2.setText(mDataset.get(position).getHarga()+"");
            holder.mTextview3.setText(mDataset.get(position).getStatus());
//        }



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}