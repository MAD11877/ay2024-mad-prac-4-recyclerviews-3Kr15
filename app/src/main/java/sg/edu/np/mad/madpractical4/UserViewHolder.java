package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.app.AlertDialog;

import androidx.recyclerview.widget.RecyclerView;

//Class UserViewHolder() to store each random user image, name and description.
public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView smallImage;
    TextView name;
    TextView description;
    Button follow;
    Button view;

    public UserViewHolder(View itemView){
        super(itemView);
        //Location of image, name and description found in custom_activity_list.xml
        smallImage = itemView.findViewById(R.id.ivSmallImage);
        name = itemView.findViewById(R.id.tvName);
        description = itemView.findViewById(R.id.tvDescription);
        follow = itemView.findViewById(R.id.btnFollow);
        view = itemView.findViewById(R.id.button2);
    }

    public void bind (User user){
        smallImage.setImageResource(user.getSmallImageResourceId());
        name.setText(user.getName());
        description.setText(user.getDescription());

        smallImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                builder.setMessage(user.getName())
                        .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                dialog.dismiss();
                            }
                        });
                builder.create().show();
            }
        });
    }
}
