package sg.edu.np.mad.madpractical4;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;

import androidx.recyclerview.widget.RecyclerView;

//Class UserViewHolder() to store each random user image, name and description.
public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView smallImage;
    TextView name;
    TextView description;

    public UserViewHolder(View itemView){
        super(itemView);
        //Location of image, name and description found in custom_activity_list.xml
        smallImage = itemView.findViewById(R.id.ivSmallImage);
        name = itemView.findViewById(R.id.tvName);
        description = itemView.findViewById(R.id.tvDescription);
    }
}
