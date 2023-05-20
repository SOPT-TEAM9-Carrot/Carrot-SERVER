package cds.carrot.org.carrotServer.controller.post;

import cds.carrot.org.carrotServer.common.dto.ErrorType;
import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.controller.post.dto.response.PostListResponse;
import cds.carrot.org.carrotServer.controller.post.dto.response.PostResponse;
import cds.carrot.org.carrotServer.controller.post.dto.response.RecommendPostListResponse;
import cds.carrot.org.carrotServer.domain.employer.User;
import cds.carrot.org.carrotServer.domain.post.Post;
import cds.carrot.org.carrotServer.exception.BadRequestException;
import cds.carrot.org.carrotServer.service.employer.EmployerService;
import cds.carrot.org.carrotServer.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final EmployerService employerService;

    private static final String AUTHORIZATION = "Authorization";

    @GetMapping("/list")
    public JsonResponse getPostList(@RequestParam(required = false) Integer size) {
        if (ObjectUtils.isEmpty(size)) {
            throw new BadRequestException(ErrorType.VALIDATION_REQUEST_MISSING_EXCEPTION);
        } else if (size < 0) {
            throw new BadRequestException(ErrorType.REQUEST_SIZE_EXCEPTION);
        }
        List<Post> posts = postService.getAll();
        return JsonResponse.success(SuccessType.READ_BOARD_LIST_SUCCESS,
                PostListResponse.of(posts.subList(0, Math.min(size, posts.size()))));
    }

    @GetMapping("/{postId}")
    public JsonResponse getPost(@PathVariable Long postId) {
        PostResponse response = PostResponse.of(postService.getById(postId));
        return JsonResponse.success(SuccessType.READ_BOARD_SUCCESS, response);
    }

    @GetMapping("/recommend")
    public JsonResponse getRecommendPostList(@RequestParam(required = false) Integer size, HttpServletRequest request) {
        if (ObjectUtils.isEmpty(size)) {
            throw new BadRequestException(ErrorType.VALIDATION_REQUEST_MISSING_EXCEPTION);
        } else if (size < 0) {
            throw new BadRequestException(ErrorType.REQUEST_SIZE_EXCEPTION);
        }
        User findUser = employerService.getById(Long.parseLong(request.getHeader(AUTHORIZATION)));
        List<Post> posts = postService.getAll();
        RecommendPostListResponse response = RecommendPostListResponse.of(
                findUser.getNickname(),
                posts.subList(0, Math.min(posts.size(), size))
        );
        return JsonResponse.success(SuccessType.READ_BOARD_RECOMMEND_SUCCESS, response);
    }
}
