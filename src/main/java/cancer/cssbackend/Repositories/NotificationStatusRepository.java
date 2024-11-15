package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.NotificationLog;
import cancer.cssbackend.Entities.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationStatusRepository extends JpaRepository<NotificationStatus, Long> {
    public NotificationStatus findByNotifStatusName(String name);
}
