// Code from https://developer.android.com/training/volley/simple
// Used for reference in project-37 for SER401

final TextView textView = (TextView) findViewById(R.id.text);


// Instantiate the RequestQueue.
RequestQueue queue = Volley.newRequestQueue(this);
String url ="https://www.google.com";

// Request a string response from the provided URL.
StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        // Display the first 500 characters of the response string.
        textView.setText("Response is: "+ response.substring(0,500));
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        textView.setText("That didn't work!");
    }
});

// Add the request to the RequestQueue.
queue.add(stringRequest);


// Cancel a Request
public static final String TAG = "MyTag";
StringRequest stringRequest; // Assume this exists.
RequestQueue requestQueue;  // Assume this exists.

// Set the tag on the request.
stringRequest.setTag(TAG);

// Add the request to the RequestQueue.
requestQueue.add(stringRequest);


// Stop the request
@Override
protected void onStop () {
    super.onStop();
    if (requestQueue != null) {
        requestQueue.cancelAll(TAG);
    }
}

// Request JSON

String url = "http://my-json-feed";

JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

    @Override
    public void onResponse(JSONObject response) {
        textView.setText("Response: " + response.toString());
    }
}, new Response.ErrorListener() {

    @Override
    public void onErrorResponse(VolleyError error) {
        // TODO: Handle error

    }
});

// Access the RequestQueue through your singleton class.
MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

// Parse a network response
@Override
protected Response<T> parseNetworkResponse(
        NetworkResponse response) {
    try {
        String json = new String(response.data,
        HttpHeaderParser.parseCharset(response.headers));
    return Response.success(gson.fromJson(json, clazz),
    HttpHeaderParser.parseCacheHeaders(response));
    }
    // handle errors
// ...
}


