package com.example.blackhummer.u_smart.Util;

public class Config {

    public static final String DATABASE_NAME = "room-db";

    //column names of student table
    public static final String TABLE_ROOM = "room";
    public static final String COLUMN_ROOM_ID = "_id";
    public static final String COLUMN_ROOM_NAME = "name";
    public static final String COLUMN_ROOM_REGISTRATION = "registration_no";


    //column names of subject table
    public static final String TABLE_DEVICE = "device";
    public static final String COLUMN_DEVICE_ID = "_id";
    public static final String COLUMN_REGISTRATION_NUMBER = "fk_registration_no";
    public static final String COLUMN_DEVICE_NAME = "name";
    public static final String COLUMN_DEVICE_CODE = "device_code";
    public static final String ROOM_SUB_CONSTRAINT = "room_sub_unique";

    //others for general purpose key-value pair data
    public static final String TITLE = "title";
    public static final String CREATE_ROOM = "create_room";
    public static final String UPDATE_ROOM = "update_room";
    public static final String CREATE_DEVICE = "create_device";
    public static final String UPDATE_DEVICE = "update_device";
    public static final String ROOM_REGISTRATION = "student_registration";
}
