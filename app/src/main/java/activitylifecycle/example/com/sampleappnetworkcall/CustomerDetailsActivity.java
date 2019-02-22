package activitylifecycle.example.com.sampleappnetworkcall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class CustomerDetailsActivity extends AppCompatActivity {
TextView customerName;
ImageView customerImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        customerImage=(ImageView)findViewById(R.id.customerImage) ;
        Customer customer= (Customer) getIntent().getSerializableExtra("CustomerDetails");
        customerName=(TextView)findViewById(R.id.txt_customername);
        customerName.setText("Customer Name: "+customer.getFirst_name());
        Picasso.with( getApplicationContext() )
                .load( customer.avatar )

                .into(customerImage );

    }

}
