package com.j2kb5th.chippo.tag.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private TagType type;

    @Column(length = 20, nullable = false, unique = true)
    private String name;

}
