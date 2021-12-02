package com.example.blackhummer.u_smart.Rooms;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blackhummer.u_smart.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.util.ArrayList;
import java.util.List;



import com.example.blackhummer.u_smart.Rooms.RoomObject;
import com.example.blackhummer.u_smart.Rooms.RoomAdapter;
import com.example.blackhummer.u_smart.Rooms.RoomtDB;
import com.example.blackhummer.u_smart.Rooms.RoomItemClick;


public class Rooms extends AppCompatActivity {

    private RoomAdapter productAdapter;
    private List<RoomObject> productObjectList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView emptyproduct;
    private static final int REQUEST_WRITE_PERMISSION = 786;
    ImageView photoproduct, img;
    Uri imguri=null;
    private RoomtDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        toggleEmptyProduct();
        productObjectList.addAll(db.getAllProducts());
        productAdapter = new  RoomAdapter(this, productObjectList);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(productAdapter);
        recyclerView.addOnItemTouchListener(new  RoomItemClick(this, recyclerView, new  RoomItemClick.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
            }
            @Override
            public void onLongClick(View view, int position) {
                showActionsDialog(position);
            }
        }));
        toggleEmptyProduct();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProductDialog(false, null, -1);
            }
        });
    }
    public void init(){
        db = new RoomtDB(this);
        recyclerView = findViewById(R.id.recycler_view);
        emptyproduct = findViewById(R.id.emptyproduct);
    }
    /**
     * Toggling list and empty products view
     */
    private void toggleEmptyProduct() {
        // you can check productObjectList.size() > 0
        if (db.getProductsCount() > 0) {
            emptyproduct.setVisibility(View.GONE);
        } else {
            emptyproduct.setVisibility(View.VISIBLE);
        }
    }

    private void createProduct(RoomObject product) {
        // inserting product in db and getting
        // newly inserted product id
        long id = db.insertProduct(product);
        // get the newly inserted product from db
        RoomObject n = db.getProduct(id);
        if (n != null) {
            // adding new product to array list at 0 position
            productObjectList.add(0, n);
            // refreshing the list
            productAdapter.notifyDataSetChanged();
        }
        toggleEmptyProduct();
    }



    private void updateProduct(RoomObject product, int position) {
        RoomObject p = productObjectList.get(position);
        // updating product text
        p.setName(product.getName());
        // updating product in db
        db.updateProduct(p);
        // refreshing the list
        productObjectList.set(position, p);
        productAdapter.notifyItemChanged(position);
    }


    private void deleteProduct(int position) {
        // deleting the product from db
        db.deleteProduct(productObjectList.get(position));
        // removing the product from the list
        productObjectList.remove(position);
        productAdapter.notifyItemRemoved(position);
    }



    /**
     * This Dialog Is For Edit & Delete options
     * Edit - 0
     * Delete - 0
     */
    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Edit Product", "Delete Product"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose option");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showProductDialog(true, productObjectList.get(position), position);
                } else {
                    deleteProduct(position);
                }
            }
        });
        builder.show();
    }



    /**
     * Shows alert dialog with EditText options to enter / edit
     * a product.
     * when shouldUpdate=true, it automatically displays old product and changes the
     * button text to UPDATE
     */
    private void showProductDialog(final boolean shouldUpdate, final RoomObject product, final int position) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.dialog_insert, null);
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(Rooms.this);
        alertDialogBuilderUserInput.setView(view);
        photoproduct = view.findViewById(R.id.photoproduct);
        img = view.findViewById(R.id.img);
        final EditText nameproduct = view.findViewById(R.id.nameproduct);
        // Product photos setOnClickListener
        photoproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if Build SDK version
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    // Request Permission
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
                } else {
                    // Start pick image
                    CropImage.startPickImageActivity(Rooms.this);
                }
            }
        });
        TextView dialogTitle = view.findViewById(R.id.dialog_title);
        dialogTitle.setText(!shouldUpdate ? "ADD NEW ROOM" : "EDIT ROOM");
        if (shouldUpdate && product != null) {
          //  photoproduct.setImageURI(Uri.parse(product.getImg()));
            nameproduct.setText(product.getName());
        }
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton(shouldUpdate ? "Update" : "Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                    }
                })
                .setNegativeButton("Cencel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });
        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message when no text is entered
                if (TextUtils.isEmpty(nameproduct.getText().toString())) {
                    Toast.makeText(Rooms.this, "Enter product!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    alertDialog.dismiss();
                }
                // create product object
                RoomObject p = new RoomObject();
                p.setName(nameproduct.getText().toString());
          //      p.setImg(imguri.toString());
                // check if user updating product
                if (shouldUpdate) {
                    // collect data with object
                    updateProduct(p, position);
                } else {
                    // create new product
                    createProduct(p);
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // Check if callback request permission relost is Granted and Write Permission
        if (requestCode == REQUEST_WRITE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            CropImage.startPickImageActivity(Rooms.this);
        }
    }
    @Override
    @SuppressLint("NewApi")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // Retrieve Uri of Pick
            Uri imageUri = CropImage.getPickImageResultUri(getApplicationContext(), data);
            // And now check when permission is granted
            if (CropImage.isReadExternalStoragePermissionsRequired(getApplicationContext(), imageUri)) {
                // If permission is not granted, you need to request again to user
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
            } else {
                // When pick image result is success and Permission Granted
                // Starting crop image
                Crop(imageUri);
            }
        }
        // Check result for cropped image
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                // Result Ok
                // Set image URI to photoproduct
                photoproduct.setImageURI(result.getUri());
                // Get image uri for save into img uri for saving
                imguri = result.getUri();
                // Set visibility gone for camera icon
                img.setVisibility(View.GONE);
            }
        }
    }
    private void Crop(Uri imageUri) {
        CropImage.activity(imageUri)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setRequestedSize(500, 500)
                .setMultiTouchEnabled(true)
                .setAspectRatio(1,1)
                .start(this);
    }
}