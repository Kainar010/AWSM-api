package me.kainar.awsm.model;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue("post")
public class PostLike extends Like{

}
