package com.example.blackhummer.u_smart.Features.DeviceCRUD.UpdateDeviceInfo;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.blackhummer.u_smart.Database.DatabaseQueryClass;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice.Device;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice.DeviceCreateDialogFragment;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice.DeviceCreateListener;
import com.example.blackhummer.u_smart.R;
import com.example.blackhummer.u_smart.Util.Config;

public class DeviceUpdateDialogFragment extends DialogFragment {

    private EditText subjectNameEditText;
    private EditText subjectCodeEditText;
    private EditText subjectCreditEditText;
    private Button updateButton;
    private Button cancelButton;

    private static DeviceUpdateListener subjectUpdateListener;
    private static long subjectId;
    private static int position;

    private DatabaseQueryClass databaseQueryClass;

    public DeviceUpdateDialogFragment() {
        // Required empty public constructor
    }

    public static DeviceUpdateDialogFragment newInstance(long subId, int pos, DeviceUpdateListener listener){
        subjectId = subId;
        position = pos;
        subjectUpdateListener = listener;

        DeviceUpdateDialogFragment subjectUpdateDialogFragment = new DeviceUpdateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", "Update subject information");
        subjectUpdateDialogFragment.setArguments(args);

        subjectUpdateDialogFragment.setStyle(android.support.v4.app.DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return subjectUpdateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject_update_dialog, container, false);

        subjectNameEditText = view.findViewById(R.id.subjectNameEditText);
        subjectCodeEditText = view.findViewById(R.id.subjectCodeEditText);
        updateButton = view.findViewById(R.id.updateButton);
        cancelButton = view.findViewById(R.id.cancelButton);

        databaseQueryClass = new DatabaseQueryClass(getContext());

        String title = getArguments().getString(Config.TITLE);
        getDialog().setTitle(title);

        Device subject = databaseQueryClass.getSubjectById(subjectId);

        subjectNameEditText.setText(subject.getName());
        subjectCodeEditText.setText(String.valueOf(subject.getCode()));

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subjectName = subjectNameEditText.getText().toString();
                int subjectCode = Integer.parseInt(subjectCodeEditText.getText().toString());
                double subjectCredit = Double.parseDouble(subjectCreditEditText.getText().toString());

                Device subject = new Device(subjectId, subjectName, subjectCode);

                long rowCount = databaseQueryClass.updateSubjectInfo(subject);

                if(rowCount>0){
                    subjectUpdateListener.onSubjectInfoUpdate(subject, position);
                    getDialog().dismiss();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            //noinspection ConstantConditions
            dialog.getWindow().setLayout(width, height);
        }
    }

}
