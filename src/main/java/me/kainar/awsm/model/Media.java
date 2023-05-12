package me.kainar.awsm.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.springframework.core.io.Resource;

import java.io.File;

@Entity
@Table(name = "media")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "media_type")
    private String type;

    private File file;

    public File getFile() {
        if(file!=null){
            return file;
        }

        return null;
    }
}
