package com.example.studentshelpapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class UploadListAdapter extends RecyclerView.Adapter<UploadListAdapter.ViewHolder> {
    public List<String> fileNameList;
    public List<String> fileDoneList;
    private OnCrossListener onCrossListener;

    public UploadListAdapter(List<String> fileNameList,List<String>fileDoneList,OnCrossListener onCrossListener)
    {
        this.fileDoneList=fileDoneList;
        this.fileNameList=fileNameList;
        this.onCrossListener=onCrossListener;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_tem,parent,false);
        return new ViewHolder(v,onCrossListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         String fileName=fileNameList.get(position);
         holder.fileName.setText(fileName);
    }

    @Override
    public int getItemCount() {
        return fileNameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView cross;
        public TextView fileName;
        private OnCrossListener onCrossListener;

        public ViewHolder(@NonNull View itemView,OnCrossListener onCrossListener) {
            super(itemView);


            fileName=(TextView) itemView.findViewById(R.id.upload_filename);
            cross=(ImageView)itemView.findViewById(R.id.cross);
            this.onCrossListener=onCrossListener;


            cross.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           if(view.getId()==cross.getId())
           {
               //Log.d("pressed",Integer.toString(getAdapterPosition())+"cross is pressed");
               onCrossListener.onCrossClick(getAdapterPosition());

           }

        }
    }
    public interface OnCrossListener{
        void onCrossClick(int position);
    }



}
