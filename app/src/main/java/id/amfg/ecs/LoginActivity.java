package id.amfg.ecs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import id.amfg.ecs.api.ApiUtils;
import id.amfg.ecs.api.CoreApiInterface;
import id.amfg.ecs.model.LoginModel;
import id.amfg.ecs.model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

//    private static final String[] DUMMY_CREDENTIALS = new String[]{
//            "ridwan:123456", "bar@example.com:world"
//    };

    // UI references.
    private EditText mUseridView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    View focusView = null;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        mUseridView = findViewById(R.id.userid);
        mPasswordView = findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mbtnLogin = findViewById(R.id.btnLogin);
        mbtnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void attemptLogin() {
        boolean cancel = loginValidation();

        if (cancel) {
            focusView.requestFocus();
        }
        else {
            showProgress(true);
            CoreApiInterface coreApi = ApiUtils.getCoreApi();
            final String userid = mUseridView.getText().toString();
            String password = mPasswordView.getText().toString();
            coreApi.login(
                    "application/json"
                    , new LoginModel(userid, password))
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {
                                try {
                                    showProgress(false);
                                    if (response.body() != null){
                                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                        User userObj = new Gson().fromJson(jsonRESULTS.toString(), User.class);

                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.putExtra("user", userObj.getZuusna());
                                        startActivity(intent);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                showProgress(false);
                                Toast.makeText(mContext, "Invalid credential, please check your user id or password", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.e("debug", "onFailure: ERROR > " + t.toString());
                            showProgress(false);
                        }
                    });
        }
    }

    private boolean loginValidation() {
        // Reset errors.
        mUseridView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String userid = mUseridView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        // Check for a valid password
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        // Check for a valid user id
        if (TextUtils.isEmpty(userid)) {
            mUseridView.setError(getString(R.string.error_field_required));
            focusView = mUseridView;
            cancel = true;
        }

        return cancel;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}

