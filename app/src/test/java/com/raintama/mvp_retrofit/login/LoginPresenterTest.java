package com.raintama.mvp_retrofit.login;

import android.support.annotation.NonNull;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Scope;
import com.raintama.mvp_retrofit.connection.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import retrofit2.Call;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginContract.View view;

    @Mock
    private LoginContract.Interactor interactor;

    @Mock
    private Call call;

    @Mock
    private View mView;

    @Mock
    private GoogleSignInAccount googleSignInAccount;

    @Mock
    private GoogleSignInResult googleSignInResult;

    @Mock
    private User user;

    private LoginPresenter presenter;

    @Before
    public void setUp() {
        presenter = new LoginPresenter(view);
    }

    @Test
    public void permissionGoogle() {
        presenter.permissionGoogle();
        verify(view).googleAPIClientBuild();
    }

    @Test
    public void googleLogin() {
        presenter.googleLogin(mView);
        verify(view).doSignInGoogleView();
    }

    @Test
    public void handleSignInGoogle() {
        presenter.handleSignInGoogle(googleSignInResult);
//        verify(view).signInGoogleSuccess(googleSignInResult);
        verify(view).signInGoogleFailed(googleSignInResult);
    }

    private GoogleSignInAccount createGoogleSignInAccountFromToken(@NonNull String token, @NonNull Set<Scope> grantedScopes) {
        when(googleSignInAccount.getIdToken()).thenReturn(token);
        when(googleSignInAccount.getGrantedScopes()).thenReturn(grantedScopes);
        return googleSignInAccount;
    }

    @Test
    public void callLoginSuccess() {
        presenter.callLoginSuccess(user);
        verify(view).loginSuccess(user);
    }

    @Test
    public void callLoginFailed() {
        String MESSAGE = "gagal login dengan google";

        presenter.callLoginFailed(MESSAGE);
        verify(view).showServerErrorDialog(MESSAGE);
    }

    @Test
    public void onNoConnection() {
        presenter.onNoConnection(call);
        verify(view).retryDialog(call);
    }
}