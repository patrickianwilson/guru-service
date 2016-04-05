package com.github.patrickianwilson.template.java.web.repositories;

import java.util.List;
import com.github.patrickianwilson.template.java.web.repositories.exceptions.EntityNotFoundException;
import com.github.patrickianwilson.template.java.web.repositories.models.User;

/**
 * Created by pwilson on 3/7/16.
 */
public interface UserRepository {

    /**
     * Find a user with a given ID.
     * @param id the id of the user
     * @return a single user or null if no such user exists.
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.DatabaseException if there is an unexpected error writing to the database
     */
    User findByID(String id);

    /**
     * Find a set of users with a given first name
     * @param fname the first name to search for. Exact match only.
     * @return all the users whose first name matches the criteria.
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.DatabaseException if there is an unexpected error writing to the database
     */
    List<User> findByFirstName(String fname);

    /**
     * find a user with a given email address. It is assumed that email addresses are unique.
     * @param email the email address to search for.
     * @return the single user whose email matches the criteria.
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.DatabaseException if there is an unexpected error writing to the database
     */
    User findByEmailAddress(String email);


    /**
     * Create a new user record in the repository.
     * @param user the user details to create
     * @return a user entity object.  Generally, this is just the input with the Database ID added to the record.
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.DatabaseException if there is an unexpected error writing to the database
     */
    User create(User user);

    /**
     * update a user record in the repository
     * @param user the modified user record.  The ID will be used for the update.
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.EntityNotFoundException if the user Id is not valid or exists
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.DatabaseException if there is an unexpected error writing to the database
     */
    void update(User user);

    /**
     * delete a user record.
     * @param user the user record to delete, the ID will be used from the entity.
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.EntityNotFoundException if the user Id is not valid or exists
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.DatabaseException if there is an unexpected error writing to the database
     */
    void delete(User user);

    /**
     * Delete a user entity from the repo given an ID
     * @param userID a user id to delete.
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.EntityNotFoundException if the user Id is not valid or exists
     * @throws com.github.patrickianwilson.template.java.web.repositories.exceptions.DatabaseException if there is an unexpected error writing to the database
     */
    void delete(String userID);
}
