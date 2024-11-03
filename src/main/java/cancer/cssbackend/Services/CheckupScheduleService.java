package cancer.cssbackend.Services;

import cancer.cssbackend.Repositories.CheckupScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckupScheduleService {
    private final CheckupScheduleRepository checkupScheduleRepository;
}
