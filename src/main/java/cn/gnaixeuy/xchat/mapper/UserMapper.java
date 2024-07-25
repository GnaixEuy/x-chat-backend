package cn.gnaixeuy.xchat.mapper;

import cn.gnaixeuy.xchat.dto.UserDto;
import cn.gnaixeuy.xchat.dto.request.UserCreateRequest;
import cn.gnaixeuy.xchat.dto.request.UserUpdateRequest;
import cn.gnaixeuy.xchat.entity.User;
import cn.gnaixeuy.xchat.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * <img src="https://img1.baidu.com/it/u=2537966709,2852517020&fm=253&fmt=auto&app=138&f=JPEG?w=648&h=489"/> <br/>
 * easy-chat
 *
 * @author GnaixEuy
 * @version 1.0
 * @see <a href="https://github.com/GnaixEuy">GnaixEuy</a>
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}