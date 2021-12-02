package com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice;

public class Device {
    private long id;
    private String name;
    private int code;


    public Device(long id, String name, int code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}