package model;

import lombok.Data;

@Data
public class DeleteResponseModel {
    public Data data;
    public Support support;

    @lombok.Data
    public static class Data {
        public String id, email, first_name, last_name, avatar;
    }

    @lombok.Data
    public static class Support {
        public String url, text;
    }

}
