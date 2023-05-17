package cds.carrot.org.carrotServer.controller.post;

import cds.carrot.org.carrotServer.common.dto.JsonResponse;
import cds.carrot.org.carrotServer.common.dto.SuccessType;
import cds.carrot.org.carrotServer.domain.post.Post;
import cds.carrot.org.carrotServer.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public JsonResponse getPostList(@RequestParam(required = false) int size) {
        return JsonResponse.success(SuccessType.FIND_BOARD_SUCCESS, postService.getAll());
    }

    @GetMapping
    public JsonResponse getPost(@PathVariable Long postId) {
        return JsonResponse.success(SuccessType.FIND_BOARD_SUCCESS, postService.getById(postId));
    }

    @GetMapping("/recommend")
    public JsonResponse getRecommendPostList(@RequestParam(required = false) int size) {
        return JsonResponse.success(SuccessType.FIND_BOARD_SUCCESS, postService.getAll());
    }
}
