package ru.mirea.ishutin.data.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ru.mirea.ishutin.domain.domain.repository.AuthCallback;
import ru.mirea.ishutin.domain.domain.repository.AuthRepository;

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
}
