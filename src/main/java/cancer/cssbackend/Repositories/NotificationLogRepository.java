package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
    @Query(value = "SELECT COUNT(*) AS notification_count FROM NOTIFICATIONLOG WHERE NOTIFICATION_RECEIVER = :patientID AND NOTIFICATION_STATUS = 2", nativeQuery = true)
    int countUnreadByPatient(@Param("patientID") Long patientID);
}
