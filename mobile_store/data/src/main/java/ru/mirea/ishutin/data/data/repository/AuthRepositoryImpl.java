package ru.mirea.ishutin.data.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ru.mirea.ishutin.domain.domain.models.User;
import ru.mirea.ishutin.domain.domain.repository.AuthCallback;
import ru.mirea.ishutin.domain.domain.repository.AuthRepository;
import ru.mirea.ishutin.domain.domain.repository.UserCallback;

public class AuthRepositoryImpl implements AuthRepository {

    private final FirebaseAuth auth;

    public AuthRepositoryImpl() {
        this.auth = FirebaseAuth.getInstance();
    }

    @Override
    public void signIn(String email, String password, AuthCallback callback) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                callback.onSuccess();
            } else {
                callback.onError(task.getException() != null
                        ? task.getException().getMessage()
                        : "Sign-in failed");
            }
        });
    }

    @Override
    public void signUp(String email, String password, AuthCallback callback){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
           if (task.isSuccessful()){
               callback.onSuccess();
           }else {
               callback.onError(task.getException() != null
                       ? task.getException().getMessage()
                       : "Sign-up failed");
           }
        });
    }


    @Override
    public void signOut(AuthCallback callback) {
        auth.signOut();
        callback.onSuccess();
    }

    @Override
    public boolean isUserLoggedIn() {
        FirebaseUser user = auth.getCurrentUser();
        return user != null;
    }

    @Override
    public String getUserId() {
        return auth.getCurrentUser().getUid();
    }

    @Override
    public void getUserInfo(String id, UserCallback userCallback) {
        if (auth.getCurrentUser() != null) {
            userCallback.onSuccess(new User(id, auth.getCurrentUser().getDisplayName(), auth.getCurrentUser().getEmail()));
        } else {
            userCallback.onError("Error, no user");
        }
    }


}
