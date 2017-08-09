package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class PostTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Post.clearAllPosts();
    }

    public Post setupNewPost() {
        return new Post("crowbar", "water", "rope", "cellphone");
    }

    public Post setupNewPost2() {
        return new Post("thug", "rope", "tire", "battery");
    }

    //// tests begin below here ////

    @Test
    public void PostObjectGetsCorrectlyCreated_true() throws Exception {
        Post post = setupNewPost();
        assertEquals(true, post instanceof Post);
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Post post = setupNewPost();
        Post post2 = setupNewPost2();
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception {
        Post post = setupNewPost();
        assertEquals(false, post.getPublished());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception {
        Post post = setupNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), post.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception {
        Post.clearAllPosts();
        Post post = setupNewPost();
        assertEquals(1, post.getId());
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Post post = setupNewPost();
        assertEquals(1, Post.findById(post.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Post post = setupNewPost();
        Post post2 = setupNewPost2();
        assertEquals(2, Post.findById(post2.getId()).getId());
    }

    @Test
    public void updateChangesPostContent() throws Exception {
        Post post = setupNewPost();
//        ArrayList<Post> formerContent = post.getContent();
//        LocalDateTime formerDate = post.getCreatedAt();
//        int formerId = post.getId();
        post.update("Android", "cat", "mouse", "tire");
        assertEquals("cat" , post.getItem2());

    }
}