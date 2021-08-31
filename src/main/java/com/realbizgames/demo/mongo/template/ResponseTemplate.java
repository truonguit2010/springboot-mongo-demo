package com.realbizgames.demo.mongo.template;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseTemplate<T> {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Status {
        private String message;
        private Integer code;
        private boolean success;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Meta {
        private Integer totalPages;
        private Integer pageSize;
        private Long totalRows;
        private Integer currentPage;
    }

    private Status status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Meta meta;
}

