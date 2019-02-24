package moran.james.fruitylist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the OnListFragmentInteractionListener
 * interface.
 */
public class FruitListFragment extends Fragment {


    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private List<Fruit> fruits;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FruitListFragment() {
    }

    @SuppressWarnings("unused")
    public static FruitListFragment newInstance(int columnCount) {
        FruitListFragment fragment = new FruitListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fruit_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            fruits = getFruitData();
            recyclerView.setAdapter(new FruitRecyclerViewAdapter(fruits, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnListFragmentInteractionListener {

        void onListFragmentInteraction(Fruit fruit);
    }

    private List<Fruit> getFruitData() {
        List<Fruit> fruitList = new LinkedList<>();

        try {
            long requestStart = System.currentTimeMillis();

            String r = new LoadJSONDataTask().execute(new String("")).get();

            long requestEnd = System.currentTimeMillis();
            long requestTime = requestEnd - requestStart;
            String[] queryParams = {"load", Long.toString(requestTime)};

            new InteractionRecordTask().execute(queryParams);

            JSONObject json = new JSONObject(r);
            JSONArray type = json.getJSONArray("fruit");

            for (int i = 0; i < type.length(); i++) {
                JSONObject a = type.getJSONObject(i);
                fruitList.add(new Fruit(a.getString("type"), a.getDouble("price"), a.getDouble("weight")));
            }
            
        } catch (JSONException e) {
                e.printStackTrace();
            Toast.makeText(this.getContext(),"Cannot Access Data",Toast.LENGTH_SHORT);
        }
        catch (ExecutionException e) {
            e.printStackTrace();
            Toast.makeText(this.getContext(),"Cannot Access Data",Toast.LENGTH_SHORT);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(this.getContext(),"Cannot Access Data",Toast.LENGTH_SHORT);
        }
        return fruitList;
    }
}
