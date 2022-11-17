package com.osagie.confluenceapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
@NoArgsConstructor
@Data
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private int sessionId;
    @Column(name = "session_name")
    private String sessionName;
    @Column(name = "session_description")
    private String sessionDescription;
    @Column(name = "session_length")
    private int sessionLength;

    @ManyToMany
    @JoinTable(name = "session_speakers", joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private List<Speaker> speakers;
}
