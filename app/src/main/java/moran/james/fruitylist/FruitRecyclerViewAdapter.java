package moran.james.fruitylist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import moran.james.fruitylist.FruitListFragment.OnListFragmentInteractionListener;
import java.util.List;

/**
 * RecyclerView.Adapter that can display a Fruit and makes a call to the
 * specified  OnListFragmentInteractionListener.
 */
public class FruitRecyclerViewAdapter extends RecyclerView.Adapter<FruitRecyclerViewAdapter.ViewHolder> {

    private final List<Fruit> mValues;
    private final OnListFragmentInteractionListener mListener;

    public FruitRecyclerViewAdapter(List<Fruit> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_list_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mFruit = mValues.get(position);
        holder.mFruitNameView.setText(mValues.get(position).getType());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mFruit);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mFruitNameView;
        public Fruit mFruit;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mFruitNameView = view.findViewById(R.id.fruit_type);
        }

    }
}
