package mx.ipn.escom.wad.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.dao.AccessDao;
import mx.ipn.escom.wad.dao.AccountDao;
import mx.ipn.escom.wad.dao.AddressDao;
import mx.ipn.escom.wad.dao.ContactDao;
import mx.ipn.escom.wad.dao.PersonContactDao;
import mx.ipn.escom.wad.dao.UsersDao;
import mx.ipn.escom.wad.entidad.Account;
import mx.ipn.escom.wad.entidad.Contact;
import mx.ipn.escom.wad.entidad.PersonContact;
import mx.ipn.escom.wad.entidad.User;

@Service("usersBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsersBs {

	@Autowired
	private AccessDao accessDao;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private PersonContactDao personContactDao;

	@Autowired
	private UsersDao usersDao;

	public List<User> findAllUsers() {
		return usersDao.findAllUsers();
	}

	public User findById(Integer id) {
		return usersDao.findById(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteUser(Integer id) {
		User user = findById(id);
		accessDao.delete(user.getAccess());
		for (Account acc : user.getAccounts()) {
			accountDao.delete(acc);
		}
		for (PersonContact pc : user.getPersonContacts()) {
			personContactDao.delete(pc);
		}
		for (Contact c : user.getContacts()) {
			contactDao.delete(c);
		}
		if (user.getAddress() != null) {
			addressDao.delete(user.getAddress());
		}
		usersDao.delete(user);
	}
}
