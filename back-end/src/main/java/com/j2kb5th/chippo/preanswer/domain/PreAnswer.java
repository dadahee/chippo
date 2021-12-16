package com.j2kb5th.chippo.preanswer.domain;

import com.j2kb5th.chippo.global.domain.BaseTimeEntity;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.preanswer.controller.dto.request.UpdatePreAnswerRequest;
import com.j2kb5th.chippo.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PreAnswer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id", nullable = false)
    private Interview interview;

    @Builder
    public PreAnswer(Long id, String content, User user, Interview interview) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.interview = interview;
    }

    public PreAnswer update(String content) {
        this.content = content;
        return this;
    }
}
