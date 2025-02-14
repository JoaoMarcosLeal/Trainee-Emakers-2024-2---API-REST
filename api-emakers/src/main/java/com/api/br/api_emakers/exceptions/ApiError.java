package com.api.br.api_emakers.exceptions;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record ApiError(
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime timetamp,

        Integer code,

        String status,

        List<String> errors
) {

        //Builder
        public static final class Builder {

                LocalDateTime timetamp;

                Integer code;

                String status;

                List<String> errors;

                public Builder(LocalDateTime timetamp, Integer code, String status, List<String> errors) {
                        this.timetamp = timetamp;
                        this.code = code;
                        this.status = status;
                        this.errors = errors;
                }

                public ApiError build() {
                        return new ApiError(timetamp, code, status, errors);
                }
        }


}
