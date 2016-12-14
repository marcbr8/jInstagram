package org.jinstagram.auth.model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;

import static org.junit.Assert.assertEquals;

public class OAuthRequestTest {

    private OAuthRequest request;

    @Before
    public void setup() {
        request = new OAuthRequest(HttpMethod.GET, "http://example.com");
    }

    @Test
    public void shouldAddOAuthParamters() {
        request.addOAuthParameter(OAuthConstants.SCOPE, "scope");

        assertEquals(1, request.getOauthParameters().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfParameterIsNotOAuth() {
        request.addOAuthParameter("otherParam", "value");
    }
}