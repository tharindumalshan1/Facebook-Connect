package com.example.facebookConnect.restFB;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;
import com.restfb.types.User;

import java.util.Arrays;

public class GetUserDetails {

    public UserProfile GetProfileinfor(String accesstoken) {
        UserProfile objUserProfile=new UserProfile();
        FacebookClient facebookClient = new DefaultFacebookClient(accesstoken, Version.VERSION_10_0);
        User user = facebookClient.fetchObject("me", User.class);
        System.out.println("User name: " + user.getName());
        objUserProfile.setUserName(user.getName());
        return objUserProfile;
    }

    public UserProfile  GetProfileinfoOther(String accesstoken) {

        UserProfile objUserProfile=new UserProfile();
        try {

            FacebookClient facebookClient = new DefaultFacebookClient(accesstoken, Version.VERSION_10_0);

            JsonObject fetchObjectsResults = facebookClient.fetchObjects(Arrays.asList("me", "123456789"),
                    JsonObject.class, Parameter.with("fields", "name,id,email,picture"));

            System.out.println(fetchObjectsResults);

            String temp = fetchObjectsResults.toString();
            objUserProfile.setUserName(temp.substring(temp.indexOf("\"name\":\"")+8, temp.indexOf("\",\"id\":\"")));
            objUserProfile.setId(temp.substring(temp.indexOf("\",\"id\":\"")+8, temp.indexOf("\",\"email\"")));
            objUserProfile.setEmail(temp.substring(temp.indexOf("\",\"email\"")+11, temp.indexOf("\",\"picture\":")));
            objUserProfile.setPicture(temp.substring(temp.indexOf("\"url\":\"")+7, temp.indexOf("\",\"width\"")));
        } catch (Exception e){
            System.out.println("Error"+ e);
        }
        return objUserProfile;
    }
}
