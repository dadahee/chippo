package com.j2kb5th.chippo.interview.domain;

import com.j2kb5th.chippo.comment.domain.Comment;
import com.j2kb5th.chippo.global.domain.BaseTimeEntity;
import com.j2kb5th.chippo.thumb.domain.Thumb;
import com.j2kb5th.chippo.tag.domain.InterviewTag;
import com.j2kb5th.chippo.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToMany(mappedBy = "interview", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InterviewTag> interviewTags = new ArrayList<>();

    @OneToMany(mappedBy = "interview", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Thumb> thumbs = new ArrayList<>();

    @OneToMany(mappedBy = "interview", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Interview(Long id, User user, String question, String answer, String extraInfo, List<InterviewTag> interviewTags, List<Thumb> thumbs, List<Comment> comments) {
        this.id = id;
        this.user = user;
        this.question = question;
        this.answer = answer;
        this.extraInfo = extraInfo;
        this.interviewTags = interviewTags;
        this.thumbs = thumbs;
        this.comments = comments;
    }
}
