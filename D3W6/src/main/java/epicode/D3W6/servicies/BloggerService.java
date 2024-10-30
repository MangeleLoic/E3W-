package epicode.D3W6.services;

import epicode.D3W6.entities.Blogger;
import epicode.D3W6.repositories.BloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloggerService {
    @Autowired
    private BloggerRepository bloggerRepository;

    public List<Blogger> findAll() {
        return bloggerRepository.findAll();
    }

    public Optional<Blogger> findById(int id) {
        return bloggerRepository.findById(id);
    }

    public Blogger save(Blogger blogger) {
        return bloggerRepository.save(blogger);
    }

    public Blogger update(int id, Blogger updatedBlogger) {
        return bloggerRepository.findById(id)
                .map(blogger -> {
                    blogger.setNome(updatedBlogger.getNome());
                    blogger.setCognome(updatedBlogger.getCognome());
                    blogger.setEmail(updatedBlogger.getEmail());
                    blogger.setDataDiNascita(updatedBlogger.getDataDiNascita());
                    blogger.setAvatar(updatedBlogger.getAvatar());
                    return bloggerRepository.save(blogger);
                })
                .orElse(null);
    }

    public void deleteById(int id) {
        bloggerRepository.deleteById(id);
    }
}

