package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    public ToggleButton toggleFlashLightOnOff;
    public ToggleButton toggleFlashLightOnOffFront;
    public CameraManager cameraManager;
    public String getCameraID;
    public String getCameraIDFront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleFlashLightOnOff = findViewById(R.id.toggle_flashlight);
        toggleFlashLightOnOffFront = findViewById(R.id.toggle_flashlight_front);

        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            // O means back camera unit,
            getCameraID = cameraManager.getCameraIdList()[0];
            // 1 means front camera unit
            getCameraIDFront = cameraManager.getCameraIdList()[1];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    //back flashlight
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void toggleFlashLight(View view) {
        if (toggleFlashLightOnOff.isChecked()) {
            try {
                cameraManager.setTorchMode(getCameraID, true);
                toggleFlashLightOnOff.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_corner));
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } else {
            try {
                cameraManager.setTorchMode(getCameraID, false);
                toggleFlashLightOnOff.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_corner));
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    //front flashlight
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void toggleFlashLightFront(View view) {
        if (toggleFlashLightOnOffFront.isChecked()) {
            try {
                cameraManager.setTorchMode(getCameraIDFront, true);
                toggleFlashLightOnOffFront.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_corner));
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } else {
            try {
                cameraManager.setTorchMode(getCameraIDFront, false);
                toggleFlashLightOnOffFront.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_corner));
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }
}