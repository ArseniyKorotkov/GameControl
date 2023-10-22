package by.arsy.p4service;

import by.arsy.p3dao.AppDao;

public class AppService {

    private static final AppService APP_SERVICE = new AppService();

    private AppService() {
    }

    public void activateTables() {
        AppDao.activateTables();
    }

    public static AppService getInstance() {
        return APP_SERVICE;
    }
}
