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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "ridwan:123456", "bar@example.com:world"
    };

    //private UserLoginTask mAuthTask = null;

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
        mUseridView = (EditText) findViewById(R.id.userid);
        mPasswordView = (EditText) findViewById(R.id.password);
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

        Button mbtnLogin = (Button) findViewById(R.id.btnLogin);
        mbtnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

//    private void attemptLogin() {
//        showProgress(true);
//
//        // Reset errors.
//        mUseridView.setError(null);
//        mPasswordView.setError(null);
//
//        // Store values at the time of the login attempt.
//        String userid = mUseridView.getText().toString();
//        String password = mPasswordView.getText().toString();
//
//        boolean cancel = false;
//        View focusView = null;
//
//        // Check for a valid password, if the user entered one.
//        if (TextUtils.isEmpty(password)) {
//            mPasswordView.setError(getString(R.string.error_invalid_password));
//            focusView = mPasswordView;
//            cancel = true;
//        }
//
//        // Check for a valid email address.
//        if (TextUtils.isEmpty(userid)) {
//            mUseridView.setError(getString(R.string.error_field_required));
//            focusView = mUseridView;
//            cancel = true;
//        }
//
//        if (cancel) {
//            // There was an error; don't attempt login and focus the first
//            // form field with an error.
//            focusView.requestFocus();
//        } else {
//            coreApi.login(
//                    "application/json"
//                    , new LoginModel(userid, password))
//                    .enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            if (response.isSuccessful()) {
//                                showProgress(false);
//                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                startActivity(intent);
//                                try {
//                                    JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                    if (jsonRESULTS.getString("error").equals("false")) {
//                                        Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
//                                        //String nama = jsonRESULTS.getJSONObject("user").getString("nama");
//                                        Intent intent = new Intent(mContext, MainActivity.class);
//                                        //intent.putExtra("result_nama", nama);
//                                        startActivity(intent);
//                                    } else {
//                                        // Jika login gagal
//                                        String error_message = "LOGIN GAGAL";
//                                        Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
//                                    }
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            } else {
//                                showProgress(false);
//                                Toast.makeText(mContext, response.message(), Toast.LENGTH_LONG).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//                            Log.e("debug", "onFailure: ERROR > " + t.toString());
//                            showProgress(false);
//                        }
//                    });
//        }
//    }

    private void attemptLogin() {
        boolean mCancel = this.loginValidation();
        if (mCancel) {
            focusView.requestFocus();
        } else {
            String userid = mUseridView.getText().toString();
            String password = mPasswordView.getText().toString();

            //loginProcessWithRetrofit(userid, password);
            Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
            loginIntent.putExtra("USER", userid);
            startActivity(loginIntent);
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

    private void loginProcessWithRetrofit(final String userid, String password) {
        CoreApiInterface coreApi = ApiUtils.getCoreApi();
        coreApi.login(
                "application/json"
                , new LoginModel(userid, password))
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                            loginIntent.putExtra("USER", userid);
                            startActivity(loginIntent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        call.cancel();
                        Toast.makeText(LoginActivity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
                    }
                });
    }

//    private void attemptLogin() {
//        if (mAuthTask != null) {
//            return;
//        }
//
//        if (cancel) {
//            // There was an error; don't attempt login and focus the first
//            // form field with an error.
//            focusView.requestFocus();
//        } else {
//            // Show a progress spinner, and kick off a background task to
//            // perform the user login attempt.
//            showProgress(true);
//            mAuthTask = new UserLoginTask(userid, password);
//            mAuthTask.execute((Void) null);
//        }
//    }

//    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
//    private void showProgress(final boolean show) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
//            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
//
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//                }
//            });
//
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mProgressView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//                }
//            });
//        } else {
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//        }
//    }

//    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
//
//        private final String mUserId;
//        private final String mPassword;
//
//        UserLoginTask(String UserId, String password) {
//            mUserId = UserId;
//            mPassword = password;
//        }
//
//
//        Boolean result;
//        @Override
//        protected Boolean doInBackground(Void... params) {
//            coreApi.login(mUserId, mPassword)
//                    .enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            if (response.isSuccessful()) {
//                                result = true;
//                            } else {
//                                result = false;
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//                            Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        }
//                    });
//
////            for (String credential : DUMMY_CREDENTIALS) {
////                String[] pieces = credential.split(":");
////                if (pieces[0].equals(mUserId)) {
////                    // Account exists, return true if the password matches.
////                    return pieces[1].equals(mPassword);
////                }
////            }
//
//            return result;
//        }
//
//        @Override
//        protected void onPostExecute(final Boolean success) {
//            mAuthTask = null;
//            showProgress(false);
//
//            if (success) {
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//            } else {
//                mPasswordView.setError(getString(R.string.error_incorrect_password));
//                mPasswordView.requestFocus();
//            }
//        }
//
//        @Override
//        protected void onCancelled() {
//            mAuthTask = null;
//            showProgress(false);
//        }
//    }

}

