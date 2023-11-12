package pp.rsmmm.domain.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp.rsmmm.domain.consumer.entity.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

    public boolean existsByName(String name);
}
