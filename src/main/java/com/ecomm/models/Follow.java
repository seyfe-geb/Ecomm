package com.ecomm.models;

import javax.persistence.*;

@Table(name = "follows", uniqueConstraints={@UniqueConstraint(columnNames = {"follower_id", "followee_id"})})
@Entity
public class Follow {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "followee_id", nullable = false)
    private User followee;
}
