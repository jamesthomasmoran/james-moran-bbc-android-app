package moran.james.fruitylist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

/**
 * Application Launch Activity
 */
public class MainActivity extends FragmentActivity implements FruitListFragment.OnListFragmentInteractionListener, FruitDetailsFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onListFragmentInteraction(Fruit fruit) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

        FruitDetailsFragment fDF = FruitDetailsFragment.newInstance(fruit);
        Fragment fLF = fm.findFragmentById(R.id.fruit_list);

        fm.beginTransaction().hide(fLF).commit();

        fm.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .add(R.id.content_window, fDF)
                .commit();

        Long timestamp = System.currentTimeMillis();

        String[] queryParams = {"display", Long.toString(timestamp)};

        new InteractionRecordTask().execute(queryParams);
    }


    @Override
    public void onFragmentInteraction() {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

        Fragment fDF = fm.getFragments().get(1);
        Fragment fLF = fm.findFragmentById(R.id.fruit_list);

        fm.beginTransaction().remove(fDF).commit();

        fm.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .show(fLF)
                .commit();

        Long timestamp = System.currentTimeMillis();

        String[] queryParams = {"display", Long.toString(timestamp)};

        new InteractionRecordTask().execute(queryParams);
    }
}


