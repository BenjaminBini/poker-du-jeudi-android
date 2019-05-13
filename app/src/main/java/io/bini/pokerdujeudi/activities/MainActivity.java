package io.bini.pokerdujeudi;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView menuView;
    private RecyclerView.Adapter menuViewAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuView = findViewById(R.id.menu_view);
        menuView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        menuView.setLayoutManager(layoutManager);

        List<MenuEntry> menuEntries = new ArrayList<>();
        menuEntries.add(new MenuEntry("Sessions", 0));
        menuEntries.add(new MenuEntry("Players", R.layout.players));
        menuViewAdapter = new MenuViewAdapter(menuEntries);
        menuView.setAdapter(menuViewAdapter);
    }

    public void addSession(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment existingFragment = getSupportFragmentManager().findFragmentByTag("players_fragment");
        if (existingFragment != null) {
            fragmentTransaction.detach(existingFragment);
        }
        fragmentTransaction.addToBackStack(null);
        DialogFragment playersFragment = new PlayersFragment();
        playersFragment.show(fragmentManager, "players_fragment");
    }

}
