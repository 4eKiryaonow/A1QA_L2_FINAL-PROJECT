package api.service;

import api.util.RestUtil;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static api.constatnt.EndPoints.GET_NEW_TOKEN;
import static api.constatnt.query.KeyParameter.VARIANT_KEY;

public class RestTokenService {
    public Response getNewTokenResponse(String varNumber) {
        Map<String, String> params = new HashMap<>();
        params.put(VARIANT_KEY.getKeyParam(), varNumber);
        return RestUtil.postWithParams(GET_NEW_TOKEN, params);
    }

    public String getNewToken(Response response) {
        return response.getBody().asString();
    }
}