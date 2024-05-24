package org.dingli.Vo;

import lombok.Data;

import java.util.List;

@Data
public class SaveOrUpdateUserVO {


    private String username;

    private String passWord;

    private String email;

    private String mobile;


    private List<String> relateEnterPriseVOS;




    @Override
    public String toString() {
        return "SaveOrUpdateUserVO{" +
                "username='" + username + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", relateEnterPriseVOS=" + relateEnterPriseVOS +
                '}';
    }
}
