import static spark.Spark.staticFileLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Post;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/posts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "post-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/posts/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToEdit = Integer.parseInt(req.params("id"));
            Post editPost = Post.findById(idOfPostToEdit);
            model.put("editPost", editPost);
            return new ModelAndView(model, "post-form.hbs");
        }, new HandlebarsTemplateEngine());


        get("/posts/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToFind = Integer.parseInt(req.params("id"));
            Post foundPost = Post.findById(idOfPostToFind);
            model.put("post", foundPost);
            return new ModelAndView(model, "post-detail.hbs");
        }, new HandlebarsTemplateEngine());


        post("/item/new",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String item1 = request.queryParams("item1");
            String item2 = request.queryParams("item2");
            String item3 = request.queryParams("item3");
            String item4 = request.queryParams("item4");
            Post newpost = new Post(item1, item2, item3, item4);
            model.put("raccoon", newpost);
            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());



        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Post> allPosts = Post.getAll();
            model.put("itemList", allPosts);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
















}
    }
