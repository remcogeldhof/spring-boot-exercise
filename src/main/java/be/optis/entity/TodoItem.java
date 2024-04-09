package be.optis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean completed;
    private String priority;
    private String completionDate;
    private String creationDate;
    private String description;
    private String projectTag;
    private String contextTag;

    public TodoItem(boolean completed, String priority, String completionDate, String creationDate, String description, String projectTag, String contextTag) {
        this.completed = completed;
        this.priority = priority;
        this.completionDate = completionDate;
        this.creationDate = creationDate;
        this.description = description;
        this.projectTag = projectTag;
        this.contextTag = contextTag;
    }

    public TodoItem() {

    }
}
