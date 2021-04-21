package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "imagePost")
public class ImagePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "imagePath",nullable = false)
    private String imagePath;

    public static ImagePost from(ImagePost imagePost) {
        return ImagePost.builder()
                .id(imagePost.getId())
                .title(imagePost.getTitle())
                .type(imagePost.getType())
                .description(imagePost.getDescription())
                .imagePath(imagePost.getImagePath())
                .build();
    }

    public static List<ImagePost> from(List<ImagePost> products) {
        return products.stream()
                .map(ImagePost::from)
                .collect(Collectors.toList());
    }
}
