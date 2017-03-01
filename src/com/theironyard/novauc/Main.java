package com.theironyard.novauc;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static HashMap<String, ArrayList<xxMessagesxx>> mess = new HashMap<>();
    static HashMap m = new HashMap();
    static User user;
    static xxMessagesxx y;

    public static void main(String[] args) {

        Spark.init();

        Spark.get("/", ((request, response) -> {


            if (user == null) {
                return new ModelAndView(m, "index.html"); //might need to create a login.html
            } else {
                m.put("name", user.name);
                return new ModelAndView(m, "messages.html");
            }
        }), new MustacheTemplateEngine());


        Spark.post("/createUser", ((request, response) -> {
                    String name = request.queryParams("createUser");
                    user = new User(name);

                    response.redirect("/");

                    return "";

                })
        );

        Spark.post("/createMessage", ((request, response) -> {
                    String ymessage = request.queryParams("createMessage");
                    y = new xxMessagesxx(ymessage);
                    ArrayList<xxMessagesxx> a = new ArrayList<>();
                    a.add(y);
                    mess.put(user.name, a);
                    int x = 2;

                    response.redirect("/");

                    return "";

                })
        );
    }
}







