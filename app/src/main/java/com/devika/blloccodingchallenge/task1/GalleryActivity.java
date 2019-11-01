package com.devika.blloccodingchallenge.task1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.devika.blloccodingchallenge.R;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    RecyclerView folderRecycler;
    TextView errorView;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        errorView = findViewById(R.id.empty);
        folderRecycler = findViewById(R.id.folderRecycler);
        folderRecycler.addItemDecoration(new MarginDecoration(this));
        folderRecycler.hasFixedSize();
        if (isReadStoragePermissionGranted()) {
            setList();
        }
    }

    private void setList() {
        ArrayList<ImageFolder> folds = Utils.getPicturePaths(this);
        if (folds.isEmpty()) {
            errorView.setText(getString(R.string.empty));
            errorView.setVisibility(View.VISIBLE);
        } else {
            RecyclerView.Adapter folderAdapter = new GalleryAdapter(folds, GalleryActivity.this);
            folderRecycler.setAdapter(folderAdapter);
        }
    }

    public boolean isReadStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                return false;
            }
        } else {
            //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setList();
            } else {
                errorView.setText(getString(R.string.permission_denied));
                errorView.setVisibility(View.VISIBLE);
            }
        }
    }
}

