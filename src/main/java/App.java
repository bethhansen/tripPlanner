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


// unfunctional, because we need to edit the entire array. //
// https://www.learnhowtoprogram.com/java-august-2017/web-applications-with-java/epicodus-blog-update-and-delete-routes
// ^ this is where we left off
//        get("/posts/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            String item1 = req.queryParams("item1");
//            String item2 = req.queryParams("item2");
//            String item3 = req.queryParams("item3");
//            String item4 = req.queryParams("item4");
//            int idOfPostToEdit = Integer.parseInt(req.params("id"));
//            Post editPost = Post.findById(idOfPostToEdit);
//            editPost.update( "item1","");
//            editPost.update( String"item2");
//            editPost.update( String"item3");
//            editPost.update( String"item4");
////            model.put("editPost", editPost); // take this one out ?
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());


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
