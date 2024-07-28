package willianssantos.elibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import willianssantos.elibrary.exception.BusinessException;
import willianssantos.elibrary.exception.NotFoundException;
import willianssantos.elibrary.model.User;
import willianssantos.elibrary.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) throws NotFoundException {
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public User create(User entity) {
        return this.repository.save(entity);
    }

    @Override
    @Transactional
    public User update(Long id, User entity) {

        User dbUser;
        try {
            dbUser = this.findById(id);
        } catch (NotFoundException e) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbUser.setName(entity.getName());
        dbUser.setReadings(entity.getReadings());


        return this.repository.save(dbUser);
    }

    @Override
    public void delete(Long id) {
        User dbUser;
        try {
            dbUser = this.findById(id);
        } catch (NotFoundException e) {
            throw new BusinessException("The ID does not exist.");
        }
        this.repository.delete(dbUser);
    }
}
