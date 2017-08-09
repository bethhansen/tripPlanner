package models;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {
    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private int id;
    private boolean published;
    private LocalDateTime createdAt;
    private static ArrayList<Post> itemList = new ArrayList<>();

    public Post(String item1, String item2, String item3, String item4){
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        itemList.add(this);
        this.id = itemList.size();
    }

    public static ArrayList<Post> getAll() {
        return itemList;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // test-clear-all-method//

    public static void clearAllPosts(){
        itemList.clear();
    }
    //                     //


    public boolean getPublished(){
        return this.published;
    }

    public int getId() {
        return id;
    }

    /// getter methods ///
    //////////////////////

    public String getItem1() {
        return item1;
    }
    public String getItem2() {
        return item2;
    }
    public String getItem3() {
        return item3;
    }
    public String getItem4() {
        return item4;
    }
    public static ArrayList<Post> getItemList() {
        return itemList;
    }
    ////////////////////////
    ////////////////////////

}
