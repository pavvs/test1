package service.impl;

import dao.ReaderOrmDAO;
import entity.Reader;
import service.ReaderService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 04.06.13
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
public class ReaderServiceImpl implements ReaderService {
    private ReaderOrmDAO readerDao;

    public ReaderOrmDAO getReaderDao() {
        return readerDao;
    }

    public void setReaderDao(ReaderOrmDAO readerDao) {
        this.readerDao = readerDao;
    }

    @Override
    public void save(Reader reader) {
        readerDao.putNewReader(reader);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Reader> findAll() {
        return readerDao.getAllReaders();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
