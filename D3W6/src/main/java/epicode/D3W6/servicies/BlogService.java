package epicode.D3W6.services;

import epicode.D3W6.entities.Blog;
import epicode.D3W6.payloads.NewBlogPayload;
import epicode.D3W6.repositories.BlogRepository; // Assicurati di avere il repository importato
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog saveBlog(NewBlogPayload body) {
        Blog newBlog = new Blog(body.getCategoria(), body.getContenuto(), body.getCover(), body.getTempoDiLettura(), body.getTitolo());
        return blogRepository.save(newBlog);
    }

    public Optional<Blog> findById(int blogId) {
        return blogRepository.findById(blogId);
    }

    public Optional<Blog> findByIdAndUpdate(int blogId, NewBlogPayload body) {
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            blog.setCategoria(body.getCategoria());
            blog.setTitolo(body.getTitolo());
            blog.setCover(body.getCover());
            blog.setContenuto(body.getContenuto());
            blog.setTempoDiLettura(body.getTempoDiLettura());
            blogRepository.save(blog);
            return Optional.of(blog);
        }
        return Optional.empty();
    }
}
