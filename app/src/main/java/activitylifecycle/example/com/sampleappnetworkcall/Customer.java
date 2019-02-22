package activitylifecycle.example.com.sampleappnetworkcall;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

class Customer implements Serializable {
    @SerializedName("id")
    String id;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @SerializedName("avatar")
    String avatar;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @SerializedName("first_name")
    String first_name;

    public List<Customer> getList() {
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }

    @SerializedName("data")
    List<Customer>list;


}
