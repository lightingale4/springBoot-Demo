package org.dingli.Vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UpmsMessageModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String passWord;

    private String email;

    private String mobile;

    private String appCode;

    //消息描述
    private String description;
}
