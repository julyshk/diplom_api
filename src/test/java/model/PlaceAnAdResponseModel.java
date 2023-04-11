package model;

import lombok.Data;

@Data
public class PlaceAnAdResponseModel {
    String status, data, from_cache, memkey;
    String[] result;
    public Error error;

    @Data
    public static class Error {
        public String code, message;
    }

}
