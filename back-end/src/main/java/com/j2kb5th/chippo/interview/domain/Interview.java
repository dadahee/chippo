package com.j2kb5th.chippo.interview.domain;

import com.j2kb5th.chippo.comment.domain.Comment;
import com.j2kb5th.chippo.global.domain.BaseTimeEntity;
import com.j2kb5th.chippo.thumb.domain.Thumb;
import com.j2kb5th.chippo.tag.domain.InterviewTag;
import com.j2kb5th.chippo.user.domain.User;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@DynamicInsert
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
public class Interview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 150, nullable = false)
    private String question;

    @Column(length = 300, nullable = false)
    private String answer;

    @Column(length = 300, nullable = false)
    private String extraInfo;

    @ColumnDefault("1")
    @Column(nullable = false)
    private boolean visible;

    @OneToMany(mappedBy = "interview", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InterviewTag> interviewTags = new ArrayList<>();

    @OneToMany(mappedBy = "interview", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Thumb> likes = new ArrayList<>();

    @OneToMany(mappedBy = "interview", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

}
