package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String content;
    private LocalDateTime published;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public Message(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.published = LocalDateTime.now();
        this.author = author;
    }

    public Message() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getTitle().equals(message.getTitle()) &&
                getContent().equals(message.getContent()) &&
                getPublished().equals(message.getPublished()) &&
                getAuthor().equals(message.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getContent(), getPublished(), getAuthor());
    }


}
