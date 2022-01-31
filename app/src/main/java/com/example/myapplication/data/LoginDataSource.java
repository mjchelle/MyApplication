package com.example.myapplication.data;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapplication.data.model.LoggedInUser;
import com.example.myapplication.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    /*FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userRef;*/

    public Result<LoggedInUser> login(String username, String password, FirebaseAuth mAuth) {
        final boolean[] worked = {false};
        final FirebaseUser[] user = new FirebaseUser[1];
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        try {
            // TODO: handle loggedInUser authentication
            mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener
                    ( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithCustomToken:success");
                                user[0] = mAuth.getCurrentUser();
                               // LoginActivity.updateUiWithFirebaseUser(user);
                                //return new Result.Success<>(user);
                                worked[0] = true;
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                                //Toast.makeText(LoginDataSource.this, "Authentication failed.",
                                        //Toast.LENGTH_SHORT).show();
                                //updateUiWithUser(null);//TODO: change
                            }
                        }
                    });
           /* LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");*/
            if (worked[0]) return new Result.Success<>(user[0]);
            else return new Result.Error(new Exception());

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }


    public Result<LoggedInUser> register(String username, String password, FirebaseAuth mAuth) {
        final boolean[] worked = {false};
        final FirebaseUser[] user = new FirebaseUser[1];
        try {
            // TODO: handle loggedInUser authentication
            mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener
                    ( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithCustomToken:success");
                                user[0] = mAuth.getCurrentUser();
                                // LoginActivity.updateUiWithFirebaseUser(user);
                                //return new Result.Success<>(user);
                                worked[0] = true;
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                                //Toast.makeText(LoginDataSource.this, "Authentication failed.",
                                //Toast.LENGTH_SHORT).show();
                                //updateUiWithUser(null);//TODO: change
                            }
                        }
                    });
            if (worked[0]) return new Result.Success<>(user[0]);
            else return new Result.Error(new Exception());

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}