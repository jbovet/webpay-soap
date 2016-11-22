package cl.tuxy.webpay.dto;

import java.io.Serializable;

/**
 * Created by josebovet on 11/21/16.
 */
public class TbkResponse implements Serializable {

    private String url;
    private String token;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TbkResponse{" +
                "url='" + url + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
