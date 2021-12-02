package com.example.blackhummer.u_smart.Features.RoomCRUD.UpdateRoomInfo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.blackhummer.u_smart.Database.DatabaseQueryClass;
import com.example.blackhummer.u_smart.Features.RoomCRUD.CreateRoom.Room;
import com.example.blackhummer.u_smart.R;
import com.example.blackhummer.u_smart.Util.Config;


public class RoomUpdateDialogFragment extends DialogFragment {

    private static long studentRegNo;
    private static int studentItemPosition;
    private static RoomUpdateListener roomUpdateListener;

    private Room mStudent;

    private EditText nameEditText;
    private EditText registrationEditText;
    private Button updateButton;
    private Button cancelButton;

    private String nameString = "";
    private long registrationNumber = -1;


    private DatabaseQueryClass databaseQueryClass;

    public RoomUpdateDialogFragment() {
        // Required empty public constructor
    }

    public static RoomUpdateDialogFragment newInstance(long registrationNumber, int position, RoomUpdateListener listener){
        studentRegNo = registrationNumber;
        studentItemPosition = position;
        roomUpdateListener = listener;
        RoomUpdateDialogFragment roomUpdateDialogFragment = new RoomUpdateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", "Update Room information");
        roomUpdateDialogFragment.setArguments(args);

        roomUpdateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return roomUpdateDialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student_update_dialog, container, false);

        databaseQueryClass = new DatabaseQueryClass(getContext());

        nameEditText = view.findViewById(R.id.studentNameEditText);
        registrationEditText = view.findViewById(R.id.registrationEditText);
        updateButton = view.findViewById(R.id.updateStudentInfoButton);
        cancelButton = view.findViewById(R.id.cancelButton);

        String title = getArguments().getString(Config.TITLE);
        getDialog().setTitle(title);

        mStudent = databaseQueryClass.getStudentByRegNum(studentRegNo);

        if(mStudent!=null){
            nameEditText.setText(mStudent.getName());
            registrationEditText.setText(String.valueOf(mStudent.getRegistrationNumber()));


            updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nameString = nameEditText.getText().toString();
                    registrationNumber = Integer.parseInt(registrationEditText.getText().toString());

                    mStudent.setName(nameString);
                    mStudent.setRegistrationNumber(registrationNumber);


                    long id = databaseQueryClass.updateStudentInfo(mStudent);

                    if(id>0){
                        roomUpdateListener.onStudentInfoUpdated(mStudent, studentItemPosition);
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

        }

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
