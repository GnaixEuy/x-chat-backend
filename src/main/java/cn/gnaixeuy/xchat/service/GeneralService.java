package cn.gnaixeuy.xchat.service;

import cn.gnaixeuy.xchat.dto.BaseDto;
import cn.gnaixeuy.xchat.entity.BaseEntity;
import cn.gnaixeuy.xchat.exception.ExceptionType;
import cn.gnaixeuy.xchat.mapper.MapperInterface;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto> {

    JpaRepository<Entity, String> getRepository();

    MapperInterface<Entity, Dto> getMapper();

    ExceptionType getNotFoundExceptionType();

    Dto create(Dto dto);

    Dto get(String id);

    Dto update(String id, Dto dto);

    void delete(String id);

}