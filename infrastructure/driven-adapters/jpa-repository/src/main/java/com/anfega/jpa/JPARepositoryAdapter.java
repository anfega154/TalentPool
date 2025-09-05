package com.anfega.jpa;

import com.anfega.jpa.helper.AdapterOperations;
import com.anfega.model.user.User;
import com.anfega.model.user.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<User, UserEntity, Long, JPARepository> implements UserRepository {

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, User.class));
    }

    @Override
    public User getUserById(Long id) {
        return this.toEntity(this.repository.findById(id).orElse(new UserEntity()));
    }

    @Override
    public User saveUser(User user) {
        return this.toEntity(this.repository.save(mapper.map(user, UserEntity.class)));
    }
}

