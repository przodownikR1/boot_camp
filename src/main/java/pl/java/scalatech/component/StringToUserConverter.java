package pl.java.scalatech.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;

import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.UserRepository;

@Component
public class StringToUserConverter implements Converter<String,User>{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(String id) {
        Preconditions.checkNotNull(id);
        return userRepository.findOne(Long.parseLong(id));
    }

}