package service;

import entity.Reader;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 04.06.13
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public interface ReaderService {
    public void save(Reader reader);
    public List<Reader> findAll();
}
