package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.CheckupStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckupStatusService {
    private final CheckupStatusRepository checkupStatusRepository;
}
