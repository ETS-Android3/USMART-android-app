package com.example.blackhummer.u_smart.Rooms;

public class RoomObject {

        public static final String TABLE_NAME = "room";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";


        private int id;
        private String name;
        private String img;

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + COLUMN_NAME + " TEXT"
                        + ")";

        public RoomObject() {
        }

        public RoomObject(int id, String name) {
            this.setId(id);
            this.setName(name);
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
}