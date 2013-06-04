package service.impl;

import dao.PhoneOrmDAO;
import entity.Phone;
import service.PhoneService;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 04.06.13
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class PhoneServiceImpl implements PhoneService {
    private PhoneOrmDAO phoneDao;

    public PhoneOrmDAO getPhoneDao() {
        return phoneDao;
    }

    public void setPhoneDao(PhoneOrmDAO phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Override
    public void save(Phone phone) {
        phoneDao.putNewPhone(phone);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Phone> findAll() {
        return phoneDao.getAllPhones();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
