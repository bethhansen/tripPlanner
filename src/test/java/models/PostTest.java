package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PostTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Post.clearAllPosts();
    }

    public Post setupNewPost(){
        return new Post("crowbar", "water", "rope", "cellphone");
    }
    public Post setupNewPost2() {
        return new Post("thug", "rope", "tire", "battery");
    }

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








    }