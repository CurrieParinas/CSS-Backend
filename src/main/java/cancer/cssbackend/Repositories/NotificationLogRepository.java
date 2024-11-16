package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
    @Query(value = "SELECT COUNT(*) AS notification_count FROM NOTIFICATIONLOG WHERE NOTIFICATION_RECEIVER = :userID AND NOTIFICATION_STATUS = 2", nativeQuery = true)
    int countUnreadByUser(@Param("userID") Long userID);

    @Query(value="SELECT N.* FROM NOTIFICATIONLOG N WHERE NOTIFICATION_RECEIVER = :userID AND NOTIFICATION_STATUS = 2", nativeQuery = true)
    List<NotificationLog> fetchUnreadByUser(@Param("userID") Long userID);

    @Query(value="SELECT N.* FROM NOTIFICATIONLOG N WHERE NOTIFICATION_RECEIVER = :userID", nativeQuery = true)
    List<NotificationLog> fetchAllNotifsByUser(@Param("userID") Long userID);
}
