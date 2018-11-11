import com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql.LocationRepository;
import com.sjsu.cmpe.sstreet.mirroringserver.repository.mysql.SmartClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartClusterService {

    private SmartClusterRepository smartClusterRepository;
    private LocationRepository locationRepository;


    @Autowired
    public SmartClusterService(SmartClusterRepository smartClusterRepository, LocationRepository locationRepository) {
        this.smartClusterRepository = smartClusterRepository;
        this.locationRepository = locationRepository;
    }





}