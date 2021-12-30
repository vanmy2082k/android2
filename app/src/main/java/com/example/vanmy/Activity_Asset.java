package com.example.vanmy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class Activity_Asset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset);

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("truyen.pdf")
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }
}