package cn.gnaixeuy.xchat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
public abstract class BaseEntity implements Serializable {

    @Id
    private String id;
    /**
     * 更新时间
     */
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdTime;

    /**
     * 创建时间
     */
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;

    /**
     * 创建人
     */
    @CreatedBy
    private String createdUser;
    
    /**
     * 更新人
     */
    @LastModifiedBy
    private String updatedUser;

}