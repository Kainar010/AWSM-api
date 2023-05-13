package me.kainar.awsm.controller;


import me.kainar.awsm.model.*;
import me.kainar.awsm.service.MailService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    private MailService service;

    @Autowired
    SessionFactory sessionFactory;

    @GetMapping("/")
    @Transactional
    public void likePost(){
        System.out.println("liked a post");
        Session session = sessionFactory.getCurrentSession();
        Post post = session.get(Post.class, 1);
        LikeId id = new LikeId();
        id.setPost(post);
        id.setUser(session.get(User.class, 1));
        PostLike like = new PostLike();
        like.setId(id);
        session.persist(like);
    }

    @GetMapping("/add")
    @Transactional
    public void addPost(){
        Post post = new Post();
        post.setMedia(new ArrayList<>());
        post.setDescription("fuck u");
        Session session = sessionFactory.getCurrentSession();
        session.persist(post);
    }
}
