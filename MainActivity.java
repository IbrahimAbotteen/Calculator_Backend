package com.example.calculator_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    boolean starting=true;
    String mynumber="";
    String temp="";
    String tempRes="";
    Double result=0.0;
    boolean resultFlag=false;
    boolean addFlag=false;
    boolean subFlag=false;
    boolean multFlag=false;
    boolean divFlag=false;

    public void number(View view){

        Button b = (Button) view;
        TextView t = (TextView) findViewById(R.id.textView3);

        if (resultFlag==true){
            starting=true;
            resultFlag=false;
        }
        mynumber+=b.getText().toString();
        t.setText(mynumber);
    }

    public void add(View view){
        TextView t = (TextView) findViewById(R.id.textView3);
        Button fp=(Button)findViewById(R.id.floatingPoint);
        fp.setEnabled(true);
        temp=mynumber;
        mynumber="";

       if(starting==true){
           result=Double.valueOf(temp);
           starting=false;

       }
       else if (resultFlag==true){

           resultFlag=false;

       }
       else if (subFlag==true){
           //result=result-Double.valueOf(temp);
           backEndSub(result,Double.valueOf(temp),view);
           subFlag=false;
       }
       else if (multFlag==true){
           //result=result*Double.valueOf(temp);
           backEndMult(result,Double.valueOf(temp),view);
           multFlag=false;
       }
       else if (divFlag==true){
           //result=result/Double.valueOf(temp);
           backEndDiv(result,Double.valueOf(temp),view);
           divFlag=false;
       }
       else{
           //result=result+Double.valueOf(temp);
          backEndSum(result,Double.valueOf(temp),view);
           mynumber="";
       }

       addFlag=true;
       subFlag=false;
       multFlag=false;
       divFlag=false;
    }

    public void sub(View view){
        TextView t = (TextView) findViewById(R.id.textView3);
        Button fp=(Button)findViewById(R.id.floatingPoint);
        fp.setEnabled(true);
        temp=mynumber;
        mynumber="";
        if (starting==true){
            result=Double.valueOf(temp);
            starting=false;
        }
        else if (resultFlag==true){
            resultFlag=false;
        }
        else if(addFlag==true){
            //result=result+Double.valueOf(temp);
            backEndSum(result,Double.valueOf(temp),view);
            addFlag=false;
        }
        else if (multFlag==true){
            //result=result*Double.valueOf(temp);
            backEndMult(result,Double.valueOf(temp),view);
            multFlag=false;
        }
        else if (divFlag==true){
           // result=result/Double.valueOf(temp);
            backEndDiv(result,Double.valueOf(temp),view);
            divFlag=false;
        }
        else{
            //result=result-Double.valueOf(temp);
            backEndSub(result,Double.valueOf(temp),view);
        }

        addFlag=false;
        subFlag=true;
        multFlag=false;
        divFlag=false;
    }

    public void mult(View view){
        TextView t = (TextView) findViewById(R.id.textView3);
        Button fp=(Button)findViewById(R.id.floatingPoint);
        fp.setEnabled(true);
        temp=mynumber;
        mynumber="";
        if (starting==true){
            result=Double.valueOf(temp);
            starting=false;
        }
        else if (resultFlag==true){
            resultFlag=false;
        }
        else if(addFlag==true){
           // result=result+Double.valueOf(temp);
            backEndSum(result,Double.valueOf(temp),view);
            addFlag=false;
        }
        else if (subFlag==true) {
           // result = result - Double.valueOf(temp);
            backEndSub(result,Double.valueOf(temp),view);
            subFlag = false;
        }
        else if (divFlag==true){
           // result=result/Double.valueOf(temp);
            backEndDiv(result,Double.valueOf(temp),view);
            divFlag=false;
        }
        else{
          //  result=result*Double.valueOf(temp);
            backEndMult(result,Double.valueOf(temp),view);
        }

        addFlag=false;
        subFlag=false;
        multFlag=true;
        divFlag=false;
    }

    public void div(View view){
        TextView t = (TextView) findViewById(R.id.textView3);
        Button fp=(Button)findViewById(R.id.floatingPoint);
        fp.setEnabled(true);
        temp=mynumber;
        mynumber="";
        if (starting==true){
            result=Double.valueOf(temp);
            starting=false;
        }
        else if (resultFlag==true) {
            resultFlag = false;
        }
        else if(addFlag==true){
           // result=result+Double.valueOf(temp);
            backEndSum(result,Double.valueOf(temp),view);
            addFlag=false;
        }
        else if (subFlag==true) {
           // result = result - Double.valueOf(temp);
            backEndSub(result,Double.valueOf(temp),view);
            subFlag = false;
        }
        else if (multFlag==true) {
            //result = result * Double.valueOf(temp);
            backEndMult(result,Double.valueOf(temp),view);
            multFlag = false;
        }

        else{
            //result=result/Double.valueOf(temp);
            backEndDiv(result,Double.valueOf(temp),view);
        }
        addFlag=false;
        subFlag=false;
        multFlag=false;
        divFlag=true;
    }
    public void result(View view){
        TextView t = (TextView) findViewById(R.id.textView3);
        Button fp=(Button)findViewById(R.id.floatingPoint);
        fp.setEnabled(true);
        temp=mynumber;
        mynumber="";
        if (starting==true){
            result=Double.valueOf(temp);
            starting=false;
        }
        else if(addFlag==true){
            //result=result+Double.valueOf(temp);
            backEndSum(result,Double.valueOf(temp),view);
            addFlag=false;
        }
        else if(subFlag==true){
            //result=result-Double.valueOf(temp);
            backEndSub(result,Double.valueOf(temp),view);
            subFlag=false;
        }
        else if(multFlag==true){
            //result=result*Double.valueOf(temp);
            backEndMult(result,Double.valueOf(temp),view);
            multFlag=false;
        }
        else if (divFlag==true){
            //result=result/Double.valueOf(temp);
            backEndDiv(result,Double.valueOf(temp),view);
            divFlag=false;
        }
        t.setText(result.toString());
        resultFlag=true;
    }

    public void clear(View view){
        TextView t = (TextView) findViewById(R.id.textView3);
        Button fp=(Button)findViewById(R.id.floatingPoint);
        fp.setEnabled(true);
        addFlag=false;
        subFlag=false;
        multFlag=false;
        divFlag=false;
        starting=true;
        resultFlag=false;
        mynumber=" ";
        result=0.0;
        t.setText("0");
    }
    public void floatingPoint(View view){
        TextView t = (TextView) findViewById(R.id.textView3);
        Button fp=(Button)view;
        fp.setEnabled(false);
        if (resultFlag==true){
            starting=true;
            resultFlag=false;
        }
        mynumber+=fp.getText().toString();
        t.setText(mynumber);
    }

    public void backEndSum(double num1,double num2,View view){
        final TextView t = (TextView) findViewById(R.id.textView3);
        RequestQueue queue;
        String URL = "http://10.0.2.2:8080/CalculatorBackend/Sum?num1=" + num1 + "&num2=" + num2;
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                t.setText(response);
                result=Double.valueOf(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());

            }
        });
        queue.add(request);
    }

    public void backEndSub(double num1,double num2,View view){
        final TextView t = (TextView) findViewById(R.id.textView3);
        RequestQueue queue;
        String URL = "http://10.0.2.2:8080/CalculatorBackend/Sub?num1=" + num1 + "&num2=" + num2;
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                t.setText(response);
                result=Double.valueOf(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());

            }
        });
        queue.add(request);
    }

    public void backEndMult(double num1,double num2,View view){
        final TextView t = (TextView) findViewById(R.id.textView3);
        RequestQueue queue;
        String URL = "http://10.0.2.2:8080/CalculatorBackend/Mult?num1=" + num1 + "&num2=" + num2;
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                t.setText(response);
                result=Double.valueOf(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());

            }
        });
        queue.add(request);
    }

    public void backEndDiv(double num1,double num2,View view){
        final TextView t = (TextView) findViewById(R.id.textView3);
        RequestQueue queue;
        String URL = "http://10.0.2.2:8080/CalculatorBackend/Div?num1=" + num1 + "&num2=" + num2;
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                t.setText(response);
                result=Double.valueOf(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());

            }
        });
        queue.add(request);
    }

    public void test(){
        RequestQueue queue;
        String URL = "http://10.0.2.2:8080/CalculatorBackend/Mult?num1=20&num2=5";
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //textView.setText(response.toString());
                //Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                System.out.println("hello");
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());

            }
        });

        queue.add(request);
    }

}















