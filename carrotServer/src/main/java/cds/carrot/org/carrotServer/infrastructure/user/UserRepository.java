package cds.carrot.org.carrotServer.infrastructure.user;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findById(Long userId);
}
