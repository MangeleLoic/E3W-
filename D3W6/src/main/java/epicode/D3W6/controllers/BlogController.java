package epicode.D3W6.controllers;

import epicode.D3W6.entities.Blog;
import epicode.D3W6.payloads.NewBlogPayload;
import epicode.D3W6.servicies.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> getBlogs() {
        return this.blogService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody NewBlogPayload body) {
        return this.blogService.saveBlog(body);
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int blogId) {
        Optional<Blog> blog = this.blogService.findById(blogId);
        return blog.map(ResponseEntity::ok) // Restituisce 200 OK se presente
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Restituisce 404 Not Found se non trovato
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<Blog> findBlogByIdAndUpdate(@PathVariable int blogId, @RequestBody NewBlogPayload body) {
        Optional<Blog> updatedBlog = this.blogService.findByIdAndUpdate(blogId, body);
        return updatedBlog.map(ResponseEntity::ok) // Restituisce 200 OK con il blog aggiornato
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Restituisce 404 Not Found se non trovato
    }
}
