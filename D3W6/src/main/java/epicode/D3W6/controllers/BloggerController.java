package epicode.D3W6.controllers;

import epicode.D3W6.entities.Blogger;
import epicode.D3W6.exceptions.BloggerNotFoundException;
import epicode.D3W6.services.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bloggers")
public class BloggerController {
    @Autowired
    private BloggerService bloggerService;

    @GetMapping
    public List<Blogger> getAllBloggers() {
        return bloggerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Blogger> getBloggerById(@PathVariable int id) {
        return bloggerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blogger createBlogger(@RequestBody Blogger blogger) {
        return bloggerService.save(blogger);
    }

    @PutMapping("/{id}")
    public Blogger updateBlogger(@PathVariable int id, @RequestBody Blogger blogger) {
        Blogger updated = bloggerService.update(id, blogger);
        if (updated == null) {
            throw new BloggerNotFoundException("Blogger con id: " + id + " non trovato");
        }
        return updated;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogger(@PathVariable int id) {
        bloggerService.deleteById(id);
    }
}
