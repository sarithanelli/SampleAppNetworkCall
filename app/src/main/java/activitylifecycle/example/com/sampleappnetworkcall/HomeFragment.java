package activitylifecycle.example.com.sampleappnetworkcall;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    CustomerDetailsAdapter customerDetailsAdapter;
    APIInterface apiInterface;
    Toolbar toolbar;
    List<Customer> list = new ArrayList<>();

   /* private String result = "[\n" +
            "  { \"customer_id\": \"1\",\n" +
            "    \"customer_name\": \"saritha\",\n" +
            "    \"customer_number\": \"7036363769\",\n" +
            "    \"startdate\": \"23-02-2019\",\n" +
            "    \"enddate\": \"25-02-2019\",\n" +
            "    \"description\": \"related information\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"customer_id\": \"2\",\n" +
            "    \"customer_name\": \"Avinash\",\n" +
            "    \"customer_number\": \"9136363769\",\n" +
            "    \"startdate\": \"23-02-2019\",\n" +
            "    \"enddate\": \"25-02-2019\",\n" +
            "    \"description\": \"related information\"\n" +
            "  }\n" +
            "]";*/

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
      /*  toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("CustomerList");*/
        //parsingData();

        //Retrofit api initialization
        apiInterface = APIClent.getClient().create(APIInterface.class);

        getDataFromNetwork();
        return view;
    }

    private void getDataFromNetwork() {

        //Retrofit method in api
        Call<Customer> call = apiInterface.getList("1");
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                Customer customer = response.body();
                list = customer.getList();
                customerDetailsAdapter = new CustomerDetailsAdapter(getActivity(), list);
                recyclerView.setAdapter(customerDetailsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {

            }
        });


    }
   /* private void parsingData() {
        try {
            ArrayList<Customer> list = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("customer_id");
                String name = jsonObject.getString("customer_name");
                Customer customer = new Customer();
                customer.customer_id = id;
                customer.customer_name = name;
                list.add(customer);
            }
            customerDetailsAdapter = new CustomerDetailsAdapter(getActivity(), list);
            recyclerView.setAdapter(customerDetailsAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/
}
