package com.innovationem.service;

import com.google.appengine.api.datastore.Key;
import com.innovationem.meta.UserMeta;
import com.innovationem.model.User;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.innovationem.util.CacheKeyUtil.*;

public class UserService {

	private UserMeta userMeta = new UserMeta();

	private static final Logger logger = Logger.getLogger(UserService.class
			.getName());

	// Creates a user and also adds an member automatically.
	public void createUser(User user) {
		Key userKey = Datastore.allocateId(User.class);
		user.setKey(userKey);
		// Capture other fields from User
		User dbUser = getUserByEmail(user.getEmail());
		if (dbUser == null) {
			Datastore.put(user); // We don't want user creation to hold for the
									// rest of them.
		}
	}

	public User getUserByID(Long id) {
		User user = Memcache.get(userKey(id));
		if (user == null) {
			Key key = Datastore.createKey(User.class, id);
			user = Datastore.get(User.class, key);
			Memcache.put(userKey(id), user);
		}
		return user;
	}

	public List<User> getUsersByIDs(List<Long> ids) {
		List<Key> userKeys = new ArrayList<Key>();
		for (Long id : ids) {
			userKeys.add(Datastore.createKey(User.class, id));
		}
		return Datastore.get(User.class, userKeys);
	}

	public void updateUser(User user) {
		Memcache.put(userKey(user.getKey().getId()), user);
		Memcache.put(userEmailKey(user.getEmail()), user);
		Datastore.put(user);
	}

	public User getUserByEmail(String email) {
		email = email.toLowerCase();
		User user = Memcache.get(userEmailKey(email));
		logger.info("'user' object from Memcache for '" + email + "': " + user);
		if (user == null) {
			user = Datastore.query(userMeta)
					.filter(userMeta.email.equal(email)).asSingle();
			logger.info("'user' object from Datastore for '" + email + "': "
					+ user);
			Memcache.put(userEmailKey(email), user);
		}
		return user;
	}

}
