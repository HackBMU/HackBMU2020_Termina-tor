package com.z3t4z00k.hackvsit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class placesadapter extends RecyclerView.Adapter<placesadapter.ViewHolder> {
    private Context context;
    private List<adapterplace> listurl;
    boolean urlformat;

    public placesadapter(Context context, List<adapterplace> listurl) {
        this.context = context;
        this.listurl = listurl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.placecnearby,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final adapterplace data= listurl.get(i);
        viewHolder.folder_name.setText(listurl.get(i).getName());
        viewHolder.url.setText(listurl.get(i).getUrl());
        viewHolder.desc.setText(listurl.get(i).getDesc());
        viewHolder.gotourl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String link=data.getUrl();
                if(link.matches("https")||link.matches("http"))
                {
                    urlformat=true;
                }
                if(!urlformat)
                {
                    link="https://"+data.getUrl();
                }
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                context.startActivity(intent);



            }
        });
    }

    @Override
    public int getItemCount() {
        return listurl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView url;
        public TextView folder_name;
        public Button gotourl;
        public TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            folder_name=(TextView) itemView.findViewById(R.id.title);
            url=(TextView)itemView.findViewById(R.id.urlcontain);
            gotourl =(Button) itemView.findViewById(R.id.gotourl);
            desc=(TextView)itemView.findViewById(R.id.description);

        }
    }
}
