package com.j2kb5th.chippo.tag.domain;

import com.j2kb5th.chippo.interview.domain.Interview;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private TagType type;

    @Column(length = 20, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "interview", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InterviewTag> interviewTags = new ArrayList<>();

    public void addInterviewTag(InterviewTag interviewTag) {
        this.interviewTags.add(interviewTag);
    }
}
