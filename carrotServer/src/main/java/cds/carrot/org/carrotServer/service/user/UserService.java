package cds.carrot.org.carrotServer.service.user;

import cds.carrot.org.carrotServer.domain.user.User;

public interface UserService {

    User getById(Long userId);
}
