package cancer.cssbackend.Services;

import cancer.cssbackend.Entities.LabsDownload;
import cancer.cssbackend.Repositories.LabsDownloadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LabsDownloadService {
    private final LabsDownloadRepository labsDownloadRepository;
}
