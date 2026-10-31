package com.tap.DAO;

import java.util.List;

import com.tap.model.User;



public interface UserDAO {
	void addUser(User user);

    // Get a single user by their ID — accepts userId, returns the User object
    User getUser(int userId);

    // Update an existing user — accepts the updated User object
    void updateUser(User user);

    // Delete a user by ID — accepts userId, returns nothing
    void deleteUser(int userId);

    // Get all users — accepts nothing, returns a list of all User objects
    List<User> getAllUser();

}
