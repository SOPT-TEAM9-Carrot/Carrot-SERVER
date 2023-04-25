package cds.carrot.org.carrotServer.infrastructure.user;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepositoryImpl extends Repository<UserEntity, Long>, UserRepository{
}
