package app.project.nanodrgree.android.udacity.com.sunshineapp01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

    public ForecastFragment() {
    }
    ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_main, container, false);

        ArrayList<String> forcastArrayList=new ArrayList<String>();
        forcastArrayList.add("Today - Sunny - 88/63");
        forcastArrayList.add("Tomorrow - Foggy - 70/46");
        forcastArrayList.add("Weds - Cloudy - 72/63");
        forcastArrayList.add("Thurs - Rainy - 64/51");
        forcastArrayList.add("Fri - Foggy - 70/46");
        forcastArrayList.add("Sat - Sunny - 76/68");

        adapter = new ArrayAdapter<String>(getActivity(),R.layout.listview_layout,R.id.list_item_forcast_textView,forcastArrayList);
        ListView listView = (ListView) rootView.findViewById(R.id.listView_forecast);
        listView.setAdapter(adapter);
        FetchWeatherTask fetchWeatherTaskObj=new FetchWeatherTask();
        fetchWeatherTaskObj.execute("45110","JSON","metric","7");
        return rootView;
    }


    /**
     * Created by ARNAB on 2/9/2016.
     */
    /*public class FetchWeatherTask extends AsyncTask<String, Void, String[]> {

        private final String Log_Tag=FetchWeatherTask.class.getSimpleName();
        ArrayAdapter<String> adapter=null;

        @Override
        public String[] doInBackground(String... params) {
            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String forecastJsonStr = null;
            String[] formattedWeatherData=null;
            try

            {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast
                Map<String, String> urlParameter=new HashMap<String, String>();
                int parameterValues=params.length;
                String [] queryParamKey=new String[4];
                queryParamKey[0]="q";
                queryParamKey[1]="mode";
                queryParamKey[2]="units";
                queryParamKey[3]="cnt";
                for (int i=0;i<parameterValues;i++){
                    urlParameter.put(queryParamKey[i], params[i]);
                }
                String domainApiName="http://api.openweathermap.org/data/2.5/forecast/daily";

                String baseUrl = buildURI(domainApiName,urlParameter);
                Log.v(Log_Tag, "Building the new URL: " + baseUrl);
                String apiKey = "&APPID=" + "5c246f601deb2b240b3cb6c02e09aa82";
                URL url = null;
                try {
                    url = new URL(baseUrl.concat(apiKey));
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }

                try {
                    // Create the request to OpenWeatherMap, and open the connection
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();


                    // Read the input stream into a String
                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuffer buffer = new StringBuffer();
                    if (inputStream == null) {
                        // Nothing to do.
                        //return null;
                    }

                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                        // But it does make debugging a *lot* easier if you print out the completed
                        // buffer for debugging.
                        buffer.append(line + "\n");
                    }

                    if (buffer.length() == 0) {
                        // Stream was empty.  No point in parsing.
                        // return null;
                    }
                    forecastJsonStr = buffer.toString();
                    Log.d(Log_Tag,forecastJsonStr);

                    //Calling the JSON Perser for Parsing the Data.
                    ParseWeatherResponse ParseWeatherResponseObj=new ParseWeatherResponse();
                    formattedWeatherData=ParseWeatherResponseObj.getWeatherDataFromJson(forecastJsonStr, 7);
                    Log.d(Log_Tag,"Formatted WeatherData"+formattedWeatherData);

                } catch (IOException e) {
                    Log.e(Log_Tag, "Error ", e);
                    // If the code didn't successfully get the weather data, there's no point in attemping
                    // to parse it.
                    //return null;
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (final IOException e) {
                            Log.e(Log_Tag, "Error closing stream", e);
                        }
                    }
                }

            }
            catch (Exception e){
                Log.e(Log_Tag, "Error closing stream", e);

            }
            return formattedWeatherData;
        }

        @Override
        protected void onPostExecute(String[] result) {
            if(result!=null){
                if(adapter!=null) {
                    adapter.clear();
                }
                Log.e(Log_Tag, "adapter:"+adapter);
                for(String dayForCastStr:result){
                    adapter.add(dayForCastStr);
                }
            }
        }

        private String buildURI(String url, Map<String, String> params) {

            // build url with parameters.
            Uri.Builder builder = Uri.parse(url).buildUpon();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }

            return builder.build().toString();
        }
    }*/

}
