package cn.gnaixeuy.xchat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role", schema = "x-chat")
public class Role extends BaseEntity {

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "title", length = 128)
    private String title;

}