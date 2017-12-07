package br.ufrn.reuse.remote.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Created by Daniel on 11/15/2017.
 */
public class AuthorizationDTO {

    @SerializedName("access_token")
    @Expose
    private String accessToken;

    @SerializedName("token_type")
    @Expose
    private String tokenType;

    @SerializedName("refresh_token")
    @Expose
    private String refreshToken;

    @SerializedName("expires_in")
    @Expose
    private Date expiresIn;

    @SerializedName("scope")
    @Expose
    private Boolean scope;

    public boolean isValid(){
        boolean isValid = true;

        if(StringUtils.isEmpty(accessToken)){
            isValid = false;
        }

        if(StringUtils.isEmpty(tokenType)){
            isValid = false;
        }

        return isValid;
    }

    public String getAuthorizationHeader(){
        return tokenType+" "+ accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Date expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Boolean getScope() {
        return scope;
    }

    public void setScope(Boolean scope) {
        this.scope = scope;
    }
}
