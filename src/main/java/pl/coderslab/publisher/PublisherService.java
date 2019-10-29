package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublisherService {

    private PublisherDao publisherDao;

    @Autowired
    public PublisherService(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    public void save(Publisher publisher) {
        publisherDao.save(publisher);
    }

    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public Publisher findOne(Long id) {
        return publisherDao.findOne(id);
    }

    public void delete(Long id) {
        publisherDao.delete(id);
    }

    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }

}
