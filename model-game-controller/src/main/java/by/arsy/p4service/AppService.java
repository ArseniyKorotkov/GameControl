package by.arsy.p4service;

import by.arsy.p3dao.AppDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private AppDao appDao;

    public void activateTables() {
        appDao.activateTables();
    }

}
