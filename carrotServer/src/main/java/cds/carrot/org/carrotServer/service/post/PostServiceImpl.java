package cds.carrot.org.carrotServer.service.post;

import cds.carrot.org.carrotServer.common.dto.ErrorType;
import cds.carrot.org.carrotServer.domain.post.Category;
import cds.carrot.org.carrotServer.domain.post.Post;
import cds.carrot.org.carrotServer.exception.NotFoundException;
import cds.carrot.org.carrotServer.infrastructure.category.CategoryEntity;
import cds.carrot.org.carrotServer.infrastructure.post.PostEntity;
import cds.carrot.org.carrotServer.infrastructure.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        List<PostEntity> postEntities = postRepository.findAll();
        return postEntities
                .stream()
                .map(this::fromPostEntityToPostMapper)
                .collect(Collectors.toList());
    }

    @Override
    public Post getById(Long postId) {
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorType.NOT_FOUND_POST_EXCEPTION, ErrorType.NOT_FOUND_POST_EXCEPTION.getMessage()));
        return fromPostEntityToPostMapper(postEntity);
    }

    private Post fromPostEntityToPostMapper(PostEntity postEntity) {
        return Post.builder()
                .postId(postEntity.getId())
                .company(postEntity.getCompany())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .imageUrl(postEntity.getImageUrl())
                .address(postEntity.getAddress())
                .hourlyWage(postEntity.getHourlyWage())
                .monthlyWage(postEntity.getMonthlyWage())
                .categories(fromCategoryEntityListToCategoryList(postEntity.getCategories()))
                .build();
    }

    private List<Category> fromCategoryEntityListToCategoryList(List<CategoryEntity> categoryEntityList) {
        return categoryEntityList
                .stream()
                .map((categoryEntity -> new Category(categoryEntity.getName())))
                .collect(Collectors.toList());
    }
}
