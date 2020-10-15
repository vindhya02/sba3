package com.wellsfargo.fsd.imsa.service;

import java.util.List;

import com.wellsfargo.fsd.imsa.entity.User;
import com.wellsfargo.fsd.imsa.entity.UserDTO;
import com.wellsfargo.fsd.imsa.exception.InvException;

public interface UserService {

	User add(UserDTO User) throws InvException;

	User save(UserDTO User) throws InvException;

	boolean deleteUser(int icode) throws InvException;

	UserDTO getUserById(int icode) throws InvException;

	List<UserDTO> getAllUsers() throws InvException;
}
