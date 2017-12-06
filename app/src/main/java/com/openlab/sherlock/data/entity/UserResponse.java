package com.openlab.sherlock.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public class UserResponse {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("orcid_code")
    @Expose
    private Object orcidCode;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("unmsm_code")
    @Expose
    private String unmsmCode;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("interest_areas")
    @Expose
    private List<Object> interestAreas = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getOrcidCode() {
        return orcidCode;
    }

    public void setOrcidCode(Object orcidCode) {
        this.orcidCode = orcidCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUnmsmCode() {
        return unmsmCode;
    }

    public void setUnmsmCode(String unmsmCode) {
        this.unmsmCode = unmsmCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Object> getInterestAreas() {
        return interestAreas;
    }

    public void setInterestAreas(List<Object> interestAreas) {
        this.interestAreas = interestAreas;
    }

}
