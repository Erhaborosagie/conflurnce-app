package com.osagie.confluenceapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@NoArgsConstructor
@Data
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speaker_id")
    private int speakerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String LastName;

    private String title;

    private String company;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "speaker_bio")
    private String speakerBio;

    @Column(name = "speaker_photo")
    private byte[] speakerPhoto;

    @ManyToMany(mappedBy = "speakers")
    private List<Session> sessions;
}
