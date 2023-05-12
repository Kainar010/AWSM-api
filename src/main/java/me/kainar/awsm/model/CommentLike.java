package me.kainar.awsm.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("comment")
public class CommentLike extends Like{

}
