package cds.carrot.org.carrotServer.controller.post;

import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.domain.post.Post;
import cds.carrot.org.carrotServer.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
//    private final UserService

    @GetMapping("/list")
    public JsonResponse getPostList(@RequestParam int size) {

        return JsonResponse.success(SuccessType.FIND_BOARD_SUCCESS, postService.getAll());
    }

    @GetMapping
    public JsonResponse getPost(@PathVariable Long postId) {
        return JsonResponse.success(SuccessType.FIND_BOARD_SUCCESS, postService.getById(postId));
    }

    @GetMapping("/recommend")
    public JsonResponse getRecommendPostList(@RequestParam int size, HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        return JsonResponse.success(SuccessType.FIND_BOARD_SUCCESS, postService.getAll());
    }
}
