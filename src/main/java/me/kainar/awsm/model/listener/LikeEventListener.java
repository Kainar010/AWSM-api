package me.kainar.awsm.model.listener;

import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import me.kainar.awsm.model.Comment;
import me.kainar.awsm.model.Post;
import me.kainar.awsm.model.Like;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class LikeEventListener implements PostInsertEventListener, PostDeleteEventListener {
    @Override
    public void onPostInsert(PostInsertEvent postInsertEvent) {
        Like like = (Like)postInsertEvent.getEntity();

        if(like.getId().getPost()!=null){
            Post post = like.getId().getPost();
            post.setCountOfLikes(post.getCountOfLikes()+1);
            postInsertEvent.getSession().persist(post);
        }
        else if(like.getId().getComment()!=null){
            Comment comment = like.getId().getComment();
            comment.setCountOfLike(comment.getCountOfLike()+1);
        }
    }


    @Override
    public void onPostDelete(PostDeleteEvent postDeleteEvent) {
        Like like = (Like)postDeleteEvent.getEntity();

        if(like.getId().getPost()!=null){
            Post post = like.getId().getPost();
            post.setCountOfLikes(post.getCountOfLikes()+1);
            postDeleteEvent.getSession().persist(post);
        }
        else if(like.getId().getComment()!=null){
            Comment comment = like.getId().getComment();
            comment.setCountOfLike(comment.getCountOfLike()+1);
        }
    }


    @Override
    public boolean requiresPostCommitHandling(EntityPersister entityPersister) {
        return false;
    }
}
