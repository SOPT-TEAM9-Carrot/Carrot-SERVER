package cds.carrot.org.carrotServer.service.post;


import cds.carrot.org.carrotServer.domain.post.Post;

import java.util.List;

public interface PostService {

    List<Post> getAll();

    Post getById(Long postId);
}
