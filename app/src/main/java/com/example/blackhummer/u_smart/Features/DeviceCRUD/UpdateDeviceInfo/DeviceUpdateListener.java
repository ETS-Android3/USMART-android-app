package com.example.blackhummer.u_smart.Features.DeviceCRUD.UpdateDeviceInfo;

import com.example.blackhummer.u_smart.Database.DatabaseQueryClass;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice.Device;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice.DeviceCreateDialogFragment;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice.DeviceCreateListener;
import com.example.blackhummer.u_smart.R;
import com.example.blackhummer.u_smart.Util.Config;
public interface DeviceUpdateListener {
    void onSubjectInfoUpdate(Device subject, int position);
}
