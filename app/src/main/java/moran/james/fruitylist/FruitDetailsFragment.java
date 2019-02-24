package moran.james.fruitylist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Activities that contain this fragment must implement the
 * FruitDetailsFragment.OnFragmentInteractionListener interface
 * to handle interaction events.
 * Use the FruitDetailsFragment.newInstance factory method to
 * create an instance of this fragment.
 */
public class FruitDetailsFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "type";
    private static final String ARG_PARAM2 = "price";
    private static final String ARG_PARAM3 = "weight";


    private OnFragmentInteractionListener mListener;

    public FruitDetailsFragment() {
        // Required empty public constructor
    }


    public static FruitDetailsFragment newInstance(Fruit fruit) {
        FruitDetailsFragment fragment = new FruitDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fruit.getType());
        args.putString(ARG_PARAM2, fruit.formatPriceOfFruit());
        args.putString(ARG_PARAM3, fruit.formatWeightOfFruit());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fruit_details_fragment, container, false);
        TextView fruitType = v.findViewById(R.id.fruit_name);
        fruitType.setText(this.getArguments().getString("type"));
        TextView fruitPrice = v.findViewById(R.id.fruit_price);
        fruitPrice.setText(this.getArguments().getString("price"));
        TextView fruitWeight = v.findViewById(R.id.fruit_weight);
        fruitWeight.setText(this.getArguments().getString("weight"));
        Button ret = v.findViewById(R.id.return_to_list);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction();
            }
        });
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
    public interface OnFragmentInteractionListener {

        void onFragmentInteraction();
    }
}
