package io.bini.pokerdujeudi;

import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lombok.Setter;

public class MenuViewAdapter extends RecyclerView.Adapter<MenuViewAdapter.MenuViewHolder> {
    private List<MenuEntry> menuEntries;

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout menuLayout;

        @Setter
        public int targetLayout;

        public MenuViewHolder(ConstraintLayout cl) {
            super(cl);
            menuLayout = cl;
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent;
                    switch(targetLayout) {
                        case R.layout.players:
                            intent = new Intent(context, PlayersActivity.class);
                            break;
                        default:
                            intent = new Intent(context, MainActivity.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

    public MenuViewAdapter(List<MenuEntry> menuEntries) {
        this.menuEntries = menuEntries;
    }

    @Override
    public MenuViewAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout menuLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_holder, parent, false);
        MenuViewHolder vh = new MenuViewHolder(menuLayout);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView menuText = holder.menuLayout.findViewById(R.id.menu_text);
        menuText.setText(menuEntries.get(position).getLabel());
        holder.setTargetLayout(menuEntries.get(position).getTarget());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return menuEntries.size();
    }
}
