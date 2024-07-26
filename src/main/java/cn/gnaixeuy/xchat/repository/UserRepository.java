package cn.gnaixeuy.xchat.repository;

import cn.gnaixeuy.xchat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     * @author GnaixEuy
     * @date 2024/7/25
     * @version 1.0.0
     */
    Optional<User> findByUsername(String username);

}