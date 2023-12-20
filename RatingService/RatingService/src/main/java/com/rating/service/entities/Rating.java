package com.rating.service.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_rating")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
