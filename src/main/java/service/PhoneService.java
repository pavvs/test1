package service;

import entity.Phone;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 04.06.13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public interface PhoneService {
    public void save(Phone phone);
    public List<Phone> findAll();
}
