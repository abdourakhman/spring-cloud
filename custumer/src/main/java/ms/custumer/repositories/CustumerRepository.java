package ms.custumer.repositories;

import ms.custumer.models.Custumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustumerRepository extends JpaRepository<Custumer,Long> {
}
