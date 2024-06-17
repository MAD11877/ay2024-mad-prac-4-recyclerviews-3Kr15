package sg.edu.np.mad.madpractical4;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    private ArrayList<User> list_objects;
    //private ListActivity activity;
    private static Context context;
    public UserAdapter(ArrayList<User> list_objects, ListActivity activity){
        this.list_objects = list_objects;
        // this.activity = activity;
        this.context = context;
    }
    //Method to create a view holder for a username.
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;
    }
    //Method to bind username to a view holder.
    public void onBindViewHolder(UserViewHolder holder, int position){
        //Get position of a username
        User list_items = list_objects.get(position);
        //Set username to the view holder based on custom_activity_list.xml
        holder.name.setText(list_items.getName());
        //Set description to the view holder based on custom_activity_list.xml
        holder.description.setText(list_items.getDescription());

        String name = list_items.getName();
        char lastChar = name.charAt(name.length() - 1);

        ImageView imageView = holder.itemView.findViewById(R.id.ivSmallImage);

        if(!name.isEmpty() && lastChar == '7') {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }


        holder.smallImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                builder.setMessage(list_items.getName());
                builder.setTitle("Profile");
                builder.setCancelable(false);
                builder.setPositiveButton("CLOSE", (DialogInterface.OnClickListener) (dialog, which) -> {
                    Bundle userinfo = new Bundle();
                    userinfo.putString("name", list_items.getName());
                    userinfo.putString("description", list_items.getDescription());
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                });

                builder.setNegativeButton("CLOSE", (DialogInterface.OnClickListener)(dialog, which) -> {
                    dialog.cancel();
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }
    public int getItemCount() { return list_objects.size(); }
}
