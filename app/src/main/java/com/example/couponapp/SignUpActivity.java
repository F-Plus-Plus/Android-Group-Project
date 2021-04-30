package com.example.couponapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.PasswordAuthentication;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    public static final int GET_FROM_GALLERY = 7;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;
    private ImageView ivProfilePic;
    private Button btnUploadPic;
    private Button btnSignUp;
    private boolean isSaved;
    private Bitmap bitmap;
    private Uri imageUri;
    ParseFile parseFile;

    private File photoFile;
    public String photoFileName = "picture.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        etUsername = findViewById(R.id.etUsername);
        etUsername.setText(getIntent().getStringExtra("username"));

        etPassword = findViewById(R.id.etPassword);
        etPassword.setText(getIntent().getStringExtra("password"));

        etEmail = findViewById(R.id.etEmail);
        ivProfilePic = findViewById(R.id.ivPicture);

        // Create a File reference for future access
        photoFile = getPhotoFileUri(photoFileName);
        ParseFile parseFile = new ParseFile(photoFile);

        btnUploadPic = findViewById(R.id.btnUploadPic);
        btnUploadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { uploadFromGallery(); }
        });

        photoFile = getPhotoFileUri(photoFileName);

        btnSignUp = findViewById(R.id.btnFinishSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpUser(etUsername.getText().toString(), etPassword.getText().toString(),
                        etEmail.getText().toString(), photoFile);
            }
        });
    }

    private void uploadFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GET_FROM_GALLERY);
    }

    // Returns the File for a photo stored on disk given the fileName
    public File getPhotoFileUri(String fileName) {
        // Get safe storage directory for photos
        // Use `getExternalFilesDir` on Context to access package-specific directories.
        // This way, we don't need to request external read/write runtime permissions.
        File mediaStorageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), TAG);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
            Log.d(TAG, "failed to create directory");
        }

        // Return the file target for the photo based on filename
        return new File(mediaStorageDir.getPath() + File.separator + fileName);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {
                case GET_FROM_GALLERY:
                    if (resultCode == RESULT_OK) {
                        imageUri = data.getData();
                        bitmap = uriToBitmap(imageUri);
                        ivProfilePic.setImageBitmap(bitmap);
                        break;
                    } else if (resultCode == Activity.RESULT_CANCELED) {
                        Log.e(TAG, "Selecting picture cancelled");
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception in onActivityResult : " + e.getMessage());
        }
    }

    private Bitmap uriToBitmap(Uri selectedFileUri) {
        Bitmap image = null;
        try {
            ParcelFileDescriptor parcelFileDescriptor =
                    getContentResolver().openFileDescriptor(selectedFileUri, "r");
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
            parcelFileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private void signUpUser(String username, String password, String email, File photoFile) {
        Log.i(TAG, "Attempting to sign up new user:" + username);
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        if (email.length() > 0)
            user.setEmail(email);

        // TODO: Upload own profile picture while signing up
        /*
        ParseFile file = new ParseFile(photoFile);
        file.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){ e.printStackTrace(); }
                // Invoke signUpInBackground

            }
        }); */

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e != null){
                    Log.e(TAG, "Error while signing up.", e);
                    Toast.makeText(SignUpActivity.this, "Error while signing up!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(SignUpActivity.this, "Successfully signed up.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}