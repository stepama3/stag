package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Deadline {

    @SerializedName("eprDeadlinePrihlaska")
    public DeadlineDate deadline;

    public static class DeadlineDate {
        @SerializedName("value")
        public String value;
    }
}


