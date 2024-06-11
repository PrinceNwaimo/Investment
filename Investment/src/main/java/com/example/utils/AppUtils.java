package com.example.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.data.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static java.time.Instant.now;

public class AppUtils {

        public static final String ACTIVATION_LINK = "";
        public static final int ONE = 1;

        public static final int ZERO = 0;

        public static final String JSON_PATCH_CONSTANT = "application/json-patch+json";

        public static final int DEFAULT_PAGE_NUMBER = 1;

        public static final int DEFAULT_PAGE_LIMIT = 10;
        public static final String EMAIL_OR_PASSWORD_NOT_VALID = "It appears that the email %s you provided is already taken by another user";
        public static final String EMAIL_Taken_ERROR_MSG ="It appears that the email %s you provided is already taken by another user";
        public static final String USER_NOT_SAVE_iNTO_DB= "It appears that this %s UserName not save";
        public static final String EMAIL_NOT_FOUND = "It appears that this %s UserName not found";
        public static final String USER_NAME_DOES_NOT_EXIST = "The username %s does not exist.";
        public static final String ACTIVATE_ACCOUNT_URL = "localhost:8080/api/v1/customer/verify %s" ;
        public static final String API_KEY_VALUE = "api-key";
        public static final String ID = "id";

        public static final String Email = "Email";
        public static final String EMPTY_SPACE_VALUE=" ";
        public static final String EMAIL_URL="https://api.brevo.com/v3/smtp/email";
        public static final String SENDER = "sender";

        public static final String RECIPIENT = "recipient";
        public static final String TO = "to";
        public static final String SUBJECT="ACTIVATION LINK";
        public static final String COMPANY_NAME = "RecyclePal";
    public static final String USER_REGISTRATION_SUCCESSFUL = "User Registration Successful";

        public static final String CLAIMS_VALUE = "claim";

        public static final String LOGIN_ENDPOINT = "/api/v1/login";
        public static final String AGENT_API_VALUE = "/api/v1/agent";



        public static Pageable buildPageRequest(int page, int items){
            if (page <= ZERO) page = DEFAULT_PAGE_NUMBER;
            if (page <= ZERO) items = DEFAULT_PAGE_LIMIT;
            page-= ONE;
            return PageRequest.of(page, items);
        }
        public static String generateToken(User agent, String secret){
            return JWT.create()
                    .withIssuedAt(now())
                    .withExpiresAt(now().plusSeconds(200L))
                    .withClaim(ID, agent.getUserId())
                    .sign(Algorithm.HMAC512(secret.getBytes()));
        }
        public static List<String> getAuthWhiteList(){
            return List.of(
                    AGENT_API_VALUE, LOGIN_ENDPOINT
            );
        }




    }



