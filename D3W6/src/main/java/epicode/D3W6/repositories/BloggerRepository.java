package epicode.D3W6.repositories;

import epicode.D3W6.entities.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggerRepository extends JpaRepository<Blogger, Integer> {

}

