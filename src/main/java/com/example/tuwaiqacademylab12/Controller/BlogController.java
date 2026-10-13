package com.example.tuwaiqacademylab12.Controller;

import com.example.tuwaiqacademylab12.Api.ApiResponse;
import com.example.tuwaiqacademylab12.Model.Blog;
import com.example.tuwaiqacademylab12.Model.User;
import com.example.tuwaiqacademylab12.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<?> getBlogs(@RequestParam(required = false) String title) {
        return ResponseEntity.status(200).body(
                title == null ? blogService.getAllBlogs() : blogService.getBlogByTitle(title)
        );
    }

    @PostMapping
    public ResponseEntity<?> addBlog(@AuthenticationPrincipal User user, @Valid @RequestBody Blog blog) {
        blogService.addBlog(user.getId(), blog);
        return ResponseEntity.status(200).body(new ApiResponse("Blog added successfully"));
    }

    @PutMapping("/{blog_id}")
    public ResponseEntity<?> updateBlog(@AuthenticationPrincipal User user, @PathVariable Integer blog_id, @Valid @RequestBody Blog blog) {
        blogService.updateBlog(user.getId(), blog_id, blog);
        return ResponseEntity.status(200).body(new ApiResponse("Blog updated successfully"));
    }

    @DeleteMapping("/{blog_id}")
    public ResponseEntity<?> deleteBlog(@AuthenticationPrincipal User user, @PathVariable Integer blog_id) {
        blogService.deleteBlog(user.getId(), blog_id);
        return ResponseEntity.status(200).body(new ApiResponse("Blog deleted successfully"));
    }

    @GetMapping("/{blog_id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer blog_id) {
        return ResponseEntity.status(200).body(blogService.getBlogById(blog_id));
    }

}
