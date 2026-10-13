package com.example.tuwaiqacademylab12.Service;

import com.example.tuwaiqacademylab12.Api.ApiException;
import com.example.tuwaiqacademylab12.Model.Blog;
import com.example.tuwaiqacademylab12.Model.User;
import com.example.tuwaiqacademylab12.Repository.AuthRepository;
import com.example.tuwaiqacademylab12.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final AuthRepository authRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public void addBlog(Integer user_id ,Blog blog) {
        User user = authRepository.findById(user_id)
                .orElseThrow(() -> new ApiException("User not found"));
        blog.setUser(user);
        blogRepository.save(blog);
    }

    public void updateBlog(Integer user_id, Integer blog_id, Blog blog) {
        User user = authRepository.findById(user_id)
                .orElseThrow(() -> new ApiException("User not found"));

        Blog oldBlog = blogRepository.findById(blog_id)
                .orElseThrow(() -> new ApiException("Blog not found"));

        if (oldBlog.getUser().getId() != user_id) {
            throw new ApiException("Can't update");
        }

        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());

        blogRepository.save(oldBlog);
    }

    public void deleteBlog(Integer user_id, Integer blog_id) {
        Blog blog = blogRepository.findById(blog_id)
                .orElseThrow(() -> new ApiException("Blog not found"));

        if (blog.getUser() == null || !blog.getUser().getId().equals(user_id)) {
            throw new ApiException("can't delete");
        }

        blogRepository.delete(blog);
    }

    public Blog getBlogById(Integer blog_id) {
        return blogRepository.findById(blog_id)
                .orElseThrow(() -> new ApiException("Blog not found"));
    }

    public List<Blog> getBlogByTitle(String title) {
        List<Blog> result = blogRepository.findByTitle(title);

        if (result.isEmpty()) {
            throw new ApiException("No blog was found");
        }

        return result;
    }
}
