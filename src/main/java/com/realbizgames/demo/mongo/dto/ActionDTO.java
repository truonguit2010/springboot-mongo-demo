package com.realbizgames.demo.mongo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.simple.JSONObject;

@Getter
@Setter
@NoArgsConstructor
public class ActionDTO {
    private String action;
    private String id;
    private JSONObject data;

    @Override
    public String toString() {
        return "ObjectAction{" +
                "action='" + action + '\'' +
                ", id='" + id + '\'' +
                ", data=" + data +
                '}';
    }
}
