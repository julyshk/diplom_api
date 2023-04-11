package model;

import lombok.Data;

@Data
public class AddToFaforiteResponseModel {
    String status, code;
    public Result result;

    @Data
    public static class Result {
        public String message;
    }

}
