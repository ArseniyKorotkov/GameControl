package by.arsy.p4service;

import by.arsy.p3dao.AppDao;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    public void activateTables() {
        AppDao.activateTables();
    }

}
