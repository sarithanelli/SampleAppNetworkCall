package activitylifecycle.example.com.sampleappnetworkcall;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomerDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Customer> list;
    Context context;
    private LayoutInflater inflater;


    public CustomerDetailsAdapter(Context context, List<Customer> list) {
        inflater = LayoutInflater.from(context);

        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.customer_list, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        final Customer current = list.get(position);
        Picasso.with(context)
                .load(current.avatar)
                .into(myHolder.customerImage);

        myHolder.customerName.setText("Customer Name:  " + list.get(position).getFirst_name());
        myHolder.customerId.setText("CustomerId:  " + current.getId());
        myHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CustomerDetailsActivity.class);
                intent.putExtra("CustomerDetails", current);
                context.startActivity(intent);
                }
        });
        }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder {
        TextView customerId;
        TextView customerName;
        ImageView customerImage;
        RelativeLayout parent;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            customerId = (TextView) itemView.findViewById(R.id.txt_customername);
            customerName = (TextView) itemView.findViewById(R.id.txt_customerid);
            customerImage = (ImageView) itemView.findViewById(R.id.customerImage);
            parent = (RelativeLayout) itemView.findViewById(R.id.parent);

        }
    }
}
