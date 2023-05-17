package cds.carrot.org.carrotServer.service.user;

import cds.carrot.org.carrotServer.domain.user.User;
import cds.carrot.org.carrotServer.infrastructure.user.UserEntity;
import cds.carrot.org.carrotServer.infrastructure.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다."));
        return fromUserEntityToUserMapper(userEntity);
    }

    private User fromUserEntityToUserMapper(UserEntity userEntity) {
        return User.builder()
                .nickname(userEntity.getNickname())
                .imageUrl(userEntity.getImageUrl())
                .degree(userEntity.getDegree())
                .build();
    }
}
