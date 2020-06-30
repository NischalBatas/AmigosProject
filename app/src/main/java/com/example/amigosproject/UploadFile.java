package com.example.amigosproject;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class UploadFile extends Fragment {
    Button browse, uploads;
    EditText text1, emailn,messagem ;
    ImageView imgg1;
    Uri FilePathUri;
    StorageReference sReference;
    File file;
    DatabaseReference dbReference;
    DatabaseReference dReference;
    int Image_Request_Code = 7;
    ProgressDialog progressDialog ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_upload_file, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        
        sReference = FirebaseStorage.getInstance().getReference("Images");
        dReference = FirebaseDatabase.getInstance().getReference("Images");
        browse = (Button)getView().findViewById(R.id.b1);
        uploads= (Button)getView().findViewById(R.id.b2);
        dbReference= FirebaseDatabase.getInstance().getReference().child("File");
        text1 = (EditText)getView().findViewById(R.id.text1);
        emailn=(EditText)getView().findViewById(R.id.eid);
        messagem=(EditText)getView().findViewById(R.id.mid);
        imgg1 = (ImageView)getView().findViewById(R.id.image_view);
        progressDialog = new ProgressDialog(getContext());// context name as per your project name
        file=new File();

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), Image_Request_Code);

            }
        });
        uploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                UploadImage();

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Image_Request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {

            FilePathUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), FilePathUri);
                imgg1.setImageBitmap(bitmap);
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


    public String GetFileExtension(Uri uri) {

        ContentResolver contentResolver = getActivity().getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;

    }


    public void UploadImage() {

        if (FilePathUri != null) {
            String imgid;
            imgid=System.currentTimeMillis() + "." + GetFileExtension(FilePathUri);
            file.setEmail(emailn.getText().toString().trim());
            file.setMessage(messagem.getText().toString().trim());
            file.setImgid(imgid);
            dbReference.setValue(file);
            progressDialog.setTitle("Please wait the image is loading");
            progressDialog.show();
            StorageReference obj2 = sReference.child(imgid);
            obj2.putFile(FilePathUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            String TempImageName = text1.getText().toString().trim();
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), " Uploaded Successfully ", Toast.LENGTH_LONG).show();
                            @SuppressWarnings("VisibleForTests")
                            imageupload obj1 = new imageupload(TempImageName, taskSnapshot.getUploadSessionUri().toString());
                            String ImageUploadId = dReference.push().getKey();
                            dReference.child(ImageUploadId).setValue(obj1);
                        }
                    });
        }
        else {

            Toast.makeText(getContext(), "Field is empty", Toast.LENGTH_LONG).show();

        }
    }

}
