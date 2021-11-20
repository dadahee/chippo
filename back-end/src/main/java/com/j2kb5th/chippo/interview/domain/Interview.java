package com.j2kb5th.chippo.interview.domain;

import com.j2kb5th.chippo.comment.domain.Comment;
import com.j2kb5th.chippo.global.domain.BaseTimeEntity;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Interview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String question;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private boolean visible = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @OneToMany(mappedBy = "interview", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

}
