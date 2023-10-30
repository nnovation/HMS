package com.example.hms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button logOut;
    String color[] = {"#FF0000", "#FBB917", "#357EC7"};
    private List<StudentList> finalStudentList = new ArrayList<>();
    String phase[] = {"R", "Y", "B"};
    String ColumnName[] = {"Name", "S ID", "H ID"};
    String border[] = {"r_border", "y_border", "b_border"};
    String RYB_voltage[][];
    private FirebaseAuth mAuth;
    String getmyStudent_url = "http://192.168.137.129/fatchstudents.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        get_myAnimal();
    }

    public void Table(String PanelVoltage[][]) {

        int lenth = finalStudentList.size();
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        TableRow.LayoutParams row_with = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 100);
        TableRow.LayoutParams panel_name_with = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 100);
        panel_name_with.span = 4;
//        TableLayout.LayoutParams tableLayout = new TableLayout.LayoutParams();
//        stk.setLayoutParams(tableLayout);

        TableRow First_Row = new TableRow(MainActivity.this);

        for (int d = 0; d < 3; d++) {
            TextView Collumn_Name = new TextView(MainActivity.this);

            Collumn_Name.setLayoutParams(row_with);
            Collumn_Name.setBackgroundColor(Color.WHITE);
            Collumn_Name.setText(ColumnName[d]);
            Collumn_Name.setTextColor(Color.BLACK);
            Collumn_Name.setTextSize(18);
            Collumn_Name.setGravity(Gravity.CENTER);
            Collumn_Name.setBackground(getDrawable(R.drawable.border));
            First_Row.addView(Collumn_Name);
        }
        stk.addView(First_Row);

        for (int i = 0; i < finalStudentList.size(); i++) {
            TableRow Data_Row = new TableRow(MainActivity.this);

            StudentList item = finalStudentList.get(i);

                TextView Data_R = new TextView(MainActivity.this);

                Data_R.setLayoutParams(row_with);
                Data_R.setBackgroundColor(Color.WHITE);
                Data_R.setText(item.getName());
                Data_R.setTextColor(Color.BLACK);
                Data_R.setTextSize(18);
                Data_R.setGravity(Gravity.CENTER);
                Data_R.setBackground(getDrawable(R.drawable.border));
                Data_Row.addView(Data_R);

            TextView Data_B = new TextView(MainActivity.this);

            Data_B.setLayoutParams(row_with);
            Data_B.setBackgroundColor(Color.WHITE);
            Data_B.setText(item.getStudent_id());
            Data_B.setTextColor(Color.BLACK);
            Data_B.setTextSize(18);
            Data_B.setGravity(Gravity.CENTER);
            Data_B.setBackground(getDrawable(R.drawable.border));
            Data_Row.addView(Data_B);

            TextView Data_Y = new TextView(MainActivity.this);

            Data_Y.setLayoutParams(row_with);
            Data_Y.setBackgroundColor(Color.WHITE);
            Data_Y.setText(item.getHostel_id());
            Data_Y.setTextColor(Color.BLACK);
            Data_Y.setTextSize(18);
            Data_Y.setGravity(Gravity.CENTER);
            Data_Y.setBackground(getDrawable(R.drawable.border));
            Data_Row.addView(Data_Y);

            stk.addView(Data_Row);
//            stk.setBackground(this.getDrawable(R.drawable.border));
            stk.setPadding(15, 0, 15, 20);
        }
    }
    private void  get_myAnimal() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, getmyStudent_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);

                            List<StudentList>  studentLists= new ArrayList<>();
                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject student = array.getJSONObject(i);
                                Log.d("mySql",student.toString());

                                StudentList item = new StudentList();

                                item.setName(student.getString("name"));
                                item.setHostel_id(student.getString("hostel_id"));
                                item.setStudent_id(student.getString("student_id"));

                                studentLists.add(item);
                            }
                            finalStudentList.addAll(studentLists);
                            //creating adapter object and setting it to recyclerview
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //ui update of recycle view
//                            adapter.setItem();
                                    Table(RYB_voltage);
                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("mySql","error while get My Animal data"+error.getLocalizedMessage());
                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }
}