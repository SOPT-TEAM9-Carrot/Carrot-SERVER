package cds.carrot.org.carrotServer.controller.post;

import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.controller.post.dto.response.RecommendPostListResponse;
import cds.carrot.org.carrotServer.domain.employer.User;
import cds.carrot.org.carrotServer.domain.post.Post;
import cds.carrot.org.carrotServer.service.employer.EmployerService;
import cds.carrot.org.carrotServer.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final EmployerService employerService;

    @GetMapping("/list")
    public JsonResponse getPostList(@RequestParam int size) {

        return JsonResponse.success(SuccessType.FIND_BOARD_SUCCESS, postService.getAll());
    }

    @GetMapping
    public JsonResponse getPost(@PathVariable Long postId) {
        return JsonResponse.success(SuccessType.FIND_BOARD_SUCCESS, postService.getById(postId));
    }

    @GetMapping("/recommend")
    public JsonResponse getRecommendPostList(@RequestParam(name = "size") int size, HttpServletRequest request) {
//        long userId = Long.parseLong(request.getHeader("Authorization"));
//        User findUser = employerService.getUserWithReviews(userId, 0);
//        List<Post> posts = postService.getAll();
//        RecommendPostListResponse response = RecommendPostListResponse.of(findUser.getNickname(), posts);
//        RecommendPostListResponse response1 = RecommendPostListResponse.of("test", null);
        RecommendPostListResponse response = new RecommendPostListResponse("hello");
        return JsonResponse.success(SuccessType.FIND_BOARD_SUCCESS, "test");
    }
}
