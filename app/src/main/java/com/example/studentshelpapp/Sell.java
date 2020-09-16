package com.example.studentshelpapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Sell extends AppCompatActivity implements UploadListAdapter.OnCrossListener {
    Button mSelectButton;
    RecyclerView mUploadList;
    private int RESULT_LOAD_IMAGE=1;
    private List<String> fileNameList;
    private List<String > fileDoneList;
    private List<Uri> fileUriList;
    private UploadListAdapter uploadListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Sell");
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Spinner dropdown = findViewById(R.id.spinner);

        String[] items = new String[]{"ED Kit","Bicycle","Books/Notes","Apron","Other"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);
        mSelectButton=findViewById(R.id.btnchoose);
        mUploadList=findViewById(R.id.uploadList);

        fileNameList=new ArrayList<>();
        fileDoneList=new ArrayList<>();
        fileUriList=new ArrayList<>();
        uploadListAdapter=new UploadListAdapter(fileNameList,fileDoneList,this);
        //Recycler View
        mUploadList.setLayoutManager(new LinearLayoutManager(this));
       mUploadList.setHasFixedSize(true);
       mUploadList.setAdapter(uploadListAdapter);

        mSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"),RESULT_LOAD_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_LOAD_IMAGE&&resultCode==RESULT_OK)
        {
            if(data.getClipData()!=null)
            {
                int totalItemSelected=data.getClipData().getItemCount();
                for(int i = 0; i < totalItemSelected; i++)
                {
                    Uri fileUri=data.getClipData().getItemAt(i).getUri();
                    String fileName = getFileName(fileUri);
                    fileNameList.add(fileName);
                    fileUriList.add(fileUri);
                    uploadListAdapter.notifyDataSetChanged();


                }
                //Toast.makeText(Sell.this,"Selected Multiple Images",Toast.LENGTH_LONG).show();

            }
            else if(data.getData()!=null)
            {
                Uri fileUri=data.getData();
                String fileName = getFileName(fileUri);
                fileNameList.add(fileName);
                fileUriList.add(fileUri);
                uploadListAdapter.notifyDataSetChanged();
                //Toast.makeText(Sell.this,"Selected Single Image",Toast.LENGTH_LONG).show();
            }

        }
    }
    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }



    @Override
    public void onCrossClick(int position) {
       fileNameList.remove(position);
       fileUriList.remove(position);
       uploadListAdapter.notifyDataSetChanged();
    }


}

